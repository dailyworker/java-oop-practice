package domain;

import domain.exception.CardDrawException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DealerTest {

    @Test
    @DisplayName("딜러의 카드 포인트가 17이상인지 판단")
    public void 두_카드의_합이_17이상인지() {

        CardDeck cardDeck = new CardDeck();
        Dealer dealer = new Dealer();

        dealer.receiveCard(cardDeck.draw());
        dealer.receiveCard(cardDeck.draw());
        dealer.showCards();

        if (dealer.getPoint() >= 17) {
            CardDrawException thrown = assertThrows(
                    CardDrawException.class,
                    () -> dealer.receiveCard(cardDeck.draw())
            );
            assertTrue(thrown.getMessage().contains("포인트 합이 17이 넘으므로, 카드를 드로우 할 수 없습니다."));
        } else {
            dealer.receiveCard(cardDeck.draw());
            assertEquals(dealer.getCards().size(), 3);
        }
    }

    @Test
    @DisplayName("딜러는 3장 이상 뽑을 수 없다.")
    public void 딜러는_핸드가_3장을_넘길_수_없다() {
        CardDeck cardDeck = new CardDeck();
        Dealer dealer = new Dealer();

        dealer.receiveCard(cardDeck.draw());
        dealer.receiveCard(cardDeck.draw());
        dealer.receiveCard(cardDeck.draw());

        CardDrawException thrown = assertThrows(
                CardDrawException.class,
                () -> dealer.receiveCard(cardDeck.draw())
        );
        assertTrue(thrown.getMessage().contains("받을 수 있는 핸드 수를 초과하였습니다."));
    }

}