package TicTacToe;

import java.util.Scanner;
public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ігрове поле 3x3
        char[][] gameBoard = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        System.out.print("Enter cells: ");
        String input = scanner.nextLine();

        if (input.length() != 9) {
            System.out.println("Invalid input. Please enter exactly 9 characters.");
            return;
        }

        fillGameBoard(gameBoard, input);

        // Друкуємо ігрове поле
        printGameBoard(gameBoard);
    }

    // Метод для друкування ігрового поля
    public static void printGameBoard(char[][] gameBoard) {
        System.out.println("---------");
        for (int row = 0; row < gameBoard.length; row++) {
            System.out.print("| ");
            for (int col = 0; col < gameBoard[row].length; col++) {
                System.out.print(gameBoard[row][col] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    // Метод для заповнення ігрового поля на основі введеного рядка
    public static void fillGameBoard(char[][] gameBoard, String input) {
        int index = 0;
        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard[row].length; col++) {
                char currentChar = input.charAt(index);
                if (currentChar == 'X' || currentChar == 'O' || currentChar == '_') {
                    gameBoard[row][col] = currentChar;
                } else {
                    System.out.println("Invalid character detected: " + currentChar);
                    return;
                }
                index++;
            }
        }
    }
}