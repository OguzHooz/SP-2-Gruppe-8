package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class System1 {


    static ArrayList<Person> listOfPersons = new ArrayList<Person>(); //Its a linkedList so its sorted by the last thing that got added
    static ArrayList<User> listOfUsers = new ArrayList<User>();
    static ArrayList<Program> listOfPrograms = new ArrayList<Program>();
    static ArrayList<Credit> listOfCredit = new ArrayList<Credit>();
    static Connection connection = null;
    Statement statement = null;


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
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM credit");
            ResultSet rst = statement.executeQuery("SELECT * FROM persondata");

            while (resultSet.next() ){
                //Here we gather information for the credit objects
                int creditID = resultSet.getInt("creditid");
                String role = resultSet.getString("role");
                int personID = resultSet.getInt("personid_fk");


                //To create a credit object, we need a person object, so here we get the person information
                for (int i = 0; i < System1.listOfPersons.size(); i++){
                    Person person = System1.listOfPersons.get(i);

                    if (personID == person.getPersonID()){
                        Credit c_credit = new Credit(person, role, person.getPersonID(), person.getPersonName());
                        System1.listOfCredit.add(c_credit);
                    }
                    else {
                        continue;
                    }
                }

/*                //To create a credit object, we need a person object, so here we get the person information
                for (int i = 0; i < System1.listOfPersons.size(); i++){
                    Person person = System1.listOfPersons.get(i);
                    int p_id = person.getPersonID();
                    String p_name = person.getPersonName();
                    String p_information = person.getPersonInformation();

                }*/

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

            String inputEmail = "";
            String inputPassword = "";

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
