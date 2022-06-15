package com.proj2.gui;

import com.proj2.model.Reward;
import com.proj2.model.abstraction.AbstractPerson;
import com.proj2.model.person.Admin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class AdminRewardController
{

    private AbstractPerson user;
    @FXML
    private TableColumn<Reward, Integer> colomnCost;
    @FXML
    private TableColumn<Reward, String> colomnItems;
    @FXML
    private TableView<Reward> rewardsTable;

    @FXML
    void addReward(ActionEvent event) {

    }

    @FXML
    void backToDashboard(ActionEvent event) {
        // dit is nodig om de stage te bepalen
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        // hier wordt de nieuwe scene gemaakt en de user meegegeven
        Scene scene;
        if (user instanceof Admin) scene = IControllerInfo.createNewScene(user, "/com/proj2/admin-dashboard.fxml", new AdminDashboardController());
        else scene = IControllerInfo.createNewScene(user, "/com/proj2/dashboard.fxml", new DashboardController());

        // spreekt voorzich denk...
        if (scene != null) stage.setScene(scene);
    }

    @FXML
    void deleteReward(ActionEvent event) {

    }
}
