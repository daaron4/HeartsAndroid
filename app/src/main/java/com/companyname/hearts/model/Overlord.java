package com.companyname.hearts.model;

import java.util.Arrays;

public class Overlord {

    private boolean playing;
    private boolean heartsBroken;
    private int roundsPlayed;
    private Player leadingPlayer;

    private static Overlord instance = null;

    private Overlord() {
        // Do no allow instantiation
        playing = true;
        heartsBroken = false;
        roundsPlayed = 1;
        leadingPlayer = playerWithTheTwoOfClubs();
    }

    public static Overlord getInstance() {
        if(instance == null) {
            instance = new Overlord();
        }
        return instance;
    }

    public Player playerWithTheTwoOfClubs() {
        Player playerWithTwoOfClubs = null;
        for (int i = 0; i < 13; i++) {
            if (Table.getInstance().getPlayer1().getHand().get(i).getRank().getValue() == 2
                    && Table.getInstance().getPlayer1().getHand().get(i).getSuit() == Suit.Clubs)
                playerWithTwoOfClubs = Table.getInstance().getPlayer1();
            if (Table.getInstance().getPlayer2().getHand().get(i).getRank().getValue() == 2
                    && Table.getInstance().getPlayer2().getHand().get(i).getSuit() == Suit.Clubs)
                playerWithTwoOfClubs = Table.getInstance().getPlayer2();
            if (Table.getInstance().getPlayer3().getHand().get(i).getRank().getValue() == 2
                    && Table.getInstance().getPlayer3().getHand().get(i).getSuit() == Suit.Clubs)
                playerWithTwoOfClubs = Table.getInstance().getPlayer3();
            if (Table.getInstance().getPlayer4().getHand().get(i).getRank().getValue() == 2
                    && Table.getInstance().getPlayer4().getHand().get(i).getSuit() == Suit.Clubs)
                playerWithTwoOfClubs = Table.getInstance().getPlayer4();
        }
        return playerWithTwoOfClubs;
    }

    public void determineTrickWinner() {
        System.out.println("Board is: " + Arrays.toString(Table.getInstance().getBoard().toArray()));
        Card winner = Table.getInstance().getBoard().get(0);
        Suit lead = winner.getSuit();
        int leadValue = winner.getRank().getValue();
        int winnerPosition = 0;
        for (int i = 1; i < Table.getInstance().getBoard().size(); i++) {
            if (Table.getInstance().getBoard().get(i).getSuit() == lead) {
                if (Table.getInstance().getBoard().get(i).getRank().getValue() > leadValue) {
                    winner = Table.getInstance().getBoard().get(i);
                    winnerPosition = i;
                    leadValue = winner.getRank().getValue();
                }
            }
        }

        // Leading player wins hand:
        if (getLeadingPlayer() == Table.getInstance().getPlayer1()) {
            if (winnerPosition == 0) {

            }
            else if (winnerPosition == 1) {
                setLeadingPlayer(Table.getInstance().getPlayer2());
            }
            else if (winnerPosition == 2) {
                setLeadingPlayer(Table.getInstance().getPlayer3());
            }
            else {
                setLeadingPlayer(Table.getInstance().getPlayer4());
            }
        }
        else if (getLeadingPlayer() == Table.getInstance().getPlayer2()) {
            if (winnerPosition == 0) {

            }
            else if (winnerPosition == 1) {
                setLeadingPlayer(Table.getInstance().getPlayer3());
            }
            else if (winnerPosition == 2) {
                setLeadingPlayer(Table.getInstance().getPlayer4());
            }
            else {
                setLeadingPlayer(Table.getInstance().getPlayer1());
            }
        }
        else if (getLeadingPlayer() == Table.getInstance().getPlayer3()) {
            if (winnerPosition == 0) {

            }
            else if (winnerPosition == 1) {
                setLeadingPlayer(Table.getInstance().getPlayer4());
            }
            else if (winnerPosition == 2) {
                setLeadingPlayer(Table.getInstance().getPlayer1());
            }
            else {
                setLeadingPlayer(Table.getInstance().getPlayer2());
            }
        }
        else {
            if (winnerPosition == 0) {

            }
            else if (winnerPosition == 1) {
                setLeadingPlayer(Table.getInstance().getPlayer1());
            }
            else if (winnerPosition == 2) {
                setLeadingPlayer(Table.getInstance().getPlayer2());
            }
            else {
                setLeadingPlayer(Table.getInstance().getPlayer3());
            }
        }

        for (int i = 0; i < Table.getInstance().getBoard().size(); i++) {
            getLeadingPlayer().getOldCards().add(Table.getInstance().getBoard().get(i));
        }
        Table.getInstance().getBoard().clear();
    }

