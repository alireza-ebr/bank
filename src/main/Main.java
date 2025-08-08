package main;

import menu.AdminMenu;
import menu.OwnerMenu;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner scanner = new Scanner(System.in);

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
                AdminMenu adminMenu = new AdminMenu(scanner);
                adminMenu.handleAdminLogin();
            }
            case 2 -> {
                OwnerMenu ownerMenu = new OwnerMenu();
                ownerMenu.handleAccountOwnerLogin();
            }
            case 3 -> System.exit(0);
            default -> System.out.println("Invalid option");
        }
    }
}