package domain;

import domain.exception.CardDrawException;

import java.util.ArrayList;
import java.util.List;

public class Dealer {

    private static final int ADDITIONAL_DRAW_CRITERIA = 17;
    private static final int MAXIMUM_HAND_SIZE = 3;
    private int point = 0;

    private List<Card> cards = new ArrayList<>();

    public void receiveCard(Card card){
        if(this.cards.size() < MAXIMUM_HAND_SIZE){
            addHandCard(card);
        } else {
            throw new CardDrawException("받을 수 있는 핸드 수를 초과하였습니다.");
        }
    }

    private void addHandCard(Card card) {
        if (isDrawable()){
            this.cards.add(card);
            setPoint(card.getPoint());
        } else {
            throw new CardDrawException("포인트 합이 17이 넘으므로, 카드를 드로우 할 수 없습니다.");
        }
    }

    private boolean isDrawable() {
        return getPoint() < ADDITIONAL_DRAW_CRITERIA;
    }

    public int getPoint() {
        return point;
    }

    public List<Card> getCards() {
        return cards;
    }

    private void setPoint(int pointFromDenomination) {
        this.point += pointFromDenomination;
    }

    public List<Card> cardOpen(){
        return this.cards;
    }

    public void showCards() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("현재 보유 카드 목록 \n");

        for(Card card : this.cards){
            stringBuilder.append(card.toString());
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder.toString());
    }
}
