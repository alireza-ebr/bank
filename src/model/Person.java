package model;

import java.util.Objects;

public class Person {
    private String firstName;
    private String lastName;
    private int birthYear;
    private String gender;

    public Person(String name, String lastName, int birthYear, String gender) {
        this.firstName = name;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void printInfo() {
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Birth Year: " + birthYear);
        System.out.println("Gender: " + gender);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + birthYear + ",  " + gender + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false; // null یا کلاس متفاوت
        Person other = (Person) obj;
        return birthYear == other.birthYear &&
                Objects.equals(firstName, other.firstName) &&
                Objects.equals(lastName, other.lastName) &&
                Objects.equals(gender, other.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthYear, gender);
    }
}