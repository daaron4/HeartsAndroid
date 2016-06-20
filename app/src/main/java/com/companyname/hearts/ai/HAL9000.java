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
public class HAL9000 {
    public static Card computer1MakesMove() {
        System.out.println("Computer 1 hand: " + Arrays.toString(Table.getInstance().getPlayer2().getHand().toArray()));
        int handValueComp1 = 0;
        int numOfHeartsComp1 = 0;
        int numOfSpadesComp1 = 0;
        int numOfDiamondsComp1 = 0;
        int numOfClubsComp1 = 0;
        List<Card> arrayOfHeartsComp1 = new ArrayList<>();
        List<Card> arrayOfSpadesComp1 = new ArrayList<>();
        List<Card> arrayOfDiamondsComp1 = new ArrayList<>();
        List<Card> arrayOfClubsComp1 = new ArrayList<>();

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
            if (computerSelection.getSuit() == Suit.Diamonds) {
                numOfDiamondsComp1++;
                arrayOfDiamondsComp1.add(computerSelection);
            }
            if (computerSelection.getSuit() == Suit.Clubs) {
                numOfClubsComp1++;
                arrayOfClubsComp1.add(computerSelection);
            }
        }

        Collections.sort(arrayOfHeartsComp1);
        Collections.sort(arrayOfSpadesComp1);
        Collections.sort(arrayOfDiamondsComp1);
        Collections.sort(arrayOfClubsComp1);

        //this is has clubs either Deuce or otherwise, and plays first trick.
        if (Overlord.getInstance().getRoundsPlayed() == 1) {
            if (numOfClubsComp1 != 0) {
                if (arrayOfClubsComp1.get(0).toString().equals("Deuce of Clubs")) {
                    for (int i = 0; i < Table.getInstance().getPlayer2().getHand().size(); i++) {
                        computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                        if (computerSelection.getRank().getValue() == 2 && computerSelection.getSuit() == Suit.Clubs) {
                            System.out.println("Computer 1 played: " + Table.getInstance().getPlayer2().getHand().get(i).toString());
                            computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                            Table.getInstance().getPlayer2().getHand().remove(i);
                            return computerSelection;
                        }
                    }
                } else {
                    String highestClub = arrayOfClubsComp1.get(arrayOfClubsComp1.size() - 1).toString();
                    for (int i = 0; i < Table.getInstance().getPlayer2().getHand().size(); i++) {
                        computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                        if (computerSelection.toString().equals(highestClub)) {
                            System.out.println("Computer 1 played: " + Table.getInstance().getPlayer2().getHand().get(i).toString());
                            computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                            Table.getInstance().getPlayer2().getHand().remove(i);
                            return computerSelection;
                        }
                    }
                }
            }
        } else {
            if (numOfDiamondsComp1 != 0) {
                String highestDiamond = arrayOfDiamondsComp1.get(arrayOfDiamondsComp1.size() - 1).toString();
                for (int i = 0; i < Table.getInstance().getPlayer2().getHand().size(); i++) {
                    computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                    if (computerSelection.toString().equals(highestDiamond)) {
                        System.out.println("Computer 1 played: " + Table.getInstance().getPlayer2().getHand().get(i).toString());
                        computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                        Table.getInstance().getPlayer2().getHand().remove(i);
                        return computerSelection;
                    }
                }

            } else if (numOfSpadesComp1 != 0) {
                String highestSpade = arrayOfSpadesComp1.get(arrayOfSpadesComp1.size() - 1).toString();
                for (int i = 0; i < Table.getInstance().getPlayer2().getHand().size(); i++) {
                    computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                    if (computerSelection.toString().equals(highestSpade)) {
                        System.out.println("Computer 1 played: " + Table.getInstance().getPlayer2().getHand().get(i).toString());
                        computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                        Table.getInstance().getPlayer2().getHand().remove(i);
                        return computerSelection;
                    }
                }
            } else if (numOfHeartsComp1 != 0) {
                String highestHeart = arrayOfHeartsComp1.get(arrayOfHeartsComp1.size() - 1).toString();
                for (int i = 0; i < Table.getInstance().getPlayer2().getHand().size(); i++) {
                    computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                    if (computerSelection.toString().equals(highestHeart)) {
                        System.out.println("Computer 1 played: " + Table.getInstance().getPlayer2().getHand().get(i).toString());
                        computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                        Table.getInstance().getPlayer2().getHand().remove(i);
                        return computerSelection;
                    }
                }
            }
        }

        //----This is the beginning of round 2----\\

        if (Overlord.getInstance().getRoundsPlayed() == 2) {
            //if I am the leading player(true)

            if (numOfClubsComp1 >= numOfDiamondsComp1 && numOfClubsComp1 > numOfSpadesComp1) {
                //in here play lowest club
                String lowestClub = arrayOfClubsComp1.get(0).toString();
                for (int i = 0; i < Table.getInstance().getPlayer2().getHand().size(); i++) {
                    computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                    if (computerSelection.toString().equals(lowestClub)) {
                        System.out.println("Computer 1 played: " + Table.getInstance().getPlayer2().getHand().get(i).toString());
                        computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                        Table.getInstance().getPlayer2().getHand().remove(i);
                        return computerSelection;
                    }
                }
            } else if (numOfDiamondsComp1 > numOfClubsComp1 && numOfDiamondsComp1 > numOfSpadesComp1) {
                //in here play lowest diamond
                String lowestDiamond = arrayOfDiamondsComp1.get(0).toString();
                for (int i = 0; i < Table.getInstance().getPlayer2().getHand().size(); i++) {
                    computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                    if (computerSelection.toString().equals(lowestDiamond)) {
                        System.out.println("Computer 1 played: " + Table.getInstance().getPlayer2().getHand().get(i).toString());
                        computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                        Table.getInstance().getPlayer2().getHand().remove(i);
                        return computerSelection;
                    }
                }
            } else {
                //in here begins bleed of spades.
                String lowestSpade = arrayOfSpadesComp1.get(0).toString();
                for (int i = 0; i < Table.getInstance().getPlayer2().getHand().size(); i++) {
                    computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                    if (computerSelection.toString().equals(lowestSpade)) {
                        System.out.println("Computer 1 played: " + Table.getInstance().getPlayer2().getHand().get(i).toString());
                        computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                        Table.getInstance().getPlayer2().getHand().remove(i);
                        return computerSelection;
                    }
                }
            }
        }

        //----------"Original Crap" THIS MUST REMAIN @ THE END OF THE CLASS------just trust me on this-------\\
        for (int i = 0; i < Table.getInstance().getPlayer2().getHand().size(); i++) {
            computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
            if (Overlord.getInstance().canPlayCard(computerSelection, Table.getInstance().getPlayer2())) {
                break;
            }
        }

        Table.getInstance().getPlayer2().getHand().remove(computerSelection);
        System.out.println("Computer 1 played: " + computerSelection.toString());
        return computerSelection;



    }
}


