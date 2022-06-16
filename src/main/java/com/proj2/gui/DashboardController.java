package com.proj2.gui;

import com.proj2.model.abstraction.AbstractPerson;
import com.proj2.model.person.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController extends GeneralDashboard implements Initializable
{
    public Label pointsUser;

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