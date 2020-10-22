package domain;

import java.util.List;

public class Rule {

    private static final int DEALER_ADDITIONAL_DRAW_CRITERIA = 17;

    public Player getWinner(List<Player> players) {

        Player winner = null;
        int highPoint = 0;

        for(Player player : players){
            int temp = highPoint;
            int playerGamePoint = calculatePoint(player.cardOpen());

            highPoint = getHighPoint(highPoint, playerGamePoint);
            winner = getPlayer(winner, highPoint, player, temp);
        }

        return winner;
    }

    public boolean isDealerDrawable(List<Card> cards) {
        int dealerTotalGamePoint = calculatePoint(cards);
        return dealerTotalGamePoint < DEALER_ADDITIONAL_DRAW_CRITERIA;
    }

    private Player getPlayer(Player winner, int highPoint, Player player, int temp) {
        if(temp != highPoint) {
            winner = player;
        }
        return winner;
    }

    private int getHighPoint(int oldPoint, int newPoint) {
        return Math.max(oldPoint, newPoint);
    }

    private boolean isBurst(int gamePoint) {
        return gamePoint > 21;
    }

    private int calculatePoint(List<Card> playerHand) {
        int total = 0;

        for(Card card : playerHand){
            total += card.getPoint();
        }

        if(isBurst(total)) {
            return 0;
        }
        return total;
    }

}
