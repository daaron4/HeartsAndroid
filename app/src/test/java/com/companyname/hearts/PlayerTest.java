package com.companyname.hearts;

import com.companyname.hearts.model.Card;
import com.companyname.hearts.model.Player;
import com.companyname.hearts.model.Rank;
import com.companyname.hearts.model.Suit;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by daaron on 6/15/16.
 */

public class PlayerTest {

    private Player testPlayer;
    private ArrayList<Card> testHand;

    @Before
    public void setUp() {
        testPlayer = new Player("Tester");
        testHand = new ArrayList<>();
        Card cardOne = new Card(Rank.Ace, Suit.Clubs, R.drawable.ace_clubs);
        testHand.add(cardOne);
    }

    @Test
    public void testPlayer() {
        assertEquals("Tester", testPlayer.getName());
        assertEquals(0, testPlayer.getPoints());
        assertEquals(0, testPlayer.getHand().size());
        assertEquals(0, testPlayer.getOldCards().size());
        testPlayer.setHand(testHand);
        assertEquals(1, testPlayer.getHand().size());
        testPlayer.setOldCards(testHand);
        assertEquals(1, testPlayer.getOldCards().size());
        testPlayer.setPoints(55);
        assertEquals(55, testPlayer.getPoints());
    }


}
