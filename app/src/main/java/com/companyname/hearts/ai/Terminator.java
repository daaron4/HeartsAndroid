package com.companyname.hearts.ai;

import com.companyname.hearts.model.Card;
import com.companyname.hearts.model.Overlord;
import com.companyname.hearts.model.Suit;
import com.companyname.hearts.model.Table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by EmployYeezy on 6/17/16.
 */
public class Terminator {

    public static Card computer2MakesMove() {
        System.out.println("Computer 2 hand: " + Arrays.toString(Table.getInstance().getPlayer3().getHand().toArray()));
        Card computerSelection = null;
        //----------"Original Crap" THIS MUST REMAIN @ THE END OF THE CLASS------just trust me on this-------\\
        for (int i = 0; i < Table.getInstance().getPlayer3().getHand().size(); i++) {
            computerSelection = Table.getInstance().getPlayer3().getHand().get(i);
            if (Overlord.getInstance().canPlayCard(computerSelection, Table.getInstance().getPlayer3())) {
                break;
            }
        }

        Table.getInstance().getPlayer3().getHand().remove(computerSelection);
        System.out.println("Computer 2 played: " + computerSelection.toString());
        return computerSelection;
    }

    public static ArrayList<Card> cardsToPassComp2() {
        //------This is a card passer for Terminator that emphasizes holding onto the Queen & all Hearts-----\\

        Card computerSelection = null;
        int numClubsAndDiamonds = 0;
        int numClubsSpadesAndDiamonds = 0;
        List<Card> arrayOfWholeHandComp3 = new ArrayList<>();
        ArrayList<Card> arrayOfCardsToPass = new ArrayList<>();
        List<Card> arrayOfClubsAndDiamonds = new ArrayList<>();
        List<Card> arrayOfClubsDiamondsAndSpades = new ArrayList<>();


            for (int j = 0; j < Table.getInstance().getPlayer3().getHand().size(); j++) {
                //This section sorts the cards into arrays of Clubs & Diamonds and Clubs, Spades, and Diamonds
                computerSelection = Table.getInstance().getPlayer3().getHand().get(j);
                arrayOfWholeHandComp3.add(computerSelection);

                if (computerSelection.getSuit() == Suit.Spades) {
                    //adds spades to array for clubs diamonds and spades
                    numClubsSpadesAndDiamonds++;
                    arrayOfClubsDiamondsAndSpades.add(computerSelection);
                }
                if (computerSelection.getSuit() == Suit.Diamonds) {
                    //adds diamonds to array of clubs and diamonds && clubs, diamonds and spades
                    numClubsAndDiamonds++;
                    arrayOfClubsAndDiamonds.add(computerSelection);
                    arrayOfClubsDiamondsAndSpades.add(computerSelection);
                }
                if (computerSelection.getSuit() == Suit.Clubs) {
                    //adds clubs to array of clubs and diamonds && clubs, diamonds and spades
                    numClubsAndDiamonds++;
                    arrayOfClubsAndDiamonds.add(computerSelection);
                    arrayOfClubsDiamondsAndSpades.add(computerSelection);
                }
                if (computerSelection.toString().equals("Queen of Spades")) {
                    //removes the queen of spades from the array, because Terminator NEVER passes the queen
                    arrayOfClubsDiamondsAndSpades.remove(computerSelection);
                    arrayOfWholeHandComp3.remove(computerSelection);
                }
            }
            Collections.sort(arrayOfClubsAndDiamonds);
            Collections.sort(arrayOfClubsDiamondsAndSpades);
            Collections.sort(arrayOfWholeHandComp3);

        if (numClubsAndDiamonds >= 3) {
            //First selection is for only clubs and diamonds to cards to pass array
            for (int i = 0; i < 3; i++) {
                String cardToPass = arrayOfClubsAndDiamonds.get(0).toString();
                arrayOfClubsAndDiamonds.remove(0);
                for (int j = 0; j < Table.getInstance().getPlayer3().getHand().size(); j++) {
                    computerSelection = Table.getInstance().getPlayer3().getHand().get(j);
                    if (computerSelection.toString().equals(cardToPass)) {
                        System.out.println("Computer 2 passed: " + Table.getInstance().getPlayer3().getHand().get(j).toString());
                        computerSelection = Table.getInstance().getPlayer3().getHand().get(j);
                        Table.getInstance().getPlayer3().getHand().remove(j);
                        arrayOfCardsToPass.add(computerSelection);
                    }
                }
            }
        } else if (numClubsSpadesAndDiamonds >= 3) {
            //This second case if for clubs, diamonds, and spades to cards to pass array
            for (int i = 0; i < 3; i++) {
                String cardToPass = arrayOfClubsDiamondsAndSpades.get(0).toString();
                arrayOfClubsAndDiamonds.remove(0);
                for (int j = 0; j < Table.getInstance().getPlayer3().getHand().size(); j++) {
                    computerSelection = Table.getInstance().getPlayer3().getHand().get(j);
                    if (computerSelection.toString().equals(cardToPass)) {
                        System.out.println("Computer 2 passed: " + Table.getInstance().getPlayer3().getHand().get(j).toString());
                        computerSelection = Table.getInstance().getPlayer3().getHand().get(j);
                        Table.getInstance().getPlayer3().getHand().remove(j);
                        arrayOfCardsToPass.add(computerSelection);
                    }
                }
            }
        } else {
            //This is basically a catch case to include hearts in the worst case to cards to pass array
            for (int i = 0; i < 3; i++) {
                String cardToPass = arrayOfWholeHandComp3.get(0).toString();
                arrayOfClubsAndDiamonds.remove(0);
                for (int j = 0; j < Table.getInstance().getPlayer3().getHand().size(); j++) {
                    computerSelection = Table.getInstance().getPlayer3().getHand().get(j);
                    if (computerSelection.toString().equals(cardToPass)) {
                        System.out.println("Computer 2 passed: " + Table.getInstance().getPlayer3().getHand().get(j).toString());
                        computerSelection = Table.getInstance().getPlayer3().getHand().get(j);
                        Table.getInstance().getPlayer3().getHand().remove(j);
                        arrayOfCardsToPass.add(computerSelection);
                    }
                }
            }
        }
        return arrayOfCardsToPass;
    }
}

