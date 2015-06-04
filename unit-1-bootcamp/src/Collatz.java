import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by Sufei Zhao on 4/16/15.
 * Collatz Problem follows the following rules:
 *     * If n is even: n -> n/2
 *     * If n is odd:  n -> 3n + 1
 *     * Although it has not been proved yet, it is thought that all starting numbers finish at 1
 * Which starting number, under one million, produces the longest chain?
 * NOTE: code did not work with (int n), must be (long n)
 */

public class Collatz {

    // Takes in a starting number, returns count of how long the sequence is
    public static int chainCount(long n, int count) {
        if (n == 0 || n == 1)
            return count;
        else if (n % 2 == 0)
            return chainCount((n/2), ++count);
        else
            return chainCount((3 * n + 1), ++count);
    }

    // Takes in a starting number as a parameter, returns ArrayList of Collatz Sequence
    public static ArrayList<Long> collatzSequence(long n) {
        ArrayList<Long> collatz = new ArrayList<Long>();

        collatz.add(n);
        while (n != 1) {
            if (n % 2 == 0)
                n = n / 2;
            else
                n = (3 * n) + 1;
            collatz.add(n);
        }
        return collatz;
    }

    // prints out sequence chain
    public static void printCollatz(ArrayList<Long> collatz) {
        for (int i = 0; i < collatz.size(); i++) {
            System.out.print(collatz.get(i));
            if (i != (collatz.size() - 1))
                System.out.print(" -> ");
        }
    }

    // print out the longest chain found, and the starting number.
    public static void main(String[] args) {
        long longestI = 0;
        int count = 0;

        for (long i = 1; i < 1000000; i++) {
            if (chainCount(i, 0) > count) {
                longestI = i;
                count = chainCount(i, 0);
            }
        }

        System.out.println("Between 1 and 1,000,000 the longest collatz sequence has " + count + " numbers.");
        System.out.println("It begins with the number " + longestI + ":");
        printCollatz(collatzSequence(longestI));
    }
}
