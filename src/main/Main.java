package main;

import menu.AdminMenu;
import menu.OwnerMenu;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu(scanner);
        }
    }

    public static void showMenu(Scanner scanner) {
        System.out.println("*** MAIN MENU ***");
        int item = 0;

        do {
            System.out.println("1. Login as admin");
            System.out.println("2. Login as account owner");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            if (scanner.hasNextInt()) {
                item = scanner.nextInt();
            } else {
                System.out.println("Invalid option.Please enter a number between 1 and 3");
                scanner.next();
            }
        } while (item < 1 || item > 3);

        switch (item) {
            case 1 -> {
                new AdminMenu(scanner);
            }
            case 2 -> {
                new OwnerMenu(scanner);
            }
            case 3 -> System.exit(0);
            default -> System.out.println("Invalid option");

        }
    }
}