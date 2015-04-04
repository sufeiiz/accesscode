package nyc.c4q.sufeiiz;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

/**
 * Access Code 2.1
 *
 * Author  Sufei Zhao
 * Date    March 26 2015
 *
 * This class asks the user which car they have and prints its price.
 */

public class Adder {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        int userNum, sum = 0;

        System.out.print("Give me some numbers to add: ");

        while (true) {
            userNum = input.nextInt();
            if (userNum == -2) {
                break;
            } else if (userNum == -1) {
                numbers.clear();
            }
            numbers.add(userNum);
        }

        /* Alternate sum solution
        for (int num : numbers) {
            sum += num;
        }

        System.out.print("Thanks! Your sum is " + sum);
        */

        Iterator<Integer> numsIter = numbers.iterator();
        while (numsIter.hasNext()) {
            sum += numsIter.next();
        }
    }
}
