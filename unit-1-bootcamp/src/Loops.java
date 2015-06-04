import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Sufei Zhao on 4/14/15.
 */
public class Loops {

    // Write a method that prints the numbers 1 through 10 using a loop.
    public static void printOneThroughTen() {
        printOneThroughN(10);
    }

    // Write a method that prints the numbers 1 through 10 using a different kind of loop.
    public static void printOneThroughTen2() {
        int count = 1;
        while (count < 11) {
            System.out.print(count + " ");
            count++;
        }
    }

    // Write a method that takes in an int n and prints the numbers 1 through n.
    public static void printOneThroughN(int n) {
        for (int i=1; i<=n; i++) {
            System.out.print(i + " ");
        }
    }

    // Write a method that takes in an int n and prints the even numbers 2 through n.
    public static void printEven(int n) {
        for (int i=2; i<=n; i++) {
            if (i % 2 == 0)
                System.out.print(i + " ");
        }
    }

    // Write a method that takes in an int n and prints the sum of the numbers 1 through n using a loop.
    public static void printSumN(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    // Write a method that takes in an int n and a String s and prints out s on its own line, n times. If n is negative, print "".
    public static void printStringln(int n, String s) {
        if (n < 0)
            System.out.println("");
        else {
            for (int i = 0; i < n; i++) {
                System.out.println(s);
            }
        }
    }

    // Modify the method to print out the string concatenated with itself n times.
    public static void printString(int n, String s) {
        if (n < 0)
            System.out.println("");
        else {
            for (int i = 0; i < n; i++) {
                System.out.print(s);
            }
        }
    }

    // Find nth fibonacci number
    public static int fibonacci(int n) {
        if (n == 1)
            return 0;
        else if (n == 2)
            return 1;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Modify the method to take in an int x and sum the first x Fibonnaci numbers.
    public static int fibSum(int x) {
        int sum = 0;
        for (int i = 1; i <= x; i++) {
            sum += fibonacci(i);
        }
        return sum;
    }

    // Given a string, return the sum of the numbers appearing in the string, ignoring all other characters.
    // sumNumbers("abc123xyz") → 123 || sumNumbers("aa11b33") → 44 || sumNumbers("7 11") → 18
    public static int sumNumbers(String s) {
        String num, clone = s + " ";
        int sum = 0, index = 0, next;

        // i becomes the char after substring
        for (int i = 0; i < clone.length(); i=index+1) {

            // if char is a digit, look for index of next nondigit
            if (Character.isDigit(clone.charAt(i))) {
                index = i;
                next = 1;

                // continue while no changes have been made to index
                while (index == i) {
                    if (!Character.isDigit(clone.charAt(i + next)))
                        index = i + next;
                    else
                        next++;
                }

                num = clone.substring(i, index);
                sum += Integer.parseInt(num);
            }
        }
        return sum;
    }

    // Given a string, return a string where every appearance of the lowercase word "is" has been replaced with "is not".
    // (Note: Character.isLetter(char) tests if a char is a letter.)
    // notReplace("is test") → "is not test"
    // notReplace("is-is") → "is not-is not"
    // notReplace("This is right") → "This is not right"
    public static String notReplace(String string) {
        String s = " " + string + " ";
        String replaced = "", substring;

        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == 'i' && s.charAt(i + 1) == 's') {
                if (Character.isSpaceChar(s.charAt(i + 2)))
                    replaced += "is not";
                else if (!Character.isLetter(s.charAt(i - 1)) && !Character.isLetter(s.charAt(i + 2)))
                    replaced += "is not ";
            } else {
                replaced += s.charAt(i);
            }
        }

        return replaced;
    }




    // Given a string and a non-empty word string, return a string made of each char just before and just after every
    // appearance of the word in the string. Ignore cases where there is no char before or after the word,
    // and a char may be included twice if it is between two words. //XYbhvhX
    public static void wordEnds(String string, String word) {
        char curr;
        String beforeAfter = "", substring;
        int index = 0, end = string.length() - word.length();

        for (int i = 0; i < string.length(); i = index) {
            curr = string.charAt(i);

            if (curr == word.charAt(0) && i <= string.length() - word.length()) {
                substring = string.substring(i, i + word.length());
                if (substring.equals(word)) {
                    if (i == 0) {
                        beforeAfter += string.charAt(i + word.length());
                    } else if (i == end) {
                        beforeAfter += string.charAt(end - 1);
                    } else {
                        beforeAfter += string.charAt(i - 1);
                        beforeAfter += string.charAt(i + word.length());
                    }

                    index = i + word.length();
                } else {
                    index++;
                }
            } else {
                index++;
            }
        }

        System.out.println(beforeAfter);
    }


    // Use nested for loops to generate a list of all the pairs of positive two digit numbers whose sum is 60, and whose difference is 14.
    public static void numberPuzzle() {
        HashMap<Integer, Integer> list = new HashMap<Integer, Integer>();
        for (int i = 10; i <= 50; i ++) {
            for (int j = 50; j >= 10; j--) {
                if (i + j == 60 && (i - j == 14 || j - i == 14))
                    list.put(i, j);
            }
        }

        for (Integer num : list.keySet()) {
            System.out.println(num + " & " + list.get(num));
        }
    }

    // Use nested for loops to generate a list of all the positive two digit numbers. Display the numbers, and the sums of their digits.
    public static void digits() {
        String num;
        char one, two;
        int x = 0, y = 0, sum;
        for (int i = 10; i < 100; i++) {
            num = Integer.toString(i);
            one = num.charAt(0);
            two = num.charAt(1);

            for (int j = 0; j <= 9; j++) {
                if (j == i / 10)
                    x = j;
                if (j == i % 10)
                    y = j;
            }

            sum = x + y;
            System.out.println(num + ", " + one + " + " + two + " = " + sum);
        }
    }

    public static void main (String args[]) {
        // Write a method that prints the first ten Fibonnaci numbers.
        for (int i=1; i<=10; i++) {
            System.out.println(fibonacci(i));
        }

        System.out.println(notReplace("this-is-s"));
    }
}
