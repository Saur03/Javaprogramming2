package com.example.demo;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import java.util.ArrayList;
import javafx.scene.text.Text;
public class Exercise_15_01 extends Application {
 private Text matchText;
 @Override // Override the start method in the Application class
 public void start(Stage primaryStage) {
 // Create a VBox
 VBox vBox = new VBox();
 vBox.setAlignment(Pos.CENTER);
 // Create a HBox
 HBox hBox = new HBox(5);
 hBox.setAlignment(Pos.CENTER);
 getCards(hBox);
 // Create a button
 Button btRefresh = new Button("Refresh");
 // Process events
 btRefresh.setOnAction(e -> getCards(hBox));
 // Place nodes in vbox
 vBox.getChildren().addAll(hBox, btRefresh);
 // Create a scene and place it in the stage
 Scene scene = new Scene(vBox);
 primaryStage.setTitle("Exercise_15_01"); // Set the stage title
 primaryStage.setScene(scene); // Place the scene in the stage
 primaryStage.show(); // Display the stage
 }
 /** Returns a list with numbers 1-52 stored in random order */
 private void getCards(HBox pane) {
 pane.getChildren().clear();
 // Create a deck of card
 ArrayList<Integer> cards = new ArrayList<>();
 for (int i = 0; i < 52; i++) {
 cards.add(i + 1);
 }
 // shuffle deck
 java.util.Collections.shuffle(cards);
 for (int i = 0; i < 4; i++) {
 int cardNumber = cards.get(i);
 ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream("card/" + cardNumber + ".png")));
 pane.getChildren().add(imageView);
 };
 }
 public static void main(String[] args) {
 launch(args);
 }
 }
