package com.proj2.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private static Stage stg;
    @Override
    public void start(Stage stage) throws IOException {

        stg = stage;
        stage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("/com/proj2/hello-view.fxml"));

        stage.setTitle("Hello!");
        stage.setScene(new Scene(root, 320, 240));
        stage.show();
    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch();
    }
}