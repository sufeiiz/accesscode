package nyc.c4q.sufeiiz;

import java.util.Scanner;

public class HowManyO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a range: ");
        long m = Long.valueOf(scanner.next());
        long n = Long.valueOf(scanner.next());

        if (m > 0 && n < 0 && m <= n) {
            System.out.println(countOs(m, n));
        }
    }

    public static long countOs(long m, long n) {
        int count = 0;
        while (m <= n) {
            String num = String.valueOf(m);
            for (int i = 0; i < num.length(); i++) {
                if (num.indexOf(i) == 0)
                    count++;
            }
            m++;
        }
        return count;
    }
}
