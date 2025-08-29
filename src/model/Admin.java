package model;

import exception.ErrorMessage;
import exception.InvalidCredentialsException;

public class Admin extends Person {
    private final String username;
    private String password;

    public Admin(String name, String lastName, int birthYear, String gender, String username, String password) {
        super(name, lastName, birthYear, gender);
        this.username = username;
        this.password = password;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public void changePassword(String password) throws InvalidCredentialsException {
        if (isValidPassword(password)) {
            this.password = password;
        } else {
            throw new InvalidCredentialsException(ErrorMessage.INVALID_ACCOUNT_NUMBER);
        }
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*\\d.*");
    }
}
