/*
Author- Saurabh Chawla
Date- 28 February 2024
 */

 package com.example.lab7;
 import javafx.application.Application;
 import javafx.scene.Scene;
 import javafx.scene.layout.Pane;
 import javafx.geometry.Insets;
 import javafx.stage.Stage;
 import javafx.scene.image.Image;
 import javafx.scene.image.ImageView;
 
 
 public class Lab8 extends Application {
     @Override // Override the start method in the Application class
     public void start(Stage primaryStage) {
         //Create a pane
         Pane pane = new Pane();
         pane.setPadding(new Insets(5, 5, 5, 5));
         // Load the image
         Image image = new Image("file:\\C:\\Users\\rudra\\IdeaProjects\\lab7\\dm.jpeg");
         ImageView image1 = new ImageView(image);
         image1.setFitHeight(40);
         image1.setFitHeight(40);
         pane.getChildren().add(image1);
 
         pane.setOnKeyPressed(e->{
             switch (e.getCode()) {
                 // we use couple of System.out.println for better understanding 
                 // System.out.println("Enter LEFT arrow")
                 // int currentX = image1.getX(); // we get the X coordinate of image1
                 // int newX = currentX>10 ? currentX-10 : currentX
                 // this means that if the current X-coordinate is greater than 10, decrease it by 10; otherwise keep it same
                 // image1.setX(newX); // we have set the new X-coordinate for image1
                 // System.out.println("Updated X-coordinate: " + newX);
                 case LEFT:
                     image1.setX(image1.getX() > 10 ? image1.getX() - 10 : image1.getX());
                     break;
 
                 case UP:
                     image1.setY(image1.getY() > 10 ? image1.getY() - 10: image1.getY());
                     break;
 
                 case RIGHT:
                     image1.setX(image1.getX() < pane.getWidth() - image1.getFitWidth() - 10 ? image1.getX() + 10 : image1.getX());
                     break;
 
                 case DOWN:
                     image1.setY(image1.getY() < pane.getHeight() - image1.getFitHeight() - 10 ? image1.getY() + 10 : image1.getY());
                     break;
             }
         });
 
         // Create a scene and place it in the stage
         Scene scene = new Scene(pane, 1024, 768);
         primaryStage.setTitle("Lab8"); // Set the stage title
         primaryStage.setScene(scene); // Place the scene in the stage
         primaryStage.show(); // Display the stage
 
         pane.requestFocus();
     }
 
 
     public static void main(String[] args)
     {
         launch();
     }
 }
 