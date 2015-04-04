package nyc.c4q.sufeiiz;

/**
 * Created by sufeiiz on 3/8/15.
 * Access Code 2.1
 * Tells user if daylight savings is currently in effect.
 */

import java.util.Scanner;

public class Daylight {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int month, day;
        String inEffect = "Daylight savings is in effect.", notEffect = "Daylight savings is not in effect.";

        System.out.print("What month is it in numbers? ");
        month = input.nextInt();
        System.out.print("What day is it in numbers? ");
        day = input.nextInt();

        if (day > 31 || month > 12 || day == 0 || month == 0) {
            System.out.println("That's not a real date!");
        } else if (month == 3 && day >= 8) {
            System.out.println(inEffect);
        } else if (month >= 3 && month <= 10) {
            System.out.println(inEffect);
        } else if (month == 3 && day < 8) {
            System.out.println(notEffect);
        } else {
            System.err.println(notEffect);
        }
    }
}
