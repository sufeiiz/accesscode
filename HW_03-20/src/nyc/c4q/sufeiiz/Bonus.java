package nyc.c4q.sufeiiz;

/**
 * Created by sufeizhao on 3/17/15.
 * Access Code 2.1
 * Bonus.java
 * Bonus questions on String methods
 */

public class Bonus {

    // counts the number of words in a string
    public static int countWords(String sentence) {
        int count = 0;
        char current, next;

        for (int i=0; i<sentence.length()-1; i++) {
            current = sentence.charAt(i);
            next = sentence.charAt(i+1);

            if (current == ' ' &&
                    (next == '.' || current == ',' || current == '!' || current == '?' || current == '-'))
                continue;
            if (current == ' ' && next != ' ')
                count++;
        }
        return count + 1;
    }

    // computes the average word length by counting the total number of letters in words (not including spaces)
    // as well as the total number of words, and divide them. Make sure the result is a double, not an int
    // For example, averageWordLength("Eighty percent of success is showing up.")
    // returns about 4.714.
    public static double avgWordLength(String sentence) {
        double countLetters = 0;

        for (int i=0; i<sentence.length(); i++) {
            if (sentence.charAt(i) == ' '
                    || sentence.charAt(i) == '.'
                    || sentence.charAt(i) == ','
                    || sentence.charAt(i) == '!'
                    || sentence.charAt(i) == '?'
                    || sentence.charAt(i) == '-')
                continue;
            else
                countLetters++;
        }

        return countLetters / countWords(sentence);
    }

    // reverses a string by order of words (rather than characters). Treat punctuation as part of a word.
    public static String reverseWords(String sentence) {
        char current;
        String reversed = "";
        int lastI = sentence.length();

        // add a space before sentence so that the first word will be added to new reversed string
        sentence = " " + sentence;
        for (int i=sentence.length()-1; i>=0; i--) {
            current = sentence.charAt(i);

            if (current == ' ') {
                reversed += sentence.substring(i, lastI);
                lastI = i;
            }
        }

        return reversed;
    }
}
