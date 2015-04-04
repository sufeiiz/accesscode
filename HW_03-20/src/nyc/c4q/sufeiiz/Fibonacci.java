package nyc.c4q.sufeiiz;

/**
 * Created by sufeizhao on 3/14/15.
 * Access Code 2.1
 * Fibonacci.java
 * The Fibonacci Sequence is the series of numbers: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ...
 * Write a program which accepts as input an integer N and returns the N-th Fibonacci number.
 */

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Fibonacci {

    public static void fibonacci(int n) {
        double fminus2 = 0, fminus1 = 1, fibonacci;

        for (int i = 0; i <= n-3; i++) {
            if (i == n-3) {
                fibonacci = fminus2 + fminus1;

                // Removes the .0 decimal in double
                DecimalFormat format = new DecimalFormat("###,###");

                // Finds the ones digit for proper english declaration (1st, 2nd, 3rd, 4th..)
                if (n % 10 == 1) {
                    System.out.printf("The " + n + "st Fibonacci number is " + format.format(fibonacci));
                } else if (n % 10 == 2) {
                    System.out.printf("The " + n + "nd Fibonacci number is " + format.format(fibonacci));
                } else if (n % 10 == 3) {
                    System.out.printf("The " + n + "rd Fibonacci number is " + format.format(fibonacci));
                } else {
                    System.out.printf("The " + n + "th Fibonacci number is " + format.format(fibonacci));
                }
            } else {
                // loop through fibonacci sequence until n is reached
                fibonacci = fminus2 + fminus1;
                fminus2 = fminus1;
                fminus1 = fibonacci;
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int nth;
        boolean loop = true;

        System.out.print("Which N-th Fibonacci number would you like to know? ");

        while (loop) {

            // Catches error if user inputs String instead of int
            try {
                nth = input.nextInt();
            } catch (InputMismatchException e) {
                nth = -1;
                input.next();
            }

            // 1st and 2nd fibonacci numbers are given, or else call the fibonacci method
            if (nth <= 0) {
                System.err.println("Please enter a positive integer");
                continue;
            } else if (nth == 1) {
                System.out.println("The 1st Fibonacci number is 0");
                break;
            } else if (nth == 2) {
                System.out.println("The 2nd Fibonacci number is 1");
                break;
            } else {
                fibonacci(nth);
                break;
            }
        }
    }
}