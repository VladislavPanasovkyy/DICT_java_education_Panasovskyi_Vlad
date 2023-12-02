package CreditCalculator;

import java.util.Scanner;

public class CreditCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Зчитуємо від користувача, який параметр він хоче обчислити
        System.out.print("What do you want to calculate?\n" +
                "type \"n\" for number of monthly payments,\n" +
                "type \"a\" for annuity monthly payment amount,\n" +
                "type \"p\" for loan principal:\n> ");
        String calculationType = scanner.next();

        double principal = 0;
        double monthlyPayment = 0;
        double interest = 0;

        // Зчитуємо значення від користувача в потрібному порядку
        switch (calculationType) {
            case "n":
                System.out.print("Enter the loan principal:\n> ");
                principal = scanner.nextDouble();
                System.out.print("Enter the monthly payment:\n> ");
                monthlyPayment = scanner.nextDouble();
                System.out.print("Enter the loan interest:\n> ");
                interest = scanner.nextDouble() / 100 / 12;
                calculateNumberOfPayments(principal, monthlyPayment, interest);
                break;

            case "a":
                System.out.print("Enter the loan principal:\n> ");
                principal = scanner.nextDouble();
                System.out.print("Enter the number of periods:\n> ");
                int numberOfPayments = scanner.nextInt();
                System.out.print("Enter the loan interest:\n> ");
                interest = scanner.nextDouble() / 100 / 12;
                calculateAnnuityPayment(principal, numberOfPayments, interest);
                break;

            case "p":
                System.out.print("Enter the annuity payment:\n> ");
                monthlyPayment = scanner.nextDouble();
                System.out.print("Enter the number of periods:\n> ");
                numberOfPayments = scanner.nextInt();
                System.out.print("Enter the loan interest:\n> ");
                interest = scanner.nextDouble() / 100 / 12;
                calculateLoanPrincipal(monthlyPayment, numberOfPayments, interest);
                break;

            default:
                System.out.println("Invalid input. Please enter 'n', 'a', or 'p'.");
        }

        scanner.close();
    }

    private static void calculateNumberOfPayments(double principal, double monthlyPayment, double interest) {
        double base = 1 + interest;
        double exponent = Math.log(monthlyPayment / (monthlyPayment - interest * principal)) / Math.log(base);
        int numberOfPayments = (int) Math.ceil(exponent);
        int years = numberOfPayments / 12;
        int months = numberOfPayments % 12;

        System.out.println("It will take " + years + " years and " + months + " months to repay this loan!");
    }

    private static void calculateAnnuityPayment(double principal, int numberOfPayments, double interest) {
        double annuityPayment = principal * interest * Math.pow(1 + interest, numberOfPayments) /
                (Math.pow(1 + interest, numberOfPayments) - 1);

        System.out.println("Your monthly payment = " + (int) Math.ceil(annuityPayment) + "!");
    }

    private static void calculateLoanPrincipal(double monthlyPayment, int numberOfPayments, double interest) {
        double principal = monthlyPayment * (Math.pow(1 + interest, numberOfPayments) - 1) /
                (interest * Math.pow(1 + interest, numberOfPayments));

        System.out.println("Your loan principal = " + (int) Math.ceil(principal) + "!");
    }
}