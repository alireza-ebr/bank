
package model;
import enums.AccountType;
import exception.DepositException;
import exception.ErrorMessage;
import exception.WithdrawException;


public class GharzolHasaneAccount extends Account {
    private static final String passwornd  = "12344";
    private static final AccountType GHARZOL_HASANE_ACCOUNT = null;

    public GharzolHasaneAccount(String accountNumber, double balance, String password, double governmentShare, Person user) {
        super(accountNumber, balance, passwornd, 0,user);
    }
    @Override
    public void deposit(double amount) {
        throw new DepositException(ErrorMessage.DEPOSIT_FAILED);
    }
    public void withdraw(double amount) {
        throw new WithdrawException(ErrorMessage.WITHDRAWAL_FAILED);
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.GHARZOL_HASANE_ACCOUNT;
    }
}
