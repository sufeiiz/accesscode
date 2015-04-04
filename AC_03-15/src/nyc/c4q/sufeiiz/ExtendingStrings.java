package nyc.c4q.sufeiiz;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by sufeizhao on 3/15/15.
 * Access Code 2.1
 * Learning about java.lang.String
 * Created many methods on manipulating Strings.
 * Read comment above method for detail
 */

public class ExtendingStrings {

    // prints out the reverse of a string
    public static void printReverse(String sentence) {
        for (int i = sentence.length()-1; i >= 0; i--){
            System.out.print(sentence.charAt(i));
        }
    }

    // counts the number of times a given character appears in a string.
    public static int count(String sentence, char letter) {
        int count = 0;

        for (int i=0; i<sentence.length(); i++) {
            if (sentence.charAt(i) == letter) {
                count++;
            } else {
                continue;
            }
        }
        return count;
    }

    // swaps every two characters of a string. For example, swap2("Hello, world!") returns "eHll,ow rod !"
    public static String swap2(String sentence) {
        String swapped = "";
        int length = sentence.length();

        for (int i=0; i<length-1; i+=2) {
            swapped += sentence.charAt(i+1);
            swapped += sentence.charAt(i);
        }

        if (length % 2 == 0) // if sentence is even
            return swapped;
        else
            return swapped + sentence.charAt(length-1);
    }

    // returns a string consisting of that character repeated to produce a string of the given length
    public static String repeat(char x, int num) {
        String answer = "";

        for (int i=0; i<num; i++) {
            answer += x;
        }
        return answer;
    }

    // returns a string consisting of the string repeated to produce a string of the given length
    public static String repeatString(String sentence, int num) {
        String answer = "";
        int length = sentence.length();

        while (length < num) {
            answer += sentence;
            num -= length;
        }

        for (int i=0; i<num; i++) {
            answer += sentence.charAt(i);
        }
        return answer;
    }

    // prints a string and then underlines it with a specified character
    public static void underline(String sentence, char character) {
        System.out.println(sentence);
        for (int i = 0; i<sentence.length(); i++) {
            System.out.print(character);
        }
    }

    // prints a string in a box. Use - for the top and bottom, | for the sides, and + for the corners
    public static void box(String sentence) {
        int length = sentence.length();

        System.out.println("+-" + repeat('-', length) + "-+");
        System.out.println("| " + sentence + " |");
        System.out.println("+-" + repeat('-', length) + "-+");
    }

    // returns string padded on the left or right with a char;
    // boolean true = padding left, false = padding right
    public static String pad(String word, int num, char x, boolean left) {
        if (left) {
            return repeat(x, num-word.length()) + word;
        } else {
            return word + repeat(x, num-word.length());
        }
    }

    // takes a string and replaces all vowels with asterisks
    public static String replaceVowel(String sentence) {
        String formatted = "";
        for (int i = 0; i < sentence.length(); i++) {
            char letter = sentence.charAt(i);

            if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u')
                formatted += "*";
            else if (letter == ' ')
                formatted += " ";
            else
                formatted += String.valueOf(letter);
        }
        return formatted;
    }

    // replaces any consecutive string of digits (0 through 9) with a single hash sign
    // For example, replaceNumbers("I spent $100 for 12 books.")
    // returns "I spent $# for # books.").
    public static String replaceNumbers(String sentence) {
        char[] nums = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        String replaced = "";

        for (int i=0; i<sentence.length(); i++) {
            if (Arrays.asList(nums).contains(sentence.charAt(i))) {
                replaced += "#";
            } else {
                replaced += sentence.charAt(i);
            }
        }
        return replaced;
    }

    public static void main(String[] args) {
        Random random = new Random();
        for (int i=0;i<15;i++) {
            System.out.println(random.nextInt(2));
        }
    }


    // Exercise: Write a method that drops all characters from a string that are not either
    // letters or digits, and replaces spaces with underscores. For example, cleanUp("Hello, world!")
    // returns "Hello_world".


    // Exercise: [optional] Write a method that looks for double letters in a string and turns them
    // into triple letters. For example,
    // doubleToTriple("I look at a balloon and see three apples.")
    // returns
    // "I loook at a balllooon and seee threee appples.")


}
