import java.util.ArrayList;
import java.util.List;

// something that can be filled
public interface Refillable {
    public void refill(int amount);
}

// an object representing a vehicle which has refillable behavior
abstract class Vehicle implements Refillable {
}

// this object has refillable behavior
class Cup implements Refillable {
    int cupVolume;
    @Override
    public void refill(int amount) {
        cupVolume = amount;
    }
}

// this object is a vehicle (and indirectly has refillable behavior)
class Car extends Vehicle {
    private int tankVolume;

    public void refill(int amount) {
        tankVolume += amount;
    }
}

// this object is a vehicle (and indirectly has refillable behavior)
class Boat extends Vehicle {
    private int tankVolume;

    public void refill(int amount) {
        tankVolume += 2 * amount;
    }

    public int getSails() {
        return 2;
    }
}

class Main {
    public static void main(String[] args) {
        // http://i.imgur.com/g2iXL7C.jpg
        List<Refillable> things = new ArrayList<Refillable>();

        // this works, since a Boat is a Refillable
        Boat foo = new Boat();
        things.add(foo);

        // this also works, since a Cup is a Refillable
        Cup cup = new Cup();
        things.add(cup);

        // refill all the things!
        for(Refillable thing: things) {
            thing.refill(5);

            // this will work for the first element (Boat)
            // this will throw a ClassCastException for the second element (Cup)
            // to fix this, use the instanceof keyword to check only for Boat objects...
//            if(thing instanceof Boat) {
                System.out.println(((Boat)thing).getSails());
//            }
        }
    }
}