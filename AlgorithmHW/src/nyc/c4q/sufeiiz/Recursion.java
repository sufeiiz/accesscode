package nyc.c4q.sufeiiz;

/**
 * Created by sufeizhao on 11/4/15.
 */
public class Recursion {
    public static boolean isEvenWord(String word) {
        if (word.length() == 0)
            return true;
        else if (word.length() % 2 != 0)
            return false;
        else {
            char letter = word.charAt(0);
            word = word.substring(1);

            if (word.contains(Character.toString(letter))) {
                word = word.replaceFirst(Character.toString(letter), "");
                return isEvenWord(word);
            } else
                return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isEvenWord("tattletale"));
        System.out.println(isEvenWord("appeases"));
        System.out.println(isEvenWord("banana"));
    }
}
