package nyc.c4q.sufeiiz;

/**
 * Created by sufeizhao on 5/2/15.
 *
 * Title: Ship, CruiseShip, and CargoShip
 * Design a Ship class that the following members:
 *      A field for the name of the ship (a string).
 *      A field for the year that the ship was built (a string).
 *      A constructor and appropriate accessors and mutators.
 *      A toString method that displays the ship's name and the year it was built.
 */

public class Ship {
    private String shipName;
    private int year;

    public Ship(String shipName, int year) {
        this.shipName = shipName;
        this.year = year;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return this.getShipName() + " built in " + this.getYear();
    }
}
