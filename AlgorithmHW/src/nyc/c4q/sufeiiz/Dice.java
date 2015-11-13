package nyc.c4q.sufeiiz;

/**
 * Created by sufeizhao on 11/10/15.
 */
public class Dice {
    int num;
    static int diceCount = 0;

    public Dice(int num) {
        this.num = num;
    }

    public static int roll1() {
        diceCount++;
        return 1 + (int) (Math.random() * 6);
    }

    public int roll() {
        int result = 0;

        for (int i = 0; i < num; i++)
            result += roll1();

        return result;
    }

    public static int getDiceCount() {
        return diceCount;
    }
}
