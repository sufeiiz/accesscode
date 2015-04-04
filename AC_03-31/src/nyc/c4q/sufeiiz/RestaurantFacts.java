package nyc.c4q.sufeiiz;

/**
 * Access Code 2.1
 *
 * Author  Sufei Zhao
 * Date    March 31 2015
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class RestaurantFacts {

    public static void main(String[] args) {
        // Step 1. Use FileParser's static method getLines() to get a nested ArrayList representing the CSV file.
        ArrayList<ArrayList<String>> lines = new ArrayList<ArrayList<String>>();
        lines = FileParser.getLines("/Users/sufeizhao/Desktop/accesscode/AC_03-31/nyc-restaurants-small.csv", 14);

        // Step 2. Build a HashMap named "restaurants".
        //         Loop over every line and add the appropriate data to your HashMap.
        HashMap<String, String> restaurants = new HashMap<String, String>();
        ArrayList<String> facts = new ArrayList<String>();

        for (ArrayList<String> line : lines) {
            restaurants.put(line.get(1), line.get(14));
        }

        // Step 3. Create a Scanner and prompt the user for a restaurant.
        //         If the restaurant has a relevant fact, print it. Otherwise
        //         print "Restaurant not found.".
        Scanner input = new Scanner(System.in);
        System.out.print("Enter restaurant name: ");
        String fact = input.nextLine();

        if (restaurants.containsKey(fact))
            System.out.println(restaurants.get(fact));
        else
            System.out.println("None");
    }
}
