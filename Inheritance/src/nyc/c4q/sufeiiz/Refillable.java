package nyc.c4q.sufeiiz;

/**
 * Created by sufeizhao on 4/25/15.
 */

public interface Refillable {
        void refill();
        boolean isEmpty();
        int getGas();
        void use(int anything);
    }
