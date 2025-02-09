package com.korealm;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Controller {
    @FXML ImageView imageView;

    @FXML
    public void initialize() {
        // Translate. It is used to move elements.
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(imageView);

        // Set the transition by coordinates
        translate.setByX(250);
        translate.setByY(150);

        translate.setDuration(Duration.millis(1000));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setAutoReverse(true);

        // Rotate
        RotateTransition rotate = new RotateTransition();
        rotate.setNode(imageView);
        rotate.setDuration(Duration.millis(1000));
        rotate.setCycleCount(TranslateTransition.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR); // This makes no pause between each iteration
        rotate.setByAngle(360);
        
        // Fade
        FadeTransition fade = new FadeTransition();
        fade.setNode(imageView);
        fade.setDuration(Duration.millis(200));
        fade.setCycleCount(TranslateTransition.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        fade.setAutoReverse(true);
        fade.setFromValue(0.5);
        fade.setToValue(1);

        // Scale
        ScaleTransition scale = new ScaleTransition();
        scale.setNode(imageView);
        scale.setDuration(Duration.millis(1000));
        scale.setCycleCount(TranslateTransition.INDEFINITE);
        scale.setAutoReverse(true);
        scale.setByX(2.0);
        scale.setByY(2.0);

        // Synchronize them all
        ParallelTransition parallelTransition = new ParallelTransition(translate, rotate, fade, scale);
        parallelTransition.play();
    }
}
