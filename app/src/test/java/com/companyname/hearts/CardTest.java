package com.companyname.hearts;

import com.companyname.hearts.model.Card;
import com.companyname.hearts.model.Rank;
import com.companyname.hearts.model.Suit;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by daaron on 6/15/16.
 */
public class CardTest {

    // ToDo: test compareTo() when ready:

    private Card testCard;

    @Before
    public void setUp() {
        testCard = new Card(Rank.Three, Suit.Spades, R.drawable.three_spades);
    }

    @Test
    public void testCard() {
        assertEquals("Three of Spades", testCard.toString());
        assertEquals(Rank.Three, testCard.getRank());
        assertEquals(3, testCard.getRank().getValue());
        assertEquals(Suit.Spades, testCard.getSuit());
        assertEquals(2, testCard.getSuit().getStrength());
        assertEquals(false, testCard.isSelected());
        testCard.setSelected(true);
        assertEquals(true, testCard.isSelected());
        assertTrue(testCard.getResId() > 0);
    }
}
