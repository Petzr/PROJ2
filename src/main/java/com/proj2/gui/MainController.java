package com.proj2.gui;

import com.proj2.model.abstraction.AbstractPerson;
import com.proj2.model.person.Admin;
import javafx.event.ActionEvent;
import javafx.event.Event;
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
        if (user instanceof Admin) changeSceneTo(actionEvent,"/com/proj2/admin-dashboard.fxml", new AdminDashboardController());
        else changeSceneTo(actionEvent,"/com/proj2/dashboard.fxml", new DashboardController());
    }

    public void changeSceneTo(Event event, String fxmlFile, IControllerInfo controller) {
        Stage stage = IControllerInfo.getStage(event);
        Scene scene = IControllerInfo.createNewScene(getUser(), fxmlFile, controller);
        if (scene != null) stage.setScene(scene);
    }
}
