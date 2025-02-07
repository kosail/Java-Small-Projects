package com.korealm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        // Instead of manually creating the interface with code, we can use files FXML, which are kind of XMLs but with a java flavour. We can create those by hand or using SceneBuilder.
        // After creating them, we should load them using FXMLLoader.load() method and store it as a Parent object type. Then, create the scene using it. That's all
        Parent parent = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene = new Scene(parent);

        // Setting basic Stage customizations
        stage.setTitle("Secret Espionage Service");
        stage.getIcons().add(new Image(
            getClass().getResource("icon.png").toExternalForm() // This is a cool way to get the media path
        ));
        stage.setResizable(false);

        stage.setScene(scene);
        stage.show();
    }

}