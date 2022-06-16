package com.proj2.gui;

import com.proj2.model.abstraction.AbstractPerson;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController implements IControllerInfo{
    private AbstractPerson user;
    private Stage stage;

    public AbstractPerson getUser() {
        return user;
    }
    public Stage getStage() {
        return stage;
    }

    @Override
    public void setUser(AbstractPerson user) { this.user = user; }
    @Override
    public void setStage(Stage stage) { this.stage = stage; }

    public void backToDashboard(ActionEvent actionEvent) {
        // dit is nodig om de stage te bepalen
        Node node = (Node) actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        // hier wordt de nieuwe scene gemaakt en de user meegegeven
        Scene scene = IControllerInfo.createNewScene(user, "/com/proj2/dashboard.fxml", new DashboardController());

        // spreekt voorzich denk...
        if (scene != null) stage.setScene(scene);
    }

    public void newScene(Scene scene) {
        stage.setScene(scene);
    }

}
