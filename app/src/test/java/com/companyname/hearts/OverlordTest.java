package com.companyname.hearts;

import com.companyname.hearts.model.Dealer;
import com.companyname.hearts.model.Overlord;
import com.companyname.hearts.model.Table;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by daaron on 6/15/16.
 */
public class OverlordTest {

    @Before
    public void setUp() {
        Table.getInstance().initializeTable("Player One", "Player Two", "Player Three", "Player Four");
        Dealer.getInstance().deal(Table.getInstance().getPlayer1(), Table.getInstance().getPlayer2(), Table.getInstance().getPlayer3(), Table.getInstance().getPlayer4());
    }

    // ToDo: One of these tests fail, lame, fix:

    @Test
    public void testOverlord() {
        assertTrue(Overlord.getInstance().getPlaying());
        assertFalse(Overlord.getInstance().getHeartsBroken());
        assertEquals(1, Overlord.getInstance().getRoundsPlayed());
        assertEquals("Player Four", Overlord.getInstance().getLeadingPlayer().getName());
    }
}
