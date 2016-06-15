package com.companyname.hearts;

import com.companyname.hearts.model.Card;
import com.companyname.hearts.model.Rank;
import com.companyname.hearts.model.Suit;
import com.companyname.hearts.model.Table;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
/**
 * Created by daaron on 6/15/16.
 */
public class TableTest {

    @Before
    public void setUp() {
        Table.getInstance().initializeTable("Player One", "Player Two", "Player Three", "Player Four");
    }

    @Test
    public void testTable() {
        assertEquals("Player One", Table.getInstance().getPlayer1().getName());
        assertEquals("Player Two", Table.getInstance().getPlayer2().getName());
        assertEquals("Player Three", Table.getInstance().getPlayer3().getName());
        assertEquals("Player Four", Table.getInstance().getPlayer4().getName());
        assertEquals(0, Table.getInstance().getBoard().size());
        Card testCard = new Card(Rank.King, Suit.Clubs, R.drawable.king_clubs);
        Table.getInstance().getBoard().add(testCard);
        assertEquals(1, Table.getInstance().getBoard().size());
    }
}
