package com.proj2.gui;

import com.proj2.service.Logic;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class StartApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Logic.seedOrganisation();
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("/com/proj2/log-in.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.getIcons().add(new Image("logo.png"));
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}