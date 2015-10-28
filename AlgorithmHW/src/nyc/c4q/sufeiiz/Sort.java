package nyc.c4q.sufeiiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by sufeizhao on 10/20/15.
 */
public class Sort {

    static int[] array = new int[] {4, 1, 5, 0, 3, 9, 7, 7, 7};
    static int[] array2 = new int[] {4, 1, 5, 0, 3, 9, 7, 7, 7};


    public static void selectionSort(int[] sort) {
        int min;
        int index;

        for (int x = 0; x < sort.length; x++) {
            index = x;
            min = sort[x];

            for (int y = x + 1; y < sort.length; y++) {
                if (sort[y] < min) {
                    index = y;
                    min = sort[y];
                }
            }

            sort[index] = sort[x];
            sort[x] = min;
        }
    }

    public static void insertionSort(int[] sort) {
        int temp = 0;

        for (int x = 1; x < sort.length; x++) {
            for (int y = x - 1; y >= 0; y--) {
                if (sort[y] > sort[y + 1]) {
                    temp = sort[y + 1];
                    sort[y + 1] = sort[y];
                    sort[y] = temp;
                } else {
                    break;
                }
            }
        }
    }

    public static void mergeSort(int[] sort, int start, int end) {
        int mid = (start + end) / 2;

        if (start < end) {
            mergeSort(sort, start, mid);
            mergeSort(sort, mid, end);
//            merge(sort, start, mid, end);
        }
    }

//    public static int[] merge(int[] sort1, int start, int end, int mid) {
//
//    }



    // _________________________________ Given an array, give me the sum without loops recursively

    static int[] array3 = new int[] {4, 1, 5, 0, 3, 9, 7, 7, 7};

    public static int sum(int[] array) {
        if (array.length == 0) {
            return 0;
        } else {
            return array[0] + sum(Arrays.copyOfRange(array, 1, array.length));
        }

    }

    // Given an array of numbers and a int of interest, write a function to return all numbers that add up to int of interest.

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public boolean isCircularList(Node head) {
        Node current = head;
        HashSet<Node> set = new HashSet<Node>();

        while (current != null) {
            set.add(current);

            if (set.contains(current.next))
                return true;

            current = current.next;
        }

        return false;
    }






    public void insertAfterNode(Node before, int after) {
        Node x = new Node(after);

        x.next = before.next;
        before.next = x;
    }

    public void insertBeforeNode(Node after, int newData) {
        Node x = new Node(after.data);

        x.next = after.next;
        after.next = x;
        after.data = newData;
    }

    public static void main(String[] args) {
        selectionSort(array);
        System.out.println(Arrays.toString(array));
        insertionSort(array2);
        System.out.println(Arrays.toString(array2));

        System.out.println(sum(array3));
        System.out.println(4 + 1 + 5 + 3 + 9 + 7 + 7 + 7);
    }
}
