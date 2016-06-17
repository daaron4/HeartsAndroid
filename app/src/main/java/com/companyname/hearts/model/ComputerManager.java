package com.companyname.hearts.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by David on 6/11/2016.
 */
public class ComputerManager {

    //mm Comp1 variables
    static int handValueComp1;
    static int numOfHeartsComp1;
    static int numOfSpadesComp1;
    static int numOfDiamondsComp1;
    static int numOfClubsComp1;
    static List<Card> arrayOfHeartsComp1 = new ArrayList<>();
    static List<Card> arrayOfSpadesComp1 = new ArrayList<>();
    static List<Card> arrayOfDiamondsComp1 = new ArrayList<>();
    static List<Card> arrayOfClubsComp1 = new ArrayList<>();

    //mm Comp2 variables
    static int handValueComp2;
    static int numOfHeartsComp2;
    static int numOfSpadesComp2;
    static int numOfDiamondsComp2;
    static int numOfClubsComp2;
    static List<Card> arrayOfHeartsComp2 = new ArrayList<>();
    static List<Card> arrayOfSpadesComp2 = new ArrayList<>();
    static List<Card> arrayOfDiamondsComp2 = new ArrayList<>();
    static List<Card> arrayOfClubsComp2 = new ArrayList<>();

    //mm Comp3 variables
    static int handValueComp3;
    static int numOfHeartsComp3;
    static int numOfSpadesComp3;
    static int numOfDiamondsComp3;
    static int numOfClubsComp3;
    static List<Card> arrayOfHeartsComp3 = new ArrayList<>();
    static List<Card> arrayOfSpadesComp3 = new ArrayList<>();
    static List<Card> arrayOfDiamondsComp3 = new ArrayList<>();
    static List<Card> arrayOfClubsComp3 = new ArrayList<>();

    public static Card computer1MakesMove() {
        Card computerSelection = null;
        for (int i = 0; i < Table.getInstance().getPlayer2().getHand().size(); i++) {
            computerSelection = Table.getInstance().getPlayer2().getHand().get(i);

            //mm Begin logic of playing comp1
            handValueComp1 += computerSelection.getRank().getValue();
            if (computerSelection.getSuit() == Suit.Hearts) {
                numOfHeartsComp1++;
                arrayOfHeartsComp1.add(computerSelection);
            }
            if (computerSelection.getSuit() == Suit.Spades) {
                numOfSpadesComp1++;
                arrayOfSpadesComp1.add(computerSelection);
            }
            if (computerSelection.getSuit() == Suit.Diamonds){
                numOfDiamondsComp1++;
                arrayOfDiamondsComp1.add(computerSelection);
            }
            if (computerSelection.getSuit() == Suit.Clubs) {
                numOfClubsComp1++;
                arrayOfClubsComp1.add(computerSelection);
            }
        }
        //mm doesn't know if this is how to do this.
        Collections.sort(arrayOfHeartsComp1);
        Collections.sort(arrayOfSpadesComp1);
        Collections.sort(arrayOfDiamondsComp1);
        Collections.sort(arrayOfClubsComp1);

        if (numOfClubsComp1 != 0) {
            String dOc = arrayOfClubsComp1.get(0).toString();
            if (Overlord.getInstance().getRoundsPlayed() == 1 && dOc.equals("Deuce of Clubs")) {
                for (int i = 0; i < Table.getInstance().getPlayer2().getHand().size(); i++) {
                    computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                    if (computerSelection.getRank().getValue() == 2 && computerSelection.getSuit() == Suit.Clubs) {
                        return Table.getInstance().getPlayer2().getHand().get(i);
                    }
                }

            } else {
                return arrayOfClubsComp1.get(arrayOfClubsComp1.size() -1);
                //play this fucking card.
            }
        }

        for (int i = 0; i < Table.getInstance().getPlayer2().getHand().size(); i++) {
            computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
            if (Overlord.getInstance().canPlayCard(computerSelection, Table.getInstance().getPlayer2())) {
                break;
            }
        }

        System.out.println("Comp 1 Card selected: " + computerSelection.toString());
        Table.getInstance().getPlayer2().getHand().remove(computerSelection);
        return computerSelection;
    }

    public static Card computer2MakesMove() {
        Card computerSelection = null;
        for (int i = 0; i < Table.getInstance().getPlayer3().getHand().size(); i++) {
            computerSelection = Table.getInstance().getPlayer3().getHand().get(i);

            //mm Begin logic of playing comp2
            handValueComp2 += computerSelection.getRank().getValue();
            if (computerSelection.getSuit() == Suit.Hearts) {
                numOfHeartsComp2++;
                arrayOfHeartsComp2.add(computerSelection);
            }
            if (computerSelection.getSuit() == Suit.Spades) {
                numOfSpadesComp2++;
                arrayOfSpadesComp2.add(computerSelection);
            }
            if (computerSelection.getSuit() == Suit.Diamonds){
                numOfDiamondsComp2++;
                arrayOfDiamondsComp2.add(computerSelection);
            }
            if (computerSelection.getSuit() == Suit.Clubs) {
                numOfClubsComp2++;
                arrayOfClubsComp2.add(computerSelection);
            }
            if (Overlord.getInstance().canPlayCard(computerSelection, Table.getInstance().getPlayer3())) {
                break;
            }
        }

        //mm doesn't know if this is how to do this.
        Collections.sort(arrayOfHeartsComp2);
        Collections.sort(arrayOfSpadesComp2);
        Collections.sort(arrayOfDiamondsComp2);
        Collections.sort(arrayOfClubsComp2);

        //logic for the two of clubs
        if (arrayOfClubsComp2.contains(2)) {
            //play the fucking card.
        } else {
            Collections.max(arrayOfClubsComp2);
            //play this fucking card.
        }

        System.out.println("Comp 2 Card selected: " + computerSelection.toString());
        Table.getInstance().getPlayer3().getHand().remove(computerSelection);
        return computerSelection;
    }

    public static Card computer3MakesMove() {
        Card computerSelection = null;
        for (int i = 0; i < Table.getInstance().getPlayer4().getHand().size(); i++) {

            //mm Begin logic of playing comp3
            handValueComp3 += computerSelection.getRank().getValue();
            if (computerSelection.getSuit() == Suit.Hearts) {
                numOfHeartsComp3++;
                arrayOfHeartsComp3.add(computerSelection);
            }
            if (computerSelection.getSuit() == Suit.Spades) {
                numOfSpadesComp3++;
                arrayOfSpadesComp3.add(computerSelection);
            }
            if (computerSelection.getSuit() == Suit.Diamonds){
                numOfDiamondsComp3++;
                arrayOfDiamondsComp3.add(computerSelection);
            }
            if (computerSelection.getSuit() == Suit.Clubs) {
                numOfClubsComp3++;
                arrayOfClubsComp3.add(computerSelection);
            }
            if (Overlord.getInstance().canPlayCard(computerSelection, Table.getInstance().getPlayer3())) {
                break;
            }
        }

        //mm doesn't know if this is how to do this.
        Collections.sort(arrayOfHeartsComp3);
        Collections.sort(arrayOfSpadesComp3);
        Collections.sort(arrayOfDiamondsComp3);
        Collections.sort(arrayOfClubsComp3);

        //logic for the two of clubs
        if (arrayOfClubsComp3.contains(2)) {
            //play the fucking card.
        } else {
            Collections.max(arrayOfClubsComp3);
            //play this fucking card.
        }

        System.out.println("Comp 3 card Card selected: " + computerSelection.toString());
        Table.getInstance().getPlayer4().getHand().remove(computerSelection);
        return computerSelection;
    }
}