    public void reset() {
        // Clear all OldCards:
        Table.getInstance().getPlayer1().getOldCards().clear();
        Table.getInstance().getPlayer2().getOldCards().clear();
        Table.getInstance().getPlayer3().getOldCards().clear();
        Table.getInstance().getPlayer4().getOldCards().clear();
        heartsBroken = false;
        // increment roundPlayed:
        roundsPlayed=1;
        Dealer.getInstance().deal(Table.getInstance().getPlayer1(), Table.getInstance().getPlayer2(), Table.getInstance().getPlayer3(), Table.getInstance().getPlayer4());
        leadingPlayer = playerWithTheTwoOfClubs();
    }

    public void updatePlaying() {
        if (Table.getInstance().getPlayer1().getPoints() >= 100 || Table.getInstance().getPlayer2().getPoints() >= 100
                || Table.getInstance().getPlayer3().getPoints() >= 100 || Table.getInstance().getPlayer4().getPoints() >= 100) {
            playing = false;
        }
    }

    public void calculatePoints() {
        int player1Points = 0;
        int player2Points = 0;
        int player3Points = 0;
        int player4Points = 0;

        for (int i = 0; i < Table.getInstance().getPlayer1().getOldCards().size(); i++) {
            if (Table.getInstance().getPlayer1().getOldCards().get(i).getSuit() == Suit.Hearts)
                player1Points++;
            if (Table.getInstance().getPlayer1().getOldCards().get(i).getSuit() == Suit.Spades
                    && Table.getInstance().getPlayer1().getOldCards().get(i).getRank() == Rank.Queen)
                player1Points = player1Points + 13;
        }
        for (int i = 0; i < Table.getInstance().getPlayer2().getOldCards().size(); i++) {
            if (Table.getInstance().getPlayer2().getOldCards().get(i).getSuit() == Suit.Hearts)
                player2Points++;
            if (Table.getInstance().getPlayer2().getOldCards().get(i).getSuit() == Suit.Spades
                    && Table.getInstance().getPlayer2().getOldCards().get(i).getRank() == Rank.Queen)
                player2Points = player2Points + 13;
        }
        for (int i = 0; i < Table.getInstance().getPlayer3().getOldCards().size(); i++) {
            if (Table.getInstance().getPlayer3().getOldCards().get(i).getSuit() == Suit.Hearts)
                player3Points++;
            if (Table.getInstance().getPlayer3().getOldCards().get(i).getSuit() == Suit.Spades
                    && Table.getInstance().getPlayer3().getOldCards().get(i).getRank() == Rank.Queen)
                player3Points = player3Points + 13;
        }
        for (int i = 0; i < Table.getInstance().getPlayer4().getOldCards().size(); i++) {
            if (Table.getInstance().getPlayer4().getOldCards().get(i).getSuit() == Suit.Hearts)
                player4Points++;
            if (Table.getInstance().getPlayer4().getOldCards().get(i).getSuit() == Suit.Spades
                    && Table.getInstance().getPlayer4().getOldCards().get(i).getRank() == Rank.Queen)
                player4Points = player4Points + 13;
        }
        // Calculate points, moon shoot:
        if (player1Points == 26) {
            Table.getInstance().getPlayer2().setPoints(Table.getInstance().getPlayer2().getPoints() + 26);
            Table.getInstance().getPlayer3().setPoints(Table.getInstance().getPlayer3().getPoints() + 26);
            Table.getInstance().getPlayer4().setPoints(Table.getInstance().getPlayer4().getPoints() + 26);
        } else if (player2Points == 26) {
            Table.getInstance().getPlayer1().setPoints(Table.getInstance().getPlayer1().getPoints() + 26);
            Table.getInstance().getPlayer3().setPoints(Table.getInstance().getPlayer3().getPoints() + 26);
            Table.getInstance().getPlayer4().setPoints(Table.getInstance().getPlayer4().getPoints() + 26);
        } else if (player3Points == 26) {
            Table.getInstance().getPlayer1().setPoints(Table.getInstance().getPlayer1().getPoints() + 26);
            Table.getInstance().getPlayer2().setPoints(Table.getInstance().getPlayer2().getPoints() + 26);
            Table.getInstance().getPlayer4().setPoints(Table.getInstance().getPlayer4().getPoints() + 26);
        } else if (player4Points == 26) {
            Table.getInstance().getPlayer1().setPoints(Table.getInstance().getPlayer1().getPoints() + 26);
            Table.getInstance().getPlayer2().setPoints(Table.getInstance().getPlayer2().getPoints() + 26);
            Table.getInstance().getPlayer3().setPoints(Table.getInstance().getPlayer3().getPoints() + 26);
        } else {
            // Calculate points, no moon shoot:
            for (int i = 0; i < Table.getInstance().getPlayer1().getOldCards().size(); i++) {
                if (Table.getInstance().getPlayer1().getOldCards().get(i).getSuit() == Suit.Hearts)
                    Table.getInstance().getPlayer1().setPoints(Table.getInstance().getPlayer1().getPoints() + 1);
                if (Table.getInstance().getPlayer1().getOldCards().get(i).getSuit() == Suit.Spades
                        && Table.getInstance().getPlayer1().getOldCards().get(i).getRank() == Rank.Queen)
                    Table.getInstance().getPlayer1().setPoints(Table.getInstance().getPlayer1().getPoints() + 13);
            }
            for (int i = 0; i < Table.getInstance().getPlayer2().getOldCards().size(); i++) {
                if (Table.getInstance().getPlayer2().getOldCards().get(i).getSuit() == Suit.Hearts)
                    Table.getInstance().getPlayer2().setPoints(Table.getInstance().getPlayer2().getPoints() + 1);
                if (Table.getInstance().getPlayer2().getOldCards().get(i).getSuit() == Suit.Spades
                        && Table.getInstance().getPlayer2().getOldCards().get(i).getRank() == Rank.Queen)
                    Table.getInstance().getPlayer2().setPoints(Table.getInstance().getPlayer2().getPoints() + 13);
            }
            for (int i = 0; i < Table.getInstance().getPlayer3().getOldCards().size(); i++) {
                if (Table.getInstance().getPlayer3().getOldCards().get(i).getSuit() == Suit.Hearts)
                    Table.getInstance().getPlayer3().setPoints(Table.getInstance().getPlayer3().getPoints() + 1);
                if (Table.getInstance().getPlayer3().getOldCards().get(i).getSuit() == Suit.Spades
                        && Table.getInstance().getPlayer3().getOldCards().get(i).getRank() == Rank.Queen)
                    Table.getInstance().getPlayer3().setPoints(Table.getInstance().getPlayer3().getPoints() + 13);
            }
            for (int i = 0; i < Table.getInstance().getPlayer4().getOldCards().size(); i++) {
                if (Table.getInstance().getPlayer4().getOldCards().get(i).getSuit() == Suit.Hearts)
                    Table.getInstance().getPlayer4().setPoints(Table.getInstance().getPlayer4().getPoints() + 1);
                if (Table.getInstance().getPlayer4().getOldCards().get(i).getSuit() == Suit.Spades
                        && Table.getInstance().getPlayer4().getOldCards().get(i).getRank() == Rank.Queen)
                    Table.getInstance().getPlayer4().setPoints(Table.getInstance().getPlayer4().getPoints() + 13);
            }
        }
    }

//    // ToDo: old passing logic, might need some day:
//    public void passCards(int roundsPlayed) {
//        // display the game:
//        System.out.println("Human hand:");
//        for (int i = 0; i < human.getHand().size(); i++)
//            System.out.print(human.getCardAsString(i) + " ");
//        System.out.println();
//        System.out.println("Computer One hand:");
//        for (int i = 0; i < comp1.getHand().size(); i++)
//            System.out.print(comp1.getCardAsString(i) + " ");
//        System.out.println();
//        System.out.println("Computer Two hand:");
//        for (int i = 0; i < comp2.getHand().size(); i++)
//            System.out.print(comp2.getCardAsString(i) + " ");
//        System.out.println();
//        System.out.println("Computer Three hand:");
//        for (int i = 0; i < comp3.getHand().size(); i++)
//            System.out.print(comp3.getCardAsString(i) + " ");
//
//        System.out.println();
//
//        // Pass Cards Direction:
//        if (roundsPlayed == 1 || roundsPlayed == 5 || roundsPlayed == 9
//                || roundsPlayed == 13) {
//            System.out.println("Pass three cards left: ");
//        }
//        if (roundsPlayed == 2 || roundsPlayed == 6 || roundsPlayed == 10) {
//            System.out.println("Pass three cards right: ");
//        }
//        if (roundsPlayed == 3 || roundsPlayed == 7 || roundsPlayed == 11) {
//            System.out.println("Pass three cards across: ");
//        }
//        if (roundsPlayed == 4 || roundsPlayed == 8 || roundsPlayed == 12) {
//            System.out.println("No Passing...: ");
//        }
//        ArrayList<Card> temp = new ArrayList<Card>();
//
//        System.out.println("Select first card: ");
//        Scanner scan = new Scanner(System.in);
//        String userSelection = scan.nextLine();
//        Card firstUserCard = null;
//        while (firstUserCard == null) {
//            for (int i = 0; i < human.getHand().size(); i++) {
//                if (human.getCardAsString(i).equals(userSelection)) {
//                    firstUserCard = human.getHand().get(i);
//                    human.getHand().remove(i);
//                    break;
//                }
//            }
//            if (firstUserCard == null) {
//                System.out.println("Try Again:");
//                userSelection = scan.nextLine();
//            }
//        }
//        temp.add(firstUserCard);
//
//        System.out.println("Select second card: ");
//        userSelection = scan.nextLine();
//        Card secondUserCard = null;
//        while (secondUserCard == null) {
//            for (int i = 0; i < human.getHand().size(); i++) {
//                if (human.getCardAsString(i).equals(userSelection)) {
//                    secondUserCard = human.getHand().get(i);
//                    human.getHand().remove(i);
//                    break;
//                }
//            }
//            if (secondUserCard == null) {
//                System.out.println("Try Again:");
//                userSelection = scan.nextLine();
//            }
//        }
//        temp.add(secondUserCard);
//
//        System.out.println("Select third card: ");
//        userSelection = scan.nextLine();
//        Card thirdUserCard = null;
//        while (thirdUserCard == null) {
//            for (int i = 0; i < human.getHand().size(); i++) {
//                if (human.getCardAsString(i).equals(userSelection)) {
//                    thirdUserCard = human.getHand().get(i);
//                    human.getHand().remove(i);
//                    break;
//                }
//            }
//            if (thirdUserCard == null) {
//                System.out.println("Try Again:");
//                userSelection = scan.nextLine();
//            }
//        }
//        temp.add(thirdUserCard);
//
//        // Display human hand before passing them:
//        System.out.println("Cards before passing: ");
//        for (int i = 0; i < human.getHand().size(); i++)
//            System.out.print(human.getCardAsString(i) + " ");
//
//        // This method just gives the computer to the left three cards, and
//        // gives
//        // the user the first three cards of the computer to the left:
//
//        // Add cards from temp to end of comp1
//        for (int i = 0; i < temp.size(); i++)
//            comp1.getHand().add(temp.get(i));
//
//        // Clear temp:
//        temp.clear();
//        // Add first three Cards of comp1's hand to temp, and then remove them:
//        temp.add(comp1.getHand().get(0));
//        comp1.getHand().remove(0);
//        temp.add(comp1.getHand().get(0));
//        comp1.getHand().remove(0);
//        temp.add(comp1.getHand().get(0));
//        comp1.getHand().remove(0);
//        System.out.println();
//
//        // display cards about to be received:
//        System.out.println("You will get these cards: ");
//        for (int i = 0; i < temp.size(); i++)
//            System.out.println(temp.get(i).toString());
//
//        // Add cards from temp to end of human hand:
//        for (int i = 0; i < temp.size(); i++)
//            human.getHand().add(temp.get(i));
//
//        // sort the hands that changed:
//        sort(human.getHand());
//        sort(comp1.getHand());
//        System.out.println();
//
//    }

