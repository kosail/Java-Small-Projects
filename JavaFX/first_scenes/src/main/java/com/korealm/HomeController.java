package com.korealm;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HomeController {
    @FXML
    private Label nameLabel;

    public void displayName(String name) {
        nameLabel.setText("Welcome back, " + name + "!");
    }

    public void exitProgram() {
        System.exit(0);
    }
}
