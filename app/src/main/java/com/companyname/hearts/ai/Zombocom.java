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
public class Zombocom {

    public static Card computer3MakesMove() {
        System.out.println("Computer 3 hand: " + Arrays.toString(Table.getInstance().getPlayer4().getHand().toArray()));

        //mm Comp3 variables
        int handValueComp3 = 0;
        int numOfHeartsComp3 = 0;
        int numOfSpadesComp3 = 0;
        int numOfDiamondsComp3 = 0;
        int numOfClubsComp3 = 0;
        List<Card> arrayOfHeartsComp3 = new ArrayList<>();
        List<Card> arrayOfSpadesComp3 = new ArrayList<>();
        List<Card> arrayOfDiamondsComp3 = new ArrayList<>();
        List<Card> arrayOfClubsComp3 = new ArrayList<>();

        Card computerSelection = null;
        for (int i = 0; i < Table.getInstance().getPlayer4().getHand().size(); i++) {
            computerSelection = Table.getInstance().getPlayer4().getHand().get(i);

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
        }

        Collections.sort(arrayOfHeartsComp3);
        Collections.sort(arrayOfSpadesComp3);
        Collections.sort(arrayOfDiamondsComp3);
        Collections.sort(arrayOfClubsComp3);

        //this is has clubs either Deuce or otherwise, and plays first trick.
        if (Overlord.getInstance().getRoundsPlayed() == 1) {
            if (numOfClubsComp3 != 0) {
                if(arrayOfClubsComp3.get(0).toString().equals("Deuce of Clubs")) {
                    for (int i = 0; i < Table.getInstance().getPlayer4().getHand().size(); i++) {
                        computerSelection = Table.getInstance().getPlayer4().getHand().get(i);
                        if (computerSelection.getRank().getValue() == 2 && computerSelection.getSuit() == Suit.Clubs) {
                            System.out.println("Computer 3 played: " + Table.getInstance().getPlayer4().getHand().get(i).toString());
                            computerSelection = Table.getInstance().getPlayer4().getHand().get(i);
                            Table.getInstance().getPlayer4().getHand().remove(i);
                            return computerSelection;
                        }
                    }
                }
                else {
                    String highestClub = arrayOfClubsComp3.get(arrayOfClubsComp3.size() -1).toString();
                    for (int i = 0; i < Table.getInstance().getPlayer4().getHand().size(); i++) {
                        computerSelection = Table.getInstance().getPlayer4().getHand().get(i);
                        if (computerSelection.toString().equals(highestClub)) {
                            System.out.println("Computer 3 played: " + Table.getInstance().getPlayer4().getHand().get(i).toString());
                            computerSelection = Table.getInstance().getPlayer4().getHand().get(i);
                            Table.getInstance().getPlayer4().getHand().remove(i);
                            return computerSelection;
                        }
                    }

                }
            }
        }
        else {
            if (numOfDiamondsComp3 != 0) {
                String highestDiamond = arrayOfDiamondsComp3.get(arrayOfDiamondsComp3.size() - 1).toString();
                for (int i = 0; i < Table.getInstance().getPlayer4().getHand().size(); i++) {
                    computerSelection = Table.getInstance().getPlayer4().getHand().get(i);
                    if (computerSelection.toString().equals(highestDiamond)) {
                        System.out.println("Computer 3 played: " + Table.getInstance().getPlayer4().getHand().get(i).toString());
                        computerSelection = Table.getInstance().getPlayer4().getHand().get(i);
                        Table.getInstance().getPlayer4().getHand().remove(i);
                        return computerSelection;
                    }
                }

            }
            else if (numOfSpadesComp3 != 0) {
                String highestSpade = arrayOfSpadesComp3.get(arrayOfSpadesComp3.size() - 1).toString();
                for (int i = 0; i < Table.getInstance().getPlayer4().getHand().size(); i++) {
                    computerSelection = Table.getInstance().getPlayer4().getHand().get(i);
                    if (computerSelection.toString().equals(highestSpade)) {
                        System.out.println("Computer 3 played: " + Table.getInstance().getPlayer4().getHand().get(i).toString());
                        computerSelection = Table.getInstance().getPlayer4().getHand().get(i);
                        Table.getInstance().getPlayer4().getHand().remove(i);
                        return computerSelection;
                    }
                }
            }
            else if (numOfHeartsComp3 !=0) {
                String highestHeart = arrayOfHeartsComp3.get(arrayOfHeartsComp3.size() - 1).toString();
                for (int i = 0; i < Table.getInstance().getPlayer4().getHand().size(); i++) {
                    computerSelection = Table.getInstance().getPlayer4().getHand().get(i);
                    if (computerSelection.toString().equals(highestHeart)) {
                        System.out.println("Computer 3 played: " + Table.getInstance().getPlayer4().getHand().get(i).toString());
                        computerSelection = Table.getInstance().getPlayer4().getHand().get(i);
                        Table.getInstance().getPlayer4().getHand().remove(i);
                        return computerSelection;
                    }
                }
            }
        }

        //----This is the beginning of round 2----\\

        if (Overlord.getInstance().getRoundsPlayed() == 2) {
            //if I am the leading player(true)

            if (numOfClubsComp3 >= numOfDiamondsComp3 && numOfClubsComp3 > numOfSpadesComp3) {
                //in here play lowest club
                String lowestClub = arrayOfClubsComp3.get(0).toString();
                for (int i = 0; i < Table.getInstance().getPlayer4().getHand().size(); i++) {
                    computerSelection = Table.getInstance().getPlayer4().getHand().get(i);
                    if (computerSelection.toString().equals(lowestClub)) {
                        System.out.println("Computer 3 played: " + Table.getInstance().getPlayer4().getHand().get(i).toString());
                        computerSelection = Table.getInstance().getPlayer4().getHand().get(i);
                        Table.getInstance().getPlayer4().getHand().remove(i);
                        return computerSelection;
                    }
                }
            } else if (numOfDiamondsComp3 > numOfClubsComp3 && numOfDiamondsComp3 > numOfSpadesComp3) {
                //in here play lowest diamond
                String lowestDiamond = arrayOfDiamondsComp3.get(0).toString();
                for (int i = 0; i < Table.getInstance().getPlayer4().getHand().size(); i++) {
                    computerSelection = Table.getInstance().getPlayer4().getHand().get(i);
                    if (computerSelection.toString().equals(lowestDiamond)) {
                        System.out.println("Computer 3 played: " + Table.getInstance().getPlayer4().getHand().get(i).toString());
                        computerSelection = Table.getInstance().getPlayer4().getHand().get(i);
                        Table.getInstance().getPlayer4().getHand().remove(i);
                        return computerSelection;
                    }
                }
            } else {
                //in here begins bleed of spades.
                String lowestSpade = arrayOfSpadesComp3.get(0).toString();
                for (int i = 0; i < Table.getInstance().getPlayer4().getHand().size(); i++) {
                    computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                    if (computerSelection.toString().equals(lowestSpade)) {
                        System.out.println("Computer 3 played: " + Table.getInstance().getPlayer4().getHand().get(i).toString());
                        computerSelection = Table.getInstance().getPlayer4().getHand().get(i);
                        Table.getInstance().getPlayer4().getHand().remove(i);
                        return computerSelection;
                    }
                }
            }
        }

        //----------"Original Crap" THIS MUST REMAIN @ THE END OF THE CLASS------just trust me on this-------\\
        for (int i = 0; i < Table.getInstance().getPlayer4().getHand().size(); i++) {
            computerSelection = Table.getInstance().getPlayer4().getHand().get(i);
            if (Overlord.getInstance().canPlayCard(computerSelection, Table.getInstance().getPlayer4())) {
                break;
            }
        }

        Table.getInstance().getPlayer4().getHand().remove(computerSelection);
        System.out.println("Computer 3 played: " + computerSelection.toString());
        return computerSelection;
    }
}

