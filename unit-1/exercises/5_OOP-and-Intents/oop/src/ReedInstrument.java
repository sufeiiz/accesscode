/**
 * Created by sufeizhao on 4/30/15.
 *
 * Create an abstract class ReedInstrument, which implements Instrument.
 * A ReedInstrument needs a boolean field reed, which represents if the instrument currently has a reed in it.
 * It also needs methods:
 *    has_reed which tells us if the instrument currently has a reed
 *    place_reed, which puts a reed on the instrument
 *    remove_reed which removes the reed from the instrument.
 */

public abstract class ReedInstrument implements Instrument {
    boolean reed;

    public boolean has_reed() {
        return this.reed;
    }

    public void place_reed() {
        this.reed = true;
    }

    public void remove_reed() {
        this.reed = false;
    }
}
