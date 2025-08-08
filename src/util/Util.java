package util;

import model.Person;

import java.util.Scanner;

public class Util {
    private static final Scanner scanner = new Scanner(System.in);

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
        String firstName = readString("Enter first name: ");
        String lastName = readString("Enter last name: ");
        int birthYear = readInt("Enter birth year: ");
        String gender = readString("Enter gender: ");
        return new Person(firstName, lastName, birthYear, gender);
    }
}
