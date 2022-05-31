package com.proj2.gui;

import com.proj2.model.abstraction.AbstractPerson;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class UserDashboard {
    private AbstractPerson user;
    private final Stage stage = new Stage();


    public UserDashboard(AbstractPerson user) {
        this.user = user;
        Scene scene = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("/com/proj2/dashboard.fxml"));
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("FOUT");
//            throw new RuntimeException(e);
        }
        if (scene != null) {
            setScene(scene);
        }
    }

    public void setScene(Scene scene) {
        stage.setScene(scene);
    }
}
