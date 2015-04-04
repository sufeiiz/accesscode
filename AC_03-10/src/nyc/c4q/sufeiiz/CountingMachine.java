package nyc.c4q.sufeiiz;

/**
 * Created by sufeiiz on 3/10/15.
 * Access Code 2.1
 * Counting machine that takes user input to count in increments.
 */

import java.util.Scanner;

public class CountingMachine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int startNum, endNum, increment;

        System.out.print("What number would you like to start counting from? ");
        startNum = input.nextInt();
        System.out.print("What number would you like to count to? ");
        endNum = input.nextInt();
        System.out.print("Should we count in increments of...? ");
        increment = input.nextInt();

        for (int i = startNum; i <= endNum; i += increment) {
            System.out.print(i + " ");
        }
    }
}
