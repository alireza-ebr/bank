package exception;

public class InvalidAccountNumberException extends Throwable {
    public InvalidAccountNumberException(String message) {
        super(message);
    }
}
