package nyc.c4q.sufeiiz;

import java.util.ArrayList;

/**
 * Access Code 2.1
 *
 * Author  Gregory Gundersen
 * Date    March 24 2015
 *
 * This class represents a car.
 */

public class Car {

    String make;
    String model;
    int year;
    double price;

    public Car(String make, String model, int year, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public int getYear() {
        return this.year;
    }

    public double getPrice() {
        return this.price;
    }

    public double isInBluebook(String make, String model, int year) {
        ArrayList<Car> carList = new ArrayList<Car>();

        carList.add(new Car("Honda", "Accord", 2014, 21955));
        carList.add(new Car("Honda", "Pilot", 2014, 21955));
        carList.add(new Car("Toyota", "Corolla", 2014, 16800));
        carList.add(new Car("Lexus", "RX", 2015, 40970));
        carList.add(new Car("Mercedes-Benz", "S-class", 2015, 94400));
        carList.add(new Car("Mercedes-Benz", "E-class", 2015, 51400));
        carList.add(new Car("Jeep", "Grand Cherokee", 2014, 29495));
        carList.add(new Car("Ford", "Explorer", 2014, 30015));
        carList.add(new Car("Ford", "Fusion", 2015, 22500));
        carList.add(new Car("Acura", "RDX", 2015, 35095));

        for (int i=0; i<carList.size(); i++) {
            Car current = carList.get(i);
            if (current.getMake().equalsIgnoreCase(make)) {
                if (current.getModel().equalsIgnoreCase(model)) {
                    if (current.getYear() == year)
                        return current.getPrice();
                }
            }
        }
        return 0;
    }
}
