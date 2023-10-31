package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();

        makeCoffee(cups);

        scanner.close();
    }

    public static void makeCoffee(int cups) {
        int waterPerCup = 200;
        int milkPerCup = 50;
        int coffeeBeansPerCup = 15;

        int totalWater = waterPerCup * cups;
        int totalMilk = milkPerCup * cups;
        int totalCoffeeBeans = coffeeBeansPerCup * cups;

        System.out.println("For " + cups + " cups of coffee you will need:");
        System.out.println(totalWater + " ml of water");
        System.out.println(totalMilk + " ml of milk");
        System.out.println(totalCoffeeBeans + " g of coffee beans");
    }
}