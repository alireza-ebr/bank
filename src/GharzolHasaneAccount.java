public class GharzolHasaneAccount extends Account {
    public GharzolHasaneAccount(String accountNumber, double balance, String passwornd,double governmentShare,Person user) {
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
        return AccountType.GHARZOLHASANE;
    }
}
