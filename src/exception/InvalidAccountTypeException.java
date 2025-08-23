package exception;

public class InvalidAccountTypeException extends Throwable {
    public InvalidAccountTypeException(String message) {
        super(message);
    }
}
