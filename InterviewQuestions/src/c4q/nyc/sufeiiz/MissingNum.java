package c4q.nyc.sufeiiz;

import java.util.ArrayList;

/**
 * Created by sufeizhao on 12/1/15.
 */
public class MissingNum {
    // I have an array of the numbers 1 to 100 in a random number. One of the numbers is missing.
    // Write an algorithm to figure out what the number is and what position is missing.

    public static int missingNum(int[] nums) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 1; i <= 100; i++) {
            list.add(i);
        }

        for (int num : nums) {
            list.remove(list.indexOf(num));
        }

        return list.get(0);
    }
}
