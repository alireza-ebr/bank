package menu;

import data.DataStorage;
import exception.ErrorMessage;
import main.Main;
import model.*;
import util.Util;

import java.util.Scanner;

public class AdminMenu {
    private final Scanner scanner;
    private final String adminUsername;
    private final String adminPassword;

    public AdminMenu(Scanner scanner) {
        this.scanner = scanner;
        System.out.println("===Set up admin account====");
        this.adminUsername = scanner.next("Enter new admin username: ");
        this.adminPassword = scanner.next("Enter new admin password: ");
        System.out.println("Admin account created successfully.");
    }

    public void handleAdminLogin() {
        String username = Util.readString("Enter admin username: ");
        String password = Util.readString("Enter admin password: ");

        if (username.equals(adminUsername) && password.equals(adminPassword)) {
            System.out.println("Admin login successfully.");
            show();
        } else {
            System.out.println(ErrorMessage.INVALID_ADMIN);
            Main.showMenu();
        }
    }

    public void show() {
        int item;
        do {
            System.out.println("***ADMIN MENU***");
            System.out.println("1.Add new account");
            System.out.println("2.Remove account");
            System.out.println("3.List all accounts");
            System.out.println("4.Back to main menu");
            item = Util.readInt("Choose an option: ");
        } while (item > 4 || item < 1);
        switch (item) {
            case 1 -> addAccount();
            case 2 -> removeAccount();
            case 3 -> listAllAccounts();
            case 4 -> {
                System.out.println("Back to main menu");
                Main.showMenu();
            }
            default -> System.out.println("Invalid option");
        }

    }

    public void addAccount() {
        int item = Util.readInt("Enter option: ");
        do {
            System.out.println("\n Choose an account type :");
            System.out.println("1. Short term");
            System.out.println("2. Long term");
            System.out.println("3.Gharzolhasane");
        } while (item < 1 || item > 3);

        Account newAccount = switch (item) {
            case 1 -> createShortTermAccount();
            case 2 -> createLongTermAccount();
            case 3 -> createGharzolhasaneAccount();
            default -> null;
        };

        if (newAccount != null) {
            DataStorage.accounts.add(newAccount);
            System.out.println("Account created");
        } else {
            System.out.println(ErrorMessage.INVALID_ACCOUNT_TYPE);
        }
    }

    public Account createShortTermAccount() {
        Person user = Util.readPersonInfo();

        String accountNumber;
        do {
            accountNumber = Util.readString("Enter account number(16 digit): ");
            if (!accountNumber.matches("\\d{16}")) {
                System.out.println(ErrorMessage.INVALID_ACCOUNT_NUMBER);
            }
        } while (!accountNumber.matches("\\d{16}"));

        String password = Util.readString("Password: ");
        double balance = Util.readDouble("Balance: ");
        double govShare = 0.1;
        return new ShortTermAccount(accountNumber, balance, password, govShare, user);
    }

    public Account createLongTermAccount() {
        Person user = Util.readPersonInfo();
        String accountNumber;
        do {
            accountNumber = Util.readString("Enter account number(16 digit): ");
            if (!accountNumber.matches("\\d{16}")) {
                System.out.println(ErrorMessage.INVALID_ACCOUNT_NUMBER);
            }
        } while (!accountNumber.matches("\\d{16}"));

        String password = Util.readString("Password: ");
        double balance = Util.readDouble("Balance: ");
        double govShare = 0.1;
        return new LongTermAccount(accountNumber, balance, password, govShare, user);
    }

    public Account createGharzolhasaneAccount() {
        Person user = Util.readPersonInfo();
        String accountNumber;
        do {
            accountNumber = Util.readString("Enter account number(16 digit): ");
            if (!accountNumber.matches("\\d{16}")) {
                System.out.println(ErrorMessage.INVALID_ACCOUNT_NUMBER);
            }
        } while (!accountNumber.matches("\\d{16}"));

        String password = Util.readString("Password: ");
        double balance = Util.readDouble("Balance: ");
        double govShare = 0.0;
        return new GharzolHasaneAccount(accountNumber, balance, password, govShare, user);
    }

    public void removeAccount() {
        String accountNumber = Util.readString("Enter account number you would like to remove: ").trim();
        Account accountToRemove = findAccountByNumber(accountNumber);

        if (accountToRemove != null) {
            DataStorage.accounts.remove(accountToRemove);
            System.out.println("Account" + accountNumber + " has been removed successfully");
        } else
            System.out.println("Account " + accountNumber + " does not exist");
    }

    public Account findAccountByNumber(String accountNumber) {
        for (Account account : DataStorage.accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void listAllAccounts() {
        if (DataStorage.accounts.isEmpty()) {
            System.out.println("No accounts available");
            return;
        }

        System.out.println("\n*** List of all accounts ***");
        for (Account account : DataStorage.accounts) {
            System.out.println("-------------------------");
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Balance: " + account.getBalance());
            System.out.println("Account Owner: " + account.user.firstName + " " + account.user.lastName);
            System.out.println("Account Type: " + account.getAccountType());
        }
        System.out.println("------------------------");
    }
}
