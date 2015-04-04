package nyc.c4q.sufeiiz;

/**
 * Created by sufeizhao on 3/28/15.
 * As an exercise, we are asking you to solve one of Project Euler's problems described here.
 * Create a class called LettersInNumbers which has a method letterCount
 * which returns an integer containing the number of letters.
 *   1. If the numbers 1 to 5 are written out in words: one, two, three, four, five,
 *      then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 *   2. If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
 *   NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains
 *   23 letters and 115 (one hundred and fifteen) contains 20 letters.
 *   The use of "and" when writing out numbers is in compliance with British usage.
 */

public class LettersInNumbers {
    public static int letterCount(String number) {
        int count = 0;
        char current;

        for (int i=0; i<number.length(); i++) {
            current = number.charAt(i);
            if (Character.isLetter(current)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(letterCount("three hundred and forty-two"));
    }
}
