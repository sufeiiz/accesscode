package nyc.c4q.sufeiiz;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by sufeizhao on 4/4/15.
 * A concordance lists every word that occurs in the document, and for each word it gives the
 * line number of every line in the document where the word occurs. A concordance is like an
 * index except that line numbers are used instead of page numbers.
 * Write a program that can create a concordance. The document should be read from an input file.
 * As you read the file, you want to take each word that you encounter and add it to the concordance
 * along with the current line number.
 * Because it is so common, don't include the word "the" in your concordance.
 * Also, do not include words that have length less than 3. Feel free to add other “banned” words for testing purposes.
 */

public class Concordance {
    private HashSet<String> excludedWords;
    private HashMap<String, HashSet<Integer>> listing;
    private HashSet<Integer> lineNum;

    public Concordance(String filename, HashSet<String> bannedWords){
        File file = new File(filename);
        lineNum = new HashSet<Integer>();
        listing = new HashMap<String, HashSet<Integer>>();
        String currWord;
        int line = 1;

        try {
            Scanner input = new Scanner(new FileReader(file));

            while (input.hasNextLine()) {


                currWord = input.next();
                currWord = currWord.replaceAll("(?!\")\\p{Punct}", "");

                if (bannedWords.contains(currWord) || currWord.length() < 5)
                    break;
                lineNum.add(line);
                listing.put(currWord, lineNum);


                line++;
            }
        } catch (IOException error) {
            System.out.println("Invalid file: " + error);
        }
    }

    public HashSet<Integer> findLineNumbers(String word){
        HashSet<Integer> occur = new HashSet<Integer>();

        for (String each : listing.keySet()) {
            if (each.equalsIgnoreCase(word))
                occur.addAll(listing.get(each));
        }

        return occur;
    }

    public HashSet<Integer> getCommonLines(String word1, String word2){
        HashSet<Integer> common = new HashSet<Integer>();
        HashSet<Integer> one = new HashSet<Integer>(listing.get(word1));
        HashSet<Integer> two = new HashSet<Integer>(listing.get(word2));

        for (Integer each : one) {
            if (two.contains(each))
                common.add(each);
        }

        return common;
    }

    public void print(){
        for (String word : listing.keySet()) {
            System.out.println(word + " : " + listing.get(word));
        }
    }

    public static void main(String[] args) {
        HashSet<String> banned = new HashSet<String>();

        banned.add("the");
        banned.add("and");
        banned.add("this");
        banned.add("that");
        banned.add("him");
        banned.add("her");
        banned.add("his");
        banned.add("hers");
        banned.add("they");
        banned.add("them");
        banned.add("those");
        banned.add("you");
        banned.add("off");
        banned.add("their");
        banned.add("you");
        banned.add("you");




        Concordance moby = new Concordance("/Users/sufeizhao/Desktop/accesscode/AC_04-04/src/nyc/c4q/sufeiiz/moby.txt", banned);

        moby.print();
    }

}
