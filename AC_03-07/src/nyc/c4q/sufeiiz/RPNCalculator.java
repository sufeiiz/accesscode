package nyc.c4q.sufeiiz;

/**
 * Created by sufeiiz & reinardcox on 3/7/15.
 * Access Code 2.1
 */
import java.util.Scanner;

public class RPNCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num1, num2, answer = 0;
        float num1a, answer1; // this is to handle the / operation.
        String operator;

        System.out.print("Please enter your first number: ");
        num1 = input.nextInt();

        System.out.print("Please enter your second number: ");
        num2 = input.nextInt();

        System.out.print("Please enter an operator: ");
        operator = input.next();

        if (operator.equals("+")) {
            answer = num1 + num2;
            System.out.print("Result: " + answer);
        } else if (operator.equals("-")) {
            answer = num1 - num2;
            System.out.print("Result: " + answer);
        } else if (operator.equals("*")) {
            answer = num1 * num2;
            System.out.print("Result: " + answer);
        } else if (operator.equals("/")) {
            num1a = num1; // here is a reference point to comment up top.
            answer1 = num1a / num2; // handles the float number and outputs.
            System.out.print("Result: " + answer1);
        } else if (operator.equals("%")) {
            answer = num1 % num2;
            System.out.print("Result: " + answer);
        }

    }
}
