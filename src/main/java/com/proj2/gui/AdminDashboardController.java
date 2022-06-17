package com.proj2.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminDashboardController extends GeneralDashboard implements Initializable
{
    @FXML
    void nieuweGebruiker(ActionEvent event) {
        changeSceneTo(event, "/com/proj2/registration.fxml", new RegistrationController());
    }
    @FXML
    void verwijderGebruiker(ActionEvent event) {
        changeSceneTo(event, "/com/proj2/deleting-user.fxml", new DeletingUserController());
    }
    @FXML
    void toRewards(ActionEvent event) {
        changeSceneTo(event, "/com/proj2/admin-reward.fxml", new AdminRewardController());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        getNameUser().setText(getUser().getName());
    }
}
