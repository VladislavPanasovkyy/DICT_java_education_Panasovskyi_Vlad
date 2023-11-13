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

        // Зчитування рядка від користувача
        System.out.print("Enter cells: ");
        String input = scanner.nextLine();

        // Перевірка на коректність введених даних
        if (input.length() != 9) {
            System.out.println("Invalid input. Please enter exactly 9 characters.");
            return;
        }

        // Перетворення рядка у двовимірний масив
        fillGameBoard(gameBoard, input);

        // Друкуємо ігрове поле
        printGameBoard(gameBoard);

        // Хід користувача
        makeMove(scanner, gameBoard);

        // Перевірка стану гри та виведення результату
        printGameResult(gameBoard);
    }

    // для користувача, щоб зробити хід
    public static void makeMove(Scanner scanner, char[][] gameBoard) {
        while (true) {
            System.out.print("Enter the coordinates: ");
            try {
                int row = scanner.nextInt();
                int col = scanner.nextInt();

                // Перевірка коректності координат
                if (isValidMove(row, col, gameBoard)) {
                    gameBoard[row - 1][col - 1] = 'X';
                    break;
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                scanner.nextLine(); // очистка буфера введення
            }
        }
    }

    // для перевірки коректності координат ходу
    public static boolean isValidMove(int row, int col, char[][] gameBoard) {
        if (row < 1 || row > 3 || col < 1 || col > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }

        return gameBoard[row - 1][col - 1] == ' ';
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

    // для заповнення ігрового поля на основі введеного рядка
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

    // для перевірки переможця гри
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

    // для перевірки нічиєї
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

    // для підрахунку кількості символів на ігровому полі
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