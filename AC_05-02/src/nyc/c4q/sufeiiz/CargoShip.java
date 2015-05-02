package nyc.c4q.sufeiiz;

/**
 * Created by sufeizhao on 5/2/15.
 *
 * Design a CargoShip class that extends the Ship class.
 * The CargoShip class should have the following members:
 *      A field for the cargo capacity in tonnage (an int).
 *      A constructor and appropriate accessors and mutators.
 *      A toString method that overrides the toString method in the base class.
 * The CargoShip class's toString method should display only the ship's name and the ship's cargo capacity.
 */

public class CargoShip extends Ship{

    private int capacity;

    public CargoShip(String shipName, int year, int capacity) {
        super(shipName, year);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return this.getShipName() + " holds " + this.getCapacity() + " tons";
    }
}
