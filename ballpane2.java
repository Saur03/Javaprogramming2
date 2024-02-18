package com.example.exercise15_03;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.control.Button;
import javafx.stage.Stage;

// BallPane is a custom pane that can be used in a JavaFX application,
// and it inherits functionality from the Pane class.
public class BallPane extends Pane{

    // represents a circle with a radius of 20, positioned at (20, 20) coordinates.
    private Circle circle = new Circle(20, 20, 20);

    // Construct a default ball pane
    public BallPane() {
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        getChildren().add(circle); // The circle is added to the BallPane using getChildren().add(circle).
    }

    // Move ball left
    //If the current x-coordinate of the circle is greater than the radius,
    // it decreases the x-coordinate by 20.
    // Otherwise, it stays at the current x-coordinate.
    // The y-coordinate remains unchanged.
    public void left() {
        circle.setCenterX(circle.getCenterX() > circle.getRadius() ?
                circle.getCenterX() - 20 : circle.getCenterX());
        circle.setCenterY(circle.getCenterY());
    }

    // Move ball right
    //If the current x-coordinate of the circle is less than the width of the BallPane minus the radius,
    // it increases the x-coordinate by 20.
    // Otherwise, it stays at the current x-coordinate.
    // The y-coordinate remains unchanged.
    public void right() {
        circle.setCenterX(circle.getCenterX() < getWidth() - circle.getRadius() ?
                circle.getCenterX() + 20 : circle.getCenterX());
        circle.setCenterY(circle.getCenterY());
    }

    // Move ball up
    //If the current y-coordinate of the circle is greater than the radius,
    // it decreases the y-coordinate by 20.
    // Otherwise, it stays at the current y-coordinate.
    // The x-coordinate remains unchanged.
    public void up() {
        circle.setCenterY(circle.getCenterY() > circle.getRadius() ?
                circle.getCenterY() - 20 : circle.getCenterY());
        circle.setCenterX(circle.getCenterX());
    }

    // Move ball down
    // If the current y-coordinate of the circle is less than the height of the BallPane minus the radius,
    // it increases the y-coordinate by 20.
    // Otherwise, it stays at the current y-coordinate.
    // The x-coordinate remains unchanged.
    public void down() {
        circle.setCenterX(circle.getCenterX());
        circle.setCenterY(circle.getCenterY() < getHeight() - circle.getRadius() ?
                circle.getCenterY() + 20 : circle.getCenterY());
    }

}
