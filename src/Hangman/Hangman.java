package Hangman;

import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {

        System.out.println("HANGMAN");
        System.out.println("Guess the word: ");

        String secretWord = "java";

        Scanner scanner = new Scanner(System.in);

        String playerGuess = scanner.next();


        if (playerGuess.equals(secretWord)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }

        scanner.close();
    }
}