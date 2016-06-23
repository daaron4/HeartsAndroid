package com.companyname.hearts.model;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/*
    This is the Table class. It is a singleton that models the table that all the Players sit at.
    Also on the table is the board, which is an ArrayList of Cards that manages who played what
    during a round.
 */

public class Table implements Serializable {

	private ArrayList<Card> board;
	private Player human;
    private Player comp1;
    private Player comp2;
    private Player comp3;

    private static Table instance = null;

    private Table() {
        // Do no allow instantiation
    }

    public static Table getInstance() {
        if (instance == null) {
            instance = new Table();
        }
        return instance;
    }

    // Method for putting a saved game instance
    public static void putInstance(Table newInstance) {
        instance = newInstance;
    }

    // Method for setting up the table given the names of the four players
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

    // Saves the current instance of this Table
    public static void saveTable(Context context) {
        try {
            FileOutputStream fos = context.openFileOutput("table.dat", Context.MODE_PRIVATE);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(Table.getInstance());
            os.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Loads up the saved instance of the Table
    public static void loadTable(Context context) {
        try {
            FileInputStream fis = context.openFileInput("table.dat");
            ObjectInputStream is = new ObjectInputStream(fis);
            Table table = (Table) is.readObject();
            Table.putInstance(table);
            is.close();
            fis.close();
        } catch (IOException e) {
            System.out.println("File not found");
        } catch (ClassNotFoundException e) {
            System.out.println("Issue with class");
        }
    }

}
