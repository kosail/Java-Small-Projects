package com.korealm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Controller {
    @FXML
    private Label mainLabel;
    @FXML
    private Button submit;
    @FXML
    private TextField textField;

    private int age;

    public void submit(ActionEvent e) {
        try {
            age = Integer.parseInt(textField.getText());
            
            if (age < 18) {
                mainLabel.setText("You are underage, you cannot pass.");
            } else {
                mainLabel.setText("You are now signed in!");
                alertUser("Signed in", "Welcome back!", "Please enter your credit card", AlertType.INFORMATION);
            }
            
        } catch (NumberFormatException exception) {
            alertUser("There was an error", "You did not enter a number, please, make sure of entering just numbers", exception.getLocalizedMessage(), AlertType.WARNING);
        }
    }

    public void alertUser(String title, String header, String content, AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.show();

    }
}
