package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CardDeckTest {

    @ParameterizedTest
    @ValueSource(strings = {"SPADE", "HEART", "DIAMOND", "CLUB"})
    @DisplayName("초기 카드덱 초기화")
    public void 문양별_카드덱_만들기(String pattern){

        CardDeck cardDeck = new CardDeck();
        List<Card> cards = new ArrayList<>();

        for(int i = 0; i < 14; i++){
            String denomination = cardDeck.numberToDenomination(i);
            Card card = new Card(CardSuit.valueOf(pattern), denomination);
            cards.add(card); // 비교용 Card List Arr
            cardDeck.addCard(card);
        }
        assertSame(cardDeck.getCards().get(0), cards.get(0));
    }

    @ParameterizedTest
    @ValueSource(strings = {"SPADES", "HEARTS", "DIAMONDS", "CLUBS"})
    @DisplayName("문양 값이 잘못 들어오는 경우")
    public void 문양이_Enum에_있지_않은_값으로_들어오는_경우(String patterns){
        assertFalse(CardSuit.contains(patterns));
    }

    @Test
    @DisplayName("전체 카드덱 초기화")
    public void 전체_카드덱_만들기() {
        String[] patterns = {"SPADE", "HEART", "DIAMOND", "CLUB"};
        CardDeck actualCardDeck = new CardDeck();
        CardDeck expectedCardDeck = new CardDeck();

        actualCardDeck.generatedAllCardDeck(patterns);
        expectedCardDeck.generatedAllCardDeck(patterns);

        assertTrue(expectedCardDeck.getCards().containsAll(actualCardDeck.getCards()));
    }

}