package nyc.c4q.sufeiiz;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        ArrayList<Refillable> vehicles = new ArrayList<Refillable>();
        vehicles.add(new Car());
        vehicles.add(new Car());
        vehicles.add(new Car());
        vehicles.add(new Generator());
        vehicles.add(new Generator());

        for(int i=0; i<5; i++) {
            useVehicles(vehicles);
            refillVehicles(vehicles);
        }
    }

    static void useVehicles(ArrayList<Refillable> vehicles) {
        for (Refillable vehicle : vehicles) {
            vehicle.use(new Random().nextInt(10));
            System.out.println("Gas remaining: " + vehicle.getGas());
        }
    }

    static void refillVehicles(ArrayList<Refillable> vehicles) {
        for (Refillable vehicle : vehicles) {
            if(vehicle.isEmpty()) {
                vehicle.refill();
                System.out.println("Refilling...");
            }
        }
    }
}
