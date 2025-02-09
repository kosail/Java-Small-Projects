package com.korealm;

import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller {
    @FXML MenuBar menuBar;

    @FXML AnchorPane pane;
    @FXML Stage stage;

    public void save() {
        System.out.println("Item saved to storage!");
    }

    public void close() {
        stage = (Stage) pane.getScene().getWindow();
        stage.close();
    }
}
