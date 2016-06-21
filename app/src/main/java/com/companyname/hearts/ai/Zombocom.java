package com.companyname.hearts.ai;

import com.companyname.hearts.model.Card;
import com.companyname.hearts.model.Overlord;
import com.companyname.hearts.model.Table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by EmployYeezy on 6/17/16.
 */
public class Zombocom {

    public static Card computer3MakesMove() {
        if (Table.getInstance().getPlayer4().getHand().size() <= 1) {
            Card computerSelection = Table.getInstance().getPlayer4().getHand().get(0);
            Table.getInstance().getPlayer4().getHand().remove(0);
            System.out.println("Computer 3 played: " + computerSelection.toString());
            return computerSelection;
        }
        int times = 0;
        Random rand = new Random();
        while (times < 200) {
            int randNum = rand.nextInt(Table.getInstance().getPlayer4().getHand().size());
            int randNum2 = rand.nextInt(Table.getInstance().getPlayer4().getHand().size());
            while (randNum == randNum2) {
                randNum2 = rand.nextInt(Table.getInstance().getPlayer4().getHand().size());
            }

            Card temp = new Card(Table.getInstance().getPlayer4().getHand().get(randNum).getRank(), Table.getInstance().getPlayer4().getHand().get(randNum)
                    .getSuit(), Table.getInstance().getPlayer4().getHand().get(randNum).getResId());
            Card temp2 = new Card(Table.getInstance().getPlayer4().getHand().get(randNum2).getRank(), Table.getInstance().getPlayer4().getHand().get(
                    randNum2).getSuit(), Table.getInstance().getPlayer4().getHand().get(randNum2).getResId());
            Table.getInstance().getPlayer4().getHand().remove(randNum);
            Table.getInstance().getPlayer4().getHand().add(randNum, temp2);
            Table.getInstance().getPlayer4().getHand().remove(randNum2);
            Table.getInstance().getPlayer4().getHand().add(randNum2, temp);
            times++;
        }

        System.out.println("Computer 3 hand: " + Arrays.toString(Table.getInstance().getPlayer4().getHand().toArray()));
        int randIndex = rand.nextInt(Table.getInstance().getPlayer4().getHand().size());
        Card computerSelection = Table.getInstance().getPlayer4().getHand().get(randIndex);
        while (!Overlord.getInstance().canPlayCard(computerSelection, Table.getInstance().getPlayer4())) {
            randIndex = rand.nextInt(Table.getInstance().getPlayer4().getHand().size());
            computerSelection = Table.getInstance().getPlayer4().getHand().get(randIndex);
        }

        Table.getInstance().getPlayer4().getHand().remove(computerSelection);
        System.out.println("Computer 3 played: " + computerSelection.toString());
        return computerSelection;
    }

    public static ArrayList<Card> cardsToPassComp3() {
        ArrayList<Card> arrayOfCardsToPass = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            int randIndex = rand.nextInt(Table.getInstance().getPlayer4().getHand().size());
            arrayOfCardsToPass.add(Table.getInstance().getPlayer4().getHand().get(randIndex));
            Table.getInstance().getPlayer4().getHand().remove(randIndex);
        }
        return arrayOfCardsToPass;
    }

}
