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

        //mm Comp2 variables
        int handValueComp2 = 0;
        int numOfHeartsComp2 = 0;
        int numOfSpadesComp2 = 0;
        int numOfDiamondsComp2 = 0;
        int numOfClubsComp2 = 0;
        List<Card> arrayOfHeartsComp2 = new ArrayList<>();
        List<Card> arrayOfSpadesComp2 = new ArrayList<>();
        List<Card> arrayOfDiamondsComp2 = new ArrayList<>();
        List<Card> arrayOfClubsComp2 = new ArrayList<>();

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
        }

        Collections.sort(arrayOfHeartsComp2);
        Collections.sort(arrayOfSpadesComp2);
        Collections.sort(arrayOfDiamondsComp2);
        Collections.sort(arrayOfClubsComp2);

        //this is has clubs either Deuce or otherwise, and plays first trick.
        if (Overlord.getInstance().getRoundsPlayed() == 1) {
            if (numOfClubsComp2 != 0) {
                if(arrayOfClubsComp2.get(0).toString().equals("Deuce of Clubs")) {
                    for (int i = 0; i < Table.getInstance().getPlayer3().getHand().size(); i++) {
                        computerSelection = Table.getInstance().getPlayer3().getHand().get(i);
                        if (computerSelection.getRank().getValue() == 2 && computerSelection.getSuit() == Suit.Clubs) {
                            System.out.println("Computer 2 played: " + Table.getInstance().getPlayer3().getHand().get(i).toString());
                            computerSelection = Table.getInstance().getPlayer3().getHand().get(i);
                            Table.getInstance().getPlayer3().getHand().remove(i);
                            return computerSelection;
                        }
                    }
                }
                else {
                    String highestClub = arrayOfClubsComp2.get(arrayOfClubsComp2.size() -1).toString();
                    for (int i = 0; i < Table.getInstance().getPlayer3().getHand().size(); i++) {
                        computerSelection = Table.getInstance().getPlayer3().getHand().get(i);
                        if (computerSelection.toString().equals(highestClub)) {
                            System.out.println("Computer 2 played: " + Table.getInstance().getPlayer3().getHand().get(i).toString());
                            computerSelection = Table.getInstance().getPlayer3().getHand().get(i);
                            Table.getInstance().getPlayer3().getHand().remove(i);
                            return computerSelection;
                        }
                    }

                }
            }
        }
        else {
            if (numOfDiamondsComp2 != 0) {
                String highestDiamond = arrayOfDiamondsComp2.get(arrayOfDiamondsComp2.size() - 1).toString();
                for (int i = 0; i < Table.getInstance().getPlayer3().getHand().size(); i++) {
                    computerSelection = Table.getInstance().getPlayer3().getHand().get(i);
                    if (computerSelection.toString().equals(highestDiamond)) {
                        System.out.println("Computer 2 played: " + Table.getInstance().getPlayer3().getHand().get(i).toString());
                        computerSelection = Table.getInstance().getPlayer3().getHand().get(i);
                        Table.getInstance().getPlayer3().getHand().remove(i);
                        return computerSelection;
                    }
                }

            }
            else if (numOfSpadesComp2 != 0) {
                String highestSpade = arrayOfSpadesComp2.get(arrayOfSpadesComp2.size() - 1).toString();
                for (int i = 0; i < Table.getInstance().getPlayer3().getHand().size(); i++) {
                    computerSelection = Table.getInstance().getPlayer3().getHand().get(i);
                    if (computerSelection.toString().equals(highestSpade)) {
                        System.out.println("Computer 2 played: " + Table.getInstance().getPlayer3().getHand().get(i).toString());
                        computerSelection = Table.getInstance().getPlayer3().getHand().get(i);
                        Table.getInstance().getPlayer3().getHand().remove(i);
                        return computerSelection;
                    }
                }
            }
            else if (numOfHeartsComp2 !=0) {
                String highestHeart = arrayOfHeartsComp2.get(arrayOfHeartsComp2.size() - 1).toString();
                for (int i = 0; i < Table.getInstance().getPlayer3().getHand().size(); i++) {
                    computerSelection = Table.getInstance().getPlayer3().getHand().get(i);
                    if (computerSelection.toString().equals(highestHeart)) {
                        System.out.println("Computer 2 played: " + Table.getInstance().getPlayer3().getHand().get(i).toString());
                        computerSelection = Table.getInstance().getPlayer3().getHand().get(i);
                        Table.getInstance().getPlayer3().getHand().remove(i);
                        return computerSelection;
                    }
                }
            }
        }

        //Original Crap
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
}
