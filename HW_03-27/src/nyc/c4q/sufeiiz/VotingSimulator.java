package nyc.c4q.sufeiiz;

/**
 * Created by sufeizhao on 3/21/15.
 * Access Code 2.1
 * VotingSimulator.java
 * You are given 3 classes
 * Write a program to simulate an election. Create a class called VotingSimulator.
 * Follow the instructions on the console.
 * After each round of polling you will be asked(within the console) whether you want to continue or not.
 * Ask the ElectionManager to displayResults
 */

public class VotingSimulator {

    public static void main(String[] args) {

        // Create an Election object, and given the Election a name
        Election election = new Election ("Presidential 2016");

        // Create a few Contender objects. Add these to the Election object.
        Contender hillary = new Contender ("Hillary Clinton");
        Contender jeb = new Contender ("Jeb Bush");
        election.add(hillary);
        election.add(jeb);

        // Create a ElectionManager object. Ask it to manage the Election object created above.
        ElectionManager manager = new ElectionManager();
        manager.manage(election);

        // Ask the ElectionManager to initiatePolling
        manager.initiatePolling();

        // Ask the ElectionManager to displayResults
        manager.displayResults();

        if (hillary.getVotesReceived() > jeb.getVotesReceived())
            System.out.println(hillary.getName() + " won the election!");
        else if (hillary.getVotesReceived() < jeb.getVotesReceived())
            System.out.println(jeb.getName() + " won the election!");
        else
            System.out.println("It was a tie.");
    }

}
