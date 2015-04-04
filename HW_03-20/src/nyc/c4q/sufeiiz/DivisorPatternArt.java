package nyc.c4q.sufeiiz;

/**
 * Created by sufeizhao on 3/14/15.
 * Access Code 2.1
 * Print a table of size NxN where an entry (i, j) is:
 * @ *(@ character and an empty space) if *i divides j or j divides i
 * Two empty space characters, otherwise
 */

public class DivisorPatternArt {

    public static void main(String[] args) {

        // creates NxN grid
        int N = 25;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i % j == 0 || j % i == 0) // i divides into j or j divides into i
                    System.out.print("@ ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }
}
