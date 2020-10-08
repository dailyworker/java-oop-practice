package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
    private List<Card> cards = new ArrayList<>();

    private static final int CARD_DECK_SIZE = 13;
    private static final int PATTERN_A_NUMBER = 1;
    private static final int PATTERN_J_NUMBER = 11;
    private static final int PATTERN_Q_NUMBER = 12;
    private static final int PATTERN_K_NUMBER = 13;

    private static final String[] patterns = {
            CardSuit.SPADE.name(),
            CardSuit.HEART.name(),
            CardSuit.DIAMOND.name(),
            CardSuit.CLUB.name()
    };

    public CardDeck() {
        generatedAllCardDeck(patterns);
        shuffleCardDeck();
    }

    public List<Card> getCards() {
        return cards;
    }

    public void generatedCardDeckByPattern(String pattern){
        for(int i = 1; i <= CARD_DECK_SIZE; i++){
            String denomination = numberToDenomination(i);
            Card card = new Card(CardSuit.valueOf(pattern), denomination);
            this.cards.add(card);
        }
    }

    public String numberToDenomination(int number){
        if(number == PATTERN_A_NUMBER){
            return "A";
        } else if(number == PATTERN_J_NUMBER) {
            return "J";
        } else if(number == PATTERN_Q_NUMBER) {
            return "Q";
        } else if(number == PATTERN_K_NUMBER) {
            return "K";
        } else {
            return String.valueOf(number);
        }
    }

    public void generatedAllCardDeck(String[] patterns) {
        for(int i = 0; i < patterns.length; i++) {
            generatedCardDeckByPattern(patterns[i]);
        }
    }

    public void shuffleCardDeck(){
        Collections.shuffle(cards);
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public Card draw() {
        Card returnCard = this.cards.get(0);
        this.cards.remove(0);
        return returnCard;
    }
}
