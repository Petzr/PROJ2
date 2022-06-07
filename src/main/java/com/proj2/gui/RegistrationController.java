package com.proj2.gui;

import com.proj2.model.abstraction.AbstractPerson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class RegistrationController implements Initializable, IControllerInfo
{

    private AbstractPerson user;

    @FXML
    private TextField mailtf;

    @FXML
    private TextField nametf;

    @FXML
    private PasswordField passwordtf;

    @FXML
    private PasswordField passwordtf2;

    @FXML
    void backToDashboard(ActionEvent event) {
        // dit is nodig om de stage te bepalen
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        // hier wordt de nieuwe scene gemaakt en de user meegegeven
        Scene scene = IControllerInfo.createNewScene(user, "/com/proj2/dashboard.fxml", new DashboardController());

        // spreekt voorzich denk...
        if (scene != null) {
            stage.setScene(scene);
        }
    }

    @FXML
    void registerUser(ActionEvent event) {

    }

    @Override
    public void setUser(AbstractPerson user)
    {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }
}
