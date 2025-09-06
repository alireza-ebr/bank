package model;

import enums.AccountType;
import exception.ErrorMessage;
import exception.InsufficientBalanceException;
import exception.InvalidAccountException;
import exception.WithdrawalException;

public abstract class Account {
    protected final double governmentShare;
    protected String accountNumber;
    protected double balance;
    protected String password;
    private Person user;

    public Account(String accountNumber, double balance, String password, double governmentShare, Person user) throws InvalidAccountException {
        if (accountNumber == null || !accountNumber.matches(("\\d{16}"))) {
            throw new InvalidAccountException(ErrorMessage.INVALID_ACCOUNT_NUMBER);
        }
        if (password == null || password.isEmpty()) {
            throw new InvalidAccountException(ErrorMessage.INVALID_PASSWORD_OR_ACCOUNT_NUMBER);
        }
        if (user == null) {
            throw new InvalidAccountException(ErrorMessage.INVALID_USER);
        }
        if (balance < 0) {
            throw new InvalidAccountException(ErrorMessage.INVALID_BALANCE);
        }
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.password = password;
        this.governmentShare = governmentShare;
        this.user = user;
    }

    protected Account(double governmentShare) {
        this.governmentShare = governmentShare;
    }

    public String getPassword() {
        return password;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.AMOUNT_POSITIVE);
        }
        balance += amount;
    }

    public void withdraw(double amount) throws WithdrawalException {
        if (amount <= 0) {
            throw new WithdrawalException(ErrorMessage.AMOUNT_POSITIVE);
        }
        if (amount > balance) {
            throw new InsufficientBalanceException(ErrorMessage.INSUFFICENT_BALANCE);
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber.substring(0, 4) + "-" +
                accountNumber.substring(4, 8) + "-" +
                accountNumber.substring(8, 12) + "-" +
                accountNumber.substring(12, 16);
    }

    public void printInfo() {
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Balance: " + balance);
        System.out.println("Government Share: " + governmentShare * 100 + "%");
    }

    public abstract AccountType getAccountType();

    public Person getUser() {
        return user;
    }

    public void setUser(Person user) {
        this.user = user;
    }
    protected double applyGovernmentShare(double amount) {
        return amount*(1-governmentShare);
    }
}
