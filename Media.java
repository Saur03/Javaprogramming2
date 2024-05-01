package com.example.labs13_14_15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.net.URISyntaxException;

public class Lab13 extends Application {
    MediaPlayer player = null;
    Media media;
    boolean isMuted=false;

    @Override
    public void start(Stage stage) throws URISyntaxException {
        BorderPane root=new BorderPane();

        Button effectToggle=new Button("effects toggle");
        Button backgroundToggle=new Button("background song");
        root.setTop(effectToggle);
        root.setBottom(backgroundToggle);

        Scene scene = new Scene(root, 750, 400);
        stage.setTitle("Labs13-14!");
        stage.setScene(scene);
        stage.show();

        String backgroundPath= "background.mp3";
        String backgroundURI=getClass().getResource(backgroundPath).toURI().toString();

        Media backGroundMedia=new Media(backgroundURI);

        MediaPlayer backGroundPlayer=new MediaPlayer(backGroundMedia);
        backGroundPlayer.play();

        String path="glitch.mp3";
        String uriPath=getClass().getResource(path).toURI().toString();

        String path2="sound2.mp3";
        String uriPath2=getClass().getResource(path2).toURI().toString();

        String path3="sound3.mp3";
        String uriPath3=getClass().getResource(path3).toURI().toString();

        String path4="sound4.mp3";
        String uriPath4=getClass().getResource(path4).toURI().toString();



        media=new Media(uriPath);
        player=new MediaPlayer(media);






        scene.setOnKeyPressed(event -> {
            switch (event.getCode()){
                case DOWN:
                    media=new Media(uriPath);
                    player=new MediaPlayer(media);
                    player.setMute(isMuted);
                    player.play();
                    break;
                case UP:
                    media=new Media(uriPath2);
                    player=new MediaPlayer(media);
                    player.setMute(isMuted);
                    player.play();
                    break;
                case RIGHT:
                    media=new Media(uriPath3);
                    player=new MediaPlayer(media);
                    player.setMute(isMuted);
                    player.play();
                    break;
                case LEFT:
                    media=new Media(uriPath4);
                    player=new MediaPlayer(media);
                    player.setMute(isMuted);
                    player.play();
                    break;

            }
        });


        //BUTTON TOGGLE CODE

        effectToggle.setOnAction(event -> {
            isMuted = !isMuted;
            if (player != null) {
                player.setMute(isMuted);
            }
            root.requestFocus();
        });

        backgroundToggle.setOnAction(event -> {
            if(backGroundPlayer.isMute()){
                backGroundPlayer.setMute(false);
            }else{
                backGroundPlayer.setMute(true);
            }
            root.requestFocus();
        });



        root.requestFocus();
        root.setFocusTraversable(true);


    }

    public static void main(String[] args) {
        launch();
    }

}
