import java.util.ArrayList;

public class Owner extends Person {

    private ArrayList<Account> accounts;

    public Owner(String firstName, String lastName, int birthYear, String email) {
        super(firstName, lastName, birthYear, email);
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void listAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("You have no accounts.");
            return;
        }

        for (Account acc : accounts) {
            System.out.println("Account Number: " + acc.getAccountNumber());
            System.out.println("Balance: " + acc.getBalance());
            System.out.println("Account Type: " + acc.getAccountType());
            System.out.println("------------------------");
        }
    }

}
