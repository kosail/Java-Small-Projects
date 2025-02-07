package com.korealm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller {
    
    @FXML
    private Label statusLabel;
    @FXML
    private CheckBox checkbox;
    @FXML
    private ImageView imageShowed;

    private Image image1, image2;

    public void change(ActionEvent e) {
        image1 = new Image(getClass().getResourceAsStream("blb.png"));
        image2 = new Image(getClass().getResourceAsStream("blb2.png"));

        if (checkbox.isSelected()) {
            imageShowed.setImage(image2);
            statusLabel.setText("ON");
        } else {
            statusLabel.setText("OFF");
            imageShowed.setImage(image1);
        }
    }
}
