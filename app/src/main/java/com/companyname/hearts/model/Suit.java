package com.companyname.hearts.model;

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