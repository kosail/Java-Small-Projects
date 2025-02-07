package com.korealm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private Label mainLabel;
    @FXML
    private RadioButton rButton1, rButton2, rButton3;
    
    private Stage stage;

    public void change(ActionEvent e) {
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        if (rButton1.isSelected()) {
            mainLabel.setText(rButton1.getText());
            stage.getScene().getRoot().setStyle("-fx-background: red");

        } else if (rButton2.isSelected()) {
            mainLabel.setText(rButton2.getText());
            stage.getScene().getRoot().setStyle("-fx-background: blue");

        } else {
            mainLabel.setText(rButton3.getText());
            stage.getScene().getRoot().setStyle("-fx-background: green");
        }
    }
}
