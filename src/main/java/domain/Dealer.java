package domain;

import domain.exception.CardDrawException;
import domain.exception.NoHandException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Dealer implements Player {

    private static final int MAXIMUM_HAND_SIZE = 3;
    private List<Card> cards = new ArrayList<>();
    private final Rule rule;

    public Dealer(Rule rule) {
        this.rule = rule;
    }

    @Override
    public void receiveCard(Card card){
        if(!isOverHandSize(this.cards.size())){
            addHand(card);
        }
    }

    private void addHand(Card card) {
        if(rule.isDealerDrawable(this.cards)) {
            this.cards.add(card);
        } else {
            throw new CardDrawException("포인트 합이 17이 넘으므로, 카드를 드로우 할 수 없습니다.");
        }
    }

    private boolean isOverHandSize(int currentHandSize){
        if(currentHandSize < MAXIMUM_HAND_SIZE){
            return false;
        }
        throw new CardDrawException("받을 수 있는 핸드 수를 초과하였습니다.");
    }

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
        if (!(o instanceof Dealer)) return false;
        Dealer dealer = (Dealer) o;
        return cards.equals(dealer.cards) &&
                rule.equals(dealer.rule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards, rule);
    }
}
