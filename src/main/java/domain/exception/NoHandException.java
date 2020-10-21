package domain.exception;

public class NoHandException extends RuntimeException {
    public NoHandException() {
        super();
    }

    public NoHandException(String message) {
        super(message);
    }
}
