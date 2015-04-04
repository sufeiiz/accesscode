package nyc.c4q.sufeiiz;

/**
 * Created by sufeiiz on 3/10/15.
 * Access Code 2.1
 * Fizz Buzz counter (censors multiples of 3 and 5)
 */

public class FizzBuzz {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0)
                System.out.println("FizzBuzz");
            else if (i % 3 == 0)
                System.out.println("Fizz");
            else if (i % 5 == 0)
                System.out.println("Buzz");
            else
                System.out.println(i);
        }
    }
}
