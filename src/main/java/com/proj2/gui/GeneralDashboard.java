package com.proj2.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class GeneralDashboard extends MainController {
    @FXML
    public Label nameUser;

    public Label getNameUser() {
        return nameUser;
    }

    public void showLeaderboard(ActionEvent actionEvent)
    {
        Stage stage = IControllerInfo.getStage(actionEvent);
        changeSceneTo(stage, "/com/proj2/leaderboard.fxml", new LeaderboardController());
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

}
