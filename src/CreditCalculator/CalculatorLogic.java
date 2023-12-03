public class CalculatorLogic {

    public void dataAnalyze(String type, String principal, String periods, String interest, String payment) {
        try {
            double principalAmount = Double.parseDouble(principal);
            int numberOfPayments = Integer.parseInt(periods);
            double annualInterestRate = Double.parseDouble(interest) / 100;
            double monthlyPaymentAmount;

            switch (type.toLowerCase()) {
                case "annuity":
                    if (payment == null) {
                        // Розрахунок щомісячного платежу
                        monthlyPaymentAmount = calculateAnnuityPayment(principalAmount, numberOfPayments, annualInterestRate);
                        System.out.println("Your annuity payment = " + (int) Math.ceil(monthlyPaymentAmount) + "!");
                    } else {
                        // Розрахунок терміну погашення
                        int months = calculateNumberOfPayments(principalAmount, Double.parseDouble(payment), annualInterestRate);
                        int years = months / 12;
                        months %= 12;
                        System.out.println("It will take " + years + " years and " + months + " months to repay this loan!");
                    }
                    break;

                case "diff":
                    if (payment != null) {
                        throw new IllegalArgumentException("Incorrect parameters.");
                    }
                    // Розрахунок диференційованих платежів
                    calculateDifferentialPayments(principalAmount, numberOfPayments, annualInterestRate);
                    break;

                default:
                    System.out.println("Incorrect parameters.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Incorrect parameters.");
        }
    }

    private double calculateAnnuityPayment(double principal, int numberOfPayments, double interest) {
        return principal * interest * Math.pow(1 + interest, numberOfPayments) / (Math.pow(1 + interest, numberOfPayments) - 1);
    }

    private int calculateNumberOfPayments(double principal, double monthlyPayment, double interest) {
        double base = 1 + interest;
        double exponent = Math.log(monthlyPayment / (monthlyPayment - interest * principal)) / Math.log(base);
        return (int) Math.ceil(exponent);
    }

    private void calculateDifferentialPayments(double principal, int numberOfPayments, double interest) {
        double totalPayments = 0;
        for (int month = 1; month <= numberOfPayments; month++) {
            double payment = (principal / numberOfPayments) + interest * (principal - (principal * (month - 1) / numberOfPayments));
            totalPayments += payment;
            System.out.println("Month " + month + ": payment is " + (int) Math.ceil(payment));
        }
        double overpayment = totalPayments - principal;
        System.out.println("Overpayment = " + (int) Math.ceil(overpayment));
    }
}