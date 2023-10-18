package Hangman;

import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {

        String[] words = {"python", "java", "javascript", "kotlin"};

        Random random = new Random();
        int randomIndex = random.nextInt(words.length);
        String secretWord = words[randomIndex];


        StringBuilder displayWord = new StringBuilder(secretWord.length());
        for (int i = 0; i < secretWord.length(); i++) {
            if (i < 2) {
                displayWord.append(secretWord.charAt(i));
            } else {
                displayWord.append("-");
            }
        }

        System.out.println("HANGMAN");
        System.out.println("Guess the word " + displayWord + ": ");

        Scanner scanner = new Scanner(System.in);

        String playerGuess = scanner.next();

        if (playerGuess.equals(secretWord)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }

        System.out.println("The correct word was: " + secretWord);

        scanner.close();
    }
}
