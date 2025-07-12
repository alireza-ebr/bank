import java.util.ArrayList;
import java.util.Scanner;

public class OwnerMenu {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Account> accounts;

    public OwnerMenu(Scanner scanner, ArrayList<Account> accounts) {
        this.accounts = accounts;
        this.scanner = scanner;
    }

    public void handleAccountOwnerLogin() {
        String accountNumber = Util.readString("Enter account number: ");
        String password = Util.readString("Enter password: ");
        Account foundAccount = null;
//TODO : add a method for search with account number
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
            System.out.println(ErrorMessage.INVALID_PASSWORD_OR_ACCOUNT_NUMBER);
    }

    public void showAccountOwnerMenu(Account account) {

        int item;
        do {
            System.out.println("\n****Account Owner Menu****");
            System.out.println("1.View Balance");
            System.out.println("2.Deposit");
            System.out.println("3.Withdraw");
            System.out.println("4.Back to main menu");

            item = Util.readInt("Choose an option: ");
        } while (item > 4 || item < 1);
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
    }

    public void DepositFunc(Account account) {
        double amount = Util.readDouble("Enter amount to deposit: ");
        account.setBalance(account.getBalance() + amount);
        System.out.println("Deposit successful. New balance is: " + account.getBalance());
    }

    public void withdrawFunc(Account account) {
        double amount = Util.readDouble("Enter amount to withdraw: ");
        if (amount <= account.getBalance()) {
            account.setBalance(account.getBalance() - amount);
            System.out.println("Withdraw successful. New balance is: " + account.getBalance());
        } else {
            System.out.println(ErrorMessage.INSUFFICIENT);
        }
    }
}

