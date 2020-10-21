package domain;

import java.util.List;

public interface Player {
    public void receiveCard(Card card);
    public void showCards();
    public List<Card> cardOpen();
    public boolean isTurn();
}
