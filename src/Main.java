import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Account> accounts = new ArrayList<>();
    static Admin admin = new Admin("Ali", "Ahmadi", 1988, "mail", "admin", "admin1234");

    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu() {
        System.out.println("*** MAIN MENU ***");
        int item;
        do {
            System.out.println("1. Login as admin");
            System.out.println("2. Login as account owner");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            item = scanner.nextInt();
        } while (item < 1 || item > 3);

        switch (item) {
            case 1 -> HandleAdminLogin();
            case 2 -> System.out.println("Account owner");
            case 3 -> System.exit(0);
            default -> System.out.println("Invalid option");
        }
    }

    public static void HandleAdminLogin() {
        System.out.println("Enter admin username: ");
        String username = scanner.nextLine();
        System.out.println("Enter admin password: ");
        String password = scanner.nextLine();

        if (admin.login(username, password)) {
            System.out.println("Successfully logged in");
            showAdminMenu();
        } else {
            System.out.println("Invalid username or password");
        }
    }

    public static void showAdminMenu() {
        System.out.println("*** ADMIN MENU ***");
        int item;
        do {
            System.out.println("***ADMIN MENU***");
            System.out.println("1.Add new account");
            System.out.println("2.Remove account");
            System.out.println("3.List all accounts");
            System.out.println("4.Back to main menu");
            item = scanner.nextInt();
            scanner.nextLine();
        } while (item < 1 || item > 4);

        switch (item) {
            case 1 -> addAccount();
            case 2 -> System.out.println("Remove account");
            case 3 -> System.out.println("List all accounts");
            case 4 -> System.out.println("Back to main menu");
            default -> System.out.println("Invalid option");
        }
    }

    public static void addAccount() {
        System.out.println("\n Choose an account type :");
        System.out.println("1. Short term");
        System.out.println("2. Long term");
        System.out.println("3.Gharzolhasane");

        int item = scanner.nextInt();
        scanner.nextLine();

        Account newAccount = switch (item) {
            case 1 -> creatLongTermAccount();
            case 2 -> createShortTermAccount();
            case 3 -> createGharzolhasaneAccount();
            default -> null;
        };

        if (newAccount != null) {
            accounts.add(newAccount);
            System.out.println("Account created");
        } else {
            System.out.println("Invalid account type");
        }
    }
    public static Account createShortTermAccount() {
        Person user = readPersonInfo();
        String accountNumber = readString("Account number (16 digits): ");
        String password = readString("Password: ");
        double balance = readDouble("Balance: ");
        double govShare = 0.1;
        return new ShortTermAccount(accountNumber ,balance ,password ,govShare ,user);
    }
    public static Account creatLongTermAccount() {
        Person user = readPersonInfo();
        String accountNumber = readString("Account number (16 digits): ");
        String password = readString("Password: ");
        double balance = readDouble("Balance: ");
        double govShare = 0.1;
        return new LongTermAccount(accountNumber ,balance ,password ,govShare ,user);
    }
    public static Account createGharzolhasaneAccount() {
        Person user = readPersonInfo();
        String accountNumber = readString("Account number (16 digits): ");
        String password = readString("Password: ");
        double balance = readDouble("Balance: ");
        double govShare = 0.0;
        return new GharzolHasaneAccount(accountNumber ,balance ,password ,govShare ,user);
    }

    public static String readString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public static int readInt(String message) {
        System.out.println(message);
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    public static double readDouble(String message) {
        System.out.println(message);
        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;
    }

    public static Person readPersonInfo() {
        String fiestName = readString("Enter first name: ");
        String lastName = readString("Enter last name: ");
        int birthYear = readInt("Enter birth year: ");
        String gender = readString("Enter gender: ");
        return new Person(fiestName, lastName, birthYear, gender);
    }
}


