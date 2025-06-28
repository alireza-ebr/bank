import java.util.ArrayList;
import java.util.Scanner;

public class OwnerMenu {
    private Scanner scanner = new Scanner(System.in);
    private Util util = new Util(scanner);
    private ArrayList<Account> accounts;

    public OwnerMenu(Scanner scanner, ArrayList<Account> accounts) {
        this.accounts = accounts;
        this.scanner = scanner;
        this.util = new Util(scanner);
    }

    public void handleAccountOwnerLogin() {
        String accountNumber = util.readString("Enter account number: ");
        String password = util.readString("Enter password: ");
        Account foundAccount = null;

        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber) && account.getPassword().equals(password)) {
                foundAccount = account;
                break;
            }
        }
        if (foundAccount != null) {
            System.out.println("Account " + accountNumber + " has been logged in successfully");
            showAccountOwnerMenu(foundAccount);
        } else
            System.out.println("Invalid account number or password");
    }

    public void showAccountOwnerMenu(Account account) {

        int item;
        do {
            System.out.println("\n****Account Owner Menu****");
            System.out.println("1.View Balance");
            System.out.println("2.Deposit");
            System.out.println("3.Withdraw");
            System.out.println("4.Back to main menu");

            item = util.readInt("Choose an option: ");

            switch (item) {
                case 1 -> System.out.println("Your balance is : " + account.getBalance());
                case 2 -> DepositFunc(account);
                case 3 -> withdrawFunc(account);
                case 4 -> {
                    System.out.println("Back to main menu");
                    Main.showMenu();
                }
                default -> System.out.println("Invalid option");
            }
        } while (item != 4);
    }

    public void DepositFunc(Account account) {
        double amount = util.readDouble("Enter amount to deposit: ");
        account.setBalance(account.getBalance() + amount);
        System.out.println("Deposit successful. New balance is: " + account.getBalance());

    }

    public void withdrawFunc(Account account) {
        double amount = util.readDouble("Enter amount to withdraw: ");
        if (amount <= account.getBalance()) {
            account.setBalance(account.getBalance() - amount);
            System.out.println("Withdraw successful. New balance is: " + account.getBalance());
        } else {
            System.out.println("Insufficient balance");
        }
    }
}

