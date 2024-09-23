package week10;

import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        String[] words = {"write", "that", "program"};

        do {
            String word = words[rand.nextInt(words.length)]; // that
            char[] puzzle = new char[word.length()];

            for (int i = 0; i < word.length(); i++) {
                puzzle[i] = '*';
            } // puzzle = ****

            int misses = 0;

            while (new String(puzzle).contains("*")) {
                System.out.print("(Guess) Enter a letter in word " + new String(puzzle) + "> ");
                String input = scan.nextLine();
                if (input == null | input.isEmpty()) continue;
                char guess = input.charAt(0);

                if (isAlreadyInWord(puzzle, guess)) {
                    System.out.println(guess + " is already in the word");
                    continue;
                }
                if (!processGuess(word, puzzle, guess)) {
                    misses++;
                }
            }

            System.out.println("The word is " + word + ". You missed " + misses + " time.");

            System.out.print("Do you want to guess another word? Enter y or n> ");
        } while (scan.nextLine().trim().equals("y"));
        scan.close();
        System.out.println("Game over. Thanks for playing!");
    }

    private static boolean processGuess(String word, char[] puzzle, char guess) {
        boolean isCorrect = false;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                puzzle[i] = guess;
                isCorrect = true;
            }
        }
        if (!isCorrect) {
            System.out.println(guess + " is not in the word");
        }
        return isCorrect;
    }

    private static boolean isAlreadyInWord(char[] puzzle, char guess) {
        for (char c : puzzle) {
            if (c == guess) {
                return true;
            }
        }
        return false;
    }
}
