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

public class DashboardController extends MainController implements Initializable
{
    public Label nameUser;
    public Label pointsUser;

    public void nieuweRit(ActionEvent actionEvent)
    {
        Stage stage = IControllerInfo.getStage(actionEvent);
        changeSceneTo(stage, "/com/proj2/nieuwe-rit.fxml", new NieuweRitController());
    }

    public void showLeaderboard(ActionEvent actionEvent)
    {
        Stage stage = IControllerInfo.getStage(actionEvent);
        changeSceneTo(stage, "/com/proj2/leaderboard.fxml", new LeaderboardController());
    }

    @FXML
    void toHistory(ActionEvent actionEvent) {
        Stage stage = IControllerInfo.getStage(actionEvent);
        changeSceneTo(stage, "/com/proj2/trip-history.fxml", new TripHistoryController());
    }


    @FXML
    void toChangeProfile(ActionEvent event) {
        Stage stage = IControllerInfo.getStage(event);
        changeSceneTo(stage, "/com/proj2/change-profile.fxml", new ChangeDataController());
    }


    @FXML
    void toRewards(ActionEvent event) {
        Stage stage = IControllerInfo.getStage(event);
        changeSceneTo(stage, "/com/proj2/rewards.fxml", new RewardController());
    }

    public void logOutButton(ActionEvent actionEvent) {
        getUser().setLoggedIn(false);
        ((Stage) ((Node) actionEvent.getSource()).getScene().getWindow()).close();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameUser.setText(getUser().getName());
        pointsUser.setText(Integer.toString(((User) getUser()).getPoints()));
    }
}