package domain.exception;

public class CardDrawException extends RuntimeException {
    public CardDrawException() {
        super();
    }

    public CardDrawException(String message) {
        super(message);
    }
}
