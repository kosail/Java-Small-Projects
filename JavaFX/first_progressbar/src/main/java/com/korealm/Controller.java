package com.korealm;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class Controller implements Initializable {
    @FXML private Label label;
    @FXML private ProgressBar progressBar;
    @FXML private Button button;

    // The BigDecimal class gives its user complete control over rounding behavior
    private BigDecimal progress = new BigDecimal(String.format("%.2f", 0.0));
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        progressBar.setStyle("-fx-accent: #202020;");
    }

    public void increaseProgress() {
        if (progress.doubleValue() >= 1.0) {
            progress = new BigDecimal(String.format("%.2f", 0.0));
        } else {
            progress = new BigDecimal(String.format("%.2f", progress.doubleValue() + 0.1));
        }

        progressBar.setProgress(progress.doubleValue());
        label.setText(Math.round(progress.doubleValue() * 100) + "%");
    }

}
