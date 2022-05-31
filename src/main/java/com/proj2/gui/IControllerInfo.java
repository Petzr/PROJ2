package com.proj2.gui;

import com.proj2.model.abstraction.AbstractPerson;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public interface IControllerInfo {
    void setUser(AbstractPerson user);

    static Scene createNewScene(AbstractPerson user, String fxmlFile, IControllerInfo controller) {
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource(fxmlFile));

        controller.setUser(user);
        fxmlLoader.setController(controller);

        try {
            return new Scene(fxmlLoader.load());

        } catch (IOException e) {
            System.out.println("FOUT");
            return null;
//            throw new RuntimeException(e);
        }
    }
}
