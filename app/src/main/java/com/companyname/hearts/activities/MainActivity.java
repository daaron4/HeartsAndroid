package com.companyname.hearts.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.companyname.hearts.R;
import com.companyname.hearts.model.Card;
import com.companyname.hearts.model.HeartsModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView playerName;
    private TextView computer1Name;
    private TextView computer2Name;
    private TextView computer3Name;
    private TextView testView;
    private ImageButton b1;
    private ImageButton b2;
    private ImageButton b3;
    private ImageButton b4;
    private ImageButton b5;
    private ImageButton b6;
    private ImageButton b7;
    private ImageButton b8;
    private ImageButton b9;
    private ImageButton b10;
    private ImageButton b11;
    private ImageButton b12;
    private ImageButton b13;

    private HeartsModel game;
    private int turns;
    private boolean timeToShuffleAndDeal;
    private Random rand;
    private int randNum;
    private boolean passing;
    private int roundsPlayed;
    private int timesClicked;
    private ArrayList<Card> temp;

    // ToDo: delete this variable when ready:
    private int scoreBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerName = (TextView) findViewById(R.id.player_name);
        computer1Name = (TextView) findViewById(R.id.computer1_name);
        computer2Name = (TextView) findViewById(R.id.computer2_name);
        computer3Name = (TextView) findViewById(R.id.computer3_name);

        b1 = (ImageButton) findViewById(R.id.card_1);
        b2 = (ImageButton) findViewById(R.id.card_2);
        b3 = (ImageButton) findViewById(R.id.card_3);
        b4 = (ImageButton) findViewById(R.id.card_4);
        b5 = (ImageButton) findViewById(R.id.card_5);
        b6 = (ImageButton) findViewById(R.id.card_6);
        b7 = (ImageButton) findViewById(R.id.card_7);
        b8 = (ImageButton) findViewById(R.id.card_8);
        b9 = (ImageButton) findViewById(R.id.card_9);
        b10 = (ImageButton) findViewById(R.id.card_10);
        b11 = (ImageButton) findViewById(R.id.card_11);
        b12 = (ImageButton) findViewById(R.id.card_12);
        b13 = (ImageButton) findViewById(R.id.card_13);

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

        testView = (TextView) findViewById(R.id.test_view);

        Intent currentIntent = getIntent();
        String[] playerNames = currentIntent.getStringArrayExtra("playerNames");
        playerName.setText(playerNames[0]);
        computer1Name.setText(playerNames[1]);
        computer2Name.setText(playerNames[2]);
        computer3Name.setText(playerNames[3]);

        game = new HeartsModel(playerNames[0], playerNames[1], playerNames[2], playerNames[3], getApplicationContext());

        turns = 1;
        rand = new Random();
        randNum = -1;
        timeToShuffleAndDeal = true;
        passing = true;
        temp = new ArrayList<>();
        roundsPlayed = 0;
        timesClicked = 0;
        // ToDo: handle this:
        scoreBoard = -9001;

        start();

    }

    public void displayOldCards() {
        // ToDo: write this method
    }

    public void updateScoreBoard() {
        // ToDo: write this method
    }

    public void displayPoints() {
        // ToDo: write this method
    }

    public void removeOldCards() {
        // ToDo: write this method
    }

    public void start() {
        if (turns == 14) {
            // Calculate points:
            game.calculatePoints();
            // Display old cards:
            displayOldCards();
            // date scoreBoard:
            updateScoreBoard();
            // Display points:
            displayPoints();
            // Clear the board:
            removeOldCards();
            // Update playing to see if the game has ended:
            game.updatePlayingGUI();
            // Game is over, display winner, ask to play again:
            if (game.getPlaying() == false) {
                // ToDo: rewrite this block:
//                int reply = JOptionPane.showConfirmDialog(null,
//                        game.displayWinnerStringVersion() + '\n'
//                                + "Play Again?", "Game Over",
//                        JOptionPane.YES_NO_OPTION);
//                if (reply == JOptionPane.YES_OPTION) {
//                    roundsPlayed = 0;
//                    scoreBoard.setText(null);
//                    scoreBoard = new JTextArea(game.getPlayer1().getName()
//                            + '\t' + game.getPlayer2().getName() + '\t'
//                            + game.getPlayer3().getName() + '\t'
//                            + game.getPlayer4().getName());
//                    game.setPlaying(true);
//                    game.getPlayer1().setPoints(0);
//                    game.getPlayer2().setPoints(0);
//                    game.getPlayer3().setPoints(0);
//                    game.getPlayer4().setPoints(0);
//
//                } else {
//                    JOptionPane.showMessageDialog(null, "Peace");
//                    System.exit(0);
//                }
            }
            // Get ready for the next hand:
            // ToDo: rewrite this as well:
//            game.reset();
//            turns = 1;
//            timeToShuffleAndDeal = true;
//            passing = true;
        }
        if (timeToShuffleAndDeal == true) {
            roundsPlayed++;
            game.getDeck().shuffle();
            game.getDeck().deal(game.getPlayer1(), game.getPlayer2(),
                    game.getPlayer3(), game.getPlayer4());
            // Organize hands:
            game.sort(game.getPlayer1().getHand());
            game.sort(game.getPlayer2().getHand());
            game.sort(game.getPlayer3().getHand());
            game.sort(game.getPlayer4().getHand());
            Collections.sort(game.getPlayer1().getHand());
            Collections.sort(game.getPlayer2().getHand());
            Collections.sort(game.getPlayer3().getHand());
            Collections.sort(game.getPlayer4().getHand());

            // Pass Cards:
            // ToDo: deal with passing later
            // game.passCards(game.getRoundsPlayed());

            // display the game:
            displayImages();
            timeToShuffleAndDeal = false;
            if (turns == 1) {
                game.setLeadingPlayer(game.playerWithTheTwoOfClubs());
            }

            if (game.getLeadingPlayer() == game.getPlayer2()) {
                System.out.println("comp1 goes");
                // comp1 plays a card:
                Card comp1Card;
                comp1Card = game.computerPlaysACard(1, turns);
                // add card to board:
                game.getBoard().add(0, comp1Card);

                // comp2 plays a card:
                Card comp2Card;
                comp2Card = game.computerPlaysACard(2, turns);
                // add card to board:
                game.getBoard().add(1, comp2Card);

                // comp3 plays a card:
                Card comp3Card;
                comp3Card = game.computerPlaysACard(3, turns);
                // add card to board:
                game.getBoard().add(2, comp3Card);

            }

            // /////////////////////////////////////////
            // Now dealing with lead is comp2:

            else if (game.getLeadingPlayer() == game.getPlayer3()) {
                System.out.println("comp2 goes");
                // comp2 plays a card:
                Card comp2Card;
                comp2Card = game.computerPlaysACard(2, turns);
                // add card to board:
                game.getBoard().add(0, comp2Card);

                // comp3 plays a card:
                Card comp3Card;
                comp3Card = game.computerPlaysACard(3, turns);
                // add card to board:
                game.getBoard().add(1, comp3Card);


            }
            // /////////////////////////////////////////
            // Now dealing with lead is comp3:

            else if (game.getLeadingPlayer() == game.getPlayer4()) {
                System.out.println("comp3 goes");
                // comp3 plays a card:
                Card comp3Card;
                comp3Card = game.computerPlaysACard(3, turns);
                // add card to board:
                game.getBoard().add(0, comp3Card);

            }

            displayBoard();

        }

        // Pass Cards:
        // ToDo: deal with passing later

    }

    public void displayBoard() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < game.getBoard().size(); i++) {
            stringBuilder.append(game.getBoard().get(i).toString()).append("\n");
        }
        testView.setText(stringBuilder.toString());
    }


    public void test() {
        for (int turns = 1; turns <= 13; turns++) {
            System.out.println();
            // see who goes first:
            if (turns == 1) {
                game.setLeadingPlayer(game.playerWithTheTwoOfClubs());
            }

            if (game.getLeadingPlayer() == game.getPlayer1()) {

                // human plays a card:
                Card userCard;
                userCard = game.humanPlaysACard(turns, "");
                // add card to board:
                game.getBoard().add(0, userCard);

                // comp1 plays a card:
                Card comp1Card;
                comp1Card = game.computerPlaysACard(1, turns);
                // add card to board:
                game.getBoard().add(1, comp1Card);

                // comp2 plays a card:
                Card comp2Card;
                comp2Card = game.computerPlaysACard(2, turns);
                // add card to board:
                game.getBoard().add(2, comp2Card);

                // comp3 plays a card:
                Card comp3Card;
                comp3Card = game.computerPlaysACard(3, turns);
                game.getBoard().add(3, comp3Card);


                // display board:
                for (int i = 0; i < game.getBoard().size(); i++)
                    System.out.println("Board is "
                            + game.getBoard().get(i).toString());

                // see who won the trick:
                game.determineWinner(1);

                // display cards in old hands:
                game.displayOldCards();

                // /////////////////////////////////////////
                // Now dealing with lead is comp1:

            }

        }
    }

    public void displayImages() {
        Card c1 = game.getPlayer1().getHand().get(0);
        Card c2 = game.getPlayer1().getHand().get(1);
        Card c3 = game.getPlayer1().getHand().get(2);
        Card c4 = game.getPlayer1().getHand().get(3);
        Card c5 = game.getPlayer1().getHand().get(4);
        Card c6 = game.getPlayer1().getHand().get(5);
        Card c7 = game.getPlayer1().getHand().get(6);
        Card c8 = game.getPlayer1().getHand().get(7);
        Card c9 = game.getPlayer1().getHand().get(8);
        Card c10 = game.getPlayer1().getHand().get(9);
        Card c11 = game.getPlayer1().getHand().get(10);
        Card c12 = game.getPlayer1().getHand().get(11);
        Card c13 = game.getPlayer1().getHand().get(12);

        b1.setImageBitmap(c1.getCardImage());
        b2.setImageBitmap(c2.getCardImage());
        b3.setImageBitmap(c3.getCardImage());
        b4.setImageBitmap(c4.getCardImage());
        b5.setImageBitmap(c5.getCardImage());
        b6.setImageBitmap(c6.getCardImage());
        b7.setImageBitmap(c7.getCardImage());
        b8.setImageBitmap(c8.getCardImage());
        b9.setImageBitmap(c9.getCardImage());
        b10.setImageBitmap(c10.getCardImage());
        b11.setImageBitmap(c11.getCardImage());
        b12.setImageBitmap(c12.getCardImage());
        b13.setImageBitmap(c13.getCardImage());
    }

    public void clickedCard(int cardNumber) {
        Card userSelection = game.getPlayer1().getHand().get(cardNumber);
        if (!game.canPlayCard(userSelection, game.getPlayer1().getHand(), game.getLeadingPlayer(), game.getPlayer1(), turns)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Can't play that");
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
        // ToDo: here! this is big!
        else {
            testView.setText(testView.getText() + userSelection.toString() + "\n");
        }
    }

    ImageButton.OnClickListener onCardClick = new ImageButton.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id = view.getId();
            switch(id) {
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
