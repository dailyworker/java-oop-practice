package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GamerTest {

    @Test
    @DisplayName("게이머는 카드를 소유한다.")
    public void 게이머는_뽑은_카드를_소유한다() {

        CardDeck cardDeck = new CardDeck();
        List<Card> cards = new ArrayList<Card>();

        cards.add(cardDeck.getCards().get(0));
        cards.add(cardDeck.getCards().get(1));

        Gamer gamer = new Gamer();
        gamer.receiveCard(cardDeck.draw());
        gamer.receiveCard(cardDeck.draw());

        assertEquals(cards, gamer.cardOpen());
    }
}