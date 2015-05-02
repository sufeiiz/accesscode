package nyc.c4q.sufeiiz;

import java.util.List;

/**
 * Created by sufeizhao on 4/26/15.
 */

public class FindMax {

    // Write a findMaxInt method for List<Integer>, which returns the index of the max element.
    public int findMaxInt(List<Integer> list) {
        int max = list.get(0);
        for (Integer n : list) {
            if (n > max)
                max = n;
        }
        return max;
    }

    // Write a findMaxComp method for List<Comparable<E>>, which returns the index of the max element.
    // Note that this method works for List<Integer>
    public int findMaxComp(List<Comparable> list) {
        Comparable max = list.get(0);
        for (Comparable n : list) {
            if (n.compareTo(max) > 0) {
                max = n;
            }
        }
        return list.indexOf(max);
    }
}
