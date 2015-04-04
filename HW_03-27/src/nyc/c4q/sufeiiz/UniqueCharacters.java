package nyc.c4q.sufeiiz;

/**
 * Created by sufeizhao on 3/21/15.
 * Access Code 2.1
 * UniqueCharacters.java
 * Write a function uniqueCharacters which accepts as input a string S.
 * Given the string S return a string S2 which contains all the distinct characters in S.
 * The input string will only contain lowercase characters.
 * The ordering of characters in the output string does not matter. Eg.

 abbcaabcaa --> abc
 apple --> aple or aepl
 microsoft --> microsft
 */

public class UniqueCharacters {

    public static String uniqueCharacters(String string) {
        String letter, distinct = "";

        for (int i=0; i<string.length(); i++) {
            letter = Character.toString(string.charAt(i));
            if (distinct.contains(letter))
                continue;
            else
                distinct += letter;
        }

        return distinct;
    }

    public static void main(String[] args) {
        System.out.print(uniqueCharacters("hippopotamus"));
    }
}
