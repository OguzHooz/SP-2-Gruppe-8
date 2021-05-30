package org.example;

import java.io.IOException;
import java.lang.module.ModuleDescriptor;
import java.net.URL;
import java.nio.file.LinkOption;
import java.nio.file.LinkPermission;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;


import javax.net.ssl.HttpsURLConnection;

public class PrimaryController {

    static int currentAccessLevel = 0;
    static Connection connection = null;
    @FXML
    private Button LogindLogin;
    @FXML
    private TextField userTextfield;
    @FXML
    private PasswordField PasswordLogin;

    @FXML
    private TextField creditIdTextfield;

    private TextField programTitleTextField;


    @FXML
    private TextArea programTexArea;
    @FXML
    private Button addCreditButton;

    @FXML
    private Button createProgramButton;

    Statement statement = null;



    //Når man trykke på lav et program knappen
    public void createProgramGUI (MouseEvent mouseEvent) throws IOException{

        User user = new User();
        user.addProgram();

    }


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

    public void logInPressed (MouseEvent mouseEvent) throws IOException{ //LOG IN METHOD

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
                    int userAccess = resultSet.getInt("user_access_level");

                    if (inputEmail.contains(user_email)  && inputPassword.contains(password)) {
                        App.setRoot("ProducerPage");
                        currentAccessLevel = userAccess;

                        }
                    else {
                        System.out.println("Logging In");

                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public int getCurrentAccessLevel() {
        return currentAccessLevel;
    }

    public void setCurrentAccessLevel(int currentAccessLevel) {
        this.currentAccessLevel = currentAccessLevel;
    }



}
