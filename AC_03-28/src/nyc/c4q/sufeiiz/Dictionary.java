package nyc.c4q.sufeiiz;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by sufeizhao & rosemary on 3/28/15.
 * Dictionary.java
 *
 * Given a dictionary, implement some basic search functions
 *   1. Create a dictionary class with a constructor that takes it a file name.
 *      Load all words into an ArrayList
 *   2. Implement a method “search” that accepts a search term from user input and returns all “hits”,
 *      in other words, words that contain the search term
 *   3. Implement a method “prefixSearch” that only returns “hits” that START with the search term
 *   4. Implement a method “suffixSearch” that only returns “hits” that END with the search term
 *   5. Be sure to account for the cases where there are no hits!
 *   6. EXTRA CREDIT:
 *      load the dictionary from a URL instead of a local file using:
 *      http://www.math.sjsu.edu/~foster/dictionary.txt
 */

public class Dictionary {
    private ArrayList<String> words;

    // Create a dictionary class with a constructor that takes it a file name.
    // Load all words into an ArrayList
    public Dictionary(File file) {
        try {
            this.words = new ArrayList<String>();
            Scanner input = new Scanner(new FileReader(file));

            while (input.hasNextLine()) {
                words.add(input.nextLine());
            }
        } catch (IOException error) {
            System.out.println("Invalid file: " + error);
        }
    }

    // Create a dictionary class with a constructor that takes it a URL document name.
    // Load all words into an ArrayList
    public Dictionary(String website) {
        URL url = HTTP.stringToURL(website);
        String document = HTTP.get(url);

        this.words = new ArrayList<String>();
        Scanner input = new Scanner(document);

        while (input.hasNextLine()) {
            words.add(input.nextLine());
        }
    }

    //
    public ArrayList<String> search(String userWord){
        ArrayList<String> hits = new ArrayList<String>();

        for (String word : words) {
            if (word.toLowerCase().contains(userWord.toLowerCase())) {
                hits.add(word);
            }
        }

        if (hits.size() == 0) {
            System.err.println("No word found.");
        }

        return hits;
    }

    public ArrayList<String> prefixSearch(String userWord) {
        ArrayList<String> hits = new ArrayList<String>();

        for (String word : words) {
            if (word.toLowerCase().startsWith(userWord.toLowerCase())) {
                hits.add(word);
            }
        }

        if (hits.size() == 0) {
            System.err.println("No word found.");
        }

        return hits;
    }

    public ArrayList<String> suffixSearch(String userWord) {
        ArrayList<String> hits = new ArrayList<String>();

        for (String word : words) {
            if (word.toLowerCase().endsWith(userWord.toLowerCase())) {
                hits.add(word);
            }
        }

        if (hits.size() == 0) {
            System.err.println("No word found.");
        }

        return hits;
    }

    public static void main(String[] args) {

//        if doc is from downloaded file
//        File file = new File("/Users/sufeizhao/Desktop/accesscode/AC_03-28/words");
//        Dictionary words = new Dictionary(file);
//
//        ArrayList<String> hits = words.search("abcdefghijk");
//
//        for (String word : hits) {
//            System.out.println(word);
//        }

        //if doc is from URL
        Dictionary words = new Dictionary("http://www.math.sjsu.edu/~foster/dictionary.txt");
        ArrayList<String> hits = words.search("aardvark");

        for (String word : hits) {
            System.out.println(word);
        }
    }
}
