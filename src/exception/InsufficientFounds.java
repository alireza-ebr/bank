package exception;

public class InsufficientFounds extends RuntimeException{
    public InsufficientFounds(String message) {
        super(message);
    }
}
