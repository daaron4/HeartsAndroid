package com.companyname.hearts.model;

/*
    This enum represents the Suit if a Card. Each Suit has
    an Integer value used so that the Cards can be sorted correctly
 */

public enum Suit {
	Hearts(1), Spades(2), Clubs(4), Diamonds(3), Joker(5);

	private int strength;

	Suit(int strength) {
		this.strength = strength;
	}

	public int getStrength() {
		return strength;
	}
}