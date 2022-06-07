package com.proj2.gui;

import com.proj2.model.abstraction.AbstractPerson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AdminDashboardController
{
    private AbstractPerson user;

    @FXML
    private Label nameUser;

    @FXML
    public void logOutButton(ActionEvent actionEvent)
    {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    @FXML
    void nieuweGebruiker(ActionEvent event) {
        // dit is nodig om de stage te bepalen
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        // hier wordt de nieuwe scene gemaakt en de user meegegeven
        Scene scene = IControllerInfo.createNewScene(user, "/com/proj2/registration.fxml", new DeletingUserController());

        // spreekt voorzich denk...
        if (scene != null) {
            stage.setScene(scene);
        }
    }

    @FXML
    void verwijderGebruiker(ActionEvent event) {

    }

    @FXML
    void showLeaderboard(ActionEvent event) {
        // dit is nodig om de stage te bepalen
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        // hier wordt de nieuwe scene gemaakt en de user meegegeven
        Scene scene = IControllerInfo.createNewScene(user, "/com/proj2/leaderboard.fxml", new LeaderboardController());

        // spreekt voorzich denk...
        if (scene != null) {
            stage.setScene(scene);
        }
    }

}
