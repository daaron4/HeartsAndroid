package com.companyname.hearts.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by David on 6/11/2016.
 */
public class ComputerManager {

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
            if (computerSelection.getSuit() == Suit.Diamonds){
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
                if(arrayOfClubsComp1.get(0).toString().equals("Deuce of Clubs")) {
                    for (int i = 0; i < Table.getInstance().getPlayer2().getHand().size(); i++) {
                        computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                        if (computerSelection.getRank().getValue() == 2 && computerSelection.getSuit() == Suit.Clubs) {
                            System.out.println("Computer 1 played: " + Table.getInstance().getPlayer2().getHand().get(i).toString());
                            computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                            Table.getInstance().getPlayer2().getHand().remove(i);
                            return computerSelection;
                        }
                    }
                }
                else {
                    String highestClub = arrayOfClubsComp1.get(arrayOfClubsComp1.size() -1).toString();
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
        }
        else {
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

            }
            else if (numOfSpadesComp1 != 0) {
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
            }
            else if (numOfHeartsComp1 !=0) {
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

        //Original Crap
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

        //Original Crap
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



