package TicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] gameBoard = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        printGameBoard(gameBoard);

        char currentPlayer = 'X';

        while (true) {
            makeMove(scanner, gameBoard, currentPlayer);
            printGameBoard(gameBoard);

            if (checkWinner(gameBoard, currentPlayer)) {
                System.out.println(currentPlayer + " wins");
                break;
            } else if (checkDraw(gameBoard)) {
                System.out.println("Draw");
                break;
            }

            // Зміна гравця
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    public static void makeMove(Scanner scanner, char[][] gameBoard, char currentPlayer) {
        while (true) {
            System.out.print("Enter the coordinates: ");
            try {
                int row = scanner.nextInt();
                int col = scanner.nextInt();

                if (isValidMove(row, col, gameBoard)) {
                    gameBoard[row - 1][col - 1] = currentPlayer;
                    break;
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                scanner.nextLine();
            }
        }
    }

    public static boolean isValidMove(int row, int col, char[][] gameBoard) {
        if (row < 1 || row > 3 || col < 1 || col > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            return false;
        }

        return gameBoard[row - 1][col - 1] == ' ';
    }

    public static void printGameBoard(char[][] gameBoard) {
        System.out.println("---------");
        for (char[] chars : gameBoard) {
            System.out.print("| ");
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static boolean checkWinner(char[][] gameBoard, char symbol) {
        for (int i = 0; i < 3; i++) {
            if ((gameBoard[i][0] == symbol && gameBoard[i][1] == symbol && gameBoard[i][2] == symbol) ||
                    (gameBoard[0][i] == symbol && gameBoard[1][i] == symbol && gameBoard[2][i] == symbol)) {
                return true;
            }
        }

        return (gameBoard[0][0] == symbol && gameBoard[1][1] == symbol && gameBoard[2][2] == symbol) ||
                (gameBoard[0][2] == symbol && gameBoard[1][1] == symbol && gameBoard[2][0] == symbol);
    }

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
}