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

        // Аналіз стану гри та виведення результату
        printGameResult(gameBoard);
    }
    // для друкування ігрового поля
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
    // для заповнення ігрового поля
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
    // для аналізу стану гри та виведення результату
    public static void printGameResult(char[][] gameBoard) {
        if (checkImpossible(gameBoard)) {
            System.out.println("Impossible");
        } else if (checkWinner(gameBoard, 'X')) {
            System.out.println("X wins");
        } else if (checkWinner(gameBoard, 'O')) {
            System.out.println("O wins");
        } else if (checkDraw(gameBoard)) {
            System.out.println("Draw");
        } else {
            System.out.println("Game not finished");
        }
    }
    // для перевірки неможливості гри
    public static boolean checkImpossible(char[][] gameBoard) {
        int countX = countSymbol(gameBoard, 'X');
        int countO = countSymbol(gameBoard, 'O');

        int diff = Math.abs(countX - countO);

        if (diff > 1 || (checkWinner(gameBoard, 'X') && checkWinner(gameBoard, 'O'))) {
            return true;
        }

        return false;
    }
    // перевірки переможця гри
    public static boolean checkWinner(char[][] gameBoard, char symbol) {
        // Перевірка рядків і стовпців
        for (int i = 0; i < 3; i++) {
            if ((gameBoard[i][0] == symbol && gameBoard[i][1] == symbol && gameBoard[i][2] == symbol) ||
                    (gameBoard[0][i] == symbol && gameBoard[1][i] == symbol && gameBoard[2][i] == symbol)) {
                return true;
            }
        }

        // Перевірка діагоналей
        if ((gameBoard[0][0] == symbol && gameBoard[1][1] == symbol && gameBoard[2][2] == symbol) ||
                (gameBoard[0][2] == symbol && gameBoard[1][1] == symbol && gameBoard[2][0] == symbol)) {
            return true;
        }

        return false;
    }
    //для перевірки нічиєї
    public static boolean checkDraw(char[][] gameBoard) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
    //для підрахунку кількості символів на ігровому полі
    public static int countSymbol(char[][] gameBoard, char symbol) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (gameBoard[i][j] == symbol) {
                    count++;
                }
            }
        }
        return count;
    }
}