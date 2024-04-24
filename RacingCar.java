/*********************************************************************************
* (Racing car) Write a program that simulates car racing, as shown in Figure     *
* 15.34a. The car moves from left to right. When it hits the right end, it       *
* restarts from the left and continues the same process. You can use a timer to  *
* control animation. Redraw the car with a new base coordinates (x, y), as shown *
* in Figure 15.34b. Also let the user pause/resume the animation with a button   *
* press/release and increase/decrease the car speed by pressing the UP and       *
* DOWN arrow keys.                                                               *
*********************************************************************************/


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;

public class RacingCar extends Application {
    public void start(Stage primaryStage) {
        // Create a car
        CarPane pane = new CarPane();

        // Create and register handles
        pane.setOnMousePressed(e-> pane.pause());
        pane.setOnMouseReleased(e-> pane.play());
        
        pane.setOnKeyPressed(e->{
            if (e.getCode() == KeyCode.Up){
                pane.increasedSpeed();
            }
            else if(e.getCode() == KeyCode.DOWN) {
                pane.decreasedSpeed();
            }
        });

        //Create a scene and place it in the stage
        Scene scene = new Scene(pane, 600, 100);
        primaryStage.setTitle("RacingCar");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Request Focus
        pane.requestFocus();
    }
    
}

// CarPane.Java
import javafx.animation.*;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.paint.Color;
import javafx.util.Duration;

public class CarPane extends Pane{
    private double x = 0;
    private double y = 100;
    private double radius = 5;
    private Rectangle rectangle;
    private Polygon polygon;
    private Circle circle1;
    private Circle circle2;
    private Timeline animation;

    // Construct and animate a default Carpane
    CarPane() {
        drawCar();
        animationa = new Timeline(new KeyFrame(Duration.millis(50), e->moveCar()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }

    // Create a car an place it in the pane
    private void drawCar(){
        getChildren().clear();
        rectangle = new Rectangle(x, y-20, 50, 10);
        polygon = new Polygon(x+10, y-20, x+20, y-30, x+30, y-30, x+40, y-20);
        circle1 =  new Circle(x+15, y-5, radius);
        circle2 = new Circle(x+35, y-5, radius);
        getChildren().addAll(rectangle, circle1, circle2, polygon);
    }

    // Pause animation
    public void pause(){
        animation.pause();
    }

    // Play animation
    public void play(){
        animation.play();
    }

    // Increase rate by 1
    public void increaseSpeed(){
        animation.setRate(animation.getRate()+1);
    }

    // decrease rate by 1
    public void decreaseSpeed(){
        animation.setRate(animation.getRate() > 0 ? animation.getRate() - 1:0);
    }

    // Redraw car with new x value
    protected void moveCar() {
        if (x <= getWidth()) {
            x += 1;
        }
        else {
            x=0;
            drawCar();
        }
    }
}



