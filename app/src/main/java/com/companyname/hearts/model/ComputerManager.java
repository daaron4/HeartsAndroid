package com.companyname.hearts.model;

/**
 * Created by David on 6/11/2016.
 */
public class ComputerManager {

    public static Card makeMove(Player currentComputer) {
        Card computerCard = null;
        for (int i = 0; i < currentComputer.getHand().size(); i++) {
            computerCard = currentComputer.getHand().get(i);
            if (Overlord.getInstance().canPlayCard(computerCard, currentComputer.getHand(),
                    Overlord.getInstance().getLeadingPlayer(), currentComputer, Overlord.getInstance().getRoundsPlayed())) {
                break;
            }
        }
        Table.getInstance().getPlayer2().getHand().remove(computerCard);
        return computerCard;
    }

}
