package nyc.c4q.sufeiiz;

/**
 * package nyc.c4q.reinardcox;
 * Created by djshadowslim & sufeiiz on 3/7/15.
 * Access Code 2.1
 * Madlibs
 */

import java.util.Scanner;

public class Madlibs {
    public static void main (String [] args){

        String inputAdjective1, inputAdjective2, inputNoun1, inputNoun2;
        int num1, num2;

        Scanner Input = new Scanner(System.in); //Declare Scanner Variable = Input

        System.out.print("What is an adjective: ");
        inputAdjective1 = Input.nextLine();

        System.out.print("Enter another adjective: ");
        inputAdjective2 = Input.nextLine();

        System.out.print("Enter a noun: ");
        inputNoun1 = Input.nextLine();

        System.out.print("Enter another noun: ");
        inputNoun2 = Input.nextLine();

        System.out.print("Enter a number: ");
        num1 = Input.nextInt();

        //System.out.print("Enter a second number: ");
        //num2 = Input.nextInt();



        if (num1 >= 2 || num1 == 0){
            //char s = 's';
            inputNoun1 = num1 + " " + inputNoun1 + "s";

        } else if (num1 == 1) {
            inputNoun1 = "a " + inputNoun1;

        }

        System.out.println("Here is your Mab Lib!!");
        System.out.println("The " + inputAdjective1 + " bear went into the " + inputAdjective2 + " house. \nThere she saw " + inputNoun1 + " and a " + inputNoun2);
    }
}