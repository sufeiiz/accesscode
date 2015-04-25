package nyc.c4q.sufeiiz;


/**
 * Created by sufeizhao on 4/25/15.
 */
public class Generator implements Refillable{
    int gas = 0;

    public Generator() {
        refill();
    }

    public void refill() {
        gas = gas + 20;
    }

    public boolean isEmpty() {
        return gas == 0;
    }

    public void use(int energy) {
        gas = gas - energy;
        if (gas < 0)
            gas = 0;
    }

    public int getGas() {
        return gas;
    }
}
