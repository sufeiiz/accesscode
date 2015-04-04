package nyc.c4q.sufeiiz;

/**
 * Created by sufeizhao on 3/15/15.
 * Access Code 2.1
 * PrettyTitle.java
 * Write a program that calls a method printTitle that prints a phrase as a title by,
 *   - converting it to title capitalization
 *   - underlining each word, i.e. underlying all characters except spaces
 */

import java.util.Arrays;
import java.util.Scanner;

public class PrettyTitle {

    // checks if a word is in the list of prepositions
    public static boolean findPreposition(String word) {
        String[] prepositions = {"a", "an", "the", "at", "by", "for", "in", "of",
                "on", "to", "up", "and", "as", "but", "it", "or", "nor"};

        return Arrays.asList(prepositions).contains(word);
    }

    // capitalizes first letter of a word
    public static String capitalize(String word) {
        char firstLetter = word.charAt(0);
        char capitalLetter = Character.toUpperCase(firstLetter);

        if (word.length() == 1)
            return capitalLetter + " ";
        else
            return capitalLetter + word.substring(1) + " ";
    }

    // Underlines title with input character, except under empty space
    public static void underline(String sentence, char character) {
        for (int i = 0; i<sentence.length(); i++) {
            if (sentence.charAt(i) == ' ')
                System.out.print(" ");
            else
                System.out.print(character);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String title, word;
        char symbol;
        int lastSpace = -1;

        System.out.print("Enter title: ");
        title = input.nextLine();
        System.out.print("Enter symbol: ");
        symbol = input.next().charAt(0);

        // add a space to the end of the title in order to include the last word in loop
        title += " ";

        for (int i = 0; i < title.length(); i++) {

            if (title.charAt(i) == ' ') {
                word = title.substring(lastSpace+1, i);  // lastSpace+1 does not include lastSpace in substring
                if (lastSpace == -1)                     // if first space found, capitalize first word
                    System.out.print(capitalize(word));
                else if (findPreposition(word))
                    System.out.print(word + " ");
                else
                    System.out.print(capitalize(word));
                lastSpace = i;
            }
        }
        System.out.println();
        underline(title, symbol);
    }
}
