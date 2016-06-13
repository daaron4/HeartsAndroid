package com.companyname.hearts.model;

import java.util.ArrayList;
import java.util.Scanner;

public class Table {

	private ArrayList<Card> board;
	private Player human;
    private Player comp1;
    private Player comp2;
    private Player comp3;

    private static Table instance = null;

    private Table() {
        // Do no allow instantiation
    }

    public static Table getTable() {
        if(instance == null) {
            instance = new Table();
        }
        return instance;
    }

	public void initializeTable(String player1Name, String player2Name, String player3Name, String player4Name) {
        human = new Player(player1Name);
        comp1 = new Player(player2Name);
        comp2 = new Player(player3Name);
        comp3 = new Player(player4Name);
        board = new ArrayList<>();
	}

    public Player getPlayer1() {
        return human;
    }

    public Player getPlayer2() {
        return comp1;
    }

    public Player getPlayer3() {
        return comp2;
    }

    public Player getPlayer4() {
        return comp3;
    }

	public ArrayList<Card> getBoard() {
		return board;
	}

}
