package exception;

public interface ErrorMessage {
    String INVALID_PASSWORD_OR_ACCOUNT_NUMBER = "Invalid account number or password";
    String INVALID_ACCOUNT_TYPE = "Invalid account type";
    String INVALID_ACCOUNT_NUMBER = "Invalid account number.It must be exactly 16 digits and " +
            "contain only numbers";
    String DAILY_LIMIT = "Withdrawal failed : amount exeed daily limit of $";
    String INSUFFICIENT = "Withdrawal failed : insufficient founds";
    String INVALID_ADMIN = "Invalid admin credentials";
}
