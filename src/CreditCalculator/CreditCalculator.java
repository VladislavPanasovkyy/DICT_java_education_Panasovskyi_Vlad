package CreditCalculator;

import java.util.Scanner;

public class CreditCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Зчитуємо суму кредиту
        System.out.print("Loan principal: ");
        int principal = scanner.nextInt();

        int month = 0;
        int totalRepaid = 0;

        // Цикл, який працює, доки не був повністю погашений кредит
        while (totalRepaid < principal) {
            // Зчитуємо суму погашення за місяць
            System.out.print("Month " + (month + 1) + ": repaid ");
            int repayment = scanner.nextInt();

            // Додаємо суму погашення до загальної суми погашень
            totalRepaid += repayment;

            // Інкрементуємо номер місяця
            month++;
        }

        System.out.println("The loan has been repaid!");

        scanner.close();
    }
}

