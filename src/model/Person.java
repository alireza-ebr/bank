package model;

public class Person {
    public String firstName;
    public String lastName;
    protected int birthYear;
    protected String gender;

    public Person(String name, String lastName, int birthYear, String gender) {
        this.firstName = name;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.gender = gender;
    }

    public Person(String name, String lastName, int birthYear, String gender, boolean printInfo) {
        this(name, lastName, birthYear, gender);
        if (printInfo) {
            System.out.println("Name :" + firstName + " " + lastName);
            System.out.println("Birth Year :" + birthYear);
            System.out.println("Gender :" + gender);
        }
    }

    public void printInfo() {
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Birth Year: " + birthYear);
        System.out.println("Gender: " + gender);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person)) return false;
        Person other = (Person) obj;
        return firstName.equals(other.firstName) && lastName.equals(other.lastName);
    }
}