package com.companyname.hearts.ai;

import com.companyname.hearts.model.Card;
import com.companyname.hearts.model.Overlord;
import com.companyname.hearts.model.Rank;
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
        int numOfClubsComp1 = 0;
        int numOfHeartsComp1 = 0;
        int numOfSpadesComp1 = 0;
        int numOfDiamondsComp1 = 0;
        List<Card> arrayOfWhatsOnTable;
        List<Card> arrayOfClubsComp1 = new ArrayList<>();
        List<Card> arrayOfHeartsComp1 = new ArrayList<>();
        List<Card> arrayOfSpadesComp1 = new ArrayList<>();
        List<Card> arrayOfDiamondsComp1 = new ArrayList<>();
        List<Card> arrayOfWholeHandComp1 = new ArrayList<>();
        List<Card> arrayOfOldCards = Table.getInstance().getPlayer2().getOldCards();

        Card computerSelection = null;
        //This function gets all the cards for the hand, then sorts them in a hand, and by suit
        for (int i = 0; i < Table.getInstance().getPlayer2().getHand().size(); i++) {
            computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
            arrayOfWholeHandComp1.add(computerSelection);
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
        Collections.sort(arrayOfWholeHandComp1);

        //this is haz clubs either Deuce or otherwise, and plays first trick.
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

        //----------This is the beginning of round 2 and beyond---------\\

        if (Overlord.getInstance().getRoundsPlayed() > 1 && (Overlord.getInstance().amITheLeadingPlayer(Table.getInstance().getPlayer2()))) {
            //this line determines that this computer player is leading the next round
            if (Overlord.getInstance().getRoundsPlayed() >= 3 && (Overlord.getInstance().amIThePreviousWinner(Table.getInstance().getPlayer2()))) {
                //if the round is greater than 3 we take a look at weather or not we should play this suit.
                Suit previousSuit = arrayOfOldCards.get(arrayOfOldCards.size() - 4).getSuit();
                if (Overlord.getInstance().getHeartsBroken()) {
                    //This code looks at if HAL9000 is getting completely killed and needs to change suit
                    if (previousSuit == Suit.Diamonds) {
                        if (numOfSpadesComp1 >= numOfClubsComp1 && numOfSpadesComp1 >= numOfHeartsComp1) {
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
                        } else if (numOfHeartsComp1 > numOfSpadesComp1 && numOfHeartsComp1 >= numOfClubsComp1) {
                            String lowestHeart = arrayOfHeartsComp1.get(0).toString();
                            for (int i = 0; i < Table.getInstance().getPlayer2().getHand().size(); i++) {
                                computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                                if (computerSelection.toString().equals(lowestHeart)) {
                                    System.out.println("Computer 1 played: " + Table.getInstance().getPlayer2().getHand().get(i).toString());
                                    computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                                    Table.getInstance().getPlayer2().getHand().remove(i);
                                    return computerSelection;
                                }
                            }
                        } else if (numOfClubsComp1 > numOfSpadesComp1 && numOfClubsComp1 > numOfHeartsComp1) {
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
                        } else {
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
                        }
                    } else if (previousSuit == Suit.Clubs) {
                        if (numOfSpadesComp1 >= numOfClubsComp1 && numOfSpadesComp1 >= numOfHeartsComp1) {
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
                        } else if (numOfHeartsComp1 > numOfSpadesComp1 && numOfHeartsComp1 >= numOfClubsComp1) {
                            String lowestHeart = arrayOfHeartsComp1.get(0).toString();
                            for (int i = 0; i < Table.getInstance().getPlayer2().getHand().size(); i++) {
                                computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                                if (computerSelection.toString().equals(lowestHeart)) {
                                    System.out.println("Computer 1 played: " + Table.getInstance().getPlayer2().getHand().get(i).toString());
                                    computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                                    Table.getInstance().getPlayer2().getHand().remove(i);
                                    return computerSelection;
                                }
                            }
                        }else if (numOfDiamondsComp1 !=0){
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
                        }
                    } else if (previousSuit == Suit.Spades) {
                        if (numOfHeartsComp1 >= numOfClubsComp1 && numOfHeartsComp1 >= numOfDiamondsComp1) {
                            String lowestHeart = arrayOfHeartsComp1.get(0).toString();
                            for (int i = 0; i < Table.getInstance().getPlayer2().getHand().size(); i++) {
                                computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                                if (computerSelection.toString().equals(lowestHeart)) {
                                    System.out.println("Computer 1 played: " + Table.getInstance().getPlayer2().getHand().get(i).toString());
                                    computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                                    Table.getInstance().getPlayer2().getHand().remove(i);
                                    return computerSelection;
                                }
                            }
                        } else if (numOfDiamondsComp1 > numOfSpadesComp1 && numOfDiamondsComp1 > numOfHeartsComp1){
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
                        } else if (numOfClubsComp1 != 0) {
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
                        } else {
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
                    } else if (previousSuit == Suit.Hearts) {
                        if (numOfSpadesComp1 >= numOfClubsComp1 && numOfSpadesComp1 >= numOfDiamondsComp1) {
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
                        } else if (numOfDiamondsComp1 > numOfSpadesComp1 && numOfDiamondsComp1 >= numOfClubsComp1) {
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
                        } else if (numOfClubsComp1 != 0) {
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
                        } else {
                            String lowestHeart = arrayOfHeartsComp1.get(0).toString();
                            for (int i = 0; i < Table.getInstance().getPlayer2().getHand().size(); i++) {
                                computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                                if (computerSelection.toString().equals(lowestHeart)) {
                                    System.out.println("Computer 1 played: " + Table.getInstance().getPlayer2().getHand().get(i).toString());
                                    computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                                    Table.getInstance().getPlayer2().getHand().remove(i);
                                    return computerSelection;
                                }
                            }
                        }
                    }
                //THIS IS THE CASE THAT HEARTS HAVE NOT BEEN BROKEN!!!
                } else {
                    if (previousSuit == Suit.Diamonds) {
                        if (numOfSpadesComp1 >= numOfClubsComp1) {
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
                        } else if (numOfClubsComp1 > numOfSpadesComp1) {
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
                            String lowestHeart = arrayOfHeartsComp1.get(0).toString();
                            for (int i = 0; i < Table.getInstance().getPlayer2().getHand().size(); i++) {
                                computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                                if (computerSelection.toString().equals(lowestHeart)) {
                                    System.out.println("Computer 1 played: " + Table.getInstance().getPlayer2().getHand().get(i).toString());
                                    computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                                    Table.getInstance().getPlayer2().getHand().remove(i);
                                    return computerSelection;
                                }
                            }
                        }
                    }
                } if (previousSuit == Suit.Clubs) {
                    if (numOfSpadesComp1 >= numOfDiamondsComp1) {
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
                    }else if(numOfDiamondsComp1 >0) {
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
                    }else if (numOfDiamondsComp1 == 0 && numOfSpadesComp1 ==0) {
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
                    } else {
                        String lowestHeart = arrayOfHeartsComp1.get(0).toString();
                        for (int i = 0; i < Table.getInstance().getPlayer2().getHand().size(); i++) {
                            computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                            if (computerSelection.toString().equals(lowestHeart)) {
                                System.out.println("Computer 1 played: " + Table.getInstance().getPlayer2().getHand().get(i).toString());
                                computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                                Table.getInstance().getPlayer2().getHand().remove(i);
                                return computerSelection;
                            }
                        }
                    }
                }
            }
            //-----END of the conditional hand catching if / else statements-----\\

                if (numOfClubsComp1 != 0 && numOfClubsComp1 >= numOfDiamondsComp1 && numOfClubsComp1 >= numOfSpadesComp1) {
                    //this here plays the lowest club
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
                } else if (numOfDiamondsComp1 != 0 && numOfDiamondsComp1 > numOfClubsComp1 && numOfDiamondsComp1 >= numOfSpadesComp1) {
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
                } else if (numOfSpadesComp1 > numOfClubsComp1 && numOfSpadesComp1 > numOfDiamondsComp1) {
                    //in here begins bleed of spades
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
                } else {
                    //this is basically a catch case in the off chance that the computer has all hearts
                    String lowestHeart = arrayOfHeartsComp1.get(0).toString();
                    for (int i = 0; i < Table.getInstance().getPlayer2().getHand().size(); i++) {
                        computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                        if (computerSelection.toString().equals(lowestHeart)) {
                            System.out.println("Computer 1 played: " + Table.getInstance().getPlayer2().getHand().get(i).toString());
                            computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                            Table.getInstance().getPlayer2().getHand().remove(i);
                            return computerSelection;
                        }
                    }
                }
        } else if (Overlord.getInstance().getRoundsPlayed() > 1) {
                //This is what the computer will do if it is round two, but NOT the leading player
                arrayOfWhatsOnTable = Table.getInstance().getBoard();
                Suit suitOfFirstCardPlayed = arrayOfWhatsOnTable.get(0).getSuit();

                if (suitOfFirstCardPlayed == Suit.Clubs && numOfClubsComp1 != 0) {
                    //This plays lowest club if clubs was played led
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
                } else if (suitOfFirstCardPlayed == Suit.Diamonds && numOfDiamondsComp1 != 0) {
                    //This plays lowest diamond if diamonds were led
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
                } else if (suitOfFirstCardPlayed == Suit.Spades && numOfSpadesComp1 != 0) {
                    //This plays the lowest spade if spades were led
                    boolean foundQueen = false;
                    int indexOfQueen = -1;
                    for (int i = 0; i < Table.getInstance().getPlayer2().getHand().size(); i++) {
                        //Searches the computers hand for the index of the queen of Spade
                        computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                        if (computerSelection.toString().equals("Queen of Spades")) {
                            foundQueen = true;
                            indexOfQueen = i;
                        }
                    }
                    Card currentCard = null;
                    for (int j = 0; j < arrayOfWhatsOnTable.size(); j++) {
                        currentCard = arrayOfWhatsOnTable.get(j);
                        if (foundQueen) {
                            if (currentCard.toString().equals("King of Spades") || currentCard.toString().equals("Ace of Spades")) {
                                System.out.println("Time to drop the queen!");
                                computerSelection = Table.getInstance().getPlayer2().getHand().get(indexOfQueen);
                                Table.getInstance().getPlayer2().getHand().remove(indexOfQueen);
                                return computerSelection;
                            }
                        } else {
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
                }
                //----------If computer player is in round 2, but can't play the leading suit---------\\
                else {
                    for (int i = 0; i < Table.getInstance().getPlayer2().getHand().size(); i++) {
                        //This Drops the queen of Spades like it's hot
                        computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                        if (computerSelection.getSuit() == Suit.Spades && computerSelection.getRank() == Rank.Queen) {
                            System.out.println("Computer 1 played: " + Table.getInstance().getPlayer2().getHand().get(i).toString());
                            computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                            Table.getInstance().getPlayer2().getHand().remove(i);
                            return computerSelection;
                        }
                    }
                    if (numOfHeartsComp1 != 0) {
                        //This Drops the highest heart
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
                    } else {
                        //This Drops the highest non-heart and not the Queen of Spades
                        String highestCardInHand = arrayOfWholeHandComp1.get(arrayOfWholeHandComp1.size() - 1).toString();
                        for (int i = 0; i < Table.getInstance().getPlayer2().getHand().size(); i++) {
                            computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                            if (computerSelection.toString().equals(highestCardInHand)) {
                                System.out.println("Computer 1 played: " + Table.getInstance().getPlayer2().getHand().get(i).toString());
                                computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                                Table.getInstance().getPlayer2().getHand().remove(i);
                                return computerSelection;
                            }
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

        public static ArrayList<Card> cardsToPassComp1 () {
            //------This is a card passer for HAL9000 that emphasizes self preservation-----\\

            int indexOfQueen = 0;
            Card computerSelection = null;
            Boolean foundQueen = false;
            List<Card> arrayOfWholeHandComp1 = new ArrayList<>();
            ArrayList<Card> arrayOfCardsToPass = new ArrayList<>();

            for (int i = 0; i < Table.getInstance().getPlayer2().getHand().size(); i++) {
                //Searches the computers hand for the index of the queen of Spade
                computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
                arrayOfWholeHandComp1.add(computerSelection);

                if (computerSelection.toString().equals("Queen of Spades")) {
                    foundQueen = true;
                    indexOfQueen = i;
                }
            }

            if (foundQueen) {
                //if the queen exists in HAL's hand he will automatically pass it & the two highest cards.
                System.out.println("I FOUND THE QUEEEEEENNNN!");
                arrayOfCardsToPass.add(Table.getInstance().getPlayer2().getHand().get(indexOfQueen));
                Table.getInstance().getPlayer2().getHand().remove(indexOfQueen);

                for (int i = 0; i < 2; i++) {
                    int current;
                    int highest = Table.getInstance().getPlayer2().getHand().get(0).getRank().getValue();
                    int index = 0;
                    for (int j = 0; j < Table.getInstance().getPlayer2().getHand().size(); j++) {
                        current = Table.getInstance().getPlayer2().getHand().get(j).getRank().getValue();
                        if (current > highest) {
                            highest = current;
                            index = j;
                        }
                    }
                    arrayOfCardsToPass.add(Table.getInstance().getPlayer2().getHand().get(index));
                    System.out.println("Computer 1 passed: " + Table.getInstance().getPlayer2().getHand().get(index).toString());
                    Table.getInstance().getPlayer2().getHand().remove(index);
                }

            } else {
                //if no Queen of spades exists, then HAL just passes the three highest cards in his hand.
                for (int i = 0; i < 3; i++) {
                    int current = 0;
                    int highest = Table.getInstance().getPlayer2().getHand().get(0).getRank().getValue();
                    int index = 0;
                    for (int j = 0; j < Table.getInstance().getPlayer2().getHand().size(); j++) {
                        current = Table.getInstance().getPlayer2().getHand().get(j).getRank().getValue();
                        if (current > highest) {
                            highest = current;
                            index = j;
                        }
                    }
                    arrayOfCardsToPass.add(Table.getInstance().getPlayer2().getHand().get(index));
                    System.out.println("Computer 1 passed: " + Table.getInstance().getPlayer2().getHand().get(index).toString());
                    Table.getInstance().getPlayer2().getHand().remove(index);
                }
            }
            return arrayOfCardsToPass;
        }
    }



