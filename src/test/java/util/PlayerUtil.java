package util;

import domain.Card;
import domain.Player;

import java.util.List;

public class PlayerUtil {
    public static int getPlayerGamePoint(Player player){
        int gamePoint = 0;

        List<Card> playerHand = player.cardOpen();
        for(Card card : playerHand){
            gamePoint += card.getPoint();
            if(gamePoint > 21){
                return 0;
            }
        }
        return gamePoint;
    }
}
