package nyc.c4q.sufeiiz;

import java.util.Arrays;

/**
 * Created by sufeizhao on 11/24/15.
 */
public class Test {

    public static void main(String[] args) {
        BitVector vector = new BitVector(10);
        vector.setShift(13, 1);
        System.out.println(vector.getShift(13));
        vector.setShift(13, 0);
        System.out.println(vector.getShift(13));

    }

    public static int[] reverse(int[] array) {
        int[] newArray = new int[array.length];
        int index = 0;

        for (int i = array.length - 1; i >= 0; i--) {
            newArray[index++] = array[i];
            // int i = 0; i < result.length; ++i
            // result[array.length - 1 - i] = array[i]
        }

        return newArray;
    }

    public static void reverseUnchanged(int[] array) {
        int temp;
        int start = 0;

        for (int end = array.length - 1; end >= start; end--) {
            temp = array[start];
            array[start++] = array[end];
            array[end] = temp;
        }
    }


}
