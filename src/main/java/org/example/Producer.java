package org.example;

import java.sql.*;
import java.util.*;

public class Producer {

    static Connection connection = null;


    public void createCredit() {



        String name = " ";
//For loop for showing the list of people
        System.out.println("Liste over personer i systemet ");
        for (int i = 0; i < System1.listOfPersons.size(); i++) {
            int personID = System1.listOfPersons.get(i).getPersonID();
            String personName = System1.listOfPersons.get(i).getPersonName();
            String personInformation = System1.listOfPersons.get(i).getPersonInformation();

            System.out.println("ID: " + personID + "  " + personName + "  " + personInformation);
        }

        //We start by importing the scanner
        Scanner myObj = new Scanner(System.in);
        Scanner myString = new Scanner(System.in);

        //Start by asking for the persons ID
        System.out.println("Indtast ID på person som du vil give role ");
        int personID = myObj.nextInt(); //This should be a textfield on the GUI


        //enter persons role
        System.out.println("Indtast personens rolle ");
        String role = myString.nextLine(); //This should be a textfield on the GUI
// this i where we asign the role
        for (int i =0; i<System1.listOfPersons.size();i++){
            if (personID == System1.listOfPersons.get(i).getPersonID()) {
                Person person = System1.listOfPersons.get(i);
                int p_ID = person.getPersonID();
                String p_name = person.getPersonName();

                Credit personCredit = new Credit(person,role, p_ID, p_name);
                System1.listOfCredit.add(personCredit);
                name = p_name;
            }
            else {
                System.out.println(" ");
            }
        }
//For loop for showing the list of Credit
        System.out.println("Liste over Credits i systemet ");
        for (int i = 0; i < System1.listOfCredit.size(); i++) {

            String personRole = System1.listOfCredit.get(i).getPersonRole();
            String personName = System1.listOfCredit.get(i).getpName();
            int pID = System1.listOfCredit.get(i).getpID();

            //Little text so it looks nice (and to confirm that a credit has been added to the system)
            System.out.println( "----"+ "Person ID: " + pID + " Name:  " + personName +  " Role:   " + personRole + "----");
            System.out.println("-------------------------------------");
        }
        System.out.println(" Personen  " +  name  + " har fået rollen " + role);

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


    public Program addProgram() {
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
        Program p = new Program(test.generateProgramID(), title, releaseD);

        System.out.println("Nu er filmen blevet tilføjet ");

        System.out.println("Filmen " + title + " har ID " + test.getProgramID());

        //Here we add the newly created program to the array
        System1.listOfPrograms.add(p);

        //Adding the program to the database

        //Create database
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/SemesterProjektDatabase",
                    "postgres",
                    "hudmanbat3103");
        } catch (SQLException e) {
            e.printStackTrace();
        }



        try {
            PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO program (title, release_date) VALUES (?,?)");
            insertStatement.setString(1, title);
            insertStatement.setString(2, releaseD);
            insertStatement.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return p;
    }


    Statement statement = null;

    public void removeProgram() {

        //Connection database
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/SemesterProjektDatabase",
                    "postgres",
                    "hudmanbat3103");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM program");

            while (resultSet.next() ){
                int programID = resultSet.getInt("program_id");
                String programTitle = resultSet.getString("title");
                String programReleaseDate = resultSet.getString("release_date");

                System.out.println("Movie ID: " + programID + ". Title: " + programTitle + ". Release date: " + programReleaseDate);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }



        //We start by importing the scanner
        Scanner myObj = new Scanner(System.in);

        System.out.println("Du kan fjerne følgende programmer: ");


        System.out.println("Indtast ID på det program du vil fjerne  ");
        int idRemover = myObj.nextInt(); //This should be a textfield/button on the GUI

        for (int i = 0; i < System1.listOfPrograms.size(); i++) { //This forloop is for looking for the different programs ID's
            if (idRemover == System1.listOfPrograms.get(i).getProgramID()) {
                System1.listOfPrograms.remove(i);
            } else {
                continue;
            }
        }




    }
}
