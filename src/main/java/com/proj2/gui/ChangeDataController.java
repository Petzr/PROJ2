package com.proj2.gui;

import com.proj2.model.abstraction.AbstractPerson;
import com.proj2.model.person.Admin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ChangeDataController implements Initializable, IControllerInfo
{

    private AbstractPerson user;

    @FXML
    private TextField newName;

    @FXML
    private PasswordField newPassword;

    @FXML
    private TextField oldName;

    @FXML
    private PasswordField oldPassword;

    @FXML
    private Label regLabel;

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
    void changeData(ActionEvent event) {
        if (user.getName().equals(oldName.getText()))
        {
            user.setName(newName.getText());
        }
        if (user.getPassword().equals(oldPassword.getText()))
        {
            user.setPassword(newPassword.getText());
        }
    }

    @Override
    public void setUser(AbstractPerson user)
    {
        this.user = user;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }
}
