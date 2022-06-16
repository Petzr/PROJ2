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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ChangeDataController implements Initializable, IControllerInfo
{
    private AbstractPerson user;
    @FXML
    private Label changeMessage;
    @FXML
    private TextField newName;
    @FXML
    private PasswordField newPassword;
    @FXML
    private PasswordField oldPassword;
    @FXML
    private Label regLabel;

    @FXML
    private TextField pictureTextfield;

    @FXML
    private ImageView profilePicture;

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

    public void newProfilePicture()
    {

    }

    @FXML
    void changeData(ActionEvent event)
    {
        if (user.comparePassword(oldPassword.getText()))
        {
            if (!newName.getText().equals("") && !newPassword.getText().equals("")) {
                user.setName(newName.getText());
                user.setPassword(newPassword.getText());
                backToDashboard(event);
            } else if (!newName.getText().equals("") && newPassword.getText().equals("")) {
                user.setName(newName.getText());
                backToDashboard(event);
            } else if (newName.getText().equals("") && !newPassword.getText().equals("")) {
                user.setPassword(newPassword.getText());
                backToDashboard(event);
            } else changeMessage.setText("Please fill in a new name and / or new password.");
        } else changeMessage.setText("Please enter the correct old password.");
    }

    @Override
    public void setUser(AbstractPerson user) { this.user = user; }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}
