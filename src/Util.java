import java.util.Scanner;

public class Util {
    private Scanner scanner;

    public Util(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public int readInt(String message) {
        System.out.println(message);
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    public double readDouble(String message) {
        System.out.println(message);
        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;
    }

    public Person readPersonInfo() {
        String fiestName = readString("Enter first name: ");
        String lastName = readString("Enter last name: ");
        int birthYear = readInt("Enter birth year: ");
        String gender = readString("Enter gender: ");
        return new Person(fiestName, lastName, birthYear, gender);
    }

}
