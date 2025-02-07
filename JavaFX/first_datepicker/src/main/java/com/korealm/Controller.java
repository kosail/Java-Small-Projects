package com.korealm;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Controller {
    @FXML
    private Label label;
    @FXML
    private DatePicker datePicker;

    public void upDate() {
        LocalDate date = datePicker.getValue();
        label.setText(date.format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
    }
}
