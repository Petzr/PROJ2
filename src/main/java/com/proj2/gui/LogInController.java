package com.proj2.gui;

import com.proj2.model.abstraction.AbstractPerson;
import com.proj2.model.person.Admin;
import com.proj2.service.AuthorizationProvider;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LogInController implements Initializable
{
    public TextField emailField;
    public PasswordField passwordField;
    public Label logintxt;

    @FXML
    public void logInButtonClick(ActionEvent actionEvent)
    {
        AbstractPerson login = AuthorizationProvider.login(emailField.getText(), passwordField.getText());
        if (login != null) {
            Scene scene;
            if (login instanceof Admin) scene = IControllerInfo.createNewScene(login, "/com/proj2/admin-dashboard.fxml", new AdminDashboardController());
            else scene = IControllerInfo.createNewScene(login, "/com/proj2/dashboard.fxml", new DashboardController());
            Stage stage = new Stage();
            stage.setTitle("Dashboard of: " + login.getName());
            stage.getIcons().add(new Image("logo.png"));
            stage.setOnCloseRequest(s -> login.setLoggedIn(false));
            stage.setScene(scene);
            stage.setUserData(login);
            stage.show();
            logintxt.setText("");
            emailField.setText("");
            passwordField.setText("");
            emailField.requestFocus();
        } else logintxt.setText("Mail and/or password incorrect or user already logged in");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}
