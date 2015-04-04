package nyc.c4q.sufeiiz;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Access Code 2.1
 *
 * Author  Sufei Zhao
 * Date    March 24 2015
 *
 * This class asks the user which car they have and prints its price.
 */

public class NameTracker {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<String>();
        names.add("Ana");

        // adds user input to ArrayList
        System.out.println("Please give me some names: ");
        while (true) {
            String newName = input.nextLine();
            if (newName.equals("")) {
                break;
            }
            names.add(newName);
        }

        // prints out items in ArrayList in reverse
        System.out.println("Your " + names.size() + " names(s) have been saved! They are:");
        for (int i=names.size()-1; i>=0; i--) {
            System.out.println(names.get(i));
        }

        // returns boolean for if input is in ArrayList
        System.out.println("Search for a name: ");
        if (names.contains(input.next()))
            System.out.println("Yes!");
        else
            System.out.println("No");
    }
}
