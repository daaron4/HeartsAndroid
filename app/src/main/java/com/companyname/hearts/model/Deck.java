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
		// ToDo: finish this:
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

		deck.add(new Card(Rank.Ace, Suit.Diamonds, aceDiamonds));
		deck.add(new Card(Rank.Deuce, Suit.Diamonds, deuceDiamonds));
		deck.add(new Card(Rank.Three, Suit.Diamonds, threeDiamonds));
		deck.add(new Card(Rank.Four, Suit.Diamonds, fourDiamonds));
		deck.add(new Card(Rank.Five, Suit.Diamonds, fiveDiamonds));
		deck.add(new Card(Rank.Six, Suit.Diamonds, sixDiamonds));
		deck.add(new Card(Rank.Seven, Suit.Diamonds, sevenDiamonds));
		deck.add(new Card(Rank.Eight, Suit.Diamonds, eightDiamonds));
		deck.add(new Card(Rank.Nine, Suit.Diamonds, nineDiamonds));
		deck.add(new Card(Rank.Ten, Suit.Diamonds, tenDiamonds));
		deck.add(new Card(Rank.Jack, Suit.Diamonds, jackDiamonds));
		deck.add(new Card(Rank.Queen, Suit.Diamonds, queenDiamonds));
		deck.add(new Card(Rank.King, Suit.Diamonds, kingDiamonds));

		deck.add(new Card(Rank.Ace, Suit.Hearts, aceHearts));
		deck.add(new Card(Rank.Deuce, Suit.Hearts, deuceHearts));
		deck.add(new Card(Rank.Three, Suit.Hearts, threeHearts));
		deck.add(new Card(Rank.Four, Suit.Hearts, fourHearts));
		deck.add(new Card(Rank.Five, Suit.Hearts, fiveHearts));
		deck.add(new Card(Rank.Six, Suit.Hearts, sixHearts));
		deck.add(new Card(Rank.Seven, Suit.Hearts, sevenHearts));
		deck.add(new Card(Rank.Eight, Suit.Hearts, eightHearts));
		deck.add(new Card(Rank.Nine, Suit.Hearts, nineHearts));
		deck.add(new Card(Rank.Ten, Suit.Hearts, tenHearts));
		deck.add(new Card(Rank.Jack, Suit.Hearts, jackHearts));
		deck.add(new Card(Rank.Queen, Suit.Hearts, queenHearts));
		deck.add(new Card(Rank.King, Suit.Hearts, kingHearts));

		deck.add(new Card(Rank.Ace, Suit.Clubs, aceClubs));
		deck.add(new Card(Rank.Deuce, Suit.Clubs, deuceClubs));
		deck.add(new Card(Rank.Three, Suit.Clubs, threeClubs));
		deck.add(new Card(Rank.Four, Suit.Clubs, fourClubs));
		deck.add(new Card(Rank.Five, Suit.Clubs, fiveClubs));
		deck.add(new Card(Rank.Six, Suit.Clubs, sixClubs));
		deck.add(new Card(Rank.Seven, Suit.Clubs, sevenClubs));
		deck.add(new Card(Rank.Eight, Suit.Clubs, eightClubs));
		deck.add(new Card(Rank.Nine, Suit.Clubs, nineClubs));
		deck.add(new Card(Rank.Ten, Suit.Clubs, tenClubs));
		deck.add(new Card(Rank.Jack, Suit.Clubs, jackClubs));
		deck.add(new Card(Rank.Queen, Suit.Clubs, queenClubs));
		deck.add(new Card(Rank.King, Suit.Clubs, kingClubs));
	}

	public void shuffle() {
		// Shuffles the deck:
		int times = 0;
		while (times < 200) {
			Random rand = new Random();
			int randNum = rand.nextInt(52);
			int randNum2 = rand.nextInt(52);
			Card temp = new Card(deck.get(randNum).getRank(), deck.get(randNum)
					.getSuit(), deck.get(randNum).getResId());
			Card temp2 = new Card(deck.get(randNum2).getRank(), deck.get(
					randNum2).getSuit(), deck.get(randNum2).getResId());
			// if they are equal:
			while (temp.getRank() == temp2.getRank()
					&& temp.getSuit() == temp2.getSuit()) {
				randNum = rand.nextInt(52);
				randNum2 = rand.nextInt(52);
				temp = new Card(deck.get(randNum).getRank(), deck.get(randNum)
						.getSuit(), deck.get(randNum).getResId());
				temp2 = new Card(deck.get(randNum2).getRank(), deck.get(
						randNum2).getSuit(), deck.get(randNum2).getResId());
			}
			// they are not equal:
			deck.remove(randNum);
			deck.add(randNum, temp2);
			deck.remove(randNum2);
			deck.add(randNum2, temp);
			times++;
		}

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

	public void deal(Player player1, Player player2, Player player3, Player player4) {
		for (int i = 0; i < 13; i++) {
			player1.getHand().add(deck.get(i));
		}
		for (int i = 13; i < 26; i++) {
			player2.getHand().add(deck.get(i));
		}
		for (int i = 26; i < 39; i++) {
			player3.getHand().add(deck.get(i));
		}
		for (int i = 39; i < 52; i++) {
			player4.getHand().add(deck.get(i));
		}
	}

	public void remove(int index) {
		deck.remove(index);
	}

	public void add(int index, Card card) {
		deck.add(index, card);
	}

}
