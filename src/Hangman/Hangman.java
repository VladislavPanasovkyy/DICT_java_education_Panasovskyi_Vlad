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

        StringBuilder usedLetters = new StringBuilder();

        System.out.println("HANGMAN");
        System.out.println(guessedWord);

        Scanner scanner = new Scanner(System.in);

        while (remainingAttempts > 0) {
            System.out.print("Input a letter: > ");
            char letter = scanner.next().charAt(0);

            if (usedLetters.toString().contains(String.valueOf(letter))) {
                System.out.println("No improvements");
            } else if (secretWord.contains(String.valueOf(letter))) {
                for (int i = 0; i < secretWord.length(); i++) {
                    if (secretWord.charAt(i) == letter) {
                        guessedWord.setCharAt(i, letter);
                    }
                }
            } else {
                System.out.println("That letter doesn't appear in the word");
                remainingAttempts--;
            }

            usedLetters.append(letter);
            System.out.println(guessedWord);

            if (guessedWord.toString().equals(secretWord)) {
                System.out.println("You guessed the word!");
                System.out.println("You survived!");
                break;
            }
        }

        if (remainingAttempts == 0) {
            System.out.println("You lost!");
            System.out.println("The correct word was: " + secretWord);
        }

        scanner.close();
    }
}