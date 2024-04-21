package com.example.snake;

import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static javafx.scene.input.KeyCode.ESCAPE;
import static javafx.scene.input.KeyCode.W;
import static javafx.scene.paint.Color.RED;

public class HelloApplication extends Application {

    public static Stage mainStage;

    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        mainStage.setTitle("High Score");
        mainStage.setScene(new TitleScene());
        mainStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
class TitleScene extends Scene {
    public TitleScene(){
        super(new TitlePane(), 600, 400);
    }
}
class TitlePane extends BorderPane {

    public TitlePane(){

        Text game = new Text("Snake Game");


        game.setFont(Font.font("Calibri", FontWeight.BLACK, FontPosture.ITALIC, 88));
        game.setFill(Color.WHITE);
        game.setStroke(Color.GAINSBORO);
        this.setCenter(game);


        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), game);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.setCycleCount(2);

        RotateTransition rot = new RotateTransition(Duration.millis(4000), game);
        rot.setByAngle(360);
        rot.setInterpolator(Interpolator.LINEAR);
        rot.setCycleCount(1);

        Image image = new Image("intro.jpg");
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(backgroundImage));


        StrokeTransition strokeTransition = new StrokeTransition(Duration.millis(3000),
                game, Color.BLACK, Color.GOLD);

        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().addAll(
                fadeTransition,
                rot,
                strokeTransition
        );
        sequentialTransition.play();

        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(fadeTransition, rot,
               strokeTransition);
        parallelTransition.setOnFinished(event -> {
            // After the animations, switch to the IntroScene
            HelloApplication.mainStage.setScene(new IntroScene());
        });
        parallelTransition.play();
    }


}

class IntroScene extends Scene {

    public IntroScene() {
        super(new IntroPane(), 600, 400);
    }
}

class MainScene extends Scene {

    public MainScene() {
        super(new MainPane(), 600, 400);
        MainPane mainPane = (MainPane) getRoot();
        setOnKeyPressed(event -> mainPane.handleKeyPressed(event));
        mainPane.startGameLoop();

    }
}

class IntroPane extends BorderPane {
    Media media = null;

    MediaPlayer mediaPlayer = null;
    Boolean sounds = true;

    public IntroPane() {
        VBox vBox = new VBox(20);
        Button play = new Button("Play Game");
        play.setMaxSize(100, 200);
        ToggleButton sound = new ToggleButton("Sound On");
        sound.setMaxSize(100, 200);
        Button score = new Button("High Scores");
        score.setMaxSize(100, 200);
        Button exit = new Button("Exit Game");
        exit.setMaxSize(100, 200);
        vBox.getChildren().addAll(play, sound, score, exit);
        vBox.setAlignment(Pos.CENTER);
        this.setCenter(vBox);
        String song = new File("Music/593911__szegvari__egypt-action-cinematic-soundtrack-background-music.wav").toURI().toString();
        media=new Media(song);
        mediaPlayer=new MediaPlayer(media);
        mediaPlayer.play();
        sound.setOnAction(e->{
            if(sound.isSelected()){
                sound.setText("Sound on");
                sounds=true;
                mediaPlayer.play();
            }
            else {
                sound.setText("Sound off");
                sounds = false;
                mediaPlayer.pause();
            }


        });
        score.setOnAction(e->{
            Stage mainStage = HelloApplication.mainStage;
            mainStage.setScene(new high());


        });

        Image image = new Image("back.jpeg");
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(backgroundImage));

        // Handle Play Game button action
        play.setOnAction(e -> {
            Stage mainStage = HelloApplication.mainStage;
            mainStage.setScene(new MainScene());
        });
        exit.setOnAction(e -> HelloApplication.mainStage.close());

    }
}
class high extends Scene{
    public high() {
        super(new highScore(), 600, 400);

    }

}
class highScore extends BorderPane{
    private TextArea area;
    Button back = new Button("Back");


    public highScore() {
        area = new TextArea();
        loadScores();
        area.setEditable(false);
        setCenter(area);
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().add(back);
        setBottom(hBox);
        back.setOnAction(e->{
            Stage mainStage = HelloApplication.mainStage;
            mainStage.setScene(new IntroScene());

        });

    }

