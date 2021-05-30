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
import javafx.event.ActionEvent;
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
    private TextField removePersonIDTextF;

    @FXML
    private TextField creditIdTextfield;

    @FXML
    private Button systemAdminButton;

    @FXML
    private TextField programTitleTextField;

    @FXML
    private TextField udgivelsesDatoTextField;

    @FXML
    private TextField programIDTextField;


    @FXML
    private TextArea programTexArea;
    @FXML
    private Button addCreditButton;

    @FXML
    private Button createProgramButton;

    @FXML
    private Button deleteCreditButton;

    @FXML
    private TextArea listOfProgramsTextArea;


    @FXML
    private Button deleteProgramButton;

    @FXML
    private TextField removePersonIdTextField;

    private TextField removeProgramIDTextF;

    @FXML
    private Button deletePersonButton;

    @FXML
    private TextArea testTexArea;

    @FXML
    private TextField removeCreditIDTextField;


    @FXML
    private TextField person_nameTextField;

    @FXML
    private TextField personInformationTextField;

    @FXML
    private TextField personIDTextField;

    @FXML
    private TextField roleTextField;

    @FXML
    private Button listOfProgramsButton;

    Statement statement = null;

    public void showProgramList (ActionEvent e) throws IOException{
        User user = new User();

        String a = "Hey";
        String b = "Yo";

        Object objects =System1.tableViewArray.stream().toArray();
        listOfProgramsTextArea.setText(objects.toString());



    }


    public void createCreditButton (ActionEvent e) throws IOException{
        User user = new User();
        String personID_Raw = personIDTextField.getText();
        String personRole = roleTextField.getText();

        //We convert ID to int
        int person_id = Integer.parseInt(personID_Raw);

        user.createCredit(person_id, personRole);


    }

    public void createPersonButton (ActionEvent e) throws IOException{
        User user = new User();
        String person_name = person_nameTextField.getText();
        String person_information = personInformationTextField.getText();
        user.createPerson(person_name, person_information);
    }

    //Når man trykke på lav et program knappen
    public void createProgramGUI (ActionEvent e) throws IOException{

        User user = new User();
        String title = programTitleTextField.getText();
        String release = udgivelsesDatoTextField.getText();

        user.addProgram(title, release);

    }

    public void removePersonButton (ActionEvent e) throws IOException{
        User user = new User();

        String person_ID_raw = removePersonIdTextField.getText();

        int personID = Integer.parseInt(person_ID_raw);

        user.removePerson(personID);
    }

    public void removeProgramButton (ActionEvent e) throws IOException{ //FUNGERE IKKE ENDNU
        User user = new User();

        String programID_RAW = removeProgramIDTextF.getId();

        int programID = Integer.parseInt(programID_RAW);

        user.removeProgram(programID);


    }



    //Når man trykker på createCredit
    public void addCreditToProgramGUI (ActionEvent event) throws IOException{
        User user = new User();
        String program_id_field = programIDTextField.getText();
        String credit_id_field = creditIdTextfield.getText();

        //Here we convert the text from String to Int
        int program_id = Integer.parseInt(program_id_field);
        int credit_id = Integer.parseInt(credit_id_field);

        user.addCreditToProgram(program_id,credit_id);


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

    public void setSystemAdminButton (ActionEvent e) throws IOException{
        App.setRoot("Systemadministrator");
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
