package nyc.c4q.sufeiiz;

/**
 * Created by sufeizhao on 3/14/15.
 * Access Code 2.1
 * TwentyQuestions.java
 * Write a program which assumes a random integer X in some range, say 1 - 100,000.
 * It prompts you to input a number and responds with the following information:
 *   - Input number is higher than X
 *   - Input number is lower than X
 *   - Input number is equal to X
 * You win the game Your program gives 20 chances to guess the number and you lose if you fail to guess.
 */

import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class TwentyQuestions {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        int count = 0, userNum;
        int randomNum = random.nextInt(99999) + 1;

        System.out.print("My number is between 1 and 100,000.\n");

        while (count < 20) {
            System.out.print("Guess my number: ");

            // Catches error if user inputs String instead of int
            try {
                userNum = input.nextInt();
            }
            catch (InputMismatchException e) {
                userNum = 0;
                input.next();
            }

            if (userNum < 1 || userNum > 100000) {
                System.err.println("My number is between 1 - 100,000. Try again.");
                continue;
            } else if (userNum == randomNum) {
                System.out.println("Congratulations! You guessed my number in " + count + " tries!");
                return;
            } else if (userNum > randomNum) {
                System.out.println("Your number is higher than my number.");
                count++;
                continue;
            } else if (userNum < randomNum) {
                System.out.println("Your number is lower than my number.");
                count++;
                continue;
            }
        }

        // if user failed to guess number in 20 tries:
        System.out.println("You failed to guess my number in 20 tries! My number was " + randomNum);
    }
}
