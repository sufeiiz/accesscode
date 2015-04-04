package nyc.c4q.sufeiiz;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by sufeizhao on 3/30/15.
 * Create a class to calculate the distribution of characters in the contents of a file.
 * Your class called DistributionCalculator should implement a
 * method calculate(File textFile) which accepts as input a Text file.
 * It reads the contents of the file and returns an ArrayList which contains the
 * distribution/percentage of characters (a-z) in the text file.
 * Call the calculate method from main and print the distribution.
 * You can ignore characters which do not belong in the range(a-z) for doing your calculation.
 */

public class DistributionCalculator {

    private static ArrayList<TreeMap<Character, Double>> distribution;
    private static TreeMap<Character, Double> map;

    public static double percentage(double num, int letter) {
        return num/letter;
    }

    public static ArrayList<TreeMap<Character, Double>> calculate(File file) {

        distribution = new ArrayList<TreeMap<Character, Double>>();
        map = new TreeMap<Character, Double>();
        String word;
        char currChar;
        double currValue;
        int letters = 0;

        // initial input of alphabet into Treemap
        map.put('a', 0.0);
        map.put('b', 0.0);
        map.put('c', 0.0);
        map.put('d', 0.0);
        map.put('e', 0.0);
        map.put('f', 0.0);
        map.put('g', 0.0);
        map.put('h', 0.0);
        map.put('i', 0.0);
        map.put('j', 0.0);
        map.put('k', 0.0);
        map.put('l', 0.0);
        map.put('m', 0.0);
        map.put('n', 0.0);
        map.put('o', 0.0);
        map.put('p', 0.0);
        map.put('q', 0.0);
        map.put('r', 0.0);
        map.put('s', 0.0);
        map.put('t', 0.0);
        map.put('u', 0.0);
        map.put('v', 0.0);
        map.put('w', 0.0);
        map.put('x', 0.0);
        map.put('y', 0.0);
        map.put('z', 0.0);

        try {
            Scanner input = new Scanner(new FileReader(file));

            while (input.hasNext()) {
                word = input.next();

                for (int index=0; index<word.length(); index++) {
                    currChar = word.toLowerCase().charAt(index);

                    // if character is a letter, it will be in Treemap
                    // increment letter count
                    if (map.containsKey(currChar)) {
                        currValue = map.get(currChar);
                        map.put(currChar, currValue+1);
                        letters++;
                    }
                }
            }
        } catch (IOException error) {
                System.out.println("Invalid file: " + error);
        }

        for (Map.Entry<Character, Double> entry : map.entrySet()) {
            map.put(entry.getKey(), percentage(entry.getValue(), letters));
        }

        distribution.add(map);

        return distribution;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the file path: ");
        String path = input.nextLine();

        File file = new File(path);
        DecimalFormat format = new DecimalFormat("##.##%");
        distribution = calculate(file);

        // loops through ArrayList to loop through TreeMap
        for (TreeMap<Character, Double> map : distribution) {
            for (Map.Entry<Character, Double> alphabet : map.entrySet()) {
                System.out.println(alphabet.getKey() + " = " + format.format(alphabet.getValue()));
            }
        }
    }
}
