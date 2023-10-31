package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffeeBeans = scanner.nextInt();

        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();

        checkResources(water, milk, coffeeBeans, cups);

        scanner.close();
    }

    public static void checkResources(int availableWater, int availableMilk, int availableCoffeeBeans, int cups) {
        int waterPerCup = 200;
        int milkPerCup = 50;
        int coffeeBeansPerCup = 15;

        int maxCupsByWater = availableWater / waterPerCup;
        int maxCupsByMilk = availableMilk / milkPerCup;
        int maxCupsByCoffeeBeans = availableCoffeeBeans / coffeeBeansPerCup;

        int maxCups = Math.min(Math.min(maxCupsByWater, maxCupsByMilk), maxCupsByCoffeeBeans);

        if (cups <= maxCups) {
            if (cups == maxCups) {
                System.out.println("Yes, I can make that amount of coffee");
            } else {
                System.out.println("Yes, I can make that amount of coffee (and even " + (maxCups - cups) + " more than that)");
            }
        } else {
            System.out.println("No, I can make only " + maxCups + " cups of coffee");
        }
    }
}