import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.FileWriter;
import java.io.IOException;

public class ButtonExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Creating Buttons
        Button clearButton = new Button("Clear Text");
        clearButton.setOnAction(e -> clearTextField());

        Button numberButton = new Button("Numbers 1 to 10");
        numberButton.setOnAction(e -> writeNumbersToFile());

        // Creating VBox layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(clearButton, numberButton);

        // Creating scene
        Scene scene = new Scene(root, 300, 200);

        // Setting stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Button Example");
        primaryStage.show();
    }

    // Method to clear the textField
    private void clearTextField() {
	textField.clear();
    }

    // Method to write numbers from 1 to 10 to a file
    private void writeNumbersToFile() {
        try (FileWriter writer = new FileWriter("numbers.txt")) {
            for (int i = 1; i <= 10; i++) {
                writer.write(i + "\n");
            }
            System.out.println("Numbers 1 to 10 have been written to numbers.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
