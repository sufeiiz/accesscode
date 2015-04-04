package nyc.c4q.sufeiiz;

/**
 * Taken from Alex Samuel:
 * package nyc.c4q.ac21.romancalc;
 * Access Code 2.1
 * Calculator for Roman Numerals
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Calculator {
    /**
     * Performs calculations on Roman numerals and prints the result.
     *
     * If either of the numbers are not Roman numerals, or if the operation is
     * unrecognized, prints an error message.  Otherwise, performs the
     * operation and prints the result in Roman numerals.  If the result is
     * less than 1 or larger than 3999, prints a message indicating this
     * instead.
     *
     * @param leftNumber
     *   The left operand, in Roman numerals.
     * @param operation
     *   The operator, which may be,
     *   - "+" for addition,
     *   - "-" for subtraction,
     *   - "*" for multiplication,
     *   - "/" for (integer) division,
     *   - "%" for remainder,
     *   - "#" to average the two numbers.
     * @param rightNumber
     *   The right operand.
     */
    public static void calculate(String leftNumber, String operation, String rightNumber) {
        int leftValue = RomanNumerals.parse(leftNumber);
        if (leftValue == -1) {
            System.err.println("invalid number: " + leftNumber);
            return;
        }
        int rightValue = RomanNumerals.parse(rightNumber);
        if (rightValue == -1) {
            System.err.println("invalid number: " + rightNumber);
        }

        int result;
        if (operation.equals("+")) {
            result = leftValue + rightValue;
        }
        else if (operation.equals("-")) {
            result = leftValue - rightValue;
        }
        else if (operation.equals("*")) {
            result = leftValue * rightValue;
        }
        else if (operation.equals("/")) {
            result = leftValue / rightValue;
        }
        else if (operation.equals("%")) {
            result = leftValue % rightValue;
        }
        else if (operation.equals("#")) {
            result = (leftValue + rightValue) / 2;
        }
        else {
            System.err.println("unknown operation: " + operation);
            return;
        }

        if (result < 1)
            System.out.println("too small");
        else if (result >= 4000)
            System.out.println("too large");
        else {
            System.out.println(RomanNumerals.format(result));
        }
    }

    /**
     * Parses a decimal number.
     * @param number
     *   A decimal number, e.g. "459".
     * @return
     *   The value of the number, or -1 if it cannot be parsed.
     * @note
     *   This function is for testing only.  It should not be used in the final program.
     * @note
     *   You do not need to understand how this function works.
     */
    public static int parseDecimalNumber(String number) {
        try {
            return Integer.valueOf(number);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * @note
     *   You do not need to understand how this function works.
     */
    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Loop forever.
        while (true) {
            // Show the prompt.
            System.out.print("> ");
            // Read a line of input.
            final String line = reader.readLine();
            if (line.length() == 0) {
                System.out.println("done");
                break;
            }
            // Scan the line into three parts: two numbers with an operator between them.
            final Scanner scanner = new Scanner(line);
            final String leftNumber, operation, rightNumber;
            try {
                leftNumber = scanner.next();
                operation = scanner.next();
                rightNumber = scanner.next();
            }
            catch (NoSuchElementException e) {
                System.err.println("syntax error");
                System.out.println();
                continue;
            }

            // Perform the calculation and show the result.
            calculate(leftNumber, operation, rightNumber);

            System.out.println();
        }
    }
}