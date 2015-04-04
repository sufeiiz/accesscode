package nyc.c4q.sufeiiz;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class for storing Election details
 *   - Maintains a list of contenders
 */

public class Election {
    private String electionName;
    private ArrayList<Contender> listOfContenders;

    private static Scanner sc = new Scanner(System.in);

    /**
     * Creates an Election with the fields electionName
     * and an empty listOfContenders of contenders
     *
     * @param electionName The name of the electionName being elected.
     */

    public Election(String electionName) {
        this.listOfContenders = new ArrayList<Contender>();
        this.electionName = electionName;
    }

    /**
     * Add a contender to the listOfContenders of contestants
     *
     * @param contender A new Candidate to add to the listOfContenders.
     */
    public void add(Contender contender) {
        listOfContenders.add(contender);
    }

    /**
     * Increase the vote received a contender
     * @param index The index is the index in listOfContenders
     */
    private void vote(int index) {
        // Determine which candidate and increment their vote count
        listOfContenders.get(index).addVote();
    }

    public void displayCandidates(){
        for ( Contender c : listOfContenders){
            System.out.println(c.getName());
        }
    }

    /**
     * Display the number of votes received for all Contenders
     */
    public void displayResults() {
        System.out.println("\n"+ electionName);
        for ( Contender c : listOfContenders) {
            System.out.println(c.toString());
        }


    }

    /**
     * Display the Election Name and print the list of Contenders
     *
     * Select the index of the contender to vote.
     *
     * */
    public void vote() {
        System.out.println(electionName);
        int i=1;

        // Display a list of the contenders
        for ( Contender c : listOfContenders) {
            System.out.println("Index = " + i + ", Contender = " + c.getName() );
            i = i + 1;
        }

        boolean voted = false;
        while ( !voted ) {
            System.out.print("Enter the index of the Contender you want to vote for: ");
            String vote = getUsersChoice();

            int index = Integer.parseInt(vote)-1;

            if ( index >=0 && index < listOfContenders.size() ) {
                vote(index);
                voted = true;
            }
            else
                System.out.println("Contender does not exist");
        }

    }

    public static String getUsersChoice() {
        return sc.nextLine();
    }

}