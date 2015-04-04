package nyc.c4q.sufeiiz;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // create a new hashtable
        Dictionary romanNum = new Hashtable();

        // add elements in the hashtable
        romanNum.put("1", "I");
        romanNum.put("5", "V");
        romanNum.put("10", "X");
        romanNum.put("50", "L");
        romanNum.put("100", "C");
        romanNum.put("500", "D");
        romanNum.put("1000", "M");

        // returns the elements associated with the key
        System.out.println(romanNum.get("1"));

        int answer = 200;
        if (answer > 1000) {

        }
        String m = Integer.toString(answer);
        m.length();
    }
}
