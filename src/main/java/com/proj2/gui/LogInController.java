package com.proj2.gui;

import com.proj2.model.person.User;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LogInController
{
    public TextField emailField;
    public PasswordField passwordField;

    public void logInButtonClick(ActionEvent actionEvent)
    {
        new UserDashboard(new User("Peter", "email", "password"));
    }
}
