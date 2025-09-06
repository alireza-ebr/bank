package model;

import enums.AccountType;
import exception.ErrorMessage;
import exception.InsufficientBalanceException;
import exception.InvalidAccountException;
import exception.WithdrawalException;


public class ShortTermAccount extends Account {
    public ShortTermAccount(String accountNumber,
                            double balance,
                            String password, double governmentShare,
                            Person user) throws InvalidAccountException {
        super(accountNumber, balance, password, governmentShare, user);
    }

    @Override
    public void withdraw(double amount) throws WithdrawalException {
        super.withdraw(amount);
        double deducted=applyGovernmentShare(amount);
        if (deducted>getBalance()){
            throw new InsufficientBalanceException(ErrorMessage.INSUFFICIENT);
        }
        System.out.println("withdrew $" + amount + "after government share $" + deducted);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.SHORTTERMACCOUNT;
    }
}
