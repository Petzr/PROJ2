package com.proj2.gui;

import com.proj2.model.abstraction.AbstractPerson;
import com.proj2.model.person.Admin;
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

public class DeletingUserController implements Initializable, IControllerInfo
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
        Scene scene = IControllerInfo.createNewScene(user, "/com/proj2/admin-dashboard.fxml", new AdminDashboardController());

        // spreekt voorzich denk...
        if (scene != null) stage.setScene(scene);
    }

    @FXML
    void deletingUser(ActionEvent event) {
        if (user.comparePassword(passwordAdmintf.getText()))
            if (user instanceof Admin)
                ((Admin) user).removeUser(mailtf.getText());
    }

    @Override
    public void setUser(AbstractPerson user) { this.user = user; }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }
}
