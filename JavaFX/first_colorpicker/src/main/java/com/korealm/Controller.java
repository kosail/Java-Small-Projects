package com.korealm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Controller {
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private Pane pane;

    public void changeColor(ActionEvent event) {
        Color color = colorPicker.getValue();
        pane.setBackground(new Background(new BackgroundFill(color, null, null)));
    }
    
}
