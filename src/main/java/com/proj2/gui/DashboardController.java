package com.proj2.gui;

import com.proj2.model.abstraction.AbstractPerson;
import com.proj2.model.person.User;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

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
        System.out.println("LEADERBOARD");
    }

    public void logOutButton(ActionEvent actionEvent)
    {
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    public void setUser(AbstractPerson user) {
        this.user = user;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameUser.setText(user.getName());
        User user1 = (User) user;
        user1.setPoints(69);
        pointsUser.setText(Integer.toString(user1.getPoints()));
    }
}
