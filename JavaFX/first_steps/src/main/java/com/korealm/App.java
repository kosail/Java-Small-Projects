    package com.korealm;

    import javafx.application.Application;
    import javafx.scene.Group;
    import javafx.scene.Scene;
    import javafx.scene.image.Image;
    import javafx.scene.image.ImageView;
    import javafx.scene.paint.Color;
    import javafx.scene.text.Font;
    import javafx.scene.text.Text;
    import javafx.stage.Stage;
    import javafx.scene.shape.Circle;
    import javafx.scene.shape.Line;
    import javafx.scene.shape.Polygon;
    import javafx.scene.shape.Rectangle;

    // #############################
    // #### NOTES ABOUT JAVAFX #####
    // #############################
    // # JFrame = Stage
    // # JPanel = Scene

    public class App extends Application {
        public static void main(String[] args) {
            // The launch method from the Application class automatically calls the start method under the hood, so this is the only thing that we will require in our main to launch JavaFX.
            // It can also be called as Application.launch(args);
            launch(args);
        }

        // Notice that in this method below, we are already getting a Stage from the Application class. We can use it and build our main Stage with it.
        @Override
        public void start(Stage stage) throws Exception {

            // ##############################
            // #### STAGE SETUP SECTION #####
            // ##############################
            stage.setTitle("Stage demo program w00f w00f");
            stage.getIcons().add(new Image("logo.png")); // Notice that this Image class is from javafx.scene package and not the standard built-in one.

            // stage.setWidth(1080);
            // stage.setHeight(1080);

            // stage.setResizable(false);
            // stage.setFullScreen(true);
            
            // stage.setFullScreenExitHint("Gae");
            // stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q "));


            // ########################################
            // #### SCENE AND GROUP SETUP SECTION #####
            // ########################################
            // This is where the elements are added, and this is required by the scene to exist
            Group root = new Group();
            Scene scene = new Scene(root, 600, 600, Color.INDIANRED);

            Text text = new Text("Lorem ipsum");
            text.setText(STYLESHEET_CASPIAN);
            
            text.setX(50);
            text.setY(50);

            text.setFont(Font.font("Noto Sans", 50));
            text.setFill(Color.WHEAT);

            Line line = new Line();
            line.setStartX(200);
            line.setStartY(200);
            line.setEndX(400);
            line.setEndY(200);

            line.setStrokeWidth(40);
            line.setStroke(Color.CHOCOLATE);
            line.setOpacity(0.9);
            line.setRotate(50);

            Rectangle rectangle = new Rectangle();
            rectangle.setWidth(100);
            rectangle.setHeight(100);
            rectangle.setX(350);
            rectangle.setY(250);

            rectangle.setFill(Color.DARKORCHID);
            rectangle.setStroke(Color.YELLOW);
            rectangle.setStrokeWidth(40);

            Polygon triangle = new Polygon();
            triangle.getPoints().setAll(
                200.0, 200.0,
                300.0, 300.0,
                200.0, 300.0);
            
            triangle.setFill(Color.TAN);

            Circle circle = new Circle(300, Color.CORNFLOWERBLUE);
            circle.setCenterX(120);
            circle.setCenterY(120);
            circle.setRadius(40);

            Image image = new Image("logo.png");
            ImageView imageView = new ImageView(image);
            
            imageView.setX(200);
            imageView.setY(380);


            root.getChildren().addAll(text, line, rectangle, triangle, circle, imageView);

            stage.setScene(scene);
            stage.show();
        }

    }