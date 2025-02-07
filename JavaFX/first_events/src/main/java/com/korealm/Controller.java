package com.korealm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.shape.Arc;

public class Controller {

    // This annotation is super important as it injects all the code from the FXML file loaded into this file, and thus I can interact with those objects from here changing their properties.
    @FXML
    private Arc pacman;
    private double x, y;

    public void up(ActionEvent e) {
        pacman.setCenterY(y-=10);
        pacman.setRotate(-90);
    }

    public void down(ActionEvent e) {
        pacman.setCenterY(y+=10);
        pacman.setRotate(90);
    }

    public void left(ActionEvent e) {
        pacman.setCenterX(x-=10);
        pacman.setRotate(180);
    }

    public void right(ActionEvent e) {
        pacman.setCenterX(x+=10);
        pacman.setRotate(360);
    }
}
