package nyc.c4q.sufeiiz;

/**
 * Created by sufeizhao on 3/8/15.
 * Access Code 2.1
 * Using If/Else for grading system
 */

import java.util.Scanner;

public class IfElse {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        System.out.print("What's your score? ");
        int score = Scanner.nextInt();

        if (score == 100) {
            System.out.println("Perfect score!");
        } else if (score >= 90){
            System.out.println("Great!");
        } else if (score >= 75) {
            System.out.println("Not bad!");
        } else if (score >= 60) {
            System.out.println("You passed.");
        } else {
            System.out.println("You failed. :(");
        }

        System.out.println("We're done!");
    }
}
