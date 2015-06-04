import java.util.ArrayList;

/**
 * Created by Sufei Zhao on 4/14/15.
 * Variables practice
 */
public class Variables {

    public static boolean isOdd(int x) {
        return !(x % 2 == 0);
    }

    public static void printHelloWorld() {
        System.out.println("Hello World");
    }

    public static ArrayList<Integer> primeFactors(long n) {
        ArrayList<Integer> factors = new ArrayList<Integer>();
        long num = n;

        for (int i = 2; i <= num; i++) {
            if (num % i == 0) {
                factors.add(i);
                num /= i;
                i--;
            }
        }
        return factors;
    }

    public static int greatestCommonFactor(int x, int y) {
        ArrayList<Integer> xFactors = primeFactors(x);
        ArrayList<Integer> yFactors = primeFactors(y);
        int common = 1;

        for (int prime : xFactors) {
            if (yFactors.contains(prime)) {
                common *= prime;
                yFactors.remove(yFactors.indexOf(prime));
            }
        }
        return common;
    }

    public static void main (String args[]) {
        int x = 113;
        double y = 2.71828;
        String z = "Computer Science";

        System.out.println("This is room #" + x);
        System.out.println("e is close to " + y);
        System.out.println("I am learning " + z);

        boolean isOdd = isOdd(5);
        System.out.println("5 is an odd number? " + isOdd);

        printHelloWorld();

        int gcf = greatestCommonFactor(18, 24);
        System.out.println("The greatest common factor of 18 and 24 is " + gcf);
    }
}
