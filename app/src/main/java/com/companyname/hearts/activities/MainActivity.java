package com.companyname.hearts.activities;

import android.content.Intent;
import android.os.Bundle;
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

        testView = (TextView) findViewById(R.id.test_view);

        Intent currentIntent = getIntent();
        String[] playerNames = currentIntent.getStringArrayExtra("playerNames");
        playerName.setText(playerNames[0]);
        computer1Name.setText(playerNames[1]);
        computer2Name.setText(playerNames[2]);
        computer3Name.setText(playerNames[3]);

        game = new HeartsModel(playerNames[0], playerNames[1], playerNames[2], playerNames[3], getApplicationContext());
        game.getDeck().shuffle();
        game.getDeck().deal(game.getPlayer1(), game.getPlayer2(), game.getPlayer3(), game.getPlayer4());

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
        }

        // Pass Cards:
        // ToDo: deal with passing later

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

        ImageButton b1 = (ImageButton) findViewById(R.id.card_1);
        ImageButton b2 = (ImageButton) findViewById(R.id.card_2);
        ImageButton b3 = (ImageButton) findViewById(R.id.card_3);
        ImageButton b4 = (ImageButton) findViewById(R.id.card_4);
        ImageButton b5 = (ImageButton) findViewById(R.id.card_5);
        ImageButton b6 = (ImageButton) findViewById(R.id.card_6);
        ImageButton b7 = (ImageButton) findViewById(R.id.card_7);
        ImageButton b8 = (ImageButton) findViewById(R.id.card_8);
        ImageButton b9 = (ImageButton) findViewById(R.id.card_9);
        ImageButton b10 = (ImageButton) findViewById(R.id.card_10);
        ImageButton b11 = (ImageButton) findViewById(R.id.card_11);
        ImageButton b12 = (ImageButton) findViewById(R.id.card_12);
        ImageButton b13 = (ImageButton) findViewById(R.id.card_13);

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


    // ToDo: Write All these methods:
    public void clickedCard1(View view) {
        Card c = game.getPlayer1().getHand().get(0);
        testView.setText(c.toString());
        // ToDo: some kind of play method here:
        //play();
    }

    public void clickedCard2(View view) {
        Card c = game.getPlayer1().getHand().get(1);
        testView.setText(c.toString());
    }

    public void clickedCard3(View view) {
        Card c = game.getPlayer1().getHand().get(2);
        testView.setText(c.toString());
    }

    public void clickedCard4(View view) {
        Card c = game.getPlayer1().getHand().get(3);
        testView.setText(c.toString());
    }

    public void clickedCard5(View view) {
        Card c = game.getPlayer1().getHand().get(4);
        testView.setText(c.toString());
    }

    public void clickedCard6(View view) {
        Card c = game.getPlayer1().getHand().get(5);
        testView.setText(c.toString());
    }

    public void clickedCard7(View view) {
        Card c = game.getPlayer1().getHand().get(6);
        testView.setText(c.toString());
    }

    public void clickedCard8(View view) {
        Card c = game.getPlayer1().getHand().get(7);
        testView.setText(c.toString());
    }

    public void clickedCard9(View view) {
        Card c = game.getPlayer1().getHand().get(8);
        testView.setText(c.toString());
    }

    public void clickedCard10(View view) {
        Card c = game.getPlayer1().getHand().get(9);
        testView.setText(c.toString());
    }

    public void clickedCard11(View view) {
        Card c = game.getPlayer1().getHand().get(10);
        testView.setText(c.toString());
    }

    public void clickedCard12(View view) {
        Card c = game.getPlayer1().getHand().get(11);
        testView.setText(c.toString());
    }

    public void clickedCard13(View view) {
        Card c = game.getPlayer1().getHand().get(12);
        testView.setText(c.toString());
    }

}
