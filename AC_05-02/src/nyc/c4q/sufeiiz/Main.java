package nyc.c4q.sufeiiz;

public class Main {

    public static void main(String[] args) {

        // Demonstrate the classes in a program that has a Shiparray.
        // Assign various Ship, CruiseShip, and CargoShip objects to the array elements.
        Ship[] shipArray = new Ship[8];
        shipArray[0] = new Ship("Wario", 2000);
        shipArray[1] = new CruiseShip("Yoshi", 2001, 200);
        shipArray[2] = new CruiseShip("Daisy", 1999, 300);
        shipArray[3] = new Ship("Luigi", 2001);
        shipArray[4] = new Ship("Boo", 2001);
        shipArray[5] = new Ship("Koopa Troopa", 2000);
        shipArray[6] = new CargoShip("Peach", 2006, 100);
        shipArray[7] = new CargoShip("Mario", 2004, 350);

        for (Ship ship : shipArray) {
            System.out.println(ship.toString());
        }
    }
}
