import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Sufei Zhao on 4/14/15.
 * Use a HashSet to figure out how many unique words are in A Tale of Two Cities and Moby Dick.
 */

public class UniqueWords {

    public static HashSet<String> uniqueSet(File file) throws FileNotFoundException {
        HashSet<String> unique = new HashSet<String>();
        String curr;

        Scanner input = new Scanner(file);

        while (input.hasNextLine()) {
            curr = input.next().toLowerCase().replaceAll("\\W", "");

            if (!unique.contains(curr) && curr.length() > 0)
                unique.add(curr);
        }

        return unique;
    }


    public static void main (String args[]) throws FileNotFoundException {
        File mb = new File("/Users/sufeizhao/Desktop/accesscode_forks/unit-1-bootcamp/src/Files/MobyDick.txt");
        File ttc = new File("/Users/sufeizhao/Desktop/accesscode_forks/unit-1-bootcamp/src/Files/TaleCity.txt");
        HashSet<String> moby = new HashSet<String>(uniqueSet(mb));
        HashSet<String> tale = new HashSet<String>(uniqueSet(ttc));
        int mobyCount, taleCount;

        // How many unique characters in each book?
        mobyCount = moby.size();
        taleCount = tale.size();
        System.out.println("Unique characters in Moby Dick: " + mobyCount);
        System.out.println("Unique characters in A Tale of Two Cities: " + taleCount);

        // Create a set that is the intersection of words between A Tale of Two Cities and Moby Dick.
        // What is the cardinality (size) of this set?
        HashSet<String> all = new HashSet<String>(moby);
        all.addAll(tale);
        HashSet<String> intersection = new HashSet<String>();

        for (String word : all) {
            if (moby.contains(word) && tale.contains(word))
                intersection.add(word);
        }
        System.out.println("These two sets have " + intersection.size() + " words in common.");

        // Create a set that is the union of words between A Tale of Two Cities and Moby Dick.
        // Create an iterator for the union set.
        HashSet<String> union = new HashSet<String>(moby);
        union.addAll(tale);
        Iterator<String> unionIter = union.iterator();
    }
}
