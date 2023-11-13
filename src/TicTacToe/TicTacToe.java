package TicTacToe;
public class TicTacToe {
    public static void main(String[] args) {
        // Ігрове поле 3x3
        char[][] gameBoard = {
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', 'O', 'X'}
        };

        // Друк ігрового поля
        printGameBoard(gameBoard);
    }

    public static void printGameBoard(char[][] gameBoard) {
        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard[row].length; col++) {
                System.out.print(gameBoard[row][col] + " ");
            }
            System.out.println();
        }
    }
}