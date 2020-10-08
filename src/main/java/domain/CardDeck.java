package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
    private List<Card> cards = new ArrayList<>();

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
        for(int i = 0; i < 14; i++){
            String denomination = numberToDenomination(i);
            Card card = new Card(CardSuit.valueOf(pattern), denomination);
            this.cards.add(card);
        }
    }

    public String numberToDenomination(int number){
        if(number == 0){
            return "A";
        } else if(number == 11) {
            return "J";
        } else if(number == 12) {
            return "Q";
        } else if(number == 13) {
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
}
