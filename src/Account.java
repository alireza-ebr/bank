public abstract class Account {
    protected String accountNumber;
    protected double balance;
    protected String password;
    protected final double governmentShare;
    protected Person user;

    public Account(String accountNumber, double balance, String password, double governmentShare, Person user) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.password = password;
        this.governmentShare = governmentShare;
        this.user = user;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        double deducted = amount * (1 - governmentShare);
        balance -= deducted;
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
}
