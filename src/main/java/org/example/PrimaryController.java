package org.example;

import java.io.IOException;
import java.lang.module.ModuleDescriptor;
import java.net.URL;
import java.nio.file.LinkOption;
import java.nio.file.LinkPermission;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import javax.net.ssl.HttpsURLConnection;

public class PrimaryController {
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
}
