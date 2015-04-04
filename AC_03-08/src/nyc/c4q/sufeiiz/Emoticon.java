package nyc.c4q.sufeiiz;

/**
 * Created by sufeiiz and theaulait on 3/8/15.
 * Access Code 2.1
 * Using emoticons for ask how a persons feeling.
 */

import java.util.Scanner;

public class Emoticon {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String response;
        boolean noAnswer = true;

        while (noAnswer) {
            System.out.print("How do you feel? ");
            response = input.nextLine();
            if (response.equals(":)") || response.equals(":D") || response.equals(":-)") || response.equals(":]") || response.equals("=)")) {
                System.out.println("You're feeling happy today! Great!");
                noAnswer = false;
            } else if (response.equals(":(") || response.equals("=(") || response.equals(":-(")) {
                System.out.println("It's okay, tomorrow will be better!");
                noAnswer = false;
            } else if (response.equals(">:(")) {
                System.out.println("Oh no! Do you want to talk about it?");
                noAnswer = false;
            } else if (response.equals(":'(")) {
                System.out.println("Do you need a tissue?");
                noAnswer = false;
            } else {
                System.out.println("Please respond with an emoticon.");
            }
        }
    }
}
