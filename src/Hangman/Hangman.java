package Hangman;

import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {

        String[] words = {"python", "java", "javascript", "kotlin"};


        Random random = new Random();
        int randomIndex = random.nextInt(words.length);
        String secretWord = words[randomIndex];

        int maxAttempts = 8;
        int remainingAttempts = maxAttempts;

        StringBuilder guessedWord = new StringBuilder(secretWord.length());
        for (int i = 0; i < secretWord.length(); i++) {
            guessedWord.append("-");
        }

        System.out.println("HANGMAN");
        System.out.println(guessedWord);

        Scanner scanner = new Scanner(System.in);

        while (remainingAttempts > 0) {
            System.out.print("Input a letter: > ");
            char letter = scanner.next().charAt(0);

            boolean letterFound = false;
            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == letter) {
                    guessedWord.setCharAt(i, letter);
                    letterFound = true;
                }
            }

            if (!letterFound) {
                remainingAttempts--;
                System.out.println("That letter doesn't appear in the word");
            }

            System.out.println(guessedWord);

            if (guessedWord.toString().equals(secretWord)) {
                System.out.println("Thanks for playing!");
                System.out.println("We'll see how well you did in the next stage");
                break;
            }
        }

        if (remainingAttempts == 0) {
            System.out.println("You ran out of attempts!");
            System.out.println("The correct word was: " + secretWord);
        }

        scanner.close();
    }
}
