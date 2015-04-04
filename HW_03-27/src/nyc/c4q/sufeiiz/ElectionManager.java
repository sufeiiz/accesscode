package nyc.c4q.sufeiiz;

/**
 * Created by sufeizhao on 3/21/15.
 */
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A Election Manager
 *   - Conducts an election.
 *   - Controls start of voting
 *
 * Ignore the private fields and constructor
 * Focus on the public methods
 */

public class ElectionManager {

    // You can safely ignore what an ArrayList does
    private ArrayList<Election> race;

    private static Scanner sc = new Scanner(System.in);

    /**
     * Create an ElectionManager.
     *
     */
    public ElectionManager() {
        race = new ArrayList<Election>();
    }

    /** Add a new Election instance */
    public void manage(Election race) {
        this.race.add(race);
    }

    /** Start the loop that allows individuals to void electronically.
     *
     *  Voting end is controlled by the voter through the console
     *
     *  If the user inputs 0, polls end
     */
    public void initiatePolling() {
        while ( pollsOpen() ) {
            for ( Election r : race ) {
                System.out.println("\nVOTE FOR ONE");
                r.vote();
            }
        }
    }

    /**
     * Displays the total number of votes received  by each contender
     *
     */
    public void displayResults() {

        System.out.println("Results of Voting ");
        for ( Election r : race ) {
            r.displayResults();
        }

    }

    /**
     * Static method. Start/Stop polls for all elections
     * @return
     */
    public static boolean pollsOpen() {
        System.out.print("Type anything to close polls else press enter to continue: ");
        String answer = sc.nextLine();
        return answer.equals("");
    }

}