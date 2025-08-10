package model;

import enums.AccountType;
import exception.ErrorMessage;
import exception.InsufficientFounds;


public class ShortTermAccount extends Account {
    public ShortTermAccount(String accountNumber, double balance, String password, double governmentShare, Person user) {
        super(accountNumber, balance, password, governmentShare, user);
    }

    @Override
    public void withdraw(double amount) {
        double deducated = amount * (1 - governmentShare);
        if (deducated > balance) {
            throw new InsufficientFounds(ErrorMessage.INSUFFICIENT);
        }
        balance -= deducated;
        System.out.println("withdrew $" + amount + "after government share $" + deducated);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.SHORTTERMACCOUNT;
    }
}
