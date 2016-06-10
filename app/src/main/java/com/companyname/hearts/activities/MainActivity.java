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
    private ImageButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13;

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

        game = new HeartsModel(playerNames[0], playerNames[1], playerNames[2], playerNames[3]);

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

    public void clickedCard(int i) {
        testView.setText(game.getPlayer1().getHand().get(i).toString());
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
