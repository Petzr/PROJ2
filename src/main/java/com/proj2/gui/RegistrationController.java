package com.proj2.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class RegistrationController  {

    @FXML
    private TextField nametf;
    @FXML
    private TextField mailtf;
    @FXML
    private PasswordField passwordtf;
    @FXML
    private PasswordField passwordtf2;
    @FXML
    private Button registerbttn;
    @FXML
    private Button returnbttn;

    public void retbttn(MouseEvent mouseEvent) throws IOException {
        // return naar de vorige pagina
        HelloApplication h = new HelloApplication();
         h.changeScene("dashboard.fxml);"); // misschien naar een ander scherm ?
    }

    public void regbttn(MouseEvent mouseEvent) throws IOException {
        if(passwordtf.getText().equals(passwordtf2.getText())) {
            //new user(gettext(),.....)
        }
    }
}
