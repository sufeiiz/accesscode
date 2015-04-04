package nyc.c4q.sufeiiz;

/**
 * Access Code 2.1
 *
 * Author  Sufei Zhao
 * Date    March 24 2015
 *
 * This class asks the user which car they have and prints its price.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class BlueBook {

    public static void main(String[] args) {
        // 1. Create a Scanner for user input.
        Scanner input = new Scanner(System.in);
        String make, model;
        int year;
        double cost;

        // 2. Create an ArrayList that holds type Car.
        ArrayList<Car> carList = new ArrayList<Car>();

        // 3. Create a few new Car objects and add them to the ArrayList.
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

        // 4. Prompt the user for the carList's make, model, and year, and store the inputs in variables.
        System.out.print("What is your car's make, model, and year? ");
        make = input.next();
        model = input.next();
        year = input.nextInt();

        // 5. Iterate over your ArrayList of cars and check for a Car instance that has the same...
        //    ...make
        //    ...model
        //    ...year
        for (int i=0; i<carList.size(); i++) {
            Car current = carList.get(i);
            if (current.getMake().equalsIgnoreCase(make)) {
                if (current.getModel().equalsIgnoreCase(model)) {
                    if (current.getYear() == year) {
                        System.out.println("Your " + year + " " + make + " " + model + " is worth $" + current.getPrice());
                        return;
                    }
                }
            }
        }
        System.out.println("The price of your " + year + " " + make + " " + model + " is unknown.");
        System.out.println("How much did it cost? ");
        cost = input.nextDouble();
        carList.add(new Car(make, model, year, cost));
        System.out.println("Your car has been added to the database.");

        // 6. Print the price of that carList.
    }
}
