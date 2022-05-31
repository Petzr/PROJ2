package com.proj2.gui;

import com.proj2.model.person.User;
import javafx.event.ActionEvent;

public class LogInController
{
    public void logInButtonClick(ActionEvent actionEvent)
    {
        new UserDashboard(new User("Peter", "email", "password"));
    }
}