    public boolean canPlayCard(Card userCard, Player whosPlaying) {
        if (getRoundsPlayed() == 1) {
            if (getLeadingPlayer() == whosPlaying) {
                if (!(userCard.getSuit() == Suit.Clubs && userCard.getRank()
                        .getValue() == 2)) {
                    return false;
                }
            }
            // If you aren't the leading player, you have to follow suit, unless
            // you don't have clubs, then you can play anything except the queen
            // of spades or hearts, unless its all you have:
            else {
                int numberOfClubs = 0;
                for (int i = 0; i < whosPlaying.getHand().size(); i++) {
                    if (whosPlaying.getHand().get(i).getSuit() == Suit.Clubs) {
                        numberOfClubs++;
                    }
                }
                // Have to play a club here:
                if (numberOfClubs > 0) {
                    if (userCard.getSuit() != Suit.Clubs)
                        return false;
                }
                // Don't have any clubs, can't play a trick unless there is no
                // other choice:
                else {
                    int notHearts = 0;
                    for (int i = 0; i < whosPlaying.getHand().size(); i++) {
                        if (whosPlaying.getHand().get(i).getSuit() != Suit.Hearts
                                || (whosPlaying.getHand().get(i).getSuit() != Suit.Spades && whosPlaying.getHand()
                                .get(i).getRank() != Rank.Queen)) {
                            notHearts++;
                        }
                    }
                    // Have stuff that isn't Hearts, must play a non-heart here:
                    if (notHearts > 0) {
                        if (userCard.getSuit() == Suit.Hearts || (userCard.getSuit() == Suit.Spades && userCard.getRank() == Rank.Queen)) {
                            return false;
                        }
                    }
                    // All cards are hearts
                    else {
                        return true;
                    }

                }

            }

        }
        // If all you have is hearts or all hearts and the queen of spades, you
        // can play right away no matter what:
        int numHearts = 0;
        for (int i = 0; i < whosPlaying.getHand().size(); i++) {
            if (whosPlaying.getHand().get(i).getSuit() == Suit.Hearts
                    || (whosPlaying.getHand().get(i).getSuit() == Suit.Spades && whosPlaying.getHand()
                    .get(i).getRank() == Rank.Queen))
                numHearts++;
        }
        if (numHearts == whosPlaying.getHand().size()) {
            // All you have is hearts, return true and break hearts:
            heartsBroken = true;
            return true;
        }

        if (Table.getInstance().getBoard().isEmpty()) {
            // Nobody has played any cards yet, make sure they don't play a
            // heart, or the queen, if hearts have not been broken:
            if (heartsBroken == false) {
                if (userCard.getSuit() == Suit.Hearts
                        || (userCard.getSuit() == Suit.Spades && userCard
                        .getRank() == Rank.Queen)) {
                    // System.out.println("Cant play that, Hearts have not been broken yet, ");
                    return false;
                }
            }
            // Hearts have been broken, the user can play any card
            leadingPlayer = whosPlaying;
            return true;
        } else {
            // board is not empty so there is at least one card in board:
            Suit leadingSuit = Table.getInstance().getBoard().get(0).getSuit();
            // Check to see if the current player can follow suit:
            int times = 0;
            for (int i = 0; i < whosPlaying.getHand().size(); i++) {
                if (whosPlaying.getHand().get(i).getSuit() == leadingSuit)
                    times++;
            }
            // I have to follow suit here
            if (times > 0) {
                // Didn't follow suit, cant do this because they have the leading
                // suit
                if (userCard.getSuit() != leadingSuit) {
                    // System.out.println("Cant play that, you must follow Suit, ");
                    return false;
                }
            }
            // Dont have to follow suit, can play whatever card you want
            // Check to see if this causes hearts to be broken:
            if (userCard.getSuit() == Suit.Hearts
                    || (userCard.getSuit() == Suit.Spades && userCard.getRank() == Rank.Queen)) {
                heartsBroken = true;
            }
            return true;
        }

    }

    public boolean getPlaying() {
        return playing;
    }

    public Player getLeadingPlayer() {
        return leadingPlayer;
    }

    public void setLeadingPlayer(Player newPlayer) {
        leadingPlayer = newPlayer;
    }

    public int getRoundsPlayed() {
        return roundsPlayed;
    }

    public void setRoundsPlayed(int newValue) {
        roundsPlayed = newValue;
    }

}
