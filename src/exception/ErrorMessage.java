package exception;

public interface ErrorMessage {
    String INVALID_PASSWORD_OR_ACCOUNT_NUMBER = "Invalid account number or password";
    String INVALID_ACCOUNT_TYPE = "Invalid account type";
    String INVALID_ACCOUNT_NUMBER = "Invalid account number.It must be exactly 16 digits and " +
            "contain only numbers";
    String DAILY_LIMIT = "Withdrawal failed : amount exeed daily limit of $";
    String INSUFFICIENT = "Withdrawal failed : insufficient founds";
    String INVALID_ADMIN = "Invalid admin credentials";
    String INVALID_BALANCE = "Invalid balance";
    String INVALID_USER = "Invalid user";
    String DEPOSIT_FAILED = "Deposit not allowed for Gharzolhasane account";
    String WITHDRAWAL_FAILED = "Withdraw not allowed for Gharzolhasane account";
    String LOGIN_FAILED = "Login not successful";
    String INVALIED_OPTION = "Invalid operation";
    String AMOUNT_POSITIVE = "Amount must be positive";
    String INSUFFICENT_BALANCE = "Insufficient balance";
}
