package ChatBot;

import java.util.Calendar;
import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        String botName = "ChaBot";

        System.out.println("Hello! My name is " + botName + ".");
        System.out.println("I was created in " + currentYear + ".");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, remind me your name.");
        String yourName = scanner.nextLine();

        System.out.println("What a great name you have, " + yourName + "!");

        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5, and 7 in separate lines.");

        int remainder3 = scanner.nextInt();
        int remainder5 = scanner.nextInt();
        int remainder7 = scanner.nextInt();

        int yourAge = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;

        System.out.println("Your age is " + yourAge + "; that's a good time to start programming!");

        System.out.println("Now I will prove to you that I can count to any number you want!");
        int userInp = scanner.nextInt();

        for (int i = 1; i <= userInp; i++) {
            System.out.println(i + "!");
        }

        System.out.println("Let's test your programming knowledge.");
        System.out.println("Why do we use methods in Java?");
        System.out.println("1. To repeat a statement multiple times.");
        System.out.println("2. To decompose a program into small, manageable, and reusable code.");
        System.out.println("3. To make a variable accessible from anywhere.");
        System.out.println("4. To confuse the programmer.");

        int userAnswer;
        do {
            System.out.print("Your answer (enter the number): ");
            userAnswer = scanner.nextInt();
            if (userAnswer != 2) {
                System.out.println("That's not correct. Please try again.");
            }
        } while (userAnswer != 2);

        System.out.println("That's correct! Goodbye, have a nice day!");

        scanner.close();
    }
}