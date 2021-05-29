package org.example;

import java.io.IOException;
import java.lang.module.ModuleDescriptor;
import java.net.URL;
import java.nio.file.LinkOption;
import java.nio.file.LinkPermission;
import java.sql.*;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import javax.net.ssl.HttpsURLConnection;

public class PrimaryController {

    static Connection connection = null;
    @FXML
    private Button LogindLogin;
    @FXML
    private TextField userTextfield;
    @FXML
    private PasswordField PasswordLogin;
    Statement statement = null;

    // denne klasse bliver brugt til at sætte funktioner på knapper, der skal ændre hvilken scene man er på.
    public void TilbageClicked(MouseEvent mouseEvent) throws IOException {
        App.setRoot("StartScreen");
    }

    public void loginClicked(MouseEvent mouseEvent) throws IOException {
      //  App.setRoot("ProducerCredit");
    }

    public void LoginClicked(MouseEvent mouseEvent) throws IOException {
        App.setRoot("LogInScreen");
    }

    public void SearchBarClicked(MouseEvent mouseEvent) throws IOException {
        App.setRoot("Credit");

    }

    public void LogUdClicked(MouseEvent mouseEvent) throws IOException {
        App.setRoot("LogInScreen");
    }

    public void ForgotPasswordClicked(MouseEvent mouseEvent) {

    }

    public void logInPressed (MouseEvent mouseEvent) throws IOException{

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


                String inputEmail = userTextfield.getText();
                String inputPassword = PasswordLogin.getText();

                System.out.println(inputEmail);
                System.out.println(inputPassword);

                while (resultSet.next()) {
                    System.out.println("User Login:");
                    String user_email = resultSet.getString("user_email");
                    String password = resultSet.getString("user_password");

                    if (inputEmail.contains(user_email)  && inputPassword.contains(password)) {
                        App.setRoot("ProducerCredit");

                        }
                    else {
                        System.out.println("Logging In");

                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
    }


}
