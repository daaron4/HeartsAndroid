package com.companyname.hearts.model;

import java.io.Serializable;

public class Card implements Comparable<Card>, Serializable {

	private Rank rank;
	private Suit suit;
	private int resId;
	private boolean selected;
	
	public Card(Rank rank, Suit suit, int resId) {
		this.rank = rank;
		this.suit = suit;
		this.resId = resId;
		selected = false;
	}

	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public int getResId() {
		return resId;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    @Override
	public int compareTo(Card otherCard) {
		//Same suit
		if (suit == otherCard.getSuit()) {
			if (rank.getValue() < otherCard.getRank().getValue()) {
                return -1;
            }
            else {
                return 1;
            }
		}
        //Different suit
		else {
            return 0;
		}
	}

}
