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
        int numOfClubsComp2 = 0;
        int numOfHeartsComp2 = 0;
        int numOfSpadesComp2 = 0;
        int numOfDiamondsComp2 = 0;

        List<Card> arrayOfWhatsOnTable;
        List<Card> arrayOfClubsComp2 = new ArrayList<>();
        List<Card> arrayOfHeartsComp2 = new ArrayList<>();
        List<Card> arrayOfSpadesComp2 = new ArrayList<>();
        List<Card> arrayOfDiamondsComp2 = new ArrayList<>();

        Card computerSelection = null;
        for (int i = 0; i < Table.getInstance().getPlayer3().getHand().size(); i++) {
            computerSelection = Table.getInstance().getPlayer3().getHand().get(i);
            handValueComp2 += computerSelection.getRank().getValue();
            arrayOfHeartsComp2.add(computerSelection);

            //mm Begin logic of playing comp2
            if (computerSelection.getSuit() == Suit.Hearts) {
                numOfHeartsComp2++;
                arrayOfHeartsComp2.add(computerSelection);
            }
            if (computerSelection.getSuit() == Suit.Spades) {
                numOfSpadesComp2++;
                arrayOfSpadesComp2.add(computerSelection);
            }
            if (computerSelection.getSuit() == Suit.Diamonds) {
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
                if (arrayOfClubsComp2.get(0).toString().equals("Deuce of Clubs")) {
                    for (int i = 0; i < Table.getInstance().getPlayer3().getHand().size(); i++) {
                        computerSelection = Table.getInstance().getPlayer3().getHand().get(i);
                        if (computerSelection.getRank().getValue() == 2 && computerSelection.getSuit() == Suit.Clubs) {
                            System.out.println("Computer 2 played: " + Table.getInstance().getPlayer3().getHand().get(i).toString());
                            computerSelection = Table.getInstance().getPlayer3().getHand().get(i);
                            Table.getInstance().getPlayer3().getHand().remove(i);
                            return computerSelection;
                        }
                    }
                } else {
                    String highestClub = arrayOfClubsComp2.get(arrayOfClubsComp2.size() - 1).toString();
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
        } else {
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
            } else if (numOfSpadesComp2 != 0) {
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
            } else if (numOfHeartsComp2 != 0) {
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

        //----This is the beginning of round 2----\\

        if (Overlord.getInstance().getRoundsPlayed() == 2 && (Overlord.getInstance().amITheLeadingPlayer(Table.getInstance().getPlayer3()))) {
            //if I am the leading player(true)

            if (numOfClubsComp2 >= numOfDiamondsComp2 && numOfClubsComp2 > numOfSpadesComp2) {
                //in here play lowest club
                String lowestClub = arrayOfClubsComp2.get(0).toString();
                for (int i = 0; i < Table.getInstance().getPlayer3().getHand().size(); i++) {
                    computerSelection = Table.getInstance().getPlayer3().getHand().get(i);
                    if (computerSelection.toString().equals(lowestClub)) {
                        System.out.println("Computer 2 played: " + Table.getInstance().getPlayer3().getHand().get(i).toString());
                        computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                        Table.getInstance().getPlayer3().getHand().remove(i);
                        return computerSelection;
                    }
                }
            } else if (numOfDiamondsComp2 > numOfClubsComp2 && numOfDiamondsComp2 > numOfSpadesComp2) {
                //in here play lowest diamond
                String lowestDiamond = arrayOfDiamondsComp2.get(0).toString();
                for (int i = 0; i < Table.getInstance().getPlayer3().getHand().size(); i++) {
                    computerSelection = Table.getInstance().getPlayer3().getHand().get(i);
                    if (computerSelection.toString().equals(lowestDiamond)) {
                        System.out.println("Computer 2 played: " + Table.getInstance().getPlayer3().getHand().get(i).toString());
                        computerSelection = Table.getInstance().getPlayer3().getHand().get(i);
                        Table.getInstance().getPlayer2().getHand().remove(i);
                        return computerSelection;
                    }
                }
            } else {
                //in here begins bleed of spades.
                String lowestSpade = arrayOfSpadesComp2.get(0).toString();
                for (int i = 0; i < Table.getInstance().getPlayer3().getHand().size(); i++) {
                    computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                    if (computerSelection.toString().equals(lowestSpade)) {
                        System.out.println("Computer 2 played: " + Table.getInstance().getPlayer3().getHand().get(i).toString());
                        computerSelection = Table.getInstance().getPlayer3().getHand().get(i);
                        Table.getInstance().getPlayer2().getHand().remove(i);
                        return computerSelection;
                    }
                }
            }
        } else if (Overlord.getInstance().getRoundsPlayed() == 2) {
            //This is what the computer will do if it is round two, but NOT the leading player
            arrayOfWhatsOnTable = Table.getInstance().getBoard();
            Suit suitOfFirstCardPlayed = arrayOfWhatsOnTable.get(0).getSuit();

            if (suitOfFirstCardPlayed == Suit.Clubs && numOfClubsComp2 != 0) {
                //This plays lowest club if clubs was played led
                String lowestClub = arrayOfClubsComp2.get(0).toString();
                for (int i = 0; i < Table.getInstance().getPlayer3().getHand().size(); i++) {
                    computerSelection = Table.getInstance().getPlayer3().getHand().get(i);
                    if (computerSelection.toString().equals(lowestClub)) {
                        System.out.println("Computer 2 played: " + Table.getInstance().getPlayer3().getHand().get(i).toString());
                        computerSelection = Table.getInstance().getPlayer3().getHand().get(i);
                        Table.getInstance().getPlayer3().getHand().remove(i);
                        return computerSelection;
                    }
                }
            } else if (suitOfFirstCardPlayed == Suit.Diamonds && numOfDiamondsComp2 != 0) {
                //This plays lowest diamond if diamonds were led
                String lowestDiamond = arrayOfDiamondsComp2.get(0).toString();
                for (int i = 0; i < Table.getInstance().getPlayer3().getHand().size(); i++) {
                    computerSelection = Table.getInstance().getPlayer3().getHand().get(i);
                    if (computerSelection.toString().equals(lowestDiamond)) {
                        System.out.println("Computer 2 played: " + Table.getInstance().getPlayer3().getHand().get(i).toString());
                        computerSelection = Table.getInstance().getPlayer3().getHand().get(i);
                        Table.getInstance().getPlayer3().getHand().remove(i);
                        return computerSelection;
                    }
                }
            } else if (suitOfFirstCardPlayed == Suit.Spades && numOfSpadesComp2 != 0) {
                //This plays the lowest spade if spades were led
                String lowestSpade = arrayOfSpadesComp2.get(0).toString();
                for (int i = 0; i < Table.getInstance().getPlayer3().getHand().size(); i++) {
                    computerSelection = Table.getInstance().getPlayer3().getHand().get(i);
                    if (computerSelection.toString().equals(lowestSpade)) {
                        System.out.println("Computer 2 played: " + Table.getInstance().getPlayer3().getHand().get(i).toString());
                        computerSelection = Table.getInstance().getPlayer3().getHand().get(i);
                        Table.getInstance().getPlayer3().getHand().remove(i);
                        return computerSelection;
                    }
                }
            }
            //doesnt have to follow suit
            else {

            }

        }

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
        //------This is a card passer for Terminator that emphasizes holding onto the Queen & Hearts-----\\

        Card computerSelection = null;
        List<Card> arrayOfWholeHandComp3 = new ArrayList<>();
        ArrayList<Card> arrayOfCardsToPass = new ArrayList<>();
        int numClubsAndDiamonds = 0;
        int numClubsSpadesAndDiamonds = 0;
        List<Card> arrayOfClubsDiamondsAndSpades = new ArrayList<>();
        List<Card> arrayOfClubsAndDiamonds = new ArrayList<>();

            for (int j = 0; j < Table.getInstance().getPlayer3().getHand().size(); j++) {
                computerSelection = Table.getInstance().getPlayer3().getHand().get(j);
                arrayOfWholeHandComp3.add(computerSelection);

                if (computerSelection.getSuit() == Suit.Spades) {
                    numClubsSpadesAndDiamonds++;
                    arrayOfClubsDiamondsAndSpades.add(computerSelection);
                }
                if (computerSelection.getSuit() == Suit.Diamonds) {
                    numClubsAndDiamonds++;
                    arrayOfClubsAndDiamonds.add(computerSelection);
                    arrayOfClubsDiamondsAndSpades.add(computerSelection);
                }
                if (computerSelection.getSuit() == Suit.Clubs) {
                    numClubsAndDiamonds++;
                    arrayOfClubsAndDiamonds.add(computerSelection);
                    arrayOfClubsDiamondsAndSpades.add(computerSelection);
                }
                if (computerSelection.toString().equals("Queen of Spades")) {
                    arrayOfClubsDiamondsAndSpades.remove(computerSelection);
                    arrayOfWholeHandComp3.remove(computerSelection);
                }
            }
            Collections.sort(arrayOfClubsAndDiamonds);
            Collections.sort(arrayOfClubsDiamondsAndSpades);
            Collections.sort(arrayOfWholeHandComp3);

        if (numClubsAndDiamonds >= 3) {
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

