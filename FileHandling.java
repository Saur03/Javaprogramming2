package com.example.notepal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.*;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 500, 500);
        TextField fileName = new TextField();
        TextArea content = new TextArea();
        content.setWrapText(true);
        Button saveButton = new Button("Save");
        saveButton.setOnAction(e->{
            try {
                BufferedWriter out = new BufferedWriter(new FileWriter(fileName.getText()));
                out.write(content.getText());
                out.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        Button loadButton = new Button("Load");
        loadButton.setOnAction(e->{
            content.setText("");
            String line = "";
            try {
                BufferedReader in = new BufferedReader(new FileReader(fileName.getText()));
                while((line = in.readLine()) != null){
                    content.appendText(line + "\n");
                    /*
                    line = "This is another example" != null ? TRUE
                    line = "This is another example" != null ? TRUE
                    repeat This is another example
                   repeat This is another example
                    repeat This is another exampleThis is another example
                    repeat This is another exampleThis is another exampleThis is another exampleThis is another exampleThis is another
                     */
                }
                in.close();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        HBox controls = new HBox();
        controls.getChildren().addAll(saveButton, loadButton);
        root.setBottom(controls);
        root.setTop(fileName);
        root.setCenter(content);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}