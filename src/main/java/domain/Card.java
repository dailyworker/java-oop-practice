package domain;

import java.util.Objects;

public class Card {

    private static final String ACE = "A";
    private static final String[] DENOMINATION_IS_TEN = {"J", "Q", "K"};

    private CardSuit pattern;
    private String denomination;
    private int point;

    public Card(CardSuit pattern, String denomination) {
        this.pattern = pattern;
        this.denomination = denomination;
        this.point = denominationToPoint(denomination);
    }

    private int denominationToPoint(String denomination) {
        if(ACE.equals(denomination)) {
            return 1;
        } else if(contains(denomination)){
            return 10;
        } else {
            return Integer.parseInt(denomination);
        }
    }

    public int getPoint() {
        return point;
    }

    public CardSuit getPattern() {
        return pattern;
    }

    public String getDenomination() {
        return denomination;
    }

    private boolean contains(String denomination){
        boolean result = false;

        for(String value : Card.DENOMINATION_IS_TEN){
            if(value.equals(denomination)){
                result = true;
                break;
            }
        }

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return getPattern() == card.getPattern() &&
                Objects.equals(getDenomination(), card.getDenomination());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPattern(), getDenomination());
    }

    @Override
    public String toString() {
        return "Card{" + "pattern='" + pattern + ", " +
                "denomination='" + denomination + ", " +
                "point='" + point + "}";
    }
}
