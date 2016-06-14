package com.companyname.hearts.model;

/**
 * Created by David on 6/11/2016.
 */
public class ComputerManager {

    public static Card computer1MakesMove() {
        Card computerSelection = null;
        for (int i = 0; i < Table.getInstance().getPlayer2().getHand().size(); i++) {
            computerSelection = Table.getInstance().getPlayer2().getHand().get(i);
            if (Overlord.getInstance().canPlayCard(computerSelection, Table.getInstance().getPlayer2())) {
                break;
            }
        }
        System.out.println("Card selected: " + computerSelection.toString());
        Table.getInstance().getPlayer2().getHand().remove(computerSelection);
        return computerSelection;
    }

    public static Card computer2MakesMove() {
        Card computerSelection = null;
        for (int i = 0; i < Table.getInstance().getPlayer3().getHand().size(); i++) {
            computerSelection = Table.getInstance().getPlayer3().getHand().get(i);
            if (Overlord.getInstance().canPlayCard(computerSelection, Table.getInstance().getPlayer3())) {
                break;
            }
        }
        System.out.println("Card selected: " + computerSelection.toString());
        Table.getInstance().getPlayer3().getHand().remove(computerSelection);
        return computerSelection;
    }

    public static Card computer3MakesMove() {
        Card computerSelection = null;
        for (int i = 0; i < Table.getInstance().getPlayer4().getHand().size(); i++) {
            computerSelection = Table.getInstance().getPlayer4().getHand().get(i);
            if (Overlord.getInstance().canPlayCard(computerSelection, Table.getInstance().getPlayer4())) {
                break;
            }
        }
        System.out.println("Card selected: " + computerSelection.toString());
        Table.getInstance().getPlayer4().getHand().remove(computerSelection);
        return computerSelection;
    }

}
