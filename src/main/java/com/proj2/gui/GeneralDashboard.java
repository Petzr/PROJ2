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

    @FXML
    public void showLeaderboard(ActionEvent actionEvent)
    {
        changeSceneTo(actionEvent, "/com/proj2/leaderboard.fxml", new LeaderboardController());
    }
    @FXML
    void toChangeProfile(ActionEvent event) {
        changeSceneTo(event, "/com/proj2/change-profile.fxml", new ChangeDataController());
    }
    @FXML
    void toRewards(ActionEvent event) {
        changeSceneTo(event, "/com/proj2/rewards.fxml", new RewardController());
    }

    public void logOutButton(ActionEvent actionEvent) {
        getUser().setLoggedIn(false);
        IControllerInfo.getStage(actionEvent).close();
    }

}
