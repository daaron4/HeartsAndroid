package com.companyname.hearts.model;

/**
 * Created by David on 6/11/2016.
 */
public class ComputerManager {

    public static Card makeMove() {
        if (Overlord.getOverlord().getCurrentPlayer() == Table.getTable().getPlayer2()) {
            Card player2Card = null;
            for (int i = 0; i < Table.getTable().getPlayer2().getHand().size(); i++) {
                player2Card = Table.getTable().getPlayer2().getHand().get(i);
                if (Overlord.getOverlord().canPlayCard(player2Card, Table.getTable().getPlayer2().getHand(),
                        Overlord.getOverlord().getCurrentPlayer(), Table.getTable().getPlayer2(), Overlord.getOverlord().getRoundsPlayed())) {
                    break;
                }
            }
            Table.getTable().getPlayer2().getHand().remove(player2Card);
            Overlord.getOverlord().setCurrentPlayer(Table.getTable().getPlayer3());
            return player2Card;
        }
        else if (Overlord.getOverlord().getCurrentPlayer() == Table.getTable().getPlayer3()) {
            Card player3Card = null;
            for (int i = 0; i < Table.getTable().getPlayer3().getHand().size(); i++) {
                player3Card = Table.getTable().getPlayer3().getHand().get(i);
                if (Overlord.getOverlord().canPlayCard(player3Card, Table.getTable().getPlayer3().getHand(),
                        Overlord.getOverlord().getCurrentPlayer(), Table.getTable().getPlayer3(), Overlord.getOverlord().getRoundsPlayed())) {
                    break;
                }
            }
            Table.getTable().getPlayer3().getHand().remove(player3Card);
            Overlord.getOverlord().setCurrentPlayer(Table.getTable().getPlayer4());
            return player3Card;
        }
        else if (Overlord.getOverlord().getCurrentPlayer() == Table.getTable().getPlayer4()) {
            Card player4Card = null;
            for (int i = 0; i < Table.getTable().getPlayer4().getHand().size(); i++) {
                player4Card = Table.getTable().getPlayer4().getHand().get(i);
                if (Overlord.getOverlord().canPlayCard(player4Card, Table.getTable().getPlayer4().getHand(),
                        Overlord.getOverlord().getCurrentPlayer(), Table.getTable().getPlayer4(), Overlord.getOverlord().getRoundsPlayed())) {
                    break;
                }
            }
            Table.getTable().getPlayer4().getHand().remove(player4Card);
            Overlord.getOverlord().setCurrentPlayer(Table.getTable().getPlayer1());
            return player4Card;
        }
        else {
            return null;
        }
    }

}
