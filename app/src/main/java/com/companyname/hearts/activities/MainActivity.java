package com.companyname.hearts.activities;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.companyname.hearts.R;
import com.companyname.hearts.model.Card;
import com.companyname.hearts.model.ComputerManager;
import com.companyname.hearts.model.Dealer;
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
//    private TextView testView;
    private Button passButton;
    private ImageView b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();
        createListeners();
        setUpGame();
        displayImages();
        beginRound();
    }

    private void initializeViews() {
        playerName = (TextView) findViewById(R.id.player_name);
        computer1Name = (TextView) findViewById(R.id.computer1_name);
        computer2Name = (TextView) findViewById(R.id.computer2_name);
        computer3Name = (TextView) findViewById(R.id.computer3_name);
//        testView = (TextView) findViewById(R.id.test_view);
        passButton = (Button) findViewById(R.id.pass_cards_button);

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

        Intent currentIntent = getIntent();
        String[] playerNames = currentIntent.getStringArrayExtra("playerNames");
        playerName.setText(playerNames[0]);
        computer1Name.setText(playerNames[1]);
        computer2Name.setText(playerNames[2]);
        computer3Name.setText(playerNames[3]);
        Table.getInstance().initializeTable(playerNames[0], playerNames[1], playerNames[2], playerNames[3]);
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
        // ToDo: decide if computer hands should be sorted as well
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
    }

    private void cantPlayThatPopUp() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Hearts");
        builder.setMessage("You can't play that!");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
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
        builder.setTitle("Hearts");
        builder.setMessage(Overlord.getInstance().getLeadingPlayer().getName() + " wins the trick.");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (Overlord.getInstance().getRoundsPlayed() == 14) {
                    // ToDo: display old cards if desired first:
                    displayScorePopUp();
                } else {
                    beginRound();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    private void displayScorePopUp() {
        // ToDo: remove old cards if desired first:
        Overlord.getInstance().calculatePoints();
        Overlord.getInstance().updatePlaying();
        Overlord.getInstance().reset();

        if (!Overlord.getInstance().getPlaying()) {
            playAgainPopUp();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Hearts");
            builder.setMessage(Table.getInstance().getPlayer1().getName() + " : " + Table.getInstance().getPlayer1().getPoints() + "\n" +
                    Table.getInstance().getPlayer2().getName() + " : " + Table.getInstance().getPlayer2().getPoints() + "\n" +
                    Table.getInstance().getPlayer3().getName() + " : " + Table.getInstance().getPlayer3().getPoints() + "\n" +
                    Table.getInstance().getPlayer4().getName() + " : " + Table.getInstance().getPlayer4().getPoints() + "\n");
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    setUpGame();
                    displayImages();
                    createListeners();
                    beginRound();
                }
            });
            builder.setCancelable(false);
            builder.show();
        }
    }

    private void playAgainPopUp() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(Overlord.getInstance().getWinningPlayer().getName() + " wins the game!");
        builder.setMessage(Table.getInstance().getPlayer1().getName() + " : " + Table.getInstance().getPlayer1().getPoints() + "\n" +
                Table.getInstance().getPlayer2().getName() + " : " + Table.getInstance().getPlayer2().getPoints() + "\n" +
                Table.getInstance().getPlayer3().getName() + " : " + Table.getInstance().getPlayer3().getPoints() + "\n" +
                Table.getInstance().getPlayer4().getName() + " : " + Table.getInstance().getPlayer4().getPoints() + "\n");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setPositiveButton("Play Again?", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Overlord.getInstance().prepareForNextGame();
                setUpGame();
                displayImages();
                createListeners();
                beginRound();
            }
        });
        builder.setNegativeButton("Quit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Bye", Toast.LENGTH_LONG).show();
                finish();
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    @SuppressLint("SetTextI18n")
    private void beginRound() {
        if (!Overlord.getInstance().getPassing()) {
            Card computerSelection;
            if (Overlord.getInstance().getLeadingPlayer() == Table.getInstance().getPlayer2()) {
                computerSelection = ComputerManager.computer1MakesMove();
                Table.getInstance().getBoard().add(computerSelection);
//                testView.setText(testView.getText() + Table.getInstance().getPlayer2().getName()
//                        + " played: " + computerSelection.toString() + "\n");

                computerSelection = ComputerManager.computer2MakesMove();
                Table.getInstance().getBoard().add(computerSelection);
//                testView.setText(testView.getText() + Table.getInstance().getPlayer3().getName()
//                        + " played: " + computerSelection.toString() + "\n");

                computerSelection = ComputerManager.computer3MakesMove();
                Table.getInstance().getBoard().add(computerSelection);
//                testView.setText(testView.getText() + Table.getInstance().getPlayer4().getName()
//                        + " played: " + computerSelection.toString() + "\n");
            } else if (Overlord.getInstance().getLeadingPlayer() == Table.getInstance().getPlayer3()) {
                computerSelection = ComputerManager.computer2MakesMove();
                Table.getInstance().getBoard().add(computerSelection);
//                testView.setText(testView.getText() + Table.getInstance().getPlayer3().getName()
//                        + " played: " + computerSelection.toString() + "\n");

                computerSelection = ComputerManager.computer3MakesMove();
                Table.getInstance().getBoard().add(computerSelection);
//                testView.setText(testView.getText() + Table.getInstance().getPlayer4().getName()
//                        + " played: " + computerSelection.toString() + "\n");
            } else if (Overlord.getInstance().getLeadingPlayer() == Table.getInstance().getPlayer4()) {
                computerSelection = ComputerManager.computer3MakesMove();
                Table.getInstance().getBoard().add(computerSelection);
//                testView.setText(testView.getText() + Table.getInstance().getPlayer4().getName()
//                        + " played: " + computerSelection.toString() + "\n");
            }
        } else {
            passButton.setText(Overlord.getInstance().getPassingDirection());
            passButton.setVisibility(View.VISIBLE);
        }

    }

    private void fixTransparentImages() {
        b1.setAlpha((float) 1);
        b2.setAlpha((float) 1);
        b3.setAlpha((float) 1);
        b4.setAlpha((float) 1);
        b5.setAlpha((float) 1);
        b6.setAlpha((float) 1);
        b7.setAlpha((float) 1);
        b8.setAlpha((float) 1);
        b9.setAlpha((float) 1);
        b10.setAlpha((float) 1);
        b12.setAlpha((float) 1);
        b12.setAlpha((float) 1);
        b13.setAlpha((float) 1);
    }

    private void passCardSelector(int i) {
        switch (i) {
            case 0:
                if (Table.getInstance().getPlayer1().getHand().get(0).isSelected()) {
                    b1.setAlpha((float) 0.5);
                }
                else {
                    b1.setAlpha((float) 1);
                }
                break;
            case 1:
                if (Table.getInstance().getPlayer1().getHand().get(1).isSelected()) {
                    b2.setAlpha((float) 0.5);
                } else {
                    b2.setAlpha((float) 1);
                }
                break;
            case 2:
                if (Table.getInstance().getPlayer1().getHand().get(2).isSelected()) {
                    b3.setAlpha((float) 0.5);
                } else {
                    b3.setAlpha((float) 1);
                }
                break;
            case 3:
                if (Table.getInstance().getPlayer1().getHand().get(3).isSelected()) {
                    b4.setAlpha((float) 0.5);
                } else {
                    b4.setAlpha((float) 1);
                }
                break;
            case 4:
                if (Table.getInstance().getPlayer1().getHand().get(4).isSelected()) {
                    b5.setAlpha((float) 0.5);
                } else {
                    b5.setAlpha((float) 1);
                }
                break;
            case 5:
                if (Table.getInstance().getPlayer1().getHand().get(5).isSelected()) {
                    b6.setAlpha((float) 0.5);
                } else {
                    b6.setAlpha((float) 1);
                }
                break;
            case 6:
                if (Table.getInstance().getPlayer1().getHand().get(6).isSelected()) {
                    b7.setAlpha((float) 0.5);
                } else {
                    b7.setAlpha((float) 1);
                }
                break;
            case 7:
                if (Table.getInstance().getPlayer1().getHand().get(7).isSelected()) {
                    b8.setAlpha((float) 0.5);
                } else {
                    b8.setAlpha((float) 1);
                }
                break;
            case 8:
                if (Table.getInstance().getPlayer1().getHand().get(8).isSelected()) {
                    b9.setAlpha((float) 0.5);
                } else {
                    b9.setAlpha((float) 1);
                }
                break;
            case 9:
                if (Table.getInstance().getPlayer1().getHand().get(9).isSelected()) {
                    b10.setAlpha((float) 0.5);
                } else {
                    b10.setAlpha((float) 1);
                }
                break;
            case 10:
                if (Table.getInstance().getPlayer1().getHand().get(10).isSelected()) {
                    b11.setAlpha((float) 0.5);
                } else {
                    b11.setAlpha((float) 1);
                }
                break;
            case 11:
                if (Table.getInstance().getPlayer1().getHand().get(11).isSelected()) {
                    b12.setAlpha((float) 0.5);
                } else {
                    b12.setAlpha((float) 1);
                }
                break;
            case 12:
                if (Table.getInstance().getPlayer1().getHand().get(12).isSelected()) {
                    b13.setAlpha((float) 0.5);
                } else {
                    b13.setAlpha((float) 1);
                }
                break;
        }
    }

    private void removeCardFromView(int i) {
        if (i == 0) {
            b1.setImageResource(0);
            b1.setOnClickListener(null);
        } else if (i == 1) {
            b2.setImageResource(0);
            b2.setOnClickListener(null);
        } else if (i == 2) {
            b3.setImageResource(0);
            b3.setOnClickListener(null);
        } else if (i == 3) {
            b4.setImageResource(0);
            b4.setOnClickListener(null);
        } else if (i == 4) {
            b5.setImageResource(0);
            b5.setOnClickListener(null);
        } else if (i == 5) {
            b6.setImageResource(0);
            b6.setOnClickListener(null);
        } else if (i == 6) {
            b7.setImageResource(0);
            b7.setOnClickListener(null);
        } else if (i == 7) {
            b8.setImageResource(0);
            b8.setOnClickListener(null);
        } else if (i == 8) {
            b9.setImageResource(0);
            b9.setOnClickListener(null);
        } else if (i == 9) {
            b10.setImageResource(0);
            b10.setOnClickListener(null);
        } else if (i == 10) {
            b11.setImageResource(0);
            b11.setOnClickListener(null);
        } else if (i == 11) {
            b12.setImageResource(0);
            b12.setOnClickListener(null);
        } else if (i == 12) {
            b13.setImageResource(0);
            b13.setOnClickListener(null);
        }

    }

    @SuppressLint("SetTextI18n")
    private void clickedCard(int i) {
        if (!Overlord.getInstance().getPassing()) {
            Card computerSelection;
            if (Overlord.getInstance().getLeadingPlayer() == Table.getInstance().getPlayer2()) {
                if (Overlord.getInstance().canPlayCard(Table.getInstance().getPlayer1().getHand().get(i), Table.getInstance().getPlayer1())) {
                    Table.getInstance().getBoard().add(Table.getInstance().getPlayer1().getHand().get(i));
//                    testView.setText(testView.getText() + "Player 1 played: " + Table.getInstance().getPlayer1().getHand().get(i).toString() + "\n");
                    // ToDo: deal with issue with removing cards:
                    Table.getInstance().getPlayer1().getHand().remove(i);
                    Table.getInstance().getPlayer1().getHand().add(i, new Card(Rank.Joker, Suit.Joker, R.drawable.derpycard));

                    Overlord.getInstance().determineTrickWinner();
                    displayTrickWinnerPopUp();
                    removeCardFromView(i);
//                    testView.setText("");
                    Overlord.getInstance().setRoundsPlayed(Overlord.getInstance().getRoundsPlayed() + 1);
                } else {
                    cantPlayThatPopUp();
                }
            } else if (Overlord.getInstance().getLeadingPlayer() == Table.getInstance().getPlayer3()) {
                if (Overlord.getInstance().canPlayCard(Table.getInstance().getPlayer1().getHand().get(i), Table.getInstance().getPlayer1())) {
                    Table.getInstance().getBoard().add(Table.getInstance().getPlayer1().getHand().get(i));
//                    testView.setText(testView.getText() + "Player 1 played: " + Table.getInstance().getPlayer1().getHand().get(i).toString() + "\n");
                    // ToDo: deal with issue with removing cards:
                    Table.getInstance().getPlayer1().getHand().remove(i);
                    Table.getInstance().getPlayer1().getHand().add(i, new Card(Rank.Joker, Suit.Joker, R.drawable.derpycard));

                    computerSelection = ComputerManager.computer1MakesMove();
                    Table.getInstance().getBoard().add(computerSelection);
//                    testView.setText(testView.getText() + Table.getInstance().getPlayer2().getName()
//                            + " played: " + computerSelection.toString() + "\n");

                    Overlord.getInstance().determineTrickWinner();
                    displayTrickWinnerPopUp();
                    removeCardFromView(i);
//                    testView.setText("");
                    Overlord.getInstance().setRoundsPlayed(Overlord.getInstance().getRoundsPlayed() + 1);
                } else {
                    cantPlayThatPopUp();
                }
            } else if (Overlord.getInstance().getLeadingPlayer() == Table.getInstance().getPlayer4()) {
                if (Overlord.getInstance().canPlayCard(Table.getInstance().getPlayer1().getHand().get(i), Table.getInstance().getPlayer1())) {
                    Table.getInstance().getBoard().add(Table.getInstance().getPlayer1().getHand().get(i));
//                    testView.setText(testView.getText() + "Player 1 played: " + Table.getInstance().getPlayer1().getHand().get(i).toString() + "\n");
                    // ToDo: deal with issue with removing cards:
                    Table.getInstance().getPlayer1().getHand().remove(i);
                    Table.getInstance().getPlayer1().getHand().add(i, new Card(Rank.Joker, Suit.Joker, R.drawable.derpycard));

                    computerSelection = ComputerManager.computer1MakesMove();
                    Table.getInstance().getBoard().add(computerSelection);
//                    testView.setText(testView.getText() + Table.getInstance().getPlayer2().getName()
//                            + " played: " + computerSelection.toString() + "\n");

                    computerSelection = ComputerManager.computer2MakesMove();
                    Table.getInstance().getBoard().add(computerSelection);
//                    testView.setText(testView.getText() + Table.getInstance().getPlayer3().getName()
//                            + " played: " + computerSelection.toString() + "\n");

                    Overlord.getInstance().determineTrickWinner();
                    displayTrickWinnerPopUp();
                    removeCardFromView(i);
//                    testView.setText("");
                    Overlord.getInstance().setRoundsPlayed(Overlord.getInstance().getRoundsPlayed() + 1);
                } else {
                    cantPlayThatPopUp();
                }
            } else {
                if (Overlord.getInstance().canPlayCard(Table.getInstance().getPlayer1().getHand().get(i), Table.getInstance().getPlayer1())) {
                    Table.getInstance().getBoard().add(Table.getInstance().getPlayer1().getHand().get(i));
//                    testView.setText(testView.getText() + "Player 1 played: " + Table.getInstance().getPlayer1().getHand().get(i).toString() + "\n");
                    // ToDo: deal with issue with removing cards:
                    Table.getInstance().getPlayer1().getHand().remove(i);
                    Table.getInstance().getPlayer1().getHand().add(i, new Card(Rank.Joker, Suit.Joker, R.drawable.derpycard));


                    computerSelection = ComputerManager.computer1MakesMove();
                    Table.getInstance().getBoard().add(computerSelection);
//                    testView.setText(testView.getText() + Table.getInstance().getPlayer2().getName()
//                            + " played: " + computerSelection.toString() + "\n");

                    computerSelection = ComputerManager.computer2MakesMove();
                    Table.getInstance().getBoard().add(computerSelection);
//                    testView.setText(testView.getText() + Table.getInstance().getPlayer3().getName()
//                            + " played: " + computerSelection.toString() + "\n");

                    computerSelection = ComputerManager.computer3MakesMove();
                    Table.getInstance().getBoard().add(computerSelection);
//                    testView.setText(testView.getText() + Table.getInstance().getPlayer4().getName()
//                            + " played: " + computerSelection.toString() + "\n");

                    Overlord.getInstance().determineTrickWinner();
                    displayTrickWinnerPopUp();
                    removeCardFromView(i);
//                    testView.setText("");
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
            }
            else {
                if (Table.getInstance().getPlayer1().getNumberOfSelectedCards() != 3) {
                    Table.getInstance().getPlayer1().getHand().get(i).setSelected(true);
                    passCardSelector(i);
                }
                else {
                    Toast.makeText(MainActivity.this, "You can't pass more than three cards", Toast.LENGTH_LONG).show();
                }
            }

        }
    }

    public void clickedPassCards(View view) {
        if (Table.getInstance().getPlayer1().getNumberOfSelectedCards() != 3) {
            Toast.makeText(MainActivity.this, "You must pass three cards", Toast.LENGTH_LONG).show();
        } else {
            for (int i = 0; i < Table.getInstance().getPlayer1().getHand().size(); i++) {
                if (Table.getInstance().getPlayer1().getHand().get(i).isSelected()) {
                    System.out.println("IN HERE");
                    Table.getInstance().getPlayer1().getHand().get(i).setSelected(false);
                    Table.getInstance().getPlayer2().getHand().add(Table.getInstance().getPlayer1().getHand().get(i));
                    Table.getInstance().getPlayer1().getHand().remove(i);
                    i--;
                }
            }

            // ToDo: make computer selections better:
            ArrayList<Card> computerCardsToPlayer = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                Card passMe = Table.getInstance().getPlayer2().getHand().get(i);
                computerCardsToPlayer.add(passMe);
                Table.getInstance().getPlayer2().getHand().remove(i);
                Table.getInstance().getPlayer1().getHand().add(passMe);
            }

            Overlord.getInstance().setPassing(false);
            passButton.setVisibility(View.INVISIBLE);

            cardsReceivedPopUp(computerCardsToPlayer);
        }

   }

    private void cardsReceivedPopUp(ArrayList<Card> computerCardsToPlayer) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Hearts");
        builder.setMessage("You received: " + Arrays.toString(computerCardsToPlayer.toArray()));
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Overlord.getInstance().setPlayerWithTheTwoOfClubs();
                Table.getInstance().getPlayer1().organizeHand();
                // ToDo: decide if computer hands should be sorted as well
                Table.getInstance().getPlayer2().organizeHand();
                Table.getInstance().getPlayer3().organizeHand();
                Table.getInstance().getPlayer4().organizeHand();
                for (int j = 0; j < 13; j++) {
                    removeCardFromView(j);
                }
                displayImages();
                fixTransparentImages();
                createListeners();
                beginRound();
            }
        });
        builder.setCancelable(false);
        builder.show();
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
