package model;

import enums.AccountType;
import exception.ErrorMessage;
import exception.InsufficientBalanceException;


public class ShortTermAccount extends Account {
    public ShortTermAccount(String accountNumber,
                            double balance,
                            String password, double governmentShare,
                            Person user) {
        super(accountNumber, balance, password, governmentShare, user);
    }

    @Override
    public void withdraw(double amount) {
        double deducted = amount * (1 - governmentShare);
        if (deducted > balance) {
            throw new InsufficientBalanceException(ErrorMessage.INSUFFICIENT);
        }
        balance -= deducted;
        System.out.println("withdrew $" + amount + "after government share $" + deducted);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.SHORTTERMACCOUNT;
    }
}
