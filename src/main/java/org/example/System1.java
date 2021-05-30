package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class System1 {


    static ArrayList<Person> listOfPersons = new ArrayList<Person>(); //Its a linkedList so its sorted by the last thing that got added
    static ArrayList<User> listOfUsers = new ArrayList<User>();
    static ArrayList<Program> listOfPrograms = new ArrayList<Program>();
    static ArrayList<Credit> listOfCredit = new ArrayList<Credit>();
    static ArrayList<String> tableViewArray = new ArrayList<String>();
    static ArrayList<String> creditInProgramArray = new ArrayList<String>();

    static Connection connection = null;
    ArrayList<Credit> tempArraylist = new ArrayList<Credit>(); //it gets used in the load credits method
    Statement statement = null;

    public void loadCreditInProgram(){
        for (int i = 0; i < listOfPrograms.size(); i++){
            Program program = listOfPrograms.get(i);
            int programID = program.getProgramID();

            for (int j = 0; j < program.creditsInProgram.size(); j++){
                Credit credit = program.creditsInProgram.get(j);
                String name = credit.getpName();
                int creditID = credit.getCreditID();
                String role = credit.getPersonRole();

                String completeCredit = (creditID + " Name " + name + " as " + role);
                program.creditInProgramArray.add(completeCredit);
                //creditInProgramArray.add(completeCredit);

            }



        }
    }


    public void insertProgramTitle(){

        for (int i = 0; i < System1.listOfPrograms.size(); i++){
            Program program = System1.listOfPrograms.get(i);

            String program_name = program.getTitle();
            String program_id = Integer.toString(program.getProgramID());
            String program_releaseDate = program.getReleaseDate();

            String completeTitle = "ID " + program_id + ": " + program_name + " " + program_releaseDate;
            tableViewArray.add(completeTitle);

        }

    }


    public void loadPersonFromDatabase(){
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

        //Here we add the programs in the database to the ListOfPrograms list:
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM persondata");

            while (resultSet.next() ){
                int personID = resultSet.getInt("person_id");
                String personName = resultSet.getString("person_name");
                String personInformation = resultSet.getString("information");

                Person person = new Person(personID, personName,personInformation);
                listOfPersons.add(person);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public void loadCreditsFromDatabase(){

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


        //Here we add the programs in the database to the ListOfPrograms list:
        try {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM credit");
            statement = connection.createStatement();

            while (resultSet.next() ){
                //Here we gather information for the credit objects
                int creditID = resultSet.getInt("creditid");
                String role = resultSet.getString("role");
                int personID = resultSet.getInt("personid_fk");


                Credit credit = new Credit(role, personID, creditID);

                tempArraylist.add(credit);
            }




            for (int j = 0; j < tempArraylist.size(); j++){
                Credit credit = tempArraylist.get(j);
                int creditID = credit.getCreditID();
                int personID = credit.getpID();
                String roleID = credit.getPersonRole();

                for (int i = 0; i < System1.listOfPersons.size(); i++ ){

                    Person tempPerson = System1.listOfPersons.get(i);
                    String p_Role = credit.getPersonRole();
                    int p_ID = tempPerson.getPersonID();
                    String p_name =  tempPerson.getPersonName();


                    if (personID == p_ID && p_Role == roleID){
                        Credit c = new Credit(tempPerson, p_Role, p_ID, p_name);
                        c.setCreditID(creditID);
                        System1.listOfCredit.add(c);
                    }

                    else{
                        System.out.println("Loading Credits ");
                    }
                }

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void loadProgramsFromDatabase(){
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

        //Here we add the programs in the database to the ListOfPrograms list:
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM program");


            while (resultSet.next() ){
                int programID = resultSet.getInt("program_id");
                String programTitle = resultSet.getString("title");
                String programReleaseDate = resultSet.getString("release_date");

                Program program = new Program(programID,programTitle,programReleaseDate);
                listOfPrograms.add(program);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public void logInUdkast(){
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

        //Here we add the programs in the database to the ListOfPrograms list:
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user_data");

            String inputEmail = " "; //DET ENE TEKSTFELT FRA GUI
            String inputPassword = " "; //DET ANDET TEKSTFELT FRA GUI

            while (resultSet.next() ){
                String user_email = resultSet.getString("user_email");
                String password = resultSet.getString("user_password");

                if (inputEmail == user_email && inputPassword == password){
                    //LOG IND
                }
                else {
                    continue;
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



}
