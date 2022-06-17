package com.proj2.gui;

import com.proj2.model.person.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController extends GeneralDashboard implements Initializable
{
    @FXML
    public Label pointsUser;

    @FXML
    public void nieuweRit(ActionEvent actionEvent)
    {
        changeSceneTo(actionEvent, "/com/proj2/nieuwe-rit.fxml", new NieuweRitController());
    }
    @FXML
    void toHistory(ActionEvent actionEvent) {
        changeSceneTo(actionEvent, "/com/proj2/trip-history.fxml", new TripHistoryController());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getNameUser().setText(getUser().getName());
        pointsUser.setText(Integer.toString(((User) getUser()).getPoints()));
    }
}