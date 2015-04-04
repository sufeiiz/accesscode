package nyc.c4q.sufeiiz;

/**
 * Created by sufeizhao on 3/12/15.
 */

public class Math {
    public static int add(int a, int b) {
        int result = a + b;
        return result;
    }

    public static int subtract(int x, int y) {
        int result = x - y;
        return result;
    }

    public static void main(String[] args) {
        int addition = add(1,2);
        System.out.println(addition);

        int subtraction = subtract(10,2);
        System.out.println(subtraction);
    }
}
