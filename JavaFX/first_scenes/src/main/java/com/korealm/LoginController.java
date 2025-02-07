package com.korealm;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    private Parent root;
    private Scene scene;
    private Stage stage;
    
    @FXML
    private TextField username_field;
    
    @FXML
    private PasswordField password_field;

    public void login(ActionEvent e) throws IOException {
        String username = "";
        String password = "";

        if (username.isBlank() || password.isBlank()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Login failed");
            alert.setHeaderText("Invalid credentials");
            alert.setContentText("Both username and password fields cannot be blank!");
            alert.showAndWait();
            return;
        }

        try {
            username = username_field.getText();
            password = password_field.getText();
        } catch(Exception excep) {
            crash(excep);
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        root = loader.load();
        HomeController homeController = loader.getController();
        homeController.displayName(username);

        stage = (Stage) ((Node) e.getSource()).getScene().getWindow(); 
        scene = stage.getScene();
        scene.setRoot(root);
        stage.show();
        
    }

    public void returnToMenu(ActionEvent e) throws IOException {
        root = App.loadFXML("Splash");
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow(); 
        scene = stage.getScene();
        scene.setRoot(root);
        stage.show();
    }

    private void crash(Exception e) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Crash Error");
        alert.setHeaderText("An unknown error has occurred");
        alert.setContentText("Contact to the site administration to further assistance.");
        alert.showAndWait();

        System.err.println('\n' + e.getLocalizedMessage());
    }
}
