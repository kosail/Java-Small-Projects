package com.korealm;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class Controller implements Initializable {

    @FXML private ChoiceBox<String> choiceBox;
    @FXML private Label label;
    private String[] foods = {"Pizza", "Sushi", "Tacos"};

    private void choiceFood(ActionEvent event) {
        label.setText(choiceBox.getValue());
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        choiceBox.getItems().addAll(foods);
        choiceBox.setOnAction(this::choiceFood);
    }
}
