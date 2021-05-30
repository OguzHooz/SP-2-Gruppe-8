package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.*;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("StartScreen"));
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    static Connection connection = null;

    public static void main(String[] args) {
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
        launch();
        System1 sys = new System1();
        Producer producer = new Producer();
        Systemadministrator systemadministrator = new Systemadministrator();

        //Here we load the information from the database into the system
        sys.loadProgramsFromDatabase(); //This method creates objects retrieved from the database
        sys.loadPersonFromDatabase();
        sys.loadCreditsFromDatabase();
        sys.insertProgramTitle();
        


        //Test for checking if the programs are there
        System.out.println("List of Programs: ");
        for (int i = 0; i < System1.listOfPrograms.size(); i++){
            Program program = System1.listOfPrograms.get(i);
            System.out.println("Title: " +program.getTitle() + "  ID " + program.getProgramID());
        }

        //Test for checking if the Person are there
        System.out.println("---------------");
        System.out.println("List of Person: ");
        for (int i = 0; i < System1.listOfPersons.size(); i++){
            Person person = System1.listOfPersons.get(i);
            System.out.println("Name: " +person.getPersonName() + "  ID " + person.getPersonID());
        }
        System.out.println(" -------------");




        //Test for checking if the Credits are there
        System.out.println("---------------");
        System.out.println("List of Credits: ");
        for (int i = 0; i < System1.listOfCredit.size(); i++){
            Credit credit = System1.listOfCredit.get(i);
            System.out.println(credit.getCreditID() + ":  Name " + credit.getpName() + " -> " + credit.getPersonRole());
        }
        System.out.println(" -------------");


        User user = new User();




        System.out.println("PROGRAMMET VIRKER");


    }

}