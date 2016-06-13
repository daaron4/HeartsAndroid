package com.companyname.hearts.model;

import com.companyname.hearts.R;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private ArrayList<Card> deck;

	public Deck() {
		deck = new ArrayList<>();
		createDeck();
	}

	public void createDeck() {
		deck.add(new Card(Rank.Ace, Suit.Spades, R.drawable.ace_spades));
		deck.add(new Card(Rank.Deuce, Suit.Spades, R.drawable.deuce_spades));
		deck.add(new Card(Rank.Three, Suit.Spades, R.drawable.three_spades));
		deck.add(new Card(Rank.Four, Suit.Spades, R.drawable.four_spades));
		deck.add(new Card(Rank.Five, Suit.Spades, R.drawable.five_spades));
		deck.add(new Card(Rank.Six, Suit.Spades, R.drawable.six_spades));
		deck.add(new Card(Rank.Seven, Suit.Spades, R.drawable.seven_spades));
		deck.add(new Card(Rank.Eight, Suit.Spades, R.drawable.eight_spades));
		deck.add(new Card(Rank.Nine, Suit.Spades, R.drawable.nine_spades));
		deck.add(new Card(Rank.Ten, Suit.Spades, R.drawable.ten_spades));
		deck.add(new Card(Rank.Jack, Suit.Spades, R.drawable.jack_spades));
		deck.add(new Card(Rank.Queen, Suit.Spades, R.drawable.queen_spades));
		deck.add(new Card(Rank.King, Suit.Spades, R.drawable.kings_spades));

		deck.add(new Card(Rank.Ace, Suit.Diamonds, R.drawable.ace_diamonds));
		deck.add(new Card(Rank.Deuce, Suit.Diamonds, R.drawable.deuce_diamonds));
		deck.add(new Card(Rank.Three, Suit.Diamonds, R.drawable.three_diamonds));
		deck.add(new Card(Rank.Four, Suit.Diamonds, R.drawable.four_diamonds));
		deck.add(new Card(Rank.Five, Suit.Diamonds, R.drawable.five_diamonds));
		deck.add(new Card(Rank.Six, Suit.Diamonds, R.drawable.six_diamonds));
		deck.add(new Card(Rank.Seven, Suit.Diamonds, R.drawable.seven_diamonds));
		deck.add(new Card(Rank.Eight, Suit.Diamonds, R.drawable.eight_diamonds));
		deck.add(new Card(Rank.Nine, Suit.Diamonds, R.drawable.nine_diamonds));
		deck.add(new Card(Rank.Ten, Suit.Diamonds, R.drawable.ten_diamonds));
		deck.add(new Card(Rank.Jack, Suit.Diamonds, R.drawable.jack_diamonds));
		deck.add(new Card(Rank.Queen, Suit.Diamonds, R.drawable.queen_diamonds));
		deck.add(new Card(Rank.King, Suit.Diamonds, R.drawable.king_diamonds));

		deck.add(new Card(Rank.Ace, Suit.Hearts, R.drawable.ace_hearts));
		deck.add(new Card(Rank.Deuce, Suit.Hearts, R.drawable.deuce_hearts));
		deck.add(new Card(Rank.Three, Suit.Hearts, R.drawable.three_hearts));
		deck.add(new Card(Rank.Four, Suit.Hearts, R.drawable.four_hearts));
		deck.add(new Card(Rank.Five, Suit.Hearts, R.drawable.five_hearts));
		deck.add(new Card(Rank.Six, Suit.Hearts, R.drawable.six_hearts));
		deck.add(new Card(Rank.Seven, Suit.Hearts, R.drawable.seven_hearts));
		deck.add(new Card(Rank.Eight, Suit.Hearts, R.drawable.eight_hearts));
		deck.add(new Card(Rank.Nine, Suit.Hearts, R.drawable.nine_hearts));
		deck.add(new Card(Rank.Ten, Suit.Hearts, R.drawable.ten_hearts));
		deck.add(new Card(Rank.Jack, Suit.Hearts, R.drawable.jack_hearts));
		deck.add(new Card(Rank.Queen, Suit.Hearts, R.drawable.queen_hearts));
		deck.add(new Card(Rank.King, Suit.Hearts, R.drawable.king_hearts));

		deck.add(new Card(Rank.Ace, Suit.Clubs, R.drawable.ace_clubs));
		deck.add(new Card(Rank.Deuce, Suit.Clubs, R.drawable.deuce_clubs));
		deck.add(new Card(Rank.Three, Suit.Clubs, R.drawable.three_clubs));
		deck.add(new Card(Rank.Four, Suit.Clubs, R.drawable.four_clubs));
		deck.add(new Card(Rank.Five, Suit.Clubs, R.drawable.five_clubs));
		deck.add(new Card(Rank.Six, Suit.Clubs, R.drawable.six_clubs));
		deck.add(new Card(Rank.Seven, Suit.Clubs, R.drawable.seven_clubs));
		deck.add(new Card(Rank.Eight, Suit.Clubs, R.drawable.eight_clubs));
		deck.add(new Card(Rank.Nine, Suit.Clubs, R.drawable.nine_clubs));
		deck.add(new Card(Rank.Ten, Suit.Clubs, R.drawable.ten_clubs));
		deck.add(new Card(Rank.Jack, Suit.Clubs, R.drawable.jack_clubs));
		deck.add(new Card(Rank.Queen, Suit.Clubs, R.drawable.queen_clubs));
		deck.add(new Card(Rank.King, Suit.Clubs, R.drawable.king_clubs));
	}

	public int getSize() {
		return deck.size();
	}

	public Card get(int index) {
		return deck.get(index);
	}

	public boolean contains(Card card) {
		return deck.contains(card);
	}

	public String toString() {
		String str = "";
		for (int i = 0; i < 52; i++) {
			str += deck.get(i).getRank().toString() + " of "
					+ deck.get(i).getSuit().toString() + " ";
			if (i == 13 || i == 26 || i == 39 || i == 51)
				str += "\n";
		}
		return str;
	}

	public void remove(int index) {
		deck.remove(index);
	}

	public void add(int index, Card card) {
		deck.add(index, card);
	}

}
