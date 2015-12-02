package c4q.nyc.sufeiiz;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by sufeizhao on 12/1/15.
 */
public class MissingNum {
    // I have an array of the numbers 1 to 100 in a random number. One of the numbers is missing.
    // Write an algorithm to figure out what the number is and what position is missing.

    public static int missingNum(int[] nums) {
        boolean[] list = new boolean[100];

        for (int num : nums) {
            list[num - 1] = true;
        }

        for (int i = 0; i < list.length; i++) {
            if (!list[i])
                return i + 1;
        }
        
        return -1;
    }
}
