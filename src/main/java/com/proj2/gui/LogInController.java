package com.proj2.gui;

import com.proj2.model.abstraction.AbstractPerson;
import com.proj2.model.person.User;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LogInController implements Initializable, IControllerInfo
{
    public TextField emailField;
    public PasswordField passwordField;

    public void logInButtonClick(ActionEvent actionEvent)
    {
        new UserDashboard(new User("Peter", "email", "password"));
    }

    @Override
    public void setUser(AbstractPerson user) {}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}
