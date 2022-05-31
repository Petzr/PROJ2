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
        Node node = (Node) actionEvent.getSource();
        Scene scene = node.getScene();
        Stage stage = (Stage) scene.getWindow();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("/com/proj2/nieuwe-rit.fxml"));

            NieuweRitController controller = new NieuweRitController();
            controller.setUser(user);
            fxmlLoader.setController(controller);

            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("FOUT");
//            throw new RuntimeException(e);
        }
        if (scene != null) {
            stage.setScene(scene);
        }
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
