package nyc.c4q.sufeiiz;

/**
 * Created by sufeiiz & vanice on 3/8/15.
 * Access Code 2.1
 * This program guesses users occupation based on input
 */

import java.util.Scanner;

public class Occupation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        /*char sword, helmet, shovel;
        String occupation;

        System.out.print("Do you carry a sword? Type y or n: ");
        sword = input.next().charAt(0);
        System.out.print("Do you wear a helmet? Type y or n: ");
        helmet = input.next().charAt(0);
        System.out.print("Do you use a shovel? Type y or n: ");
        shovel = input.next().charAt(0);

        if (sword == 'y' && helmet == 'y' && shovel == 'n') {
            occupation = " samurai.";
        } else if (sword == 'y' && helmet == 'n' && shovel == 'n') {
            occupation = " ninja.";
        } else if (sword == 'n' && helmet == 'y' && shovel == 'y') {
            occupation = " construction worker.";
        } else if (sword == 'n' && helmet == 'n' && shovel == 'y') {
            occupation = " gardener.";
        } else if (sword == 'n' && helmet == 'y' && shovel == 'n') {
            occupation = "n astronaut.";
        } else if (sword == 'n' && helmet == 'n' && shovel == 'n') {
            occupation = " coder.";
        } else {
            System.err.println("I don't know your occupation.");
            return;
        }
        System.out.println("You are a" + occupation);
        */

        // Alternate solution:
            System.out.print("Do you carry a sword? ");
            String response = input.next();
            boolean sword =
                response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y");
            System.out.print("Do you wear a helmet? ");
            response = input.next();
            boolean helmet =
                response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y");
            System.out.print("Do you use a shovel? ");
            response = input.next();
            boolean shovel =
                response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y");
            boolean none =
                    ! response.equalsIgnoreCase("yes") || ! response.equalsIgnoreCase("no");
            if (!response.equalsIgnoreCase("yes") && !response.equalsIgnoreCase("no")) {
                System.err.println("Please enter yes or no");
                return;
            }

            String profession = "";
            if (sword && helmet && !shovel)
                profession = " samurai.";
            else if (sword && !helmet && !shovel)
                profession = " ninja.";
            else if (!sword && helmet && shovel)
                profession = " construction worker.";
            else if (!sword && helmet && !shovel)
                profession = "n astronaut.";
            else if (!sword && !helmet && !shovel)
                profession = " coder.";
            else if (none) {
                System.err.println("I don't know your occupation");
                return;
            }
            System.out.println("You are a" + profession);

    }
}
