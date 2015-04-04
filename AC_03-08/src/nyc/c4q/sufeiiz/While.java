package nyc.c4q.sufeiiz;

/**
 * Created by sufeizhao & Vanice on 3/8/15.
 * Access Code 2.1
 * Creating while loops to countdown
 */

public class While {
    public static void main(String[] args) {
        /*int counter = 10;
        while (counter > 0) {
            System.out.println(counter);
            counter -= 1;
        }*/

        int count = 100;
        while (count > 0) {
            System.out.println(count);
            if (count > 10) {
                count -= 5;
            } else {
                count -= 1;
            }
        }
        System.out.println("Blastoff!");
    }
}