    private void loadScores() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("highScore.txt"));
            ArrayList<Integer> scores = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] num = line.split(" ");
                for (String n : num) {
                    scores.add(Integer.parseInt(n));
                }
            }
            reader.close();

            // Sort scores in descending order
            Collections.sort(scores, Collections.reverseOrder());
            BackgroundFill fill = new BackgroundFill(Color.RED, null, null);

            // Set the background of the TextArea
            area.setBackground(new Background(fill));

            area.setText("HIGH SCORES:"+"\n");

            for (int s : scores) {
                area.appendText(s + "\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}

class MainPane extends BorderPane {
    private static final int SPEED = 10;
    private static final int WIDTH = 30;
    private static final int HEIGHT = 20;
    private static final int CORNER_SIZE = 20;
    private static final List<Corner> snake = new ArrayList<>();
    private static Dir direction = Dir.left;
    private static boolean gameOver = false;
    private static final Random rand = new Random();
    private int score = 0;
    private static int highScore = 0;
    Media media = null;
    MediaPlayer mediaPlayer= null;
    Media media1 = null;
    MediaPlayer mediaPlayer1 = null;

    public Media getMedia() {
        String song = new File("Music/493163__breviceps__buzzer-sounds-wrong-answer-error.wav").toURI().toString();
        media = new Media(song);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
        return media;
    }

    private static final String HIGH_SCORE_FILE = "highscore.txt";

    public enum Dir {
        left, right, up, down
    }

    public static class Corner {
        int x;
        int y;

        public Corner(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int foodX;
    private static int foodY;
    private Stage stage;

    public MainPane() {


        initializeGame();
        setFocusTraversable(true);
        drawGame();
    }

    public void handleKeyPressed(javafx.scene.input.KeyEvent event) {
        if (!gameOver) {
            switch (event.getCode()) {
                case W:
                    if (direction != Dir.down)
                        direction = Dir.up;
                    break;
                case A:
                    if (direction != Dir.right)
                        direction = Dir.left;
                    break;
                case S:
                    if (direction != Dir.up)
                        direction = Dir.down;
                    break;
                case D:
                    if (direction != Dir.left)
                        direction = Dir.right;
                    break;
            }
        }
    }

    public void startGameLoop() {
        new AnimationTimer() {
            long lastTick = 0;

            public void handle(long now) {
                if (gameOver) {
                    stop();
                    return;
                }

                if (lastTick == 0) {
                    lastTick = now;
                    tick();
                    drawGame();
                    return;
                }

                if (now - lastTick > 1000000000 / SPEED) {
                    lastTick = now;
                    tick();
                    drawGame();
                }
            }
        }.start();
    }

    private static void saveHighScore() {

        try {
            FileWriter writer = new FileWriter(HIGH_SCORE_FILE);
            writer.write(Integer.toString(highScore));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void initializeGame() {
        snake.clear();
        gameOver = false;

        snake.add(new Corner(WIDTH / 2, HEIGHT / 2));
        snake.add(new Corner(WIDTH / 2, HEIGHT / 2));
        snake.add(new Corner(WIDTH / 2, HEIGHT / 2));
        direction = Dir.left;

        newFood();
    }

    private void tick() {
        // Move the snake
        for (int i = snake.size() - 1; i >= 1; i--) {
            snake.get(i).x = snake.get(i - 1).x;
            snake.get(i).y = snake.get(i - 1).y;
        }

        switch (direction) {
            case up:
                snake.get(0).y--;
                break;
            case down:
                snake.get(0).y++;
                break;
            case left:
                snake.get(0).x--;
                break;
            case right:
                snake.get(0).x++;
                break;
        }

        // Check for collision with walls
        if (snake.get(0).x < 0 || snake.get(0).x >= WIDTH || snake.get(0).y < 0 || snake.get(0).y >= HEIGHT) {
            gameOver = true;
            gameOver();
            return;
        }

        // Check if snake eats food
        if (foodX == snake.get(0).x && foodY == snake.get(0).y) {
            snake.add(new Corner(-1, -1));
            String song = new File("Music/144320__fumiya112__pow.mp3").toURI().toString();
            media1= new Media(song);
            mediaPlayer1 = new MediaPlayer(media1);
            mediaPlayer1.play();
            newFood();
            score++;
        }

        // Check for self-destruction
        for (int i = 1; i < snake.size(); i++) {
            if (snake.get(0).x == snake.get(i).x && snake.get(0).y == snake.get(i).y) {
                gameOver = true;
                gameOver();
                return; // Exit the method to stop further execution
            }
        }

        // Update high score and draw game if game is still ongoing

        updateHighScore();
        drawGame();

    }
    private void updateHighScore() {
        if (score > highScore) {
            highScore = score;
            saveHighScore();
            System.out.println("New High Score: " + highScore); // Add this line
        }
    }


    private void drawGame() {
        this.setStyle("-fx-background-color: black;");
        this.getChildren().clear();

        // Draw snake
        for (Corner c : snake) {
            Rectangle rect = new Rectangle(c.x * CORNER_SIZE, c.y * CORNER_SIZE, CORNER_SIZE, CORNER_SIZE);
            rect.setFill(Color.GREEN);
            this.getChildren().add(rect);
        }

        // Draw food
        Rectangle food = new Rectangle(foodX * CORNER_SIZE, foodY * CORNER_SIZE, CORNER_SIZE, CORNER_SIZE);
        food.setFill(RED);
        this.getChildren().add(food);

        Label scoreLabel = new Label("Score: " + score + "  High Score: " + highScore);
        scoreLabel.setTextFill(Color.WHITE);
        scoreLabel.setFont(new Font("Arial", 24));
        HBox scoreBox = new HBox();
        scoreBox.getChildren().add(scoreLabel);
        scoreBox.setAlignment(Pos.CENTER);
        this.setTop(scoreBox);


        // Add game over label if game is over
        if (gameOver) {
            Label gameOverLabel = new Label("Game Over!");
            gameOverLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: red;");
            HBox hBox = new HBox();
            hBox.getChildren().add(gameOverLabel);
            hBox.setAlignment(Pos.CENTER);
            this.setCenter(hBox);


        }



    }


    private static void newFood() {
        foodX = rand.nextInt(WIDTH);
        foodY = rand.nextInt(HEIGHT);
    }
    private void switchToCreditScene() {
        Stage stage = (Stage) getScene().getWindow();
        stage.setScene(new CreditScene());
    }

    private void gameOver() {
        gameOver = true;
        drawGame();
        getMedia();
        PauseTransition delay = new PauseTransition(Duration.seconds(3));
        delay.setOnFinished(event -> switchToCreditScene());
        delay.play();
    }


}
class CreditScene extends Scene {
    public CreditScene() {

        super(new CreditPane(), 600, 400);
    }
}

class CreditPane extends BorderPane{
    public CreditPane() {
        Text game = new Text("Snake Game");
        Text name = new Text("Created by\n" +
                "Sai Krishna Suresh\n" +
                "Anandhu Pullikkal\n" +
                "Saurabh Chawla");
        Button menu = new Button("Menu");
        menu.setMaxSize(100,200);
        Button exit = new Button("Exit");
        exit.setMaxSize(100,200);
        Button play = new Button("Play Again");
        menu.setOnAction(e->{
            Stage mainStage = HelloApplication.mainStage;
            mainStage.setScene(new IntroScene());

        });
        play.setOnAction(e->{
            Stage mainStage = HelloApplication.mainStage;
            mainStage.setScene(new MainScene());
        });



        exit.setOnAction(e -> HelloApplication.mainStage.close());
        VBox vBox = new VBox();
        vBox.getChildren().addAll(play,menu,exit);
        this.setRight(vBox);


        name.setFont(Font.font("Times New Roman", FontWeight.BLACK, FontPosture.REGULAR, 20));

        setCenter(game);
        setBottom(name);


        game.setFont(Font.font("Calibri", FontWeight.BLACK, FontPosture.ITALIC, 88));
        game.setFill(Color.GREEN);
        game.setStroke(Color.GAINSBORO);

        FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), game);
        fadeTransition.setFromValue(5);
        fadeTransition.setToValue(0);
        fadeTransition.setCycleCount(2);
        fadeTransition.setAutoReverse(true);

        ScaleTransition scale = new ScaleTransition(Duration.millis(2000), game);
        scale.setByY(1f);
        scale.setByX(0);
        scale.setAutoReverse(true);
        scale.setCycleCount(2);

        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(1000), name);
        translateTransition.setFromX(-400);
        translateTransition.setFromY(-250);
        translateTransition.setToX(400);
        translateTransition.setToY(-100);


        FillTransition fillTransition = new FillTransition(Duration.millis(3000), name, Color.BLACK, Color.BROWN);
        Image image = new Image("credit.jpg");
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(backgroundImage));


        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().addAll(fadeTransition, translateTransition, fillTransition, scale);
        sequentialTransition.play();

        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(fadeTransition,
                scale, translateTransition, fillTransition);
        parallelTransition.play();
    }
}