/*
Program Name- Ball Pane
Author Name-Saurabh Chawla
Date- February 16, 2024
 */
package com.example.exercise15_03;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class Exercise15_03 extends Application {
    private BallPane ballPane = new BallPane();

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Hold four buttons in a HBox
        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER);
        Button btLeft = new Button("Left");
        Button btRight = new Button("Right");
        Button btUp = new Button("Up");
        Button btDown = new Button("Down");
        hBox.getChildren().addAll(btLeft, btRight, btUp, btDown);

        // Create and register the handler
        btLeft.setOnAction(e -> ballPane.left());
        btRight.setOnAction(e -> ballPane.right());
        btUp.setOnAction(e -> ballPane.up());
        btDown.setOnAction(e -> ballPane.down());

        // Create a border pane
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(0, 10, 5, 10));
        pane.setCenter(ballPane);
        pane.setBottom(hBox);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 250, 250);
        primaryStage.setTitle("Exercise15_03"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args) {
        launch();
    }
}