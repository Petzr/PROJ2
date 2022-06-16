package com.proj2.gui;

import com.proj2.model.abstraction.AbstractPerson;
import com.proj2.model.person.Admin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class RegistrationController extends MainController implements Initializable
{

    @FXML
    private TextField mailtf;

    @FXML
    private TextField nametf;

    @FXML
    private PasswordField passwordtf;

    @FXML
    private PasswordField passwordtf2;

    @FXML
    private Label regLabel;

    @FXML
    void registerUser(ActionEvent event) {
        if (getUser() instanceof Admin)
            if (passwordtf.getText().equals(passwordtf2.getText())) {
                ((Admin) getUser()).addUser(nametf.getText(), mailtf.getText(), passwordtf.getText());
                regLabel.setText("Registration succesfull.");
            } else regLabel.setText("Something went wrong.");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }
}
