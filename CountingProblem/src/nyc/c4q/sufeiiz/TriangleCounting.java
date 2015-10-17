package nyc.c4q.sufeiiz;

import java.util.Scanner;

public class TriangleCounting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of sides: ");
        int n = Integer.valueOf(scanner.next());

        if (n >= 3) {
            System.out.println(countTriangle(n));
        }
    }

    public static int countTriangle(int n) {
        return factorial(n - 3) / (factorial(3) * factorial(n));
    }

    public static int factorial(int num) {
        if (num == 1 || num <= 0)
            return 1;
        else
            return num * factorial(num - 1);
    }

}
