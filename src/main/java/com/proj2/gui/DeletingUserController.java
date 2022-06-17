package com.proj2.gui;

import com.proj2.model.person.Admin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DeletingUserController extends MainController
{
    @FXML
    private TextField mailtf;
    @FXML
    private PasswordField passwordAdmintf;
    @FXML
    private PasswordField passwordUsertf;
    @FXML
    private Label delLabel;

    @FXML
    void deletingUser(ActionEvent event) {
        if (getUser().comparePassword(passwordAdmintf.getText()))
            if (getUser() instanceof Admin) {
                ((Admin) getUser()).removeUser(mailtf.getText());
                delLabel.setText("User deleted.");
            }
    }
}
