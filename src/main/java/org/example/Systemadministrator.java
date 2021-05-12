package org.example;

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

        Person person = new Person (personName, personInformation);

        System.out.println();
        System.out.print ("The new person has successfully been added." + "\n");

        System1.listOfPersons.add(person);
    }

    public void removePerson() {
        //We start by importing the scanner
        Scanner myObj = new Scanner(System.in);

        System.out.println("Du kan fjerne følgende personer: ");

        //Here we create a list with listofPersons, which contains a personID, personName and personInformation
        for (int i = 0; i < System1.listOfPersons.size(); i++){
            int personID = System1.listOfPersons.get(i).getPersonID();
            String personName = System1.listOfPersons.get(i).getPersonName();
            String personInformation = System1.listOfPersons.get(i).getPersonInformation();

            System.out.println("ID: " + personID + "  " + personName + " (" + personInformation + ") ");
        }

        System.out.println("Indtast ID på den person du vil fjerne  ");
        int idRemover = myObj.nextInt(); //This should be a textfield/button on the GUI

        for (int i = 0; i < System1.listOfPersons.size(); i++){ //This forloop is for looking for the different person ID's
            if (idRemover == System1.listOfPersons.get(i).getPersonID()){
                System.out.println(System1.listOfPersons.get(i).getPersonName() + " (Fjernet)");
                System1.listOfPersons.remove(i);
            }
            else {
                continue;
            }
        }
    }
    public User addUser() {
        Scanner myObj = new Scanner(System.in);

        System.out.println("Indtast bruger ID: ");
        String userID = myObj.nextLine(); //This should be a textfield on the GUI

        User test = new User(0);

        User u = new User(test.generateUserID());

        System1.listOfUsers.add(u);

        return u;
    }

    /* public void givePersonRole(){
        Scanner myObj = new Scanner(System.in);

        //For loop for showing the list of people
        System.out.println("Liste over personer i systemet ");
        for (int i = 0; i < System1.listOfPersons.size(); i++){
            int personID = System1.listOfPersons.get(i).getPersonID();
            String personName = System1.listOfPersons.get(i).getPersonName();
            String personInformation = System1.listOfPersons.get(i).getPersonInformation();

            System.out.println("ID: " + personID + "  " + personName + "  " + personInformation);
        }


        System.out.println("Indtast ID på den person der skal have rolle ");
        int personID = myObj.nextInt(); //The person getting a role

        for (int i = 0; i < System1.listOfPersons.size(); i++){
            if (personID == System1.listOfPersons.get(i).getPersonID()){
                Person gettingARole = System1.listOfPersons.get(i);

                System.out.println("Indtast hvilken rolle de skal have ");
                String role = myObj.next(); //The person getting a role

                Credit.personWithRole.put(System1.listOfPersons.get(i), role);
                System.out.println("ID: " + gettingARole.getPersonID() + "  " + gettingARole.getPersonName() + "  " + gettingARole.getPersonInformation() + " er har fået rollen " + role);

            }
            else {
                continue;
            }
        }
    }


     */
}
