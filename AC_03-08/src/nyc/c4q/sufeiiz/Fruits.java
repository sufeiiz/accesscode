package nyc.c4q.sufeiiz;

/**
 * Created by sufeizhao on 3/8/15.
 * Access Code 2.1
 * Takes a fruit input and prints a statement based on the fruit
 */

import java.util.Scanner;

public class Fruits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String color = "", flavor = "", fruit;

        System.out.print("Pick a fruit: ");
        fruit = scanner.next();
        if (fruit.equals("banana")) {
            color = "yellow";
            flavor = "sweet.";
        } else if (fruit.equals("grapefruit")) {
            color = "pink";
            flavor = "bitter.";
        } else if (fruit.equals("lemon")) {
            color = "yellow";
            flavor = "sour.";
        } else if (fruit.equals("apple")) {
            color = "red";
            flavor = "fresh.";
        } else {
            System.out.println("I don't know that fruit.");
            return;
        }

        System.out.println("A " + fruit + " is " + color + " and tastes " + flavor);
    }
}
