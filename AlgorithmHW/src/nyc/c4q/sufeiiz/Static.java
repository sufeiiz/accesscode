package nyc.c4q.sufeiiz;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by sufeizhao on 11/10/15.
 */

public class Static {
    public static Set<String> db = new HashSet<String>();

    public static Integer maxNum(int[] nums) {
        int max;

        if (nums.length < 0)
            max = Integer.MIN_VALUE;
        else
            throw new IllegalArgumentException("empty list!");

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max)
                max = nums[i];
        }

        return max;
    }

    public static void main(String[] args) {
        //System.out.println(maxNum(new int[] {0,4,1,-3,4,6,9,4,132,9,4}));
        SSgenerator();
        System.out.println(db);
    }

    class SS {
        String SSN;

        public SS(String SSN) {
            this.SSN = SSN;
        }
    }

    public static String SSgenerator() {
        //int SSN = (int) Math.random() * 1000000001;

        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            sb.append(random.nextInt(10));
        }
        String SSN = sb.toString();

        if (db.contains(SSN))
            return SSgenerator();

        db.add(SSN);
        return SSN;
    }
}
