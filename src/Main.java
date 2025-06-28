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
            case 1 -> {
                AdminMenu adminMenue = new AdminMenu(scanner, accounts);
                adminMenue.show();
            }
            case 2 -> {
                OwnerMenu ownerMenu = new OwnerMenu(scanner, accounts);
                ownerMenu.handleAccountOwnerLogin();
            }
            case 3 -> System.exit(0);
            default -> System.out.println("Invalid option");
        }
    }


}