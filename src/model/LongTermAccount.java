
package model;

import enums.AccountType;
import exception.*;
import exception.LimitExceededException;

public class LongTermAccount extends Account {
    private final double monthlyInterestRate = 0.10;
    private final double dailyWithdrawalLimit = 100;

    public LongTermAccount(String accountNumber, double balance, String password, double governmentShare, Person user) throws InvalidAccountException {
        super(accountNumber, balance, password, governmentShare, user);
    }

    @Override
    public void withdraw(double amount) throws WithdrawalException {
        super.withdraw(amount);
        if (amount > dailyWithdrawalLimit) {
            throw new LimitExceededException(ErrorMessage.DAILY_LIMIT);
        }
        double deducted=applyGovernmentShare(amount);
        if (deducted>getBalance()) {
            throw new InsufficientBalanceException(ErrorMessage.INSUFFICIENT);
        }
        setBalance(getBalance()-deducted);
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