package MatrixProcessing;

import java.util.Scanner;

public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("1. Add matrices");
            System.out.println("2. Multiply matrix by a constant");
            System.out.println("3. Multiply matrices");
            System.out.println("4. Transpose matrix");
            System.out.println("0. Exit");
            System.out.print("Your choice: > ");

            // зчитуємо вибір користувача
            int choice = scanner.nextInt();

            // виконуємо вибрану операцію
            switch (choice) {
                case 1:
                    addMatrices(scanner);
                    break;
                case 2:
                    multiplyMatrixByConstant(scanner);
                    break;
                case 3:
                    multiplyMatrices(scanner);
                    break;
                case 4:
                    transposeMatrix(scanner);
                    break;
                case 0:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    // додавання матриць
    private static void addMatrices(Scanner scanner) {
        System.out.print("Enter size of first matrix: > ");
        int rowsA = scanner.nextInt();
        int colsA = scanner.nextInt();
        double[][] matrixA = readMatrix(scanner, rowsA, colsA);

        System.out.print("Enter size of second matrix: > ");
        int rowsB = scanner.nextInt();
        int colsB = scanner.nextInt();
        double[][] matrixB = readMatrix(scanner, rowsB, colsB);

        if (rowsA == rowsB && colsA == colsB) {
            double[][] result = addMatrices(matrixA, matrixB);
            System.out.println("The result is:");
            printMatrix(result);
        } else {
            System.out.println("The operation cannot be performed.");
        }
    }

    // множення матриці на константу
    private static void multiplyMatrixByConstant(Scanner scanner) {
        System.out.print("Enter size of matrix: > ");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        double[][] matrix = readMatrix(scanner, rows, cols);

        System.out.print("Enter constant: > ");
        double constant = scanner.nextDouble();

        double[][] result = multiplyMatrixByConstant(matrix, constant);
        System.out.println("The result is:");
        printMatrix(result);
    }

    // множення матриць
    private static void multiplyMatrices(Scanner scanner) {
        System.out.print("Enter size of first matrix: > ");
        int rowsA = scanner.nextInt();
        int colsA = scanner.nextInt();
        double[][] matrixA = readMatrix(scanner, rowsA, colsA);

        System.out.print("Enter size of second matrix: > ");
        int rowsB = scanner.nextInt();
        int colsB = scanner.nextInt();
        double[][] matrixB = readMatrix(scanner, rowsB, colsB);

        if (colsA == rowsB) {
            double[][] result = multiplyMatrices(matrixA, matrixB);
            System.out.println("The result is:");
            printMatrix(result);
        } else {
            System.out.println("The operation cannot be performed.");
        }
    }

    // транспонування матриці
    private static void transposeMatrix(Scanner scanner) {
        System.out.println("1. Main diagonal");
        System.out.println("2. Side diagonal");
        System.out.println("3. Vertical line");
        System.out.println("4. Horizontal line");
        System.out.print("Your choice: > ");
        int transposeOption = scanner.nextInt();

        System.out.print("Enter matrix size: > ");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        double[][] matrix = readMatrix(scanner, rows, cols);

        double[][] result;
        switch (transposeOption) {
            case 1:
                result = transposeMainDiagonal(matrix);
                break;
            case 2:
                result = transposeSideDiagonal(matrix);
                break;
            case 3:
                result = transposeVerticalLine(matrix);
                break;
            case 4:
                result = transposeHorizontalLine(matrix);
                break;
            default:
                System.out.println("Invalid transpose option. Returning to the main menu.");
                return;
        }

        System.out.println("The result is:");
        printMatrix(result);
    }

    // зчитування матриці з консолі
    private static double[][] readMatrix(Scanner scanner, int rows, int cols) {
        double[][] matrix = new double[rows][cols];
        System.out.println("Enter matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }
        return matrix;
    }

    // виведення матриці на консоль
    private static void printMatrix(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // додавання двох матриць
    private static double[][] addMatrices(double[][] matrixA, double[][] matrixB) {
        int rows = matrixA.length;
        int cols = matrixA[0].length;
        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        return result;
    }

    // множення матриці на константу
    private static double[][] multiplyMatrixByConstant(double[][] matrix, double constant) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix[i][j] * constant;
            }
        }

        return result;
    }

    // множення двох матриць
    private static double[][] multiplyMatrices(double[][] matrixA, double[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int rowsB = matrixB.length;
        int colsB = matrixB[0].length;
        double[][] result = new double[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        return result;
    }

    // транспонування матриці відносно головної діагоналі
    private static double[][] transposeMainDiagonal(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] result = new double[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }

    // транспонування матриці відносно побічної діагоналі
    private static double[][] transposeSideDiagonal(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] result = new double[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[cols - 1 - j][rows - 1 - i] = matrix[i][j];
            }
        }

        return result;
    }

    // транспонування матриці відносно вертикалі
    private static double[][] transposeVerticalLine(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][cols - 1 - j] = matrix[i][j];
            }
        }

        return result;
    }

    // транспонування матриці відносно горизонталі
    private static double[][] transposeHorizontalLine(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] result = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[rows - 1 - i][j] = matrix[i][j];
            }
        }

        return result;
    }
}