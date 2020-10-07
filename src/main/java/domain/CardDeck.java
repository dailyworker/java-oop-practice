package domain;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {
    private List<Card> cards = new ArrayList<>();

    public CardDeck(List<Card> cards) {
        this.cards = cards;
    }

    public CardDeck() {

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

    public void addCard(Card card) {
        this.cards.add(card);
    }
}
