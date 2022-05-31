package com.proj2.gui;

import com.proj2.model.abstraction.AbstractPerson;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable
{
    private AbstractPerson user;

    public Label nameUser;
    public Label pointsUser;
    public void nieuweRit(ActionEvent actionEvent)
    {
    }

    public void showLeaderboard(ActionEvent actionEvent)
    {
    }

    public void logOutButton(ActionEvent actionEvent)
    {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println(nameUser.getText());
    }
}
