package org.example;

import java.sql.*;
import java.util.*;

public class Producer {

    static Connection connection = null;


    public void createCredit() {
        //Connect to database
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/SemesterProjektDatabase",
                    "postgres",
                    "hudmanbat3103");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String name = " ";
        //For loop for showing the list of people


        //We start by importing the scanner
        Scanner myObj = new Scanner(System.in);
        Scanner myString = new Scanner(System.in);

        //Start by asking for the persons ID
        System.out.println("Indtast ID på person som du vil give role ");
        int personID = myObj.nextInt(); //This should be a textfield on the GUI

        System.out.println("Indtast rollen som personen skal have ");
        String role = myString.nextLine(); //This should be a textfield on the GUI


        //This loop checks if the person exists in the system, if they do they get a role and gets added to the system.
        for (int i = 0; i < System1.listOfPersons.size(); i++) {
            Person person = System1.listOfPersons.get(i);
            int p_id = System1.listOfPersons.get(i).getPersonID();
            String personName = System1.listOfPersons.get(i).getPersonName();
            String personInformation = System1.listOfPersons.get(i).getPersonInformation();

            if (personID == p_id){
                Credit credit = new Credit(person, role, personID,personName);
                System1.listOfCredit.add(credit);
                System.out.println("The Person " + personName + " has been added with the role of " + role);

                try {
                    PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO credit (role, personid_fk) VALUES (?, ?)");
                    insertStatement.setString(1, role);
                    insertStatement.setInt(2, personID);
                    insertStatement.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
            else {
                System.out.println(" ");
            }
        }

    }


    public void addCreditToProgram(){
        //Connect to database
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/SemesterProjektDatabase",
                    "postgres",
                    "hudmanbat3103");
        } catch (SQLException e) {
            e.printStackTrace();
        }



        //We ask for the ProgramID and the CreditID
        Scanner programIDScan = new Scanner(System.in);
        Scanner creditIDScan = new Scanner(System.in);

        System.out.println("Please the program id that you wish to add credits to ");
        int programID = programIDScan.nextInt(); //Input the id nr

        System.out.println("Please the credit id that you wish to add credits to ");
        int creditID = creditIDScan.nextInt(); //The credit ID


        //Here we add the Credit to the chosen Program into the database

        try {
            PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO credit_to_program ( program_id_fk, credit_id__fk) VALUES (?,?)");
            insertStatement.setInt(1, programID);
            insertStatement.setInt(2, creditID);
            insertStatement.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean removeCreditFromProgram(){
        //Connect to database
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/SemesterProjektDatabase",
                    "postgres",
                    "hudmanbat3103");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //We start by importing our scanner so we can get the input of which credit should be removed

        Scanner creditRemove = new Scanner(System.in);

        System.out.println("Indtast det credit ID du vil fjerne");
        int creditID = creditRemove.nextInt(); //Here we get the ID that will get removed

        try {
            PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM credit_to_program WHERE credit_id__fk = ?");
            deleteStatement.setInt(1,creditID);
            return deleteStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }



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

    public boolean removeProgram() {

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


        try {

            PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM  program WHERE program_id = ?");
            deleteStatement.setInt(1,idRemover);
            return deleteStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }






    }
}
