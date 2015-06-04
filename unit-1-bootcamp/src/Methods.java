import java.util.Random;

/**
 * Created by Sufei Zhao on 4/14/15.
 * Methods practice
 */

public class Methods {

    // takes an int as a parameter and returns the square of that integer
    public static int calculateSquare(int n) {
        return n * n;
    }

    // takes an int as a parameter and returns the square root of that integer
    public static double calculateSquareRoot(int n) {
        return Math.sqrt(n);
    }

    // takes a String as a parameter and returns the String in lower case
    public static String toLowerCase(String string) {
        return string.toLowerCase();
    }

    // takes 2 int parameters and determines if the second is a multiple of the first
    public static boolean isMultiple(int x, int y) {
        return y % x == 0;
    }

    // takes an int as a parameter and prints the integer surrounded by asterisks
    public static void prettyInteger(int n) {
        String asterisk = "";
        for (int i = 0; i < n; i++) {
            asterisk += "*";
        }

        System.out.println(asterisk + " " + n + " " + asterisk);
    }

    // takes 2 ints as parameters and returns a random int within that range
    public static int random(int x, int y) {
        Random random = new Random();
        return random.nextInt(y - x) + x;
    }
}
