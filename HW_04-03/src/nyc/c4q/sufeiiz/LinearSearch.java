package nyc.c4q.sufeiiz;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by sufeizhao on 3/28/15.
 * LinearSearch.java
 * You are given an ArrayList of unknown size containing integers.
 * Write a class called LinearSearch which implements a static method search
 * which accepts as input an integer x, and returns the first index it sees of x in the list.
 * If the integer is not present return in the list return -1
 */

public class LinearSearch {
    public static int intIndex(ArrayList list, int num) {
        Iterator<Integer> numIter = list.iterator();
        int index = -1;

        while (numIter.hasNext()) {
            if (numIter.next() == num) {
                index = list.indexOf(num);
                break;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(1);
        list.add(2);

        System.out.println(intIndex(list, 2));
    }
}
