package FileHandling;

import java.io.*;

public class Exercise_12_14 {
    public static void main(String[] args) {

        try {
            BufferedReader input = new BufferedReader(new FileReader("scores.txt"));
            String line;
            int count = 0;
            double total = 0;

            while ((line = input.readLine()) != null) {
                String[] scores = line.split(" ");
                for (String score : scores) {
                    total += Double.parseDouble(score);
                    count++;
                }
            }

            input.close();

            if (count == 0) {
                System.out.println("File is empty");
            } else {
                System.out.println("Total scores: " + total);
                System.out.println("Average score: " + (total / count));
            }

            BufferedWriter output = new BufferedWriter(new FileWriter("output.txt"));
            output.write("Total scores: " + total + "\n");
            output.write("Average score: " + (total / count) + "\n");
            output.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
