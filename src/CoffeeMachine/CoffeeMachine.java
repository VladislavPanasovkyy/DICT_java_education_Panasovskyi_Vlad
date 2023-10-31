package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {

    private static int water = 400;
    private static int milk = 540;
    private static int coffeeBeans = 120;
    private static int disposableCups = 9;
    private static int money = 550;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Write action (buy, fill, take, remaining, exit): ");
            String action = scanner.nextLine();

            switch (action) {
                case "buy" -> buyCoffee(scanner);
                case "fill" -> fillMachine(scanner);
                case "take" -> takeMoney();
                case "remaining" -> showResources();
                case "exit" -> {
                    return;
                }
            }
        }
    }
    public static void buyCoffee(Scanner scanner) {
        while (true) {
            System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
            String choice = scanner.nextLine();

            if ("back".equals(choice)) {
                return;
            }

            int waterNeeded, milkNeeded, coffeeBeansNeeded, cost;

            switch (choice) {
                case "1" -> {  // espresso
                    waterNeeded = 250;
                    milkNeeded = 0;
                    coffeeBeansNeeded = 16;
                    cost = 4;
                }
                case "2" -> {  // latte
                    waterNeeded = 350;
                    milkNeeded = 75;
                    coffeeBeansNeeded = 20;
                    cost = 7;
                }
                case "3" -> {  // cappuccino
                    waterNeeded = 200;
                    milkNeeded = 100;
                    coffeeBeansNeeded = 12;
                    cost = 6;
                }
                default -> {
                    return;
                }
            }

            if (water >= waterNeeded && milk >= milkNeeded && coffeeBeans >= coffeeBeansNeeded && disposableCups > 0) {
                System.out.println("I have enough resources, making you a coffee!");
                water -= waterNeeded;
                milk -= milkNeeded;
                coffeeBeans -= coffeeBeansNeeded;
                money += cost;
                disposableCups--;
            } else {
                String message = "Sorry, I can't make this coffee. ";
                if (water < waterNeeded) message += "Not enough water. ";
                if (milk < milkNeeded) message += "Not enough milk. ";
                if (coffeeBeans < coffeeBeansNeeded) message += "Not enough coffee beans. ";
                if (disposableCups == 0) message += "Not enough disposable cups. ";
                System.out.println(message);
            }
        }
    }
    public static void fillMachine(Scanner scanner) {
        System.out.print("Write how many ml of water you want to add: ");
        int addWater = scanner.nextInt();
        System.out.print("Write how many ml of milk you want to add: ");
        int addMilk = scanner.nextInt();
        System.out.print("Write how many grams of coffee beans you want to add: ");
        int addCoffeeBeans = scanner.nextInt();
        System.out.print("Write how many disposable coffee cups you want to add: ");
        int addCups = scanner.nextInt();

        water += addWater;
        milk += addMilk;
        coffeeBeans += addCoffeeBeans;
        disposableCups += addCups;
    }
    public static void takeMoney() {
        System.out.println("I gave you $" + money);
        money = 0;
    }
    public static void showResources() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(money + " of money");
    }
}