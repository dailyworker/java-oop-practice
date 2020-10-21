package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CardDeckTest {

    @ParameterizedTest
    @ValueSource(strings = {"SPADES", "HEARTS", "DIAMONDS", "CLUBS"})
    @DisplayName("문양 값이 잘못 들어오는 경우")
    public void 문양이_Enum에_있지_않은_값으로_들어오는_경우(String patterns){
        assertFalse(CardSuit.contains(patterns));
    }

    @Test
    @DisplayName("전체 카드덱 초기화")
    public void 전체_카드덱_만들기() {
        CardDeck actualCardDeck = new CardDeck();
        CardDeck expectedCardDeck = new CardDeck();

        assertAll("Generating All Card",
                () -> assertTrue(expectedCardDeck.getCards().containsAll(actualCardDeck.getCards())),
                () -> assertEquals(52, actualCardDeck.getCards().size())
        );
    }

    @Test
    @DisplayName("카드 덱 셔플하기")
    public void 카드_섞기() {
        CardDeck actualCardDeck = new CardDeck();
        CardDeck expectedCardDeck = new CardDeck();
        assertNotEquals(expectedCardDeck.getCards().get(1).getPattern(), actualCardDeck.getCards().get(1).getPattern());
    }

    @Test
    @DisplayName("카드 드로우")
    public void 카드_뽑기() {
        CardDeck cardDeck = new CardDeck();
        Card actualCard = cardDeck.getCards().get(0);
        Card expectedCard = cardDeck.draw();

        assertAll("Card Draw Test",
                () -> assertEquals(actualCard, expectedCard),
                () -> assertEquals(51, cardDeck.getCards().size())
        );
    }
}