package nyc.c4q.sufeiiz.threads;

import java.util.Random;

/**
 * Created by sufeizhao on 6/13/15.
 */
public class RandomNum {

    public static int generateNum() {
        int num;

        Random random = new Random();
        num = random.nextInt(10) + 1;
        return num;
    }
}
