import java.util.ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminMenu {
    private Scanner scanner;
    private ArrayList<Account> accounts;
    private Util util;

    public AdminMenu(Scanner scanner, ArrayList<Account> accounts) {
        this.scanner = scanner;
        this.accounts = accounts;
        this.util = new Util(scanner);
    }

    public void show() {
        int item;
        do {
            System.out.println("***ADMIN MENU***");
            System.out.println("1.Add new account");
            System.out.println("2.Remove account");
            System.out.println("3.List all accounts");
            System.out.println("4.Back to main menu");
            item = util.readInt("Choose an option: ");

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
        } while (item != 4);
    }


    public void addAccount() {
        System.out.println("\n Choose an account type :");
        System.out.println("1. Short term");
        System.out.println("2. Long term");
        System.out.println("3.Gharzolhasane");

        int item = util.readInt("Enter option: ");

        Account newAccount = switch (item) {
            case 1 -> createShortTermAccount();
            case 2 -> createLongTermAccount();
            case 3 -> createGharzolhasaneAccount();
            default -> null;
        };

        if (newAccount != null) {
            accounts.add(newAccount);
            System.out.println("Account created");
        } else {
            System.out.println("Invalid account type");
        }
    }

    public Account createShortTermAccount() {
        Person user = util.readPersonInfo();

        String accountNumber;
        do {
            accountNumber = util.readString("Enter account number(16 digit): ");
            if (!accountNumber.matches("\\d{16}")){
                System.out.println("Invalid account number. It must be exactly 16 digits and contain only numbers.");
            }
        } while (!accountNumber.matches("\\d{16}"));

        String password = util.readString("Password: ");
        double balance = util.readDouble("Balance: ");
        double govShare = 0.1;
        return new ShortTermAccount(accountNumber, balance, password, govShare, user);
    }

    public Account createLongTermAccount() {
        Person user = util.readPersonInfo();
        String accountNumber;
        do {
            accountNumber = util.readString("Enter account number(16 digit): ");
            if (!accountNumber.matches("\\d{16}")) {
                System.out.println("Invalid account number. It must be exactly 16 digits.");
            }
        } while (!accountNumber.matches("\\d{16}"));

        String password = util.readString("Password: ");
        double balance = util.readDouble("Balance: ");
        double govShare = 0.1;
        return new LongTermAccount(accountNumber, balance, password, govShare, user);
    }

    public Account createGharzolhasaneAccount() {
        Person user = util.readPersonInfo();
        String accountNumber;
        do {
            accountNumber = util.readString("Enter account number(16 digit): ");
            if (!accountNumber.matches("\\d{16}")) {
                System.out.println("Invalid account number. It must be exactly 16 digits.");
            }
        } while (!accountNumber.matches("\\d{16}"));

        String password = util.readString("Password: ");
        double balance = util.readDouble("Balance: ");
        double govShare = 0.0;
        return new GharzolHasaneAccount(accountNumber, balance, password, govShare, user);
    }

    public void removeAccount() {
        String accountNumber = util.readString("Enter account number you would like to remove: ");
        Account accountToRemove = null;

        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                accountToRemove = account;
                break;
            }
        }
        if (accountToRemove != null) {
            accounts.remove(accountToRemove);
            System.out.println("Account" + accountNumber + " has been removed successfully");
        } else
            System.out.println("Account " + accountNumber + " does not exist");

    }

    public void listAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available");
            return;
        }

        System.out.println("\n*** List of all accounts ***");
        for (Account account : accounts) {
            System.out.println("-------------------------");
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Balance: " + account.getBalance());
            System.out.println("Account Owner: " + account.user.firstName + " " + account.user.lastName);
            System.out.println("Account Type: " + account.getAccountType());
        }
        System.out.println("------------------------");

    }


}
