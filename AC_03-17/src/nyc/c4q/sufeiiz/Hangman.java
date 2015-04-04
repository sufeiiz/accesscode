package nyc.c4q.sufeiiz;

/**
 * Created by sufeiiz && hyunj0 on 3/17/15.
 * Access Code 2.1
 * Hangman.java
 * Create a game of Hangman
 */

import java.util.Scanner;

public class Hangman {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SecretWord sw = new SecretWord();
        Drawing draw = new Drawing();

        int misses = 0;
        String guess = "";

        System.out.println("Let's play Hangman!\n");

        while (misses < 7) {
            System.out.println(sw.toString());
            System.out.print("Guess a letter: ");
            char userGuess = input.next().toUpperCase().charAt(0);
            String checkUserGuess = Character.toString(userGuess);

            // checks if user already guess the letter
            // String.contains does not work on char, must convert first
            if (guess.contains(checkUserGuess)) {
                System.err.println("You've already guessed that letter.");
                continue;
            }

            if (sw.isLetter(userGuess)) {
                sw.set(userGuess);
                guess += userGuess + " ";
            } else {
                misses++;
                guess += userGuess + " ";
            }

            System.out.println();
            System.out.println(draw.get(misses));
            System.out.println("Misses: " + misses);
            System.out.println("Guesses: " + guess);
            System.out.println();
        }

        System.out.println("You lost! The answer was:");
        System.out.print(sw.reveal());
    }
}
