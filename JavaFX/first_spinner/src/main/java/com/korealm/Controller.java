package com.korealm;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

public class Controller {
    @FXML private Spinner<Integer> spinner;
    @FXML private Label label;
    
    private int selected;

    @FXML
    public void initialize() {
        SpinnerValueFactory<Integer> factory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10);

        factory.setValue(0);
        spinner.setValueFactory(factory);

        spinner.valueProperty().addListener(new ChangeListener<Integer>() {

            @Override
            public void changed(ObservableValue<? extends Integer> arg0, Integer arg1, Integer arg2) {
                selected = spinner.getValue();
                label.setText(Integer.toString(selected));
            }
            
        });
    }

    
}
