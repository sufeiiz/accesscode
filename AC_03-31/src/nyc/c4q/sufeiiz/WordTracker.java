package nyc.c4q.sufeiiz;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by sufeizhao on 3/31/15.
 * Access Code 2.1
 * WordTracker.java
 * Adds user input to a hashmap and returns number of keys and values
 */

public class WordTracker {

    public static void main(String[] args) {
        HashMap<String, Integer> tracker = new HashMap<String, Integer>();
        Scanner input = new Scanner(System.in);
        boolean addMode = true;
        String word;
        int size;

        System.out.println("Please give me some words: (Type STOP to end program)");

        while (true) {
            word = input.next();
            if (word.equalsIgnoreCase("stop"))
                break;
            else if (word.equalsIgnoreCase("rm")) {
                addMode = false;
                continue; // or else rm or add will be put into HashMap
            } else if (word.equalsIgnoreCase("add")) {
                addMode = true;
                continue;
            } else if (word.equalsIgnoreCase("clr")) {
                tracker.clear();
                continue;
            }

            if (addMode)
                if (tracker.containsKey(word))
                    tracker.put(word, tracker.get(word) + 1);
                else
                   tracker.put(word, 1);
            else
                if (tracker.containsKey(word)) {
                    // remove word if word count will be 0
                    if (tracker.get(word) == 1)
                        tracker.remove(word);
                    else
                        tracker.put(word, tracker.get(word) - 1);
                } else {
                    tracker.remove(word);
                }
        }

        size = tracker.size();
        System.out.println("Thanks! You have give me " + size + " word(s).");

        if (tracker.isEmpty())
            System.out.println("Words is empty.");
        else {
            System.out.println("Here they are:");
            for (String key : tracker.keySet()) {
                System.out.println(key + ": " + tracker.get(key));
            }
        }
    }
}
