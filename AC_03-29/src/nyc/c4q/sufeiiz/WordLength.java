package nyc.c4q.sufeiiz;

import com.sun.applet2.AppletParameters;

import java.util.ArrayList;
import java.util.HashMap;

public class WordLength {

    public static HashMap<String, Integer> getLengths(ArrayList<String> strings) {
        HashMap<String, Integer> wordLength = new HashMap<String, Integer>();
        for (String word : strings) {
            wordLength.put(word, word.length());
        }

        return wordLength;
    }

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<String>();
        words.add("banana");
        words.add("pineapple");
        words.add("cantaloupe");

        HashMap<String, Integer> lengths = getLengths(words);
        System.out.println(lengths.get("banana"));      // should print 6
        System.out.println(lengths.get("cantaloupe"));  // should print 10
        System.out.println(lengths.get("broccoli"));    // should print null
    }
}
