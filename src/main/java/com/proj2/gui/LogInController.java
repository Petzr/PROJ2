package com.proj2.gui;

import com.proj2.model.abstraction.AbstractPerson;
import com.proj2.model.person.User;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LogInController implements Initializable, IControllerInfo
{
    public TextField emailField;
    public PasswordField passwordField;

    public void logInButtonClick(ActionEvent actionEvent)
    {
        User user = new User("Peter", "email", "password");
        Scene scene = IControllerInfo.createNewScene(user, "/com/proj2/dashboard.fxml", new DashboardController());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setUserData(user);
        stage.show();
    }

    @Override
    public void setUser(AbstractPerson user) {}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
}
