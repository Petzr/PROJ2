package com.proj2.gui;

import com.proj2.model.abstraction.AbstractPerson;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController implements IControllerInfo{
    private AbstractPerson user;

    public AbstractPerson getUser() {
        return user;
    }

    @Override
    public void setUser(AbstractPerson user) { this.user = user; }

    public void backToDashboard(ActionEvent actionEvent) {
        // dit is nodig om de stage te bepalen
        Stage stage = IControllerInfo.getStage(actionEvent);

        // hier wordt de nieuwe scene gemaakt en de user meegegeven
        Scene scene = IControllerInfo.createNewScene(user, "/com/proj2/dashboard.fxml", new DashboardController());

        // spreekt voorzich denk...
        if (scene != null) stage.setScene(scene);
    }

    public void changeSceneTo(Stage stage, String fxmlFile, IControllerInfo controller) {
        Scene scene = IControllerInfo.createNewScene(getUser(), fxmlFile, controller);
        if (scene != null) stage.setScene(scene);
    }
}
