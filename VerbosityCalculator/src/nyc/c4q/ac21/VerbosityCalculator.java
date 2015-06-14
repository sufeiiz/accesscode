package nyc.c4q.ac21;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Calculate the verbosity of a text (words/sentence)
 */

public class VerbosityCalculator {

    public static void counter(File file) {
        try{
            // Formats double to two significant figures
            DecimalFormat format = new DecimalFormat("###,###.##");

            Scanner input = new Scanner(file);
            String text;
            double avg;
            int wordCount = 0, sentenceCount = 0;

            while (input.hasNext()) {
                text = input.next();
                wordCount++;
                if ((text.contains("Mr.") || text.contains("Mrs.") || text.contains("Ms.") || text.contains("Dr.")))
                    continue;
                else if (text.contains(".") || text.contains("!") || text.contains("?"))
                    sentenceCount++;
            }

            System.out.println("There are " + format.format(sentenceCount) + " sentences in this file.");
            System.out.println("There are " + format.format(wordCount) + " words in this file.");
            avg = wordCount / (double) sentenceCount;
            System.out.println("The average number of words per sentence is " + format.format(avg));

        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){

        // An abstract representation of a File
        File mobyDick = new File("/Users/sufeizhao/Desktop/accesscode/VerbosityCalculator/resources/MobyDick.txt");
        File taleTwoCities = new File("/Users/sufeizhao/Desktop/accesscode/VerbosityCalculator/resources/ATaleOfTwoCities.txt");

        System.out.println("Moby Dick:");
        counter(mobyDick);
        System.out.println("\nA Tale of Two Cities:");
        counter(taleTwoCities);
    }
}
