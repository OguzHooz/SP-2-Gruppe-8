package sample;

import java.util.Scanner;

public class Systemadministrator {

    public static void createPerson() {
        Scanner input = new Scanner(System.in);
        String personName;
        String personInformation;

        System.out.print ("Enter name: ");
        personName = input.nextLine();

        System.out.print ("Enter person information: ");
        personInformation = input.nextLine();

        //Person object should be added to an array maybe?
        Person person = new Person (personName, personInformation);

        System.out.println();
        System.out.print ("The new person has successfully been added." + "\n");
    }

    public static void main(String[] args) {
        createPerson();
        createPerson();
    }
}
