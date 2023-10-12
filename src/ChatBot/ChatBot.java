package ChatBot;

import java.util.Calendar;

public class ChatBot {
    public static void main(String[] args) {

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        String botName = "ChaBot";

        System.out.println("Hello! My name is " + botName + ".");
        System.out.println("I was created in " + currentYear + ".");
    }
}
