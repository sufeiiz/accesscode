import sun.misc.Sort;

import java.util.*;

/**
 * Created by Sufei Zhao on 4/14/15.
 */

public class DataStructures {

    // Write a method called mostFrequentElement that takes an ArrayList of Integers and finds the most
    // frequently occurring element in the ArrayList. At the end print the element and its number of occurrences.
    // If there is more than one such element, any one of them may be printed.
    public static void mostFrequentElement(ArrayList<Integer> nums) {
        // HashMap of num to frequency
        HashMap<Integer, Integer> frequent = new HashMap<Integer, Integer>();
        for (Integer num : nums) {
            if (frequent.containsKey(num))
                frequent.put(num, frequent.get(num) + 1);
            else
                frequent.put(num, 1);
        }

        int max = Collections.max(frequent.values());
        for (Integer num : frequent.keySet()) {
            if (frequent.get(num) == max) {
                System.out.println("The number " + num + " appears the most: " + max + " times.");
            }
        }
    }

    // Write a method called canRentACar that takes the Pod HashMap as a parameter and returns whether or not the Pod can rent a car.
    // If one or more studetns is over 25, it should return true. If no one in the Pod is over 25, it should return false.
    public static boolean canRentACar(HashMap<String, Integer> pod) {
        for (String name : pod.keySet()) {
            if (pod.get(name) > 25)
                return true;
        }
        return false;
    }

    // Given an array of strings and an integer, write a method that return a an ArrayList where all the strings of the given length are omitted
    public static ArrayList<String> wordsWithoutList(ArrayList<String> list, int length) {
        ArrayList<String> strings = new ArrayList<String>();
        for (String string : list) {
            if (string.length() != length)
                strings.add(string);
        }
        return strings;
    }

    // Say that a "clump" in an ArrayList is a series of 2 or more adjacent elements of the same value.
    // Write a method that returns the number of clumps in the given ArrayList.
    public static int countClumps(ArrayList<Integer> nums) {
        Iterator<Integer> numsIter = nums.iterator();
        String numbers = " ";
        int num, lastIndex, count = 0;
        boolean alreadyAdded = false;

        while (numsIter.hasNext()) {
            num = numsIter.next();
            lastIndex = numbers.length() - 1;
            if (Integer.toString(num).charAt(0) == numbers.charAt(lastIndex) && !alreadyAdded) {
                count++;
                numbers += num;
                alreadyAdded = true;
            } else if (Integer.toString(num).charAt(0) == numbers.charAt(lastIndex) && alreadyAdded) {
                numbers += num;
            } else {
                numbers += num;
                alreadyAdded = false;
            }
        }

        return count;
    }

    // Write a method that takes a String sentence, breaks it up into an ArrayList of Strings (one word per ArrayList element),
    // and prints out the words in alphabetical order.
    public static void sortSentence(String sentence) {
        String[] list = sentence.split(" ");
        ArrayList<String> words = new ArrayList<String>();
        Collections.addAll(words, list);

        Collections.sort(words);
        for (String word : words) {
            System.out.println(word);
        }
    }

    public static void main (String args[]) {
        // Create an ArrayList of 5 Cats.
        // Use a loop to print the contents of each object in the ArrayList.
        ArrayList<Cat> cats = new ArrayList<Cat>();
        cats.add(new Cat("Garfield"));
        cats.add(new Cat("Queen"));
        cats.add(new Cat("Miles"));
        cats.add(new Cat("Cyrus"));
        cats.add(new Cat("Harry"));

        for (Cat cat : cats) {
            System.out.println(cat.getName());
        }

        // Create a HashMap that maps the names of all the Access Coders in your Pod to their age.
        // Use a loop to print each key-value pair of the HashMap.
        HashMap<String, Integer> pod = new HashMap<String, Integer>();
        pod.put("Alvin", 23);
        pod.put("Sufei", 23);
        pod.put("Jorge", 28);
        pod.put("George", 24);
        pod.put("Na", 18);
        for (String name : pod.keySet()) {
            System.out.println(name + " is " + pod.get(name) + " years old.");
        }
    }
}
