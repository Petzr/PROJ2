package com.proj2.gui;

import com.proj2.model.abstraction.AbstractPerson;
import com.proj2.model.person.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController implements Initializable, IControllerInfo
{
    private AbstractPerson user;
    public Label nameUser;
    public Label pointsUser;

    public void nieuweRit(ActionEvent actionEvent)
    {
        // dit is nodig om de stage te bepalen
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        // hier wordt de nieuwe scene gemaakt en de user meegegeven
        Scene scene = IControllerInfo.createNewScene(user, "/com/proj2/nieuwe-rit.fxml", new NieuweRitController());

        // spreekt voorzich denk...
        if (scene != null) stage.setScene(scene);
    }

    public void showLeaderboard(ActionEvent actionEvent)
    {
        // dit is nodig om de stage te bepalen
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        // hier wordt de nieuwe scene gemaakt en de user meegegeven
        Scene scene = IControllerInfo.createNewScene(user, "/com/proj2/leaderboard.fxml", new LeaderboardController());

        // spreekt voorzich denk...
        if (scene != null) stage.setScene(scene);
    }

    public void logOutButton(ActionEvent actionEvent) { ((Stage) ((Node) actionEvent.getSource()).getScene().getWindow()).close(); }

    public void setUser(AbstractPerson user) { this.user = user; }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameUser.setText(user.getName());
//        User user1 = (User) user;
//        user1.setPoints(69);
//        pointsUser.setText(Integer.toString(user1.getPoints()));
    }
}
