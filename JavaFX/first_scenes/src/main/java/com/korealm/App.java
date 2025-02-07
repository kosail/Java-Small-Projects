package com.korealm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Splash"));
        scene.getStylesheets().add(loadCss("Main"));

        stage.setTitle("Waifu Administration System V1.0 Alpha");

        stage.setScene(scene);
        stage.show();
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    private static String loadCss(String css) throws IOException {
        return App.class.getResource(css + ".css").toExternalForm();
    }

    public static void main(String[] args) {
        launch();
    }

}