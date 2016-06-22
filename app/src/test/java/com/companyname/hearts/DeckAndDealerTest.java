package com.companyname.hearts;

import com.companyname.hearts.model.Card;
import com.companyname.hearts.model.Dealer;
import com.companyname.hearts.model.Deck;
import com.companyname.hearts.model.Rank;
import com.companyname.hearts.model.Suit;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class DeckAndDealerTest {

    private Deck deck;

    @Before
    public void setUp() {
        deck = new Deck();
    }

    @Test
    public void testCreateDeck() throws Exception {
        assertTrue(deck.getSize() == 52);

        Card s1 = new Card(Rank.Ace, Suit.Spades, R.drawable.ace_spades);
        Card s2 = new Card(Rank.Deuce, Suit.Spades, R.drawable.deuce_spades);
        Card s3 = new Card(Rank.Three, Suit.Spades, R.drawable.three_spades);
        Card s4 = new Card(Rank.Four, Suit.Spades, R.drawable.four_spades);
        Card s5 = new Card(Rank.Five, Suit.Spades, R.drawable.five_spades);
        Card s6 = new Card(Rank.Six, Suit.Spades, R.drawable.six_spades);
        Card s7 = new Card(Rank.Seven, Suit.Spades, R.drawable.seven_spades);
        Card s8 = new Card(Rank.Eight, Suit.Spades, R.drawable.eight_spades);
        Card s9 = new Card(Rank.Nine, Suit.Spades, R.drawable.nine_spades);
        Card s10 = new Card(Rank.Ten, Suit.Spades, R.drawable.ten_spades);
        Card s11 = new Card(Rank.Jack, Suit.Spades, R.drawable.jack_spades);
        Card s12 = new Card(Rank.Queen, Suit.Spades, R.drawable.queen_spades);
        Card s13 = new Card(Rank.King, Suit.Spades, R.drawable.kings_spades);

        Card d1 = new Card(Rank.Ace, Suit.Diamonds, R.drawable.ace_diamonds);
        Card d2 = new Card(Rank.Deuce, Suit.Diamonds, R.drawable.deuce_diamonds);
        Card d3 = new Card(Rank.Three, Suit.Diamonds, R.drawable.three_diamonds);
        Card d4 = new Card(Rank.Four, Suit.Diamonds, R.drawable.four_diamonds);
        Card d5 = new Card(Rank.Five, Suit.Diamonds, R.drawable.five_diamonds);
        Card d6 = new Card(Rank.Six, Suit.Diamonds, R.drawable.six_diamonds);
        Card d7 = new Card(Rank.Seven, Suit.Diamonds, R.drawable.seven_diamonds);
        Card d8 = new Card(Rank.Eight, Suit.Diamonds, R.drawable.eight_diamonds);
        Card d9 = new Card(Rank.Nine, Suit.Diamonds, R.drawable.nine_diamonds);
        Card d10 = new Card(Rank.Ten, Suit.Diamonds, R.drawable.ten_diamonds);
        Card d11 = new Card(Rank.Jack, Suit.Diamonds, R.drawable.jack_diamonds);
        Card d12 = new Card(Rank.Queen, Suit.Diamonds, R.drawable.queen_diamonds);
        Card d13 = new Card(Rank.King, Suit.Diamonds, R.drawable.king_diamonds);

        Card h1 = new Card(Rank.Ace, Suit.Hearts, R.drawable.ace_hearts);
        Card h2 = new Card(Rank.Deuce, Suit.Hearts, R.drawable.deuce_hearts);
        Card h3 = new Card(Rank.Three, Suit.Hearts, R.drawable.three_hearts);
        Card h4 = new Card(Rank.Four, Suit.Hearts, R.drawable.four_hearts);
        Card h5 = new Card(Rank.Five, Suit.Hearts, R.drawable.five_hearts);
        Card h6 = new Card(Rank.Six, Suit.Hearts, R.drawable.six_hearts);
        Card h7 = new Card(Rank.Seven, Suit.Hearts, R.drawable.seven_hearts);
        Card h8 = new Card(Rank.Eight, Suit.Hearts, R.drawable.eight_hearts);
        Card h9 = new Card(Rank.Nine, Suit.Hearts, R.drawable.nine_hearts);
        Card h10 = new Card(Rank.Ten, Suit.Hearts, R.drawable.ten_hearts);
        Card h11 = new Card(Rank.Jack, Suit.Hearts, R.drawable.jack_hearts);
        Card h12 = new Card(Rank.Queen, Suit.Hearts, R.drawable.queen_hearts);
        Card h13 = new Card(Rank.King, Suit.Hearts, R.drawable.king_hearts);

        Card c1 = new Card(Rank.Ace, Suit.Clubs, R.drawable.ace_clubs);
        Card c2 = new Card(Rank.Deuce, Suit.Clubs, R.drawable.deuce_clubs);
        Card c3 = new Card(Rank.Three, Suit.Clubs, R.drawable.three_clubs);
        Card c4 = new Card(Rank.Four, Suit.Clubs, R.drawable.four_clubs);
        Card c5 = new Card(Rank.Five, Suit.Clubs, R.drawable.five_clubs);
        Card c6 = new Card(Rank.Six, Suit.Clubs, R.drawable.six_clubs);
        Card c7 = new Card(Rank.Seven, Suit.Clubs, R.drawable.seven_clubs);
        Card c8 = new Card(Rank.Eight, Suit.Clubs, R.drawable.eight_clubs);
        Card c9 = new Card(Rank.Nine, Suit.Clubs, R.drawable.nine_clubs);
        Card c10 = new Card(Rank.Ten, Suit.Clubs, R.drawable.ten_clubs);
        Card c11 = new Card(Rank.Jack, Suit.Clubs, R.drawable.jack_clubs);
        Card c12 = new Card(Rank.Queen, Suit.Clubs, R.drawable.queen_clubs);
        Card c13 = new Card(Rank.King, Suit.Clubs, R.drawable.king_clubs);

        assertTrue(deck.get(0).toString().equals(s1.toString()));
        assertTrue(deck.get(1).toString().equals(s2.toString()));
        assertTrue(deck.get(2).toString().equals(s3.toString()));
        assertTrue(deck.get(3).toString().equals(s4.toString()));
        assertTrue(deck.get(4).toString().equals(s5.toString()));
        assertTrue(deck.get(5).toString().equals(s6.toString()));
        assertTrue(deck.get(6).toString().equals(s7.toString()));
        assertTrue(deck.get(7).toString().equals(s8.toString()));
        assertTrue(deck.get(8).toString().equals(s9.toString()));
        assertTrue(deck.get(9).toString().equals(s10.toString()));
        assertTrue(deck.get(10).toString().equals(s11.toString()));
        assertTrue(deck.get(11).toString().equals(s12.toString()));
        assertTrue(deck.get(12).toString().equals(s13.toString()));

        assertTrue(deck.get(13).toString().equals(d1.toString()));
        assertTrue(deck.get(14).toString().equals(d2.toString()));
        assertTrue(deck.get(15).toString().equals(d3.toString()));
        assertTrue(deck.get(16).toString().equals(d4.toString()));
        assertTrue(deck.get(17).toString().equals(d5.toString()));
        assertTrue(deck.get(18).toString().equals(d6.toString()));
        assertTrue(deck.get(19).toString().equals(d7.toString()));
        assertTrue(deck.get(20).toString().equals(d8.toString()));
        assertTrue(deck.get(21).toString().equals(d9.toString()));
        assertTrue(deck.get(22).toString().equals(d10.toString()));
        assertTrue(deck.get(23).toString().equals(d11.toString()));
        assertTrue(deck.get(24).toString().equals(d12.toString()));
        assertTrue(deck.get(25).toString().equals(d13.toString()));

        assertTrue(deck.get(26).toString().equals(h1.toString()));
        assertTrue(deck.get(27).toString().equals(h2.toString()));
        assertTrue(deck.get(28).toString().equals(h3.toString()));
        assertTrue(deck.get(29).toString().equals(h4.toString()));
        assertTrue(deck.get(30).toString().equals(h5.toString()));
        assertTrue(deck.get(31).toString().equals(h6.toString()));
        assertTrue(deck.get(32).toString().equals(h7.toString()));
        assertTrue(deck.get(33).toString().equals(h8.toString()));
        assertTrue(deck.get(34).toString().equals(h9.toString()));
        assertTrue(deck.get(35).toString().equals(h10.toString()));
        assertTrue(deck.get(36).toString().equals(h11.toString()));
        assertTrue(deck.get(37).toString().equals(h12.toString()));
        assertTrue(deck.get(38).toString().equals(h13.toString()));

        assertTrue(deck.get(39).toString().equals(c1.toString()));
        assertTrue(deck.get(40).toString().equals(c2.toString()));
        assertTrue(deck.get(41).toString().equals(c3.toString()));
        assertTrue(deck.get(42).toString().equals(c4.toString()));
        assertTrue(deck.get(43).toString().equals(c5.toString()));
        assertTrue(deck.get(44).toString().equals(c6.toString()));
        assertTrue(deck.get(45).toString().equals(c7.toString()));
        assertTrue(deck.get(46).toString().equals(c8.toString()));
        assertTrue(deck.get(47).toString().equals(c9.toString()));
        assertTrue(deck.get(48).toString().equals(c10.toString()));
        assertTrue(deck.get(49).toString().equals(c11.toString()));
        assertTrue(deck.get(50).toString().equals(c12.toString()));
        assertTrue(deck.get(51).toString().equals(c13.toString()));

    }

    @Test
    public void testShuffleDeck() {
        Dealer.getInstance().shuffle();
        deck = Dealer.getInstance().getDeck();
        assertTrue(deck.getSize() == 52);
        Set<String> cardNamesFromDeck = new HashSet<>();
        for (int i = 0; i < deck.getSize(); i++) {
            cardNamesFromDeck.add(deck.get(i).toString());
        }

        Set<String> cardNames = new HashSet<>();
        Card s1 = new Card(Rank.Ace, Suit.Spades, R.drawable.ace_spades);
        Card s2 = new Card(Rank.Deuce, Suit.Spades, R.drawable.deuce_spades);
        Card s3 = new Card(Rank.Three, Suit.Spades, R.drawable.three_spades);
        Card s4 = new Card(Rank.Four, Suit.Spades, R.drawable.four_spades);
        Card s5 = new Card(Rank.Five, Suit.Spades, R.drawable.five_spades);
        Card s6 = new Card(Rank.Six, Suit.Spades, R.drawable.six_spades);
        Card s7 = new Card(Rank.Seven, Suit.Spades, R.drawable.seven_spades);
        Card s8 = new Card(Rank.Eight, Suit.Spades, R.drawable.eight_spades);
        Card s9 = new Card(Rank.Nine, Suit.Spades, R.drawable.nine_spades);
        Card s10 = new Card(Rank.Ten, Suit.Spades, R.drawable.ten_spades);
        Card s11 = new Card(Rank.Jack, Suit.Spades, R.drawable.jack_spades);
        Card s12 = new Card(Rank.Queen, Suit.Spades, R.drawable.queen_spades);
        Card s13 = new Card(Rank.King, Suit.Spades, R.drawable.kings_spades);

        Card d1 = new Card(Rank.Ace, Suit.Diamonds, R.drawable.ace_diamonds);
        Card d2 = new Card(Rank.Deuce, Suit.Diamonds, R.drawable.deuce_diamonds);
        Card d3 = new Card(Rank.Three, Suit.Diamonds, R.drawable.three_diamonds);
        Card d4 = new Card(Rank.Four, Suit.Diamonds, R.drawable.four_diamonds);
        Card d5 = new Card(Rank.Five, Suit.Diamonds, R.drawable.five_diamonds);
        Card d6 = new Card(Rank.Six, Suit.Diamonds, R.drawable.six_diamonds);
        Card d7 = new Card(Rank.Seven, Suit.Diamonds, R.drawable.seven_diamonds);
        Card d8 = new Card(Rank.Eight, Suit.Diamonds, R.drawable.eight_diamonds);
        Card d9 = new Card(Rank.Nine, Suit.Diamonds, R.drawable.nine_diamonds);
        Card d10 = new Card(Rank.Ten, Suit.Diamonds, R.drawable.ten_diamonds);
        Card d11 = new Card(Rank.Jack, Suit.Diamonds, R.drawable.jack_diamonds);
        Card d12 = new Card(Rank.Queen, Suit.Diamonds, R.drawable.queen_diamonds);
        Card d13 = new Card(Rank.King, Suit.Diamonds, R.drawable.king_diamonds);

        Card h1 = new Card(Rank.Ace, Suit.Hearts, R.drawable.ace_hearts);
        Card h2 = new Card(Rank.Deuce, Suit.Hearts, R.drawable.deuce_hearts);
        Card h3 = new Card(Rank.Three, Suit.Hearts, R.drawable.three_hearts);
        Card h4 = new Card(Rank.Four, Suit.Hearts, R.drawable.four_hearts);
        Card h5 = new Card(Rank.Five, Suit.Hearts, R.drawable.five_hearts);
        Card h6 = new Card(Rank.Six, Suit.Hearts, R.drawable.six_hearts);
        Card h7 = new Card(Rank.Seven, Suit.Hearts, R.drawable.seven_hearts);
        Card h8 = new Card(Rank.Eight, Suit.Hearts, R.drawable.eight_hearts);
        Card h9 = new Card(Rank.Nine, Suit.Hearts, R.drawable.nine_hearts);
        Card h10 = new Card(Rank.Ten, Suit.Hearts, R.drawable.ten_hearts);
        Card h11 = new Card(Rank.Jack, Suit.Hearts, R.drawable.jack_hearts);
        Card h12 = new Card(Rank.Queen, Suit.Hearts, R.drawable.queen_hearts);
        Card h13 = new Card(Rank.King, Suit.Hearts, R.drawable.king_hearts);

        Card c1 = new Card(Rank.Ace, Suit.Clubs, R.drawable.ace_clubs);
        Card c2 = new Card(Rank.Deuce, Suit.Clubs, R.drawable.deuce_clubs);
        Card c3 = new Card(Rank.Three, Suit.Clubs, R.drawable.three_clubs);
        Card c4 = new Card(Rank.Four, Suit.Clubs, R.drawable.four_clubs);
        Card c5 = new Card(Rank.Five, Suit.Clubs, R.drawable.five_clubs);
        Card c6 = new Card(Rank.Six, Suit.Clubs, R.drawable.six_clubs);
        Card c7 = new Card(Rank.Seven, Suit.Clubs, R.drawable.seven_clubs);
        Card c8 = new Card(Rank.Eight, Suit.Clubs, R.drawable.eight_clubs);
        Card c9 = new Card(Rank.Nine, Suit.Clubs, R.drawable.nine_clubs);
        Card c10 = new Card(Rank.Ten, Suit.Clubs, R.drawable.ten_clubs);
        Card c11 = new Card(Rank.Jack, Suit.Clubs, R.drawable.jack_clubs);
        Card c12 = new Card(Rank.Queen, Suit.Clubs, R.drawable.queen_clubs);
        Card c13 = new Card(Rank.King, Suit.Clubs, R.drawable.king_clubs);

        cardNames.add(s1.toString());
        cardNames.add(s2.toString());
        cardNames.add(s3.toString());
        cardNames.add(s4.toString());
        cardNames.add(s5.toString());
        cardNames.add(s6.toString());
        cardNames.add(s7.toString());
        cardNames.add(s8.toString());
        cardNames.add(s9.toString());
        cardNames.add(s10.toString());
        cardNames.add(s11.toString());
        cardNames.add(s12.toString());
        cardNames.add(s13.toString());

        cardNames.add(d1.toString());
        cardNames.add(d2.toString());
        cardNames.add(d3.toString());
        cardNames.add(d4.toString());
        cardNames.add(d5.toString());
        cardNames.add(d6.toString());
        cardNames.add(d7.toString());
        cardNames.add(d8.toString());
        cardNames.add(d9.toString());
        cardNames.add(d10.toString());
        cardNames.add(d11.toString());
        cardNames.add(d12.toString());
        cardNames.add(d13.toString());

        cardNames.add(h1.toString());
        cardNames.add(h2.toString());
        cardNames.add(h3.toString());
        cardNames.add(h4.toString());
        cardNames.add(h5.toString());
        cardNames.add(h6.toString());
        cardNames.add(h7.toString());
        cardNames.add(h8.toString());
        cardNames.add(h9.toString());
        cardNames.add(h10.toString());
        cardNames.add(h11.toString());
        cardNames.add(h12.toString());
        cardNames.add(h13.toString());

        cardNames.add(c1.toString());
        cardNames.add(c2.toString());
        cardNames.add(c3.toString());
        cardNames.add(c4.toString());
        cardNames.add(c5.toString());
        cardNames.add(c6.toString());
        cardNames.add(c7.toString());
        cardNames.add(c8.toString());
        cardNames.add(c9.toString());
        cardNames.add(c10.toString());
        cardNames.add(c11.toString());
        cardNames.add(c12.toString());
        cardNames.add(c13.toString());

        assertTrue(cardNamesFromDeck.equals(cardNames));

    }

}