package sample;

import java.util.concurrent.atomic.AtomicInteger;

public class Person {

    public static AtomicInteger getCount() {
        return count;
    }

    private int personID;
    private String personName;
    private String personInformation;
    private static final AtomicInteger count = new AtomicInteger(0);

    // Default constructor to initialize default instance variables
    public Person() {
        personID = 0;
        personName = " ";
        personInformation = " ";
    }
    public Person (String personName, String personInformation) {
    // Initialize instance variables
        generatePersonID();
        this.personName = personName;
        this.personInformation = personInformation;

        //to test that the output is correct
        System.out.println("Name: " + personName);
        System.out.println("Information: " + personInformation);
        System.out.println("ID: " + personID);
    }
    public void generatePersonID() {
        personID = count.incrementAndGet();
    }
    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonInformation() {
        return personInformation;
    }

    public void setPersonInformation(String personInformation) {
        this.personInformation = personInformation;
    }
}
