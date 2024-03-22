package FileHandling;
import java.util.*;
import java.io.*;

public class Exercise_12_15 {
    public static void main(String[] args) throws Exception {
        // Check if file exists
        Random random=new Random();
        File file = new File("Exercise12_15.txt");
        if (file.exists()) {
            System.out.println("File already exists");
        }else{
            try (
                    // Create output file
                    BufferedWriter output = new BufferedWriter(new FileWriter(file));
            ) {
                // Write 100 integers created randomly to file
                for (int i = 0; i < 100; i++) {
                    String line;
                    int randomNum=random.nextInt(100)+1;
                    line= String.valueOf(randomNum);
                    output.write(line);
                    output.write(" ");

                }
            }catch (IOException e){
                throw new RuntimeException(e);
            }

        }


        // Create and ArrayList
        ArrayList<Integer> list = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileReader(file))) {
            // Set delimiter to space
            scanner.useDelimiter(" ");


            while (scanner.hasNextInt()) {
                list.add(scanner.nextInt());
            }

            Collections.sort(list);

        }catch (IOException e){
            throw new RuntimeException(e);
        }

        // Display data in increasing order
        System.out.print(list);

    }
}

