package com.korealm;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SplashController {
    @FXML
    private Parent root;
    private Scene scene;
    private Stage stage;


    public void launchLogin(ActionEvent e) throws IOException {
        root = App.loadFXML("Login");
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow(); 
        scene = stage.getScene();
        scene.setRoot(root);
        stage.show();
    }
    
    public void goHome(ActionEvent e) throws IOException {
        root = App.loadFXML("Splash");
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow(); 
        scene = stage.getScene();
        scene.setRoot(root);
        stage.show();
    }

    public void goAboutUs(ActionEvent e) throws IOException {
        root = App.loadFXML("AboutUs");
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow(); 
        scene = stage.getScene();
        scene.setRoot(root);
        stage.show();
    }

    public void exitProgram(ActionEvent e) throws IOException {
        System.exit(0);
    }
}