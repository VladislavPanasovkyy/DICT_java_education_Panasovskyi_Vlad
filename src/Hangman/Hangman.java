package Hangman;

import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        boolean playGame = true;
        Scanner scanner = new Scanner(System.in);

        while (playGame) {
            System.out.println("HANGMAN");
            System.out.println("Type \"play\" to play the game, \"exit\" to quit: > ");
            String choice = scanner.next();

            if ("exit".equalsIgnoreCase(choice)) {
                playGame = false;
            } else if ("play".equalsIgnoreCase(choice)) {
                playHangmanGame();
            } else {
                System.out.println("Invalid choice. Please type \"play\" to play or \"exit\" to quit.");
            }
        }

        scanner.close();
    }

    private static void playHangmanGame() {

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
            String input = scanner.next().toLowerCase();

            if (input.length() != 1) {
                System.out.println("You should input a single letter");
                continue;
            }

            char letter = input.charAt(0);

            if (!Character.isLowerCase(letter)) {
                System.out.println("Please enter a lowercase English letter");
                continue;
            }

            if (usedLetters.toString().contains(String.valueOf(letter))) {
                System.out.println("You've already guessed this letter");
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
                System.out.println("You guessed the word " + secretWord + "!");
                System.out.println("You survived!");
                break;
            }
        }

        if (remainingAttempts == 0) {
            System.out.println("You lost!");
            System.out.println("The correct word was: " + secretWord);
        }
    }
}