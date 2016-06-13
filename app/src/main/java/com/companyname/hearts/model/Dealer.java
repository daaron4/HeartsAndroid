package com.companyname.hearts.model;

import java.util.Random;

/**
 * Created by David on 6/11/2016.
 */
public class Dealer {

    private static Dealer instance = null;
    private Deck deck;

    private Dealer() {
        // Do no allow instantiation
        deck = new Deck();
    }

    public static Dealer getDealer() {
        if(instance == null) {
            instance = new Dealer();
        }
        return instance;
    }

    public void shuffle() {
        // Shuffles the deck:
        int times = 0;
        while (times < 200) {
            Random rand = new Random();
            int randNum = rand.nextInt(52);
            int randNum2 = rand.nextInt(52);
            Card temp = new Card(deck.get(randNum).getRank(), deck.get(randNum)
                    .getSuit(), deck.get(randNum).getResId());
            Card temp2 = new Card(deck.get(randNum2).getRank(), deck.get(
                    randNum2).getSuit(), deck.get(randNum2).getResId());
            // if they are equal:
            while (temp.getRank() == temp2.getRank()
                    && temp.getSuit() == temp2.getSuit()) {
                randNum = rand.nextInt(52);
                randNum2 = rand.nextInt(52);
                temp = new Card(deck.get(randNum).getRank(), deck.get(randNum)
                        .getSuit(), deck.get(randNum).getResId());
                temp2 = new Card(deck.get(randNum2).getRank(), deck.get(
                        randNum2).getSuit(), deck.get(randNum2).getResId());
            }
            // they are not equal:
            deck.remove(randNum);
            deck.add(randNum, temp2);
            deck.remove(randNum2);
            deck.add(randNum2, temp);
            times++;
        }

    }

    public void deal(Player player1, Player player2, Player player3, Player player4) {
        for (int i = 0; i < 13; i++) {
            player1.getHand().add(deck.get(i));
        }
        for (int i = 13; i < 26; i++) {
            player2.getHand().add(deck.get(i));
        }
        for (int i = 26; i < 39; i++) {
            player3.getHand().add(deck.get(i));
        }
        for (int i = 39; i < 52; i++) {
            player4.getHand().add(deck.get(i));
        }
    }

}
