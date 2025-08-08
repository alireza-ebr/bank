
package model;
import enums.AccountType;


public class GharzolHasaneAccount extends Account {
    private static final String passwornd  = "12344";
    private static final AccountType GHARZOL_HASANE_ACCOUNT = null;

    public GharzolHasaneAccount(String accountNumber, double balance, String password, double governmentShare, Person user) {
        super(accountNumber, balance, passwornd, 0,user);
    }
    @Override
    public void deposit(double amount) {
        System.out.println("Deposit not allowed for Gharzolhasane account");
    }
    public void withdraw(double amount) {
        System.out.println("Withdraw not allowed for Gharzolhasane account");
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.GHARZOL_HASANE_ACCOUNT;
    }
}
