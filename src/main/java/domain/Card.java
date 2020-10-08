package domain;

import java.util.Objects;

public class Card {

    private CardSuit pattern;
    private String denomination;

    public Card(CardSuit pattern, String denomination) {
        this.pattern = pattern;
        this.denomination = denomination;
    }

    public Card() {

    }

    public CardSuit getPattern() {
        return pattern;
    }

    public void setPattern(CardSuit pattern) {
        this.pattern = pattern;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
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
}
