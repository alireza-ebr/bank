package data;

import com.sun.source.tree.BreakTree;
import model.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountStore {
    public static final List<Account> accounts = new ArrayList<>();

    public static void addAccount(Account account) {
        accounts.add(account);
    }

    public static boolean removeAccount(String accountNumber) {
        Account account = findAccountByNumber(accountNumber);
        if (account != null) {
            accounts.remove(account);
            return true;
        }
        return false;
    }

    public static Account findAccountByNumber(String accountNumber) {
        for (Account account : AccountStore.accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
    public static List<Account> getAccounts() {
      return new ArrayList<>(accounts);
    }

    public static boolean isEmpty() {
        return accounts.isEmpty();
    }
}
