
package model;

import enums.AccountType;
import exception.ErrorMessage;
import exception.InvalidAccountException;
import exception.LimitExceededException;
import exception.LimitExceededException;

public class LongTermAccount extends Account {
    private final double monthlyInterestRate = 0.10;
    private final double dailyWithdrawalLimit = 100;

    public LongTermAccount(String accountNumber, double balance, String password, double governmentShare, Person user) throws InvalidAccountException {
        super(accountNumber, balance, password, governmentShare, user);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > dailyWithdrawalLimit) {
            throw new LimitExceededException("Withdrawal failed : Daily limit");
        }
        double deducted = amount * (1 - governmentShare);
        if (deducted > balance) {
            throw new LimitExceededException(ErrorMessage.INSUFFICIENT);
        }
        balance -= deducted;
        System.out.println("Withdrew $" + amount + "after government share : $" + deducted + ")");
    }

    public void applyMonthlyInterestRate() {
        double interest = balance * monthlyInterestRate;
        System.out.println("Monthly interest of $" + interest + "added. New balance : $" + balance);
        balance += interest;
        System.out.println("Monthly interest of $" + interest + "added. New balance : $" + balance);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.LONGTERMACCOUNT;
    }
}