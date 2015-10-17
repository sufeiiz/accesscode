package nyc.c4q.sufeiiz;

import java.util.Scanner;

public class TinTin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of toys taken: ");
        int n = Integer.valueOf(scanner.next());

        if (n > 0 && n <= 800) {
            System.out.println(possibilities(n));
        }
    }

    public static int possibilities(int n) {
        if (n == 0 || n == 1)
            return 0;
        else if (n == 2)
            return 1;
        else
            return ((n-1) * factorial(n-1)) / 2;
    }

    public static int factorial(int num) {
        if (num == 1 || num <= 0)
            return 1;
        else
            return num * factorial(num - 1);
    }
}
