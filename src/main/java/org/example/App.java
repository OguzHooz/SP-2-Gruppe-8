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
        scene = new Scene(loadFXML("primary"), 640, 480);
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
        launch();

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


        //Inserting a user into the database:
       /* try {
            String a = "Kameramand";
            int b = 10;
            PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO credit (role, personid_fk) VALUES (?,?)");
            insertStatement.setString(1, a);
            insertStatement.setInt(2,b);
            insertStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        System.out.println("HEY");


    }

}