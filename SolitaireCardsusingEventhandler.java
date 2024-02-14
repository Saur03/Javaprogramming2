package com.example.randomcards;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class RandomCards extends Application {
    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        HBox cardsDisplay = new HBox();
        cardsDisplay.setAlignment(Pos.CENTER);
        // 0 -> 2147483647 % 5 -> 0, 1, 2, 3, 4.png
        //0.png, 1.png, 2.png, 3.png, 4.png

        /**
         * Here we build a deck of cards
         * This is done by creating 52 cards
         * The rank we shift back into the correct range by modding 13
         * Ex) 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 % 13 = 0 (King will be represented with the rank 0)
         * 14 is a new suit Ace and 14 % 13 = 1 (Giving us the correct rank again)
         * 27 is a new suit Ace and 27 % 13 = 1 (Giving us again the correct rank)
         */
        ArrayList<Card> deck = new ArrayList<>();
        for(int i = 1; i <= 52; i++){
            deck.add(new Card(new Image(getClass().getResourceAsStream("card/" + i + ".png")), i % 13));
        }
        Text message = new Text();
        root.setTop(message);
        BorderPane.setAlignment(message, Pos.TOP_CENTER);

        Button refresh = new Button("Refresh");
        refresh.setOnAction(e->{
            //Shuffle the deck
            Collections.shuffle(deck);
            Random r = new Random();
            //Display 3 cards
            cardsDisplay.getChildren().setAll(deck.get(0), deck.get(1), deck.get(2),deck.get(3));
            //Display if a match is found
            message.setText(isMatch(new int[]{deck.get(0).getRank(), deck.get(1).getRank(), deck.get(2).getRank(),deck.get(3).getRank()}));
        });

        root.setCenter(cardsDisplay);
        root.setBottom(refresh);
        BorderPane.setAlignment(refresh, Pos.BOTTOM_CENTER);
        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Determines if there is a matching value in the array
     * @param ranks the list of values
     * @return "Match found" or and empty string ""
     */
    private String isMatch(int[] ranks) {
        //Sort the numbers ex) 12, 4 ,12  sorts to 4, 12, 12
        Arrays.sort(ranks);
        //Check each value in the list and see if it matches the next value
        //if it does stop checking and return "Match Found"
        for(int i = 0; i < ranks.length-1; i++) if(ranks[i] == ranks[i+1]) return "Match Found";
        //if no match is found return nothing
        return "";
    }

    public static void main(String[] args) {
        launch();
    }
}