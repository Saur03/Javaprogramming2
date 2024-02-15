import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CalculatorApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculator");

        // Create GridPane
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        // Create Text objects
        Text firstNumberText = createText("First Number");
        Text secondNumberText = createText("Second Number");
        Text sumText = createText("Sum");

        // Create TextFields
        TextField firstNumberField = new TextField();
        TextField secondNumberField = new TextField();
        TextField sumField = new TextField();
        sumField.setEditable(false); // Make the sum field uneditable

        // Create Calculate Button
        Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Anonymous inner class handle method
                String num1Str = firstNumberField.getText();
                String num2Str = secondNumberField.getText();

                if (isValidInput(num1Str) && isValidInput(num2Str)) {
                    double num1 = Double.parseDouble(num1Str);
                    double num2 = Double.parseDouble(num2Str);
                    double sum = num1 + num2;
                    sumField.setText(Double.toString(sum));
                } else {
                    showErrorAlert("Invalid input");
                }
            }
        });

        // Add nodes to the GridPane
        gridPane.add(firstNumberText, 0, 0);
        gridPane.add(secondNumberText, 0, 1);
        gridPane.add(sumText, 0, 2);

        gridPane.add(firstNumberField, 1, 0);
        gridPane.add(secondNumberField, 1, 1);
        gridPane.add(sumField, 1, 2);

        gridPane.add(calculateButton, 1, 3);

        // Load the pi symbol image
        Image piSymbolImage = new Image("path/to/pi_symbol_image.png");
        ImageView piSymbolImageView = new ImageView(piSymbolImage);
        piSymbolImageView.setFitWidth(50);
        piSymbolImageView.setFitHeight(50);

        gridPane.add(piSymbolImageView, 2, 0, 1, 3); // Span 3 rows

        // Create Scene
        Scene scene = new Scene(gridPane, 500, 500);

        // Apply Scene to Stage
        primaryStage.setScene(scene);

        // Show the Stage
        primaryStage.show();
    }

    // Helper method to check if input is a valid double
    private boolean isValidInput(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Helper method to create Text objects with specified font properties
    private Text createText(String labelText) {
        Text text = new Text(labelText);
        text.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 18));
        text.setFill(javafx.scene.paint.Color.DIMGRAY);
        return text;
    }

    // Helper method to show an error alert
    private void showErrorAlert(String message) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
