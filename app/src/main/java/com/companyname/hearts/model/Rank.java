package com.companyname.hearts.model;

/*
    This enum represents the Rank of a Card. Each rank has a name,
    and an Integer value for how 'strong' it is
 */

public enum Rank {
	Deuce(2),
	Three(3),
	Four(4),
	Five(5),
	Six(6),
	Seven(7),
	Eight(8),
	Nine(9),
	Ten(10),
	Jack(11),
	Queen(12),
	King(13),
	Ace(14),
	Joker(15);
	
	private int rank;
	
	Rank(int rank) {
		this.rank = rank;
	}

	public int getValue() {
		return rank;
	}
	
}
