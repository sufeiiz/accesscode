package nyc.c4q.sufeiiz;

/**
 * Created by sufeizhao on 5/2/15.
 *
 * Design a CruiseShip class that extends the Ship class.
 * The CruiseShip class should have the following members:
 *      A field for the maximum number of passengers (an int).
 *      A constructor and appropriate accessors and mutators.
 *      A toString method that overrides the toString method in the base class.
 * The CruiseShip class's toString method should display only the ship's name and the maximum number of passengers.
 */

public class CruiseShip extends Ship{

    private int maxPass;

    public CruiseShip(String shipName, int year, int maxPass) {
        super(shipName, year);
        this.maxPass = maxPass;
    }

    public int getMaxPass() {
        return maxPass;
    }

    public void setMaxPass(int maxPass) {
        this.maxPass = maxPass;
    }

    @Override
    public String toString() {
        return this.getShipName() + " holds " + this.getMaxPass() + " passengers";
    }
}
