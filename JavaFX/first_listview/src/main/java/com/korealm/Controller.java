package com.korealm;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class Controller {
    @FXML ListView<String> listView;
    @FXML Label label;
    
    String[] food = {"Pizza", "Sushi", "Popcorn"};
    String currentFood;


    @FXML
    public void initialize() {
        listView.getItems().addAll(food);

        listView.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<String>() {

                @Override
                public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                    currentFood = listView.getSelectionModel().getSelectedItem();
                    
                    label.setText(currentFood);
                }
                
            }
        );
    }
}
