package com.korealm;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("primary.fxml"));
        Scene scene = new Scene(loader.load());
        Controller controller = loader.getController();

        // We can add the event in this way, or we can simplify it using a lambda, in which case it would be something like:
        // scene.setOnKeyPressed( event -> { code here } );
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                KeyCode pressedKey = event.getCode();

                switch (pressedKey) {
                    case UP:
                        Controller.moveUp();
                        break;
                    case DOWN:
                        Controller.moveDown();
                        break;
                    case LEFT:
                        Controller.moveLeft();
                        break;
                    case RIGHT:
                        Controller.moveRight();
                        break;
                    default:
                        System.err.println("Unknown key!");
                }
            }
            
        });

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}