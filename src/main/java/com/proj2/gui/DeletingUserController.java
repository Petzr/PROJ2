package com.proj2.gui;

import com.proj2.model.abstraction.AbstractPerson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DeletingUserController
{

    private AbstractPerson user;

    @FXML
    private TextField mailtf;

    @FXML
    private PasswordField passwordAdmintf;

    @FXML
    private PasswordField passwordUsertf;

    @FXML
    public void backToDashboard(ActionEvent actionEvent) {
        // dit is nodig om de stage te bepalen
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        // hier wordt de nieuwe scene gemaakt en de user meegegeven
        Scene scene = IControllerInfo.createNewScene(user, "/com/proj2/dashboard.fxml", new DashboardController());

        // spreekt voorzich denk...
        if (scene != null) {
            stage.setScene(scene);
        }
    }

    @FXML
    void deletingUser(ActionEvent event) {

    }

}
