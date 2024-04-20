import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Random;

public class Exercise17_01 {
    public static void main(String[] args) {
        String fileName = "Exercise17_01.txt";

        try {
            // Create FileWriter and BufferedWriter objects
            FileWriter fileWriter = new FileWriter(fileName, true); // 'true' parameter for append mode
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Generate and write 100 integers separated by space
            Random random = new Random();
            for (int i = 0; i < 100; i++) {
                int randomNumber = random.nextInt(1000); // Generates integers between 0 and 999
                bufferedWriter.write(randomNumber + " ");
            }

            // Close BufferedWriter
            bufferedWriter.close();
            System.out.println("Data has been written to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
