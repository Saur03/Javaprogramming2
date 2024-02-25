package com.example.lab7;
import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;

public class lab7 extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();

        Text name = new Text("Saurabh Chawla");
        name.setFont(Font.font("Impact", FontWeight.BOLD, FontPosture.REGULAR, 40));

        Text project = new Text("Snake Game");
        project.setFont(Font.font("Impact", FontWeight.BOLD, FontPosture.REGULAR, 20));

        name.setFill(Color.BLUE);
        name.setStroke(Color.BLACK);
        root.setCenter(name);
        root.setBottom(project);
        BorderPane.setAlignment(project, Pos.BOTTOM_CENTER);

        // Animation1: Fade In Transition
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), name);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(.5);
        fadeTransition.setCycleCount(2);
        fadeTransition.setAutoReverse(true);

        // Animation2: Rotate In Transition
        RotateTransition rot = new RotateTransition(Duration.millis(1000), project);
        rot.setByAngle(360);
        rot.setInterpolator(Interpolator.LINEAR);
        rot.setCycleCount(1);

        // Animation3: Translate Transition
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(1000), project);
        translateTransition.setFromX(-250);
        translateTransition.setFromY(-250);
        translateTransition.setToX(0);
        translateTransition.setToY(0);

        // Animation4: Scale Transition
        ScaleTransition scale = new ScaleTransition(Duration.millis(2000), name);
        scale.setByY(1f);
        scale.setByX(1f);
        scale.setAutoReverse(true);
        scale.setCycleCount(2);

        // Animation5:  Color Transition
        FillTransition fillTransition = new FillTransition(Duration.millis(3000), name, Color.RED, Color.YELLOW);

        //Animation6: Stroke Transition
        StrokeTransition strokeTransition = new StrokeTransition(Duration.millis(3000),project, Color.BLUE, Color.GOLD);

        //Sequential Transition
        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().addAll(
                fadeTransition,
                rot,
                fillTransition,
                scale,
                strokeTransition
        );

        //Parallel Transition
        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(
                fadeTransition,
                rot,
                fillTransition,
                scale,
                strokeTransition
        );
        parallelTransition.play();

        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Animation lab7");
        stage.setScene(scene);
        stage.show();
        slowFade(Duration.millis(2000), project).play();
    }
    public static void main(String[] args)
    {
        launch();
    }
    public FadeTransition slowFade(Duration duration, Node node){
        FadeTransition fadeTransition = new FadeTransition(duration, node);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setCycleCount(4);
        fadeTransition.setAutoReverse(true);
        return fadeTransition;
    }

}
