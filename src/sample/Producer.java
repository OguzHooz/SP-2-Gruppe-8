package sample;

import java.util.*;

public class Producer {

    public void givePersonRole(){
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
    


    public Program  addProgram(){
        //We start by importing the scanner
        Scanner myObj = new Scanner(System.in);

        //Start by asking for the movie title
        System.out.println("Indtast navnet på din film ");
        String title = myObj.nextLine(); //This should be a textfield on the GUI

        //Ask for the release date
        System.out.println("Indtast navnet på din udgivelsesdato på din film ");
        String releaseD = myObj.nextLine(); //This should be a textfield on the GUI
        Program test = new Program(0, null, null);


        //Program ID

        //Here we create the new program
        Program p = new Program (test.generateProgramID(), title, releaseD);

        System.out.println("Nu er filmen blevet tilføjet ");


        System.out.println("Filmen " + title+ " har ID " + test.getProgramID());


        //Here we add the newly created program to the array
        System1.listOfPrograms.add(p);

        return p;
    }

    public void removeProgram(){
        //We start by importing the scanner
        Scanner myObj = new Scanner(System.in);

        System.out.println("Du kan fjerne følgende programmer: ");

        //Here we create a list with listOfPrograms, which contains a ProgramID, ProgramTitle and ProgramRelease
        for (int i = 0; i < System1.listOfPrograms.size(); i++){
            int programID = System1.listOfPrograms.get(i).getProgramID();
            String programTitle = System1.listOfPrograms.get(i).getTitle();
            String programReleaseD = System1.listOfPrograms.get(i).getReleaseDate();

            System.out.println("ID: " + programID + "  " + programTitle + " (" + programReleaseD + ") ");
        }

        System.out.println("Indtast ID på det program du vil fjerne  ");
        int idRemover = myObj.nextInt(); //This should be a textfield/button on the GUI

        for (int i = 0; i < System1.listOfPrograms.size(); i++){ //This forloop is for looking for the different programs ID's
            if (idRemover == System1.listOfPrograms.get(i).getProgramID()){
                System1.listOfPrograms.remove(i);
            }
            else {
                continue;
            }
        }

    }
}
