public class CreditCalculator {
    public static void main(String[] args) {
        CalculatorLogic calculatorLogic = new CalculatorLogic();
        String type = System.getProperty("type");
        String principal = System.getProperty("principal");
        String periods = System.getProperty("periods");
        String interest = System.getProperty("interest");
        String payment = System.getProperty("payment");
        calculatorLogic.dataAnalyze(type, principal, periods, interest, payment);
    }
}