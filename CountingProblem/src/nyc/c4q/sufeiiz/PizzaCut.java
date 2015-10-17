package nyc.c4q.sufeiiz;

import java.util.Scanner;

public class PizzaCut {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of lines: ");
        int n = Integer.valueOf(scanner.next());

        if (n > 0) {
            System.out.println(cutPizza(n));
        }
    }

    public static int cutPizza(int n) {
        int slices = 1;

        for (int i = 1; i <= n; i++) {
            slices += i;
        }

        return slices;
    }
}
