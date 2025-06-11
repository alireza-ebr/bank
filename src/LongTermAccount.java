public class LongTermAccount extends Account {
    private final double monthlyInterestRate = 0.10;
    private final double dailyWithdrawalLimit = 100;

    public LongTermAccount(String accountNumber, double balance, String password, double governmentShare, Person user) {
        super(accountNumber, balance, password, governmentShare, user);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > dailyWithdrawalLimit) {
            System.out.println("Withdrawal failed : amount exceeds daily limit of $" + dailyWithdrawalLimit);
            return;
        }
        double deducted = amount * (1 - governmentShare);
        if (deducted > balance) {
            System.out.println("Withdrawal failed : insufficient founds.");
            return;
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