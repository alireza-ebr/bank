package menu;

import data.DataStorage;
import exception.ErrorMessage;
import main.Main;
import model.Account;
import util.Util;

public class OwnerMenu {

    public void handleAccountOwnerLogin() {
        String accountNumber = Util.readString("Enter account number: ");
        String password = Util.readString("Enter password: ");

        Account foundAccount = findAccountByNumber(accountNumber);

        if (foundAccount != null && foundAccount.getPassword().equals(password)) {
            System.out.println("Account " + accountNumber + "has been loged in successfully.");
            showAccountOwnerMenu(foundAccount);
        } else {
            System.out.println(ErrorMessage.INVALID_PASSWORD_OR_ACCOUNT_NUMBER);
        }
    }

    private Account findAccountByNumber(String accountNumber) {
        for (Account account : DataStorage.accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
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
            case 2 -> depositFunc(account);
            case 3 -> withdrawFunc(account);
            case 4 -> {
                System.out.println("Back to main menu");
                Main.showMenu();
            }
            default -> System.out.println("Invalid option");
        }
    }

    public void depositFunc(Account account) {
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

