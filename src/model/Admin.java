package model;

import java.util.Scanner;

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

    public boolean handleLogin(Scanner scanner) {
        scanner.nextLine();
        System.out.println("Enter admin username: ");
        String username = scanner.nextLine();

        System.out.println("Enter admin password: ");
        String password = scanner.nextLine();

        if (this.login(username, password)) {
            System.out.println("You have successfully logged in!");
            return true;
        } else {
            System.out.println("You have unsuccessfully logged in!");
            return false;
        }

    }

    public void changePassword(String password) {
        if (isValidPassword(password)) {
            this.password = password;
        } else {
            System.out.println("Password must be at least 8 characters, contain one uppercase letter and one digit.");
        }
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*\\d.*");
    }
}
