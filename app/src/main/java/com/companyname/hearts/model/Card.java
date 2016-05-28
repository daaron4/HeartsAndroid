package com.companyname.hearts.model;

import android.graphics.Bitmap;

public class Card implements Comparable<Card> {

	private Rank rank;
	private Suit suit;
	private Bitmap cardImage;
	private boolean selected;
	
	public Card(Rank rank, Suit suit, Bitmap cardImage) {
		this.rank = rank;
		this.suit = suit;
		this.cardImage = cardImage;
		selected = false;
		
	}


	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public Bitmap getCardImage() {
		return cardImage;
	}

	public void setCardImage(Bitmap cardImage) {
		this.cardImage = cardImage;
	}
	
	public String toString() {
		return rank + " of " + suit;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	@Override
	public int compareTo(Card arg0) {
		if (suit.getStrength() - arg0.getSuit().getStrength() == 0) {
			return rank.getValue() - arg0.getRank().getValue();
		}
		else {
			return 0;
		}
		

	}
}
