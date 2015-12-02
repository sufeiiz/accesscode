package c4q.nyc.sufeiiz;

/**
 * Created by sufeizhao on 12/1/15.
 */
public class MissingNum {
    // I have an array of the numbers 1 to 100 in a random number. One of the numbers is missing.
    // Write an algorithm to figure out what the number is and what position is missing.

    public static int missingNum(int[] nums) {
        int index = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                index = i;
        }

        return index;
    }
}
