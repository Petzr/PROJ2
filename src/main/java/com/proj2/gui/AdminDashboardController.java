package com.proj2.gui;

import com.proj2.model.abstraction.AbstractPerson;
import com.proj2.model.person.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminDashboardController extends MainController implements Initializable
{

    @FXML
    private Label nameUser;

    @FXML
    public void logOutButton(ActionEvent actionEvent) {
        getUser().setLoggedIn(false);
        IControllerInfo.getStage(actionEvent).close();
    }

    @FXML
    void nieuweGebruiker(ActionEvent event) {
        Stage stage = IControllerInfo.getStage(event);
        changeSceneTo(stage, "/com/proj2/registration.fxml", new RegistrationController());
    }

    @FXML
    void verwijderGebruiker(ActionEvent event) {
        Stage stage = IControllerInfo.getStage(event);
        changeSceneTo(stage, "/com/proj2/deleting-user.fxml", new DeletingUserController());
    }

    @FXML
    void showLeaderboard(ActionEvent event) {
        Stage stage = IControllerInfo.getStage(event);
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
        changeSceneTo(stage, "/com/proj2/admin-reward.fxml", new AdminRewardController());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        nameUser.setText(getUser().getName());
    }
}
