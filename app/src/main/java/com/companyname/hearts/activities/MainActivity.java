package com.companyname.hearts.activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.companyname.hearts.R;
import com.companyname.hearts.ai.HAL9000;
import com.companyname.hearts.ai.Terminator;
import com.companyname.hearts.ai.Zombocom;
import com.companyname.hearts.model.Card;
import com.companyname.hearts.model.Dealer;
import com.companyname.hearts.model.Direction;
import com.companyname.hearts.model.Overlord;
import com.companyname.hearts.model.Rank;
import com.companyname.hearts.model.Suit;
import com.companyname.hearts.model.Table;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private TextView playerName;
    private TextView computer1Name;
    private TextView computer2Name;
    private TextView computer3Name;
    private Button passButton;
    private ImageView b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13;
    private ImageView playerCard, computer1Card, computer2Card, computer3Card;
    private ImageView suitPlayed;
    private Animation passLeftAnimation, passRightAnimation, passAcrossAnimation, middle1, middle2, middle3, middle4, middle5, middle6, middle7, middle8, middle9, middle10, middle11, middle12, middle13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        boolean continueOldGame = intent.getBooleanExtra("continueOldGame", false);
        if (continueOldGame) {
            initializeSavedGame();
            setViewSavedGame();
        } else {
            initializeViews();
            createListeners();
            setUpGame();
            displayImages();
            beginRound();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveGame();
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(MainActivity.this, getString(R.string.no_escape), Toast.LENGTH_LONG).show();
    }

    private void initializeViews() {
        playerName = (TextView) findViewById(R.id.player_name);
        computer1Name = (TextView) findViewById(R.id.computer1_name);
        computer2Name = (TextView) findViewById(R.id.computer2_name);
        computer3Name = (TextView) findViewById(R.id.computer3_name);
        passButton = (Button) findViewById(R.id.pass_cards_button);

        passLeftAnimation = AnimationUtils.loadAnimation(this, R.anim.passleft);
        passRightAnimation = AnimationUtils.loadAnimation(this, R.anim.passright);
        passAcrossAnimation = AnimationUtils.loadAnimation(this, R.anim.passacross);

        middle1 = AnimationUtils.loadAnimation(this, R.anim.middle1);
        middle2 = AnimationUtils.loadAnimation(this, R.anim.middle2);
        middle3 = AnimationUtils.loadAnimation(this, R.anim.middle3);
        middle4 = AnimationUtils.loadAnimation(this, R.anim.middle4);
        middle5 = AnimationUtils.loadAnimation(this, R.anim.middle5);
        middle6 = AnimationUtils.loadAnimation(this, R.anim.middle6);
        middle7 = AnimationUtils.loadAnimation(this, R.anim.middle7);
        middle8 = AnimationUtils.loadAnimation(this, R.anim.middle8);
        middle9 = AnimationUtils.loadAnimation(this, R.anim.middle9);
        middle10 = AnimationUtils.loadAnimation(this, R.anim.middle10);
        middle11 = AnimationUtils.loadAnimation(this, R.anim.middle11);
        middle12 = AnimationUtils.loadAnimation(this, R.anim.middle12);
        middle13 = AnimationUtils.loadAnimation(this, R.anim.middle13);

        b1 = (ImageView) findViewById(R.id.card_1);
        b2 = (ImageView) findViewById(R.id.card_2);
        b3 = (ImageView) findViewById(R.id.card_3);
        b4 = (ImageView) findViewById(R.id.card_4);
        b5 = (ImageView) findViewById(R.id.card_5);
        b6 = (ImageView) findViewById(R.id.card_6);
        b7 = (ImageView) findViewById(R.id.card_7);
        b8 = (ImageView) findViewById(R.id.card_8);
        b9 = (ImageView) findViewById(R.id.card_9);
        b10 = (ImageView) findViewById(R.id.card_10);
        b11 = (ImageView) findViewById(R.id.card_11);
        b12 = (ImageView) findViewById(R.id.card_12);
        b13 = (ImageView) findViewById(R.id.card_13);

        SharedPreferences pref = this.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);
        String sharedPrefString = pref.getString("playernames", "");
        String[] playerNames = sharedPrefString.split(",");

        playerCard = (ImageView) findViewById(R.id.player_card);
        computer1Card = (ImageView) findViewById(R.id.computer1_card);
        computer2Card = (ImageView) findViewById(R.id.computer2_card);
        computer3Card = (ImageView) findViewById(R.id.computer3_card);

        suitPlayed = (ImageView) findViewById(R.id.played_suit);

        playerName.setText(playerNames[0]);
        computer1Name.setText(playerNames[1]);
        computer2Name.setText(playerNames[2]);
        computer3Name.setText(playerNames[3]);
        Table.getInstance().initializeTable(playerNames[0], playerNames[1], playerNames[2], playerNames[3]);
    }

    private void initializeSavedGame() {
        playerName = (TextView) findViewById(R.id.player_name);
        computer1Name = (TextView) findViewById(R.id.computer1_name);
        computer2Name = (TextView) findViewById(R.id.computer2_name);
        computer3Name = (TextView) findViewById(R.id.computer3_name);
        passButton = (Button) findViewById(R.id.pass_cards_button);

        passLeftAnimation = AnimationUtils.loadAnimation(this, R.anim.passleft);
        passRightAnimation = AnimationUtils.loadAnimation(this, R.anim.passright);
        passAcrossAnimation = AnimationUtils.loadAnimation(this, R.anim.passacross);

        middle1 = AnimationUtils.loadAnimation(this, R.anim.middle1);
        middle2 = AnimationUtils.loadAnimation(this, R.anim.middle2);
        middle3 = AnimationUtils.loadAnimation(this, R.anim.middle3);
        middle4 = AnimationUtils.loadAnimation(this, R.anim.middle4);
        middle5 = AnimationUtils.loadAnimation(this, R.anim.middle5);
        middle6 = AnimationUtils.loadAnimation(this, R.anim.middle6);
        middle7 = AnimationUtils.loadAnimation(this, R.anim.middle7);
        middle8 = AnimationUtils.loadAnimation(this, R.anim.middle8);
        middle9 = AnimationUtils.loadAnimation(this, R.anim.middle9);
        middle10 = AnimationUtils.loadAnimation(this, R.anim.middle10);
        middle11 = AnimationUtils.loadAnimation(this, R.anim.middle11);
        middle12 = AnimationUtils.loadAnimation(this, R.anim.middle12);
        middle13 = AnimationUtils.loadAnimation(this, R.anim.middle13);

        b1 = (ImageView) findViewById(R.id.card_1);
        b2 = (ImageView) findViewById(R.id.card_2);
        b3 = (ImageView) findViewById(R.id.card_3);
        b4 = (ImageView) findViewById(R.id.card_4);
        b5 = (ImageView) findViewById(R.id.card_5);
        b6 = (ImageView) findViewById(R.id.card_6);
        b7 = (ImageView) findViewById(R.id.card_7);
        b8 = (ImageView) findViewById(R.id.card_8);
        b9 = (ImageView) findViewById(R.id.card_9);
        b10 = (ImageView) findViewById(R.id.card_10);
        b11 = (ImageView) findViewById(R.id.card_11);
        b12 = (ImageView) findViewById(R.id.card_12);
        b13 = (ImageView) findViewById(R.id.card_13);

        playerCard = (ImageView) findViewById(R.id.player_card);
        computer1Card = (ImageView) findViewById(R.id.computer1_card);
        computer2Card = (ImageView) findViewById(R.id.computer2_card);
        computer3Card = (ImageView) findViewById(R.id.computer3_card);

        suitPlayed = (ImageView) findViewById(R.id.played_suit);

        loadGame();

        playerName.setText(Table.getInstance().getPlayer1().getName());
        computer1Name.setText(Table.getInstance().getPlayer2().getName());
        computer2Name.setText(Table.getInstance().getPlayer3().getName());
        computer3Name.setText(Table.getInstance().getPlayer4().getName());
    }

    private void createListeners() {
        b1.setOnClickListener(onCardClick);
        b2.setOnClickListener(onCardClick);
        b3.setOnClickListener(onCardClick);
        b4.setOnClickListener(onCardClick);
        b5.setOnClickListener(onCardClick);
        b6.setOnClickListener(onCardClick);
        b7.setOnClickListener(onCardClick);
        b8.setOnClickListener(onCardClick);
        b9.setOnClickListener(onCardClick);
        b10.setOnClickListener(onCardClick);
        b11.setOnClickListener(onCardClick);
        b12.setOnClickListener(onCardClick);
        b13.setOnClickListener(onCardClick);
    }

    private void setUpGame() {
        Dealer.getInstance().shuffle();
        Dealer.getInstance().deal(Table.getInstance().getPlayer1(), Table.getInstance().getPlayer2(),
                Table.getInstance().getPlayer3(), Table.getInstance().getPlayer4());
        Overlord.getInstance().setPlayerWithTheTwoOfClubs();
        Table.getInstance().getPlayer1().organizeHand();
        Table.getInstance().getPlayer2().organizeHand();
        Table.getInstance().getPlayer3().organizeHand();
        Table.getInstance().getPlayer4().organizeHand();
    }

    private void displayImages() {
        Card c1 = Table.getInstance().getPlayer1().getHand().get(0);
        Card c2 = Table.getInstance().getPlayer1().getHand().get(1);
        Card c3 = Table.getInstance().getPlayer1().getHand().get(2);
        Card c4 = Table.getInstance().getPlayer1().getHand().get(3);
        Card c5 = Table.getInstance().getPlayer1().getHand().get(4);
        Card c6 = Table.getInstance().getPlayer1().getHand().get(5);
        Card c7 = Table.getInstance().getPlayer1().getHand().get(6);
        Card c8 = Table.getInstance().getPlayer1().getHand().get(7);
        Card c9 = Table.getInstance().getPlayer1().getHand().get(8);
        Card c10 = Table.getInstance().getPlayer1().getHand().get(9);
        Card c11 = Table.getInstance().getPlayer1().getHand().get(10);
        Card c12 = Table.getInstance().getPlayer1().getHand().get(11);
        Card c13 = Table.getInstance().getPlayer1().getHand().get(12);

        b1.setImageResource(c1.getResId());
        b2.setImageResource(c2.getResId());
        b3.setImageResource(c3.getResId());
        b4.setImageResource(c4.getResId());
        b5.setImageResource(c5.getResId());
        b6.setImageResource(c6.getResId());
        b7.setImageResource(c7.getResId());
        b8.setImageResource(c8.getResId());
        b9.setImageResource(c9.getResId());
        b10.setImageResource(c10.getResId());
        b11.setImageResource(c11.getResId());
        b12.setImageResource(c12.getResId());
        b13.setImageResource(c13.getResId());

        remakeVisible();
    }

    private void setViewSavedGame() {
        Card c1 = Table.getInstance().getPlayer1().getHand().get(0);
        Card c2 = Table.getInstance().getPlayer1().getHand().get(1);
        Card c3 = Table.getInstance().getPlayer1().getHand().get(2);
        Card c4 = Table.getInstance().getPlayer1().getHand().get(3);
        Card c5 = Table.getInstance().getPlayer1().getHand().get(4);
        Card c6 = Table.getInstance().getPlayer1().getHand().get(5);
        Card c7 = Table.getInstance().getPlayer1().getHand().get(6);
        Card c8 = Table.getInstance().getPlayer1().getHand().get(7);
        Card c9 = Table.getInstance().getPlayer1().getHand().get(8);
        Card c10 = Table.getInstance().getPlayer1().getHand().get(9);
        Card c11 = Table.getInstance().getPlayer1().getHand().get(10);
        Card c12 = Table.getInstance().getPlayer1().getHand().get(11);
        Card c13 = Table.getInstance().getPlayer1().getHand().get(12);

        if (!c1.toString().equals("Joker of Joker")) {
            b1.setImageResource(c1.getResId());
            b1.setOnClickListener(onCardClick);
        } else {
            b1.setImageResource(0);
        }
        if (!c2.toString().equals("Joker of Joker")) {
            b2.setImageResource(c2.getResId());
            b2.setOnClickListener(onCardClick);
        } else {
            b2.setImageResource(0);
        }
        if (!c3.toString().equals("Joker of Joker")) {
            b3.setImageResource(c3.getResId());
            b3.setOnClickListener(onCardClick);
        } else {
            b3.setImageResource(0);
        }
        if (!c4.toString().equals("Joker of Joker")) {
            b4.setImageResource(c4.getResId());
            b4.setOnClickListener(onCardClick);
        } else {
            b4.setImageResource(0);
        }
        if (!c5.toString().equals("Joker of Joker")) {
            b5.setImageResource(c5.getResId());
            b5.setOnClickListener(onCardClick);
        } else {
            b5.setImageResource(0);
        }
        if (!c6.toString().equals("Joker of Joker")) {
            b6.setImageResource(c6.getResId());
            b6.setOnClickListener(onCardClick);
        } else {
            b6.setImageResource(0);
        }
        if (!c7.toString().equals("Joker of Joker")) {
            b7.setImageResource(c7.getResId());
            b7.setOnClickListener(onCardClick);
        } else {
            b7.setImageResource(0);
        }
        if (!c8.toString().equals("Joker of Joker")) {
            b8.setImageResource(c8.getResId());
            b8.setOnClickListener(onCardClick);
        } else {
            b8.setImageResource(0);
        }
        if (!c9.toString().equals("Joker of Joker")) {
            b9.setImageResource(c9.getResId());
            b9.setOnClickListener(onCardClick);
        } else {
            b9.setImageResource(0);
        }
        if (!c10.toString().equals("Joker of Joker")) {
            b10.setImageResource(c10.getResId());
            b10.setOnClickListener(onCardClick);
        } else {
            b10.setImageResource(0);
        }
        if (!c11.toString().equals("Joker of Joker")) {
            b11.setImageResource(c11.getResId());
            b11.setOnClickListener(onCardClick);
        } else {
            b11.setImageResource(0);
        }
        if (!c12.toString().equals("Joker of Joker")) {
            b12.setImageResource(c12.getResId());
            b12.setOnClickListener(onCardClick);
        } else {
            b12.setImageResource(0);
        }
        if (!c13.toString().equals("Joker of Joker")) {
            b13.setImageResource(c13.getResId());
            b13.setOnClickListener(onCardClick);
        } else {
            b13.setImageResource(0);
        }

        remakeVisible();

        if (Overlord.getInstance().getPassing()) {
            if (Table.getInstance().getPlayer1().getHand().get(0).isSelected()) {
                b1.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.push));
            }
            if (Table.getInstance().getPlayer1().getHand().get(1).isSelected()) {
                b2.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.push));
            }
            if (Table.getInstance().getPlayer1().getHand().get(2).isSelected()) {
                b3.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.push));
            }
            if (Table.getInstance().getPlayer1().getHand().get(3).isSelected()) {
                b4.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.push));
            }
            if (Table.getInstance().getPlayer1().getHand().get(4).isSelected()) {
                b5.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.push));
            }
            if (Table.getInstance().getPlayer1().getHand().get(5).isSelected()) {
                b6.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.push));
            }
            if (Table.getInstance().getPlayer1().getHand().get(6).isSelected()) {
                b7.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.push));
            }
            if (Table.getInstance().getPlayer1().getHand().get(7).isSelected()) {
                b8.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.push));
            }
            if (Table.getInstance().getPlayer1().getHand().get(8).isSelected()) {
                b9.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.push));
            }
            if (Table.getInstance().getPlayer1().getHand().get(9).isSelected()) {
                b10.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.push));
            }
            if (Table.getInstance().getPlayer1().getHand().get(10).isSelected()) {
                b11.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.push));
            }
            if (Table.getInstance().getPlayer1().getHand().get(11).isSelected()) {
                b12.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.push));
            }
            if (Table.getInstance().getPlayer1().getHand().get(12).isSelected()) {
                b13.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.push));
            }
            passButton.setText(Overlord.getInstance().getPassingDirection());
            passButton.setVisibility(View.VISIBLE);
        } else {
            // Setting board:

            // HAL9000 played the first card on the board:
            if (Overlord.getInstance().getLeadingPlayer().getName().equals(Table.getInstance().getPlayer2().getName())) {
                computer1Card.setImageResource(Table.getInstance().getBoard().get(0).getResId());
                computer2Card.setImageResource(Table.getInstance().getBoard().get(1).getResId());
                computer3Card.setImageResource(Table.getInstance().getBoard().get(2).getResId());
            }
            // Terminator played the first card on the board:
            if (Overlord.getInstance().getLeadingPlayer().getName().equals(Table.getInstance().getPlayer3().getName())) {
                computer2Card.setImageResource(Table.getInstance().getBoard().get(0).getResId());
                computer3Card.setImageResource(Table.getInstance().getBoard().get(1).getResId());
            }
            // Zombocom played the first card on the board:
            if (Overlord.getInstance().getLeadingPlayer().getName().equals(Table.getInstance().getPlayer4().getName())) {
                computer3Card.setImageResource(Table.getInstance().getBoard().get(0).getResId());
            }

            setSuitImage();
        }

    }

    private void cantPlayThatPopUp() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(getString(R.string.app_name));
        builder.setMessage(getString(R.string.illegal_move));
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // does nothing
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    private void displayTrickWinnerPopUp() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(getString(R.string.app_name));
        builder.setMessage(Overlord.getInstance().getLeadingPlayer().getName() + " " + getString(R.string.trick_winner) + "\n" +
                getString(R.string.board_contains) + " " + Arrays.toString(Table.getInstance().getBoard().toArray()));
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (Overlord.getInstance().getRoundsPlayed() == 14) {
                    removeCenterIcon();
                    displayScorePopUp();
                } else {
                    removeCenterIcon();
                    beginRound();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    private void displayScorePopUp() {
        Overlord.getInstance().calculatePoints();
        Overlord.getInstance().updatePlaying();
        Overlord.getInstance().reset();
        Overlord.getInstance().updateScoreTracker();

        if (!Overlord.getInstance().getPlaying()) {
            playAgainPopUp();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle(getString(R.string.score_alert));
            LayoutInflater alertLayout = this.getLayoutInflater();
            View alertView = alertLayout.inflate(R.layout.alert_scores, null);
            builder.setView(alertView);
            builder.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    removeCenterIcon();
                    setUpGame();
                    displayImages();
                    createListeners();
                    beginRound();
                }
            });
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setCancelable(false);
            builder.show();
            TextView alertNames = (TextView) alertView.findViewById(R.id.alert_score_names);
            TextView alertScores = (TextView) alertView.findViewById(R.id.alert_score_scores);
            String nameHolder = Table.getInstance().getPlayer1().getName() + "\n" +
                    Table.getInstance().getPlayer2().getName() + "\n" +
                    Table.getInstance().getPlayer3().getName() + "\n" +
                    Table.getInstance().getPlayer4().getName() + "\n";
            String scoreHolder = Table.getInstance().getPlayer1().getPoints() + "\n" +
                    Table.getInstance().getPlayer2().getPoints() + "\n" +
                    Table.getInstance().getPlayer3().getPoints() + "\n" +
                    Table.getInstance().getPlayer4().getPoints() + "\n";
            alertNames.setText(nameHolder);
            alertScores.setText(scoreHolder);
        }
    }

    private void removeCenterIcon() {
        suitPlayed.setImageResource(0);
    }

    private void playAgainPopUp() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(Overlord.getInstance().getWinningPlayer().getName() + " " + getString(R.string.game_winner));
        LayoutInflater alertLayout = this.getLayoutInflater();
        View alertView = alertLayout.inflate(R.layout.alert_scores, null);
        builder.setView(alertView);
        builder.setPositiveButton(getString(R.string.play_again), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Overlord.getInstance().prepareForNextGame();
                removeCenterIcon();
                setUpGame();
                displayImages();
                createListeners();
                beginRound();
            }
        });
        builder.setNegativeButton(getString(R.string.quit), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, getString(R.string.bye), Toast.LENGTH_LONG).show();
                finish();
            }
        });
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setCancelable(false);
        builder.show();
        TextView alertNames = (TextView) alertView.findViewById(R.id.alert_score_names);
        TextView alertScores = (TextView) alertView.findViewById(R.id.alert_score_scores);
        String nameHolder = Table.getInstance().getPlayer1().getName() + "\n" +
                Table.getInstance().getPlayer2().getName() + "\n" +
                Table.getInstance().getPlayer3().getName() + "\n" +
                Table.getInstance().getPlayer4().getName() + "\n";
        String scoreHolder = Table.getInstance().getPlayer1().getPoints() + "\n" +
                Table.getInstance().getPlayer2().getPoints() + "\n" +
                Table.getInstance().getPlayer3().getPoints() + "\n" +
                Table.getInstance().getPlayer4().getPoints() + "\n";
        alertNames.setText(nameHolder);
        alertScores.setText(scoreHolder);
    }

    private void beginRound() {
        if (!Overlord.getInstance().getPassing()) {
            Card computerSelection;
            if (Overlord.getInstance().getLeadingPlayer() == Table.getInstance().getPlayer2()) {
                computerSelection = HAL9000.computer1MakesMove();
                Table.getInstance().getBoard().add(computerSelection);
                computer1Card.setImageResource(computerSelection.getResId());
                setSuitImage();

                computerSelection = Terminator.computer2MakesMove();
                Table.getInstance().getBoard().add(computerSelection);
                computer2Card.setImageResource(computerSelection.getResId());

                computerSelection = Zombocom.computer3MakesMove();
                Table.getInstance().getBoard().add(computerSelection);
                computer3Card.setImageResource(computerSelection.getResId());

            } else if (Overlord.getInstance().getLeadingPlayer() == Table.getInstance().getPlayer3()) {
                computerSelection = Terminator.computer2MakesMove();
                Table.getInstance().getBoard().add(computerSelection);
                computer2Card.setImageResource(computerSelection.getResId());
                setSuitImage();

                computerSelection = Zombocom.computer3MakesMove();
                Table.getInstance().getBoard().add(computerSelection);
                computer3Card.setImageResource(computerSelection.getResId());

            } else if (Overlord.getInstance().getLeadingPlayer() == Table.getInstance().getPlayer4()) {
                computerSelection = Zombocom.computer3MakesMove();
                Table.getInstance().getBoard().add(computerSelection);
                computer3Card.setImageResource(computerSelection.getResId());
                setSuitImage();
            }
        } else {
            passButton.setText(Overlord.getInstance().getPassingDirection());
            passButton.setVisibility(View.VISIBLE);
        }

    }

    private void setSuitImage() {
        Suit suit = Table.getInstance().getBoard().get(0).getSuit();
        switch (suit) {
            case Hearts:
                suitPlayed.setImageResource(R.drawable.heart);
                break;
            case Spades:
                suitPlayed.setImageResource(R.drawable.spade);
                break;
            case Diamonds:
                suitPlayed.setImageResource(R.drawable.diamond);
                break;
            case Clubs:
                suitPlayed.setImageResource(R.drawable.club);
                break;
        }
    }

    private void resetPlayedCards() {
        playerCard.setImageResource(0);
        computer1Card.setImageResource(0);
        computer2Card.setImageResource(0);
        computer3Card.setImageResource(0);
    }

    private void animatePassingCards() {
        b1.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.pull));
        b2.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.pull));
        b3.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.pull));
        b4.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.pull));
        b5.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.pull));
        b6.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.pull));
        b7.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.pull));
        b8.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.pull));
        b9.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.pull));
        b10.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.pull));
        b11.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.pull));
        b12.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.pull));
        b13.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.pull));
    }

    private void passLeft(int i) {
        switch (i) {
            case 0:
                if (Table.getInstance().getPlayer1().getHand().get(0).isSelected()) {
                    b1.startAnimation(passLeftAnimation);
                }
                break;
            case 1:
                if (Table.getInstance().getPlayer1().getHand().get(1).isSelected()) {
                    b2.startAnimation(passLeftAnimation);
                }
                break;
            case 2:
                if (Table.getInstance().getPlayer1().getHand().get(2).isSelected()) {
                    b3.startAnimation(passLeftAnimation);
                }
                break;
            case 3:
                if (Table.getInstance().getPlayer1().getHand().get(3).isSelected()) {
                    b4.startAnimation(passLeftAnimation);
                }
                break;
            case 4:
                if (Table.getInstance().getPlayer1().getHand().get(4).isSelected()) {
                    b5.startAnimation(passLeftAnimation);
                }
                break;
            case 5:
                if (Table.getInstance().getPlayer1().getHand().get(5).isSelected()) {
                    b6.startAnimation(passLeftAnimation);
                }
                break;
            case 6:
                if (Table.getInstance().getPlayer1().getHand().get(6).isSelected()) {
                    b7.startAnimation(passLeftAnimation);
                }
                break;
            case 7:
                if (Table.getInstance().getPlayer1().getHand().get(7).isSelected()) {
                    b8.startAnimation(passLeftAnimation);
                }
                break;
            case 8:
                if (Table.getInstance().getPlayer1().getHand().get(8).isSelected()) {
                    b9.startAnimation(passLeftAnimation);
                }
                break;
            case 9:
                if (Table.getInstance().getPlayer1().getHand().get(9).isSelected()) {
                    b10.startAnimation(passLeftAnimation);
                }
                break;
            case 10:
                if (Table.getInstance().getPlayer1().getHand().get(10).isSelected()) {
                    b11.startAnimation(passLeftAnimation);
                }
                break;
            case 11:
                if (Table.getInstance().getPlayer1().getHand().get(11).isSelected()) {
                    b12.startAnimation(passLeftAnimation);
                }
                break;
            case 12:
                if (Table.getInstance().getPlayer1().getHand().get(12).isSelected()) {
                    b13.startAnimation(passLeftAnimation);
                }
                break;
        }
    }

    private void passRight(int i) {
        switch (i) {
            case 0:
                if (Table.getInstance().getPlayer1().getHand().get(0).isSelected()) {
                    b1.startAnimation(passRightAnimation);
                }
                break;
            case 1:
                if (Table.getInstance().getPlayer1().getHand().get(1).isSelected()) {
                    b2.startAnimation(passRightAnimation);
                }
                break;
            case 2:
                if (Table.getInstance().getPlayer1().getHand().get(2).isSelected()) {
                    b3.startAnimation(passRightAnimation);
                }
                break;
            case 3:
                if (Table.getInstance().getPlayer1().getHand().get(3).isSelected()) {
                    b4.startAnimation(passRightAnimation);
                }
                break;
            case 4:
                if (Table.getInstance().getPlayer1().getHand().get(4).isSelected()) {
                    b5.startAnimation(passRightAnimation);
                }
                break;
            case 5:
                if (Table.getInstance().getPlayer1().getHand().get(5).isSelected()) {
                    b6.startAnimation(passRightAnimation);
                }
                break;
            case 6:
                if (Table.getInstance().getPlayer1().getHand().get(6).isSelected()) {
                    b7.startAnimation(passRightAnimation);
                }
                break;
            case 7:
                if (Table.getInstance().getPlayer1().getHand().get(7).isSelected()) {
                    b8.startAnimation(passRightAnimation);
                }
                break;
            case 8:
                if (Table.getInstance().getPlayer1().getHand().get(8).isSelected()) {
                    b9.startAnimation(passRightAnimation);
                }
                break;
            case 9:
                if (Table.getInstance().getPlayer1().getHand().get(9).isSelected()) {
                    b10.startAnimation(passRightAnimation);
                }
                break;
            case 10:
                if (Table.getInstance().getPlayer1().getHand().get(10).isSelected()) {
                    b11.startAnimation(passRightAnimation);
                }
                break;
            case 11:
                if (Table.getInstance().getPlayer1().getHand().get(11).isSelected()) {
                    b12.startAnimation(passRightAnimation);
                }
                break;
            case 12:
                if (Table.getInstance().getPlayer1().getHand().get(12).isSelected()) {
                    b13.startAnimation(passRightAnimation);
                }
                break;
        }
    }

    private void passAcross(int i) {
        switch (i) {
            case 0:
                if (Table.getInstance().getPlayer1().getHand().get(0).isSelected()) {
                    b1.startAnimation(passAcrossAnimation);
                }
                break;
            case 1:
                if (Table.getInstance().getPlayer1().getHand().get(1).isSelected()) {
                    b2.startAnimation(passAcrossAnimation);
                }
                break;
            case 2:
                if (Table.getInstance().getPlayer1().getHand().get(2).isSelected()) {
                    b3.startAnimation(passAcrossAnimation);
                }
                break;
            case 3:
                if (Table.getInstance().getPlayer1().getHand().get(3).isSelected()) {
                    b4.startAnimation(passAcrossAnimation);
                }
                break;
            case 4:
                if (Table.getInstance().getPlayer1().getHand().get(4).isSelected()) {
                    b5.startAnimation(passAcrossAnimation);
                }
                break;
            case 5:
                if (Table.getInstance().getPlayer1().getHand().get(5).isSelected()) {
                    b6.startAnimation(passAcrossAnimation);
                }
                break;
            case 6:
                if (Table.getInstance().getPlayer1().getHand().get(6).isSelected()) {
                    b7.startAnimation(passAcrossAnimation);
                }
                break;
            case 7:
                if (Table.getInstance().getPlayer1().getHand().get(7).isSelected()) {
                    b8.startAnimation(passAcrossAnimation);
                }
                break;
            case 8:
                if (Table.getInstance().getPlayer1().getHand().get(8).isSelected()) {
                    b9.startAnimation(passAcrossAnimation);
                }
                break;
            case 9:
                if (Table.getInstance().getPlayer1().getHand().get(9).isSelected()) {
                    b10.startAnimation(passAcrossAnimation);
                }
                break;
            case 10:
                if (Table.getInstance().getPlayer1().getHand().get(10).isSelected()) {
                    b11.startAnimation(passAcrossAnimation);
                }
                break;
            case 11:
                if (Table.getInstance().getPlayer1().getHand().get(11).isSelected()) {
                    b12.startAnimation(passAcrossAnimation);
                }
                break;
            case 12:
                if (Table.getInstance().getPlayer1().getHand().get(12).isSelected()) {
                    b13.startAnimation(passAcrossAnimation);
                }
                break;
        }
    }

    private void passMiddle(int i) {
        switch (i) {
            case 0:
                b1.startAnimation(middle1);
                break;
            case 1:
                b2.startAnimation(middle2);
                break;
            case 2:
                b3.startAnimation(middle3);
                break;
            case 3:
                b4.startAnimation(middle4);
                break;
            case 4:
                b5.startAnimation(middle5);
                break;
            case 5:
                b6.startAnimation(middle6);
                break;
            case 6:
                b7.startAnimation(middle7);

                break;
            case 7:
                b8.startAnimation(middle8);
                break;
            case 8:
                b9.startAnimation(middle9);
                break;
            case 9:
                b10.startAnimation(middle10);
                break;
            case 10:
                b11.startAnimation(middle11);
                break;
            case 11:
                b12.startAnimation(middle12);
                break;
            case 12:
                b13.startAnimation(middle13);
                break;
        }

    }

    private void passCardSelector(int i) {
        switch (i) {
            case 0:
                if (Table.getInstance().getPlayer1().getHand().get(0).isSelected()) {
                    b1.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.push));
                } else {
                    b1.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.pull));
                }
                break;
            case 1:
                if (Table.getInstance().getPlayer1().getHand().get(1).isSelected()) {
                    b2.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.push));
                } else {
                    b2.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.pull));
                }
                break;
            case 2:
                if (Table.getInstance().getPlayer1().getHand().get(2).isSelected()) {
                    b3.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.push));
                } else {
                    b3.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.pull));
                }
                break;
            case 3:
                if (Table.getInstance().getPlayer1().getHand().get(3).isSelected()) {
                    b4.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.push));
                } else {
                    b4.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.pull));
                }
                break;
            case 4:
                if (Table.getInstance().getPlayer1().getHand().get(4).isSelected()) {
                    b5.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.push));
                } else {
                    b5.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.pull));
                }
                break;
            case 5:
                if (Table.getInstance().getPlayer1().getHand().get(5).isSelected()) {
                    b6.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.push));
                } else {
                    b6.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.pull));
                }
                break;
            case 6:
                if (Table.getInstance().getPlayer1().getHand().get(6).isSelected()) {
                    b7.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.push));
                } else {
                    b7.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.pull));
                }
                break;
            case 7:
                if (Table.getInstance().getPlayer1().getHand().get(7).isSelected()) {
                    b8.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.push));
                } else {
                    b8.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.pull));
                }
                break;
            case 8:
                if (Table.getInstance().getPlayer1().getHand().get(8).isSelected()) {
                    b9.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.push));
                } else {
                    b9.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.pull));
                }
                break;
            case 9:
                if (Table.getInstance().getPlayer1().getHand().get(9).isSelected()) {
                    b10.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.push));
                } else {
                    b10.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.pull));
                }
                break;
            case 10:
                if (Table.getInstance().getPlayer1().getHand().get(10).isSelected()) {
                    b11.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.push));
                } else {
                    b11.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.pull));
                }
                break;
            case 11:
                if (Table.getInstance().getPlayer1().getHand().get(11).isSelected()) {
                    b12.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.push));
                } else {
                    b12.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.pull));
                }
                break;
            case 12:
                if (Table.getInstance().getPlayer1().getHand().get(12).isSelected()) {
                    b13.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.push));
                } else {
                    b13.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.pull));
                }
                break;
        }
    }

    private void removeCardFromView(final int i) {
        if (i == 0) {
            b1.setImageResource(0);
            b1.setOnClickListener(null);
            b1.clearAnimation();
            b1.setVisibility(View.GONE);
        } else if (i == 1) {
            b2.setImageResource(0);
            b2.setOnClickListener(null);
            b2.clearAnimation();
            b2.setVisibility(View.GONE);
        } else if (i == 2) {
            b3.setImageResource(0);
            b3.setOnClickListener(null);
            b3.clearAnimation();
            b3.setVisibility(View.GONE);
        } else if (i == 3) {
            b4.setImageResource(0);
            b4.setOnClickListener(null);
            b4.clearAnimation();
            b4.setVisibility(View.GONE);
        } else if (i == 4) {
            b5.setImageResource(0);
            b5.setOnClickListener(null);
            b5.clearAnimation();
            b5.setVisibility(View.GONE);
        } else if (i == 5) {
            b6.setImageResource(0);
            b6.setOnClickListener(null);
            b6.clearAnimation();
            b6.setVisibility(View.GONE);
        } else if (i == 6) {
            b7.setImageResource(0);
            b7.setOnClickListener(null);
            b7.clearAnimation();
            b7.setVisibility(View.GONE);
        } else if (i == 7) {
            b8.setImageResource(0);
            b8.setOnClickListener(null);
            b8.clearAnimation();
            b8.setVisibility(View.GONE);
        } else if (i == 8) {
            b9.setImageResource(0);
            b9.setOnClickListener(null);
            b9.clearAnimation();
            b9.setVisibility(View.GONE);
        } else if (i == 9) {
            b10.setImageResource(0);
            b10.setOnClickListener(null);
            b10.clearAnimation();
            b10.setVisibility(View.GONE);
        } else if (i == 10) {
            b11.setImageResource(0);
            b11.setOnClickListener(null);
            b11.clearAnimation();
            b11.setVisibility(View.GONE);
        } else if (i == 11) {
            b12.setImageResource(0);
            b12.setOnClickListener(null);
            b12.clearAnimation();
            b12.setVisibility(View.GONE);
        } else if (i == 12) {
            b13.setImageResource(0);
            b13.setOnClickListener(null);
            b13.clearAnimation();
            b13.setVisibility(View.GONE);
        }
    }

    private void remakeVisible() {
        b1.setVisibility(View.VISIBLE);
        b2.setVisibility(View.VISIBLE);
        b3.setVisibility(View.VISIBLE);
        b4.setVisibility(View.VISIBLE);
        b5.setVisibility(View.VISIBLE);
        b6.setVisibility(View.VISIBLE);
        b7.setVisibility(View.VISIBLE);
        b8.setVisibility(View.VISIBLE);
        b9.setVisibility(View.VISIBLE);
        b10.setVisibility(View.VISIBLE);
        b11.setVisibility(View.VISIBLE);
        b12.setVisibility(View.VISIBLE);
        b13.setVisibility(View.VISIBLE);
    }

    private void passLeftWait(final ArrayList<Card> computerCardsToPlayer) {
        passLeftAnimation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                cardsReceivedPopUp(computerCardsToPlayer);
            }

        });
    }

    private void passRightWait(final ArrayList<Card> computerCardsToPlayer) {
        passRightAnimation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                cardsReceivedPopUp(computerCardsToPlayer);
            }

        });
    }

    private void passAcrossWait(ArrayList<Card> computerCardsToPlayer) {
        final ArrayList<Card> computerCardsToPlayer1 = computerCardsToPlayer;
        passAcrossAnimation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                cardsReceivedPopUp(computerCardsToPlayer1);
            }

        });
    }

    private void middleWait(final int i) {
        if (i == 0) {
            middle1.setAnimationListener(new Animation.AnimationListener() {

                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
//                    displayTrickWinnerPopUp();
                    resetPlayedCards();
                    removeCardFromView(i);
                    Table.getInstance().getBoard().clear();

                }
            });
        }
        if (i == 1) {
            middle2.setAnimationListener(new Animation.AnimationListener() {

                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
//                    displayTrickWinnerPopUp();
                    resetPlayedCards();
                    removeCardFromView(i);
                    Table.getInstance().getBoard().clear();

                }

            });
        }
        if (i == 2) {
            middle3.setAnimationListener(new Animation.AnimationListener() {

                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
//                    displayTrickWinnerPopUp();
                    resetPlayedCards();
                    removeCardFromView(i);
                    Table.getInstance().getBoard().clear();


                }

            });
        }
        if (i == 3) {
            middle4.setAnimationListener(new Animation.AnimationListener() {

                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
//                    displayTrickWinnerPopUp();
                    resetPlayedCards();
                    removeCardFromView(i);
                    Table.getInstance().getBoard().clear();


                }

            });
        }
        if (i == 4) {
            middle5.setAnimationListener(new Animation.AnimationListener() {

                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
//                    displayTrickWinnerPopUp();
                    resetPlayedCards();
                    removeCardFromView(i);
                    Table.getInstance().getBoard().clear();


                }

            });
        }
        if (i == 5) {
            middle6.setAnimationListener(new Animation.AnimationListener() {

                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
//                    displayTrickWinnerPopUp();
                    resetPlayedCards();
                    removeCardFromView(i);
                    Table.getInstance().getBoard().clear();

                }

            });
        }
        if (i == 6) {
            middle7.setAnimationListener(new Animation.AnimationListener() {

                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
//                    displayTrickWinnerPopUp();
                    resetPlayedCards();
                    removeCardFromView(i);
                    Table.getInstance().getBoard().clear();


                }

            });
        }
        if (i == 7) {
            middle8.setAnimationListener(new Animation.AnimationListener() {

                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
//                    displayTrickWinnerPopUp();
                    resetPlayedCards();
                    removeCardFromView(i);
                    Table.getInstance().getBoard().clear();


                }

            });
        }
        if (i == 8) {
            middle9.setAnimationListener(new Animation.AnimationListener() {

                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
//                    displayTrickWinnerPopUp();
                    resetPlayedCards();
                    removeCardFromView(i);
                    Table.getInstance().getBoard().clear();


                }

            });
        }
        if (i == 9) {
            middle10.setAnimationListener(new Animation.AnimationListener() {

                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
//                    displayTrickWinnerPopUp();
                    resetPlayedCards();
                    removeCardFromView(i);
                    Table.getInstance().getBoard().clear();


                }

            });
        }
        if (i == 10) {
            middle11.setAnimationListener(new Animation.AnimationListener() {

                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
//                    displayTrickWinnerPopUp();
                    resetPlayedCards();
                    removeCardFromView(i);
                    Table.getInstance().getBoard().clear();

                }

            });
        }
        if (i == 11) {
            middle12.setAnimationListener(new Animation.AnimationListener() {

                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
//                    displayTrickWinnerPopUp();
                    resetPlayedCards();
                    removeCardFromView(i);
                    Table.getInstance().getBoard().clear();

                }

            });
        }
        if (i == 12) {
            middle13.setAnimationListener(new Animation.AnimationListener() {

                @Override
                public void onAnimationStart(Animation animation) {
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }

                @Override
                public void onAnimationEnd(Animation animation) {
//                    displayTrickWinnerPopUp();
                    resetPlayedCards();
                    removeCardFromView(i);
                    Table.getInstance().getBoard().clear();

                }

            });
        }
    }

    private void clickedCard(int i) {
        if (!Overlord.getInstance().getPassing()) {
            Card computerSelection;
            if (Overlord.getInstance().getLeadingPlayer().getName().equals(Table.getInstance().getPlayer2().getName())) {
                if (Overlord.getInstance().canPlayCard(Table.getInstance().getPlayer1().getHand().get(i), Table.getInstance().getPlayer1())) {
                    Table.getInstance().getBoard().add(Table.getInstance().getPlayer1().getHand().get(i));
                    playerCard.setImageResource(Table.getInstance().getPlayer1().getHand().get(i).getResId());
                    setSuitImage();

                    Table.getInstance().getPlayer1().getHand().remove(i);
                    Table.getInstance().getPlayer1().getHand().add(i, new Card(Rank.Joker, Suit.Joker, R.drawable.derpycard));

                    Overlord.getInstance().determineTrickWinner();
                    passMiddle(i);
                    middleWait(i);
//                    resetPlayedCards();
                    displayTrickWinnerPopUp();
//                    removeCardFromView(i);
//                    Table.getInstance().getBoard().clear();
                    Overlord.getInstance().setRoundsPlayed(Overlord.getInstance().getRoundsPlayed() + 1);
                } else {
                    cantPlayThatPopUp();
                }
            } else if (Overlord.getInstance().getLeadingPlayer().getName().equals(Table.getInstance().getPlayer3().getName())) {
                if (Overlord.getInstance().canPlayCard(Table.getInstance().getPlayer1().getHand().get(i), Table.getInstance().getPlayer1())) {
                    Table.getInstance().getBoard().add(Table.getInstance().getPlayer1().getHand().get(i));
                    playerCard.setImageResource(Table.getInstance().getPlayer1().getHand().get(i).getResId());
                    setSuitImage();

                    Table.getInstance().getPlayer1().getHand().remove(i);
                    Table.getInstance().getPlayer1().getHand().add(i, new Card(Rank.Joker, Suit.Joker, R.drawable.derpycard));

                    computerSelection = HAL9000.computer1MakesMove();
                    Table.getInstance().getBoard().add(computerSelection);
                    computer1Card.setImageResource(computerSelection.getResId());

                    Overlord.getInstance().determineTrickWinner();
                    passMiddle(i);
                    middleWait(i);
//                    resetPlayedCards();
                    displayTrickWinnerPopUp();
//                    removeCardFromView(i);
//                    Table.getInstance().getBoard().clear();
                    Overlord.getInstance().setRoundsPlayed(Overlord.getInstance().getRoundsPlayed() + 1);
                } else {
                    cantPlayThatPopUp();
                }
            } else if (Overlord.getInstance().getLeadingPlayer().getName().equals(Table.getInstance().getPlayer4().getName())) {
                if (Overlord.getInstance().canPlayCard(Table.getInstance().getPlayer1().getHand().get(i), Table.getInstance().getPlayer1())) {
                    Table.getInstance().getBoard().add(Table.getInstance().getPlayer1().getHand().get(i));
                    playerCard.setImageResource(Table.getInstance().getPlayer1().getHand().get(i).getResId());

                    Table.getInstance().getPlayer1().getHand().remove(i);
                    Table.getInstance().getPlayer1().getHand().add(i, new Card(Rank.Joker, Suit.Joker, R.drawable.derpycard));

                    computerSelection = HAL9000.computer1MakesMove();
                    Table.getInstance().getBoard().add(computerSelection);
                    computer1Card.setImageResource(computerSelection.getResId());

                    computerSelection = Terminator.computer2MakesMove();
                    Table.getInstance().getBoard().add(computerSelection);
                    computer2Card.setImageResource(computerSelection.getResId());

                    Overlord.getInstance().determineTrickWinner();
                    passMiddle(i);
                    middleWait(i);
//                    resetPlayedCards();
                    displayTrickWinnerPopUp();
//                    removeCardFromView(i);
//                    Table.getInstance().getBoard().clear();
                    Overlord.getInstance().setRoundsPlayed(Overlord.getInstance().getRoundsPlayed() + 1);
                } else {
                    cantPlayThatPopUp();
                }
            } else {
                if (Overlord.getInstance().canPlayCard(Table.getInstance().getPlayer1().getHand().get(i), Table.getInstance().getPlayer1())) {
                    Table.getInstance().getBoard().add(Table.getInstance().getPlayer1().getHand().get(i));
                    playerCard.setImageResource(Table.getInstance().getPlayer1().getHand().get(i).getResId());
                    // ToDo: deal with issue with removing cards:
                    Table.getInstance().getPlayer1().getHand().remove(i);
                    Table.getInstance().getPlayer1().getHand().add(i, new Card(Rank.Joker, Suit.Joker, R.drawable.derpycard));

                    computerSelection = HAL9000.computer1MakesMove();
                    Table.getInstance().getBoard().add(computerSelection);
                    computer1Card.setImageResource(computerSelection.getResId());

                    computerSelection = Terminator.computer2MakesMove();
                    Table.getInstance().getBoard().add(computerSelection);
                    computer2Card.setImageResource(computerSelection.getResId());

                    computerSelection = Zombocom.computer3MakesMove();
                    Table.getInstance().getBoard().add(computerSelection);
                    computer3Card.setImageResource(computerSelection.getResId());

                    Overlord.getInstance().determineTrickWinner();
                    passMiddle(i);
                    middleWait(i);
//                    resetPlayedCards();
                    displayTrickWinnerPopUp();
//                    removeCardFromView(i);
//                    Table.getInstance().getBoard().clear();
                    Overlord.getInstance().setRoundsPlayed(Overlord.getInstance().getRoundsPlayed() + 1);
                } else {
                    cantPlayThatPopUp();
                }
            }
        }
        // We are passing here:
        else {
            passButton.setText(Overlord.getInstance().getPassingDirection());
            passButton.setVisibility(View.VISIBLE);

            if (Table.getInstance().getPlayer1().getHand().get(i).isSelected()) {
                Table.getInstance().getPlayer1().getHand().get(i).setSelected(false);
                passCardSelector(i);
            } else {
                if (Table.getInstance().getPlayer1().getNumberOfSelectedCards() != 3) {
                    Table.getInstance().getPlayer1().getHand().get(i).setSelected(true);
                    passCardSelector(i);
                } else {
                    Toast.makeText(MainActivity.this, getString(R.string.three_cards_max), Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    public void clickedPassCards(View view) {
        if (Table.getInstance().getPlayer1().getNumberOfSelectedCards() != 3) {
            Toast.makeText(MainActivity.this, getString(R.string.must_pass_three), Toast.LENGTH_LONG).show();
        } else {
            if (Overlord.getInstance().passingDirection() == Direction.LEFT) {
                for (int x = 0; x < 13; x++) {
                    if (Table.getInstance().getPlayer1().getHand().get(x).isSelected()) {
                        passLeft(x);
                    }
                }
            }
            if (Overlord.getInstance().passingDirection() == Direction.RIGHT) {
                for (int x = 0; x < 13; x++) {
                    if (Table.getInstance().getPlayer1().getHand().get(x).isSelected()) {
                        passRight(x);
                    }
                }
            }
            if (Overlord.getInstance().passingDirection() == Direction.ACROSS) {
                for (int x = 0; x < 13; x++) {
                    if (Table.getInstance().getPlayer1().getHand().get(x).isSelected()) {
                        passAcross(x);
                    }
                }
            }
            ArrayList<Card> computerCardsToPlayer;
            switch (Overlord.getInstance().passingDirection()) {
                // Case: HAL9000:
                case LEFT:
                    System.out.println("Starting P1 hand: " + Arrays.toString(Table.getInstance().getPlayer1().getHand().toArray()));
                    System.out.println("Starting P2 hand: " + Arrays.toString(Table.getInstance().getPlayer2().getHand().toArray()));

                    computerCardsToPlayer = HAL9000.cardsToPassComp1();
                    for (int i = 0; i < 3; i++) {
                        Table.getInstance().getPlayer1().getHand().add(computerCardsToPlayer.get(i));
                    }

                    for (int i = 0; i < Table.getInstance().getPlayer1().getHand().size(); i++) {
                        if (Table.getInstance().getPlayer1().getHand().get(i).isSelected()) {
                            Table.getInstance().getPlayer1().getHand().get(i).setSelected(false);
                            Table.getInstance().getPlayer2().getHand().add(Table.getInstance().getPlayer1().getHand().get(i));
                            Table.getInstance().getPlayer1().getHand().remove(i);
                            i--;
                        }
                    }
                    passLeftWait(computerCardsToPlayer);
                    System.out.println("Ending P1 hand: " + Arrays.toString(Table.getInstance().getPlayer1().getHand().toArray()));
                    System.out.println("Ending P2 hand: " + Arrays.toString(Table.getInstance().getPlayer2().getHand().toArray()));
                    break;
                // Case: Zombocom:
                case RIGHT:
                    System.out.println("Starting P1 hand: " + Arrays.toString(Table.getInstance().getPlayer1().getHand().toArray()));
                    System.out.println("Starting P4 hand: " + Arrays.toString(Table.getInstance().getPlayer4().getHand().toArray()));

                    computerCardsToPlayer = Zombocom.cardsToPassComp3();
                    for (int i = 0; i < 3; i++) {
                        Table.getInstance().getPlayer1().getHand().add(computerCardsToPlayer.get(i));
                    }

                    for (int i = 0; i < Table.getInstance().getPlayer1().getHand().size(); i++) {
                        if (Table.getInstance().getPlayer1().getHand().get(i).isSelected()) {
                            Table.getInstance().getPlayer1().getHand().get(i).setSelected(false);
                            Table.getInstance().getPlayer4().getHand().add(Table.getInstance().getPlayer1().getHand().get(i));
                            Table.getInstance().getPlayer1().getHand().remove(i);
                            i--;
                        }
                    }
                    passRightWait(computerCardsToPlayer);

                    System.out.println("Ending P1 hand: " + Arrays.toString(Table.getInstance().getPlayer1().getHand().toArray()));
                    System.out.println("Ending P4 hand: " + Arrays.toString(Table.getInstance().getPlayer4().getHand().toArray()));
                    break;
                // Case: Terminator
                case ACROSS:
                    System.out.println("Starting P1 hand: " + Arrays.toString(Table.getInstance().getPlayer1().getHand().toArray()));
                    System.out.println("Starting P3 hand: " + Arrays.toString(Table.getInstance().getPlayer3().getHand().toArray()));

                    computerCardsToPlayer = Terminator.cardsToPassComp2();
                    for (int i = 0; i < 3; i++) {
                        Table.getInstance().getPlayer1().getHand().add(computerCardsToPlayer.get(i));
                    }

                    for (int i = 0; i < Table.getInstance().getPlayer1().getHand().size(); i++) {
                        if (Table.getInstance().getPlayer1().getHand().get(i).isSelected()) {
                            Table.getInstance().getPlayer1().getHand().get(i).setSelected(false);
                            Table.getInstance().getPlayer3().getHand().add(Table.getInstance().getPlayer1().getHand().get(i));
                            Table.getInstance().getPlayer1().getHand().remove(i);
                            i--;
                        }
                    }
                    passAcrossWait(computerCardsToPlayer);

                    System.out.println("Ending P1 hand: " + Arrays.toString(Table.getInstance().getPlayer1().getHand().toArray()));
                    System.out.println("Ending P3 hand: " + Arrays.toString(Table.getInstance().getPlayer3().getHand().toArray()));
                    break;
                case NO_PASSING:
                    Toast.makeText(MainActivity.this, "No Passing!", Toast.LENGTH_SHORT).show();
                    break;
            }

            Overlord.getInstance().setPassing(false);
            passButton.setVisibility(View.INVISIBLE);
//            cardsReceivedPopUp(computerCardsToPlayer);
        }

    }

    private void cardsReceivedPopUp(ArrayList<Card> computerCardsToPlayer) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(getString(R.string.app_name));
        builder.setMessage(getString(R.string.cards_received) + " " + Arrays.toString(computerCardsToPlayer.toArray()));
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Overlord.getInstance().setPlayerWithTheTwoOfClubs();
                Table.getInstance().getPlayer1().organizeHand();
                Table.getInstance().getPlayer2().organizeHand();
                Table.getInstance().getPlayer3().organizeHand();
                Table.getInstance().getPlayer4().organizeHand();
                for (int j = 0; j < 13; j++) {
                    removeCardFromView(j);
                }
                displayImages();
                animatePassingCards();
                createListeners();
                beginRound();
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    private void saveGame() {
        Table.saveTable(getApplicationContext());
        Overlord.saveOverlord(getApplicationContext());
    }

    private void loadGame() {
        Table.loadTable(getApplicationContext());
        Overlord.loadOverlord(getApplicationContext());
    }

    ImageView.OnClickListener onCardClick = new ImageView.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id = view.getId();
            switch (id) {
                case R.id.card_1:
                    clickedCard(0);
                    break;
                case R.id.card_2:
                    clickedCard(1);
                    break;
                case R.id.card_3:
                    clickedCard(2);
                    break;
                case R.id.card_4:
                    clickedCard(3);
                    break;
                case R.id.card_5:
                    clickedCard(4);
                    break;
                case R.id.card_6:
                    clickedCard(5);
                    break;
                case R.id.card_7:
                    clickedCard(6);
                    break;
                case R.id.card_8:
                    clickedCard(7);
                    break;
                case R.id.card_9:
                    clickedCard(8);
                    break;
                case R.id.card_10:
                    clickedCard(9);
                    break;
                case R.id.card_11:
                    clickedCard(10);
                    break;
                case R.id.card_12:
                    clickedCard(11);
                    break;
                case R.id.card_13:
                    clickedCard(12);
                    break;
                default:
                    break;
            }
        }
    };
}
