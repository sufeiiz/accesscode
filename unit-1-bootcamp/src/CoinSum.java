/**
 * Created by sufeizhao on 4/15/15.
 */
public class CoinSum {
    // In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
    //    1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
    // It is possible to make £2 in the following way:
    //    1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
    // How many different ways can £2 be made using any number of coins?

    // How many different ways can you make $2 with American coins?
    // How many different ways can you make $2 with Canadian coins?
    // Read more on dynamic programming and the coin change problem.

    public static void euroAdd() {
        int[] euro = {200, 100, 50, 20, 10, 5, 2, 1};
        int sum, count = 0;

        for (int i = 0; i < euro.length; i++) {
            sum = 0;
            sum += euro[i];

            while (sum < 200) {
                sum += euro[i];
            }

            if (sum == 200)
                count++;
        }
    }


    public static void main(String[] args) {

    }
}
