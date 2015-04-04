package nyc.c4q.sufeiiz;

/**
 * Created by sufeizhao on 3/15/15.
 * Access Code 2.1
 * 1. Write a method that swaps the first and second halves of a string. For example, swapHalves("Hello, world!")
 * returns "world!Hello, ". The resulting string should be exactly the same length as the original.
 * 2. Write a method that takes a string and prints it in a triangle with progressively more letters.
 */

public class Substring {
    public static String swapHalves(String sentence) {
        int half = sentence.length() / 2;

        return sentence.substring(half) + sentence.substring(0, half);
    }

    public static void printTriangle(String sentence) {
        for (int i = 0; i<sentence.length(); i++) {
            for (int j = 0; j<i; j++) {
                System.out.print(sentence.charAt(j));
            }
            System.out.println();
        }
    }

    public static void printUpperTriangle(String sentence) {
        int length = sentence.length();

        for (int i = 0; i<length; i++) {
            System.out.print(ExtendingStrings.repeat(' ', i));
            System.out.println(sentence.substring(i, length));
        }
    }

    public static void main(String[] args) {
        String hello = "Hello world";
        String goodbye = "Goodbye!";

//        System.out.println(swapHalves(hello));
//        System.out.println(swapHalves(goodbye));
        printUpperTriangle("Hello World");
    }
}
