package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.HashMap;

public class LogInScreen extends ActionEvent {

    @FXML
    private TextField userTextfield;
    @FXML
    private PasswordField PasswordLogin;
    @FXML
    private Button LogindLogin;


    // public void loginClicked() throws Exception {
     //   App.setRoot("StartScreen");
    // }


        HashMap<String,String> logininfo = new HashMap<String,String>();

        LogInScreen(){

            logininfo.put("lucas","pizza");
            logininfo.put("admin","password");
            logininfo.put("user","abc123");
        }

        public HashMap getLoginInfo(){
            return logininfo;
        }


        HashMap<String,String> logininf = new HashMap<String,String>();

        LogInScreen(HashMap<String,String> loginInfoOriginal){

            logininfo = loginInfoOriginal;
            }






        public void loginClicked(ActionEvent e) throws IOException {

            if(e.getSource()==LogindLogin) {

                String userID = userTextfield.getText();
                String password = String.valueOf(PasswordLogin.getText());


                if(logininfo.containsKey(userTextfield)) {
                    if(logininfo.get(userTextfield).equals(PasswordLogin)) {
                        App.setRoot("ProducerCredit");
                        //messageLabel.setForeground(Color.green);
                        //messageLabel.setText("Login successful");

                    }
                    else {
                        // messageLabel.setForeground(Color.red);
                       // messageLabel.setText("Wrong password");
                    }

                }
                else {
                    //messageLabel.setForeground(Color.red);
                    //messageLabel.setText("username not found");
                }
            }
        }
    }



