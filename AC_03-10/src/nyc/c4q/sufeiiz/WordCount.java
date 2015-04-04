package nyc.c4q.sufeiiz;

/**
 * Created by sufeizhao on 3/10/15.
 * Acess Code 2.1
 * Counting a given work in a give String.
 */

import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String quote;
        String findWord;
        boolean found = false;
        int count = 0;

        System.out.println("Where should I search for your work?");
        quote = input.nextLine().toLowerCase();
        System.out.print("What word should I look for? ");
        findWord = input.next().toLowerCase();

        for (int i = 0; i <= quote.length()-findWord.length(); i++) {
            for (int j = 0; j < findWord.length(); j++) {
                // if the character matches, keep checking the next character
                if (quote.charAt(i + j) == findWord.charAt(j)) {
                    continue;
                } else {
                    found = true;
                    break;
                }
            }

            // if word is found, add word to count
            if (found) {
                count++;
            }
        }

        System.out.println("I found the word \"" + findWord + "\" " + wordCount + " times.");
    }
}