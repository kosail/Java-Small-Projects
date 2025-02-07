package com.korealm;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {
    
    @FXML

    private ImageView imageView;
    private Button changeBtn;
    private Image image = new Image(getClass().getResourceAsStream("mm2.png"));

    public void displayImage() {
        imageView.setImage(image);
    }

}
