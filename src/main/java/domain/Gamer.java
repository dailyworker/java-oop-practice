package domain;

import domain.exception.NoHandException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Gamer implements Player{
    private List<Card> cards = new ArrayList<>();

    @Override
    public boolean isTurn() {
        return false;
    }

    @Override
    public List<Card> cardOpen(){
        if(!cards.isEmpty()) {
            return this.cards;
        }
        throw new NoHandException("손에 든 카드가 한 장도 없습니다.");
    }

    @Override
    public void receiveCard(Card card){
        this.cards.add(card);
    }

    @Override
    public void showCards() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("현재 보유 카드 목록 \n");

        for(Card card : this.cards){
            stringBuilder.append(card.toString());
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gamer)) return false;
        Gamer gamer = (Gamer) o;
        return Objects.equals(cards, gamer.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards);
    }
}
