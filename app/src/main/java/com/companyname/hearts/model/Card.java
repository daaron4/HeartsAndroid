package com.companyname.hearts.model;

public class Card implements Comparable<Card> {

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
	public int compareTo(Card arg0) {
		if (suit.getStrength() - arg0.getSuit().getStrength() == 0) {
			return rank.getValue() - arg0.getRank().getValue();
		}
		else {
			return 0;
		}
	}

}
