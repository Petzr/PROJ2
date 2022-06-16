package com.proj2.gui;

import com.proj2.model.abstraction.AbstractPerson;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public interface IControllerInfo {
    void setUser(AbstractPerson user);
    void setStage(Stage stage);

    static Scene createNewScene(AbstractPerson user, String fxmlFile, IControllerInfo controller) {
        // het laden van de fxml file
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource(fxmlFile));

        // het maken van de controller die de user mee krijgt.
        controller.setUser(user);
        fxmlLoader.setController(controller);

        // de scene returnen met de user
        try {
            return new Scene(fxmlLoader.load());

        } catch (IOException e) {
            System.out.println("FOUT");
//            return null;
            throw new RuntimeException(e);
        }
    }
}
