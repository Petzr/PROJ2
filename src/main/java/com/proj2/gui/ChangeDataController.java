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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ChangeDataController extends MainController implements Initializable
{
    @FXML
    private Label changeMessage;
    @FXML
    private TextField newName;
    @FXML
    private PasswordField newPassword;
    @FXML
    private PasswordField oldPassword;
    @FXML
    private Label regLabel;

    @FXML
    private TextField pictureTextfield;

    @FXML
    private ImageView profilePicture;

    public void newProfilePicture()
    {

    }

    @FXML
    void changeData(ActionEvent event)
    {
        if (getUser().comparePassword(oldPassword.getText()))
        {
            if (!newName.getText().equals("") && !newPassword.getText().equals("")) {
                getUser().setName(newName.getText());
                getUser().setPassword(newPassword.getText());
                backToDashboard(event);
            } else if (!newName.getText().equals("") && newPassword.getText().equals("")) {
                getUser().setName(newName.getText());
                backToDashboard(event);
            } else if (newName.getText().equals("") && !newPassword.getText().equals("")) {
                getUser().setPassword(newPassword.getText());
                backToDashboard(event);
            } else changeMessage.setText("Please fill in a new name and / or new password.");
        } else changeMessage.setText("Please enter the correct old password.");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}
