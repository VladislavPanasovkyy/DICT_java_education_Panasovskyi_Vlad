package CreditCalculator;

import java.util.Scanner;

public class CreditCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Зчитуємо суму кредиту
        System.out.print("Enter the loan principal:\n> ");
        int principal = scanner.nextInt();

        // Вибір розрахунку: кількість місяців або щомісячний платіж
        System.out.print("What do you want to calculate?\ntype \"m\" – for number of monthly payments,\n" +
                "type \"p\" – for the monthly payment:\n> ");
        String choice = scanner.next();

        if ("m".equals(choice)) {
            // Розрахунок кількості місяців
            System.out.print("Enter the monthly payment:\n> ");
            int monthlyPayment = scanner.nextInt();

            int monthsToRepay = (int) Math.ceil((double) principal / monthlyPayment);
            System.out.println("It will take " + monthsToRepay + " months to repay the loan");
        } else if ("p".equals(choice)) {
            // Розрахунок щомісячного платежу
            System.out.print("Enter the number of months:\n> ");
            int numberOfMonths = scanner.nextInt();

            double monthlyPayment = (double) principal / numberOfMonths;
            int lastPayment = principal - (numberOfMonths - 1) * (int) Math.floor(monthlyPayment);

            System.out.println("Your monthly payment = " + (int) Math.ceil(monthlyPayment) +
                    " and the last payment = " + lastPayment);
        }

        scanner.close();
    }
}