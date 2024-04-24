/*********************************************************************************
* (Game: eye-hand coordination) Write a program that displays a circle of radius *
* 10 pixels filled with a random color at a random location on a pane, as shown  *
* in Figure 15.29b. When you click the circle, it disappears and a new random    *
* color circle is displayed at another random location. After twenty circles are *
* clicked, display the time spent in the pane, as shown in Figure 15.29c.        *
*********************************************************************************/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class EyehandCoordinationGame extends Application {
    public void start(Stage primaryStage){
        Pane pane = new Pane();
        double width = 200;
        double height = 200;
        // Create a Circle
        Circle circle = new Circle(10);
        setRandomProperties(circle, width, height);
        pane.getChildren().add(circle);
        
        //Create and register the handle
        circle.setOnMouseClicked(e->{
            pane.getChildren().clear();
            setRandomProperties(circle, width, height);
            pane.getChildren().add(circle);
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, width, height);
        primaryStage.setTitle("Eye hand Coordination");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    // Set a circle with a random color and a random location the pane
    private void setRandomProperties(circle c, double width, double height) {
        c.setFill(Color.color(Math.random(), Math.random(), Math.random()));
        c.setCenterX(c.getRadius() + Math.random() * (width - c.getRadius() * 2));
        c.setCenterY(c.getRadius() + Math.random() * (height - c.getRadius() * 2));
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
