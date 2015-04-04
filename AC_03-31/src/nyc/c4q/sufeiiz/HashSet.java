package nyc.c4q.sufeiiz;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        HashSet<Integer> odd = new HashSet<Integer>();
        odd.add(1);
        odd.add(3);
        odd.add(3);
        odd.add(51);
        odd.add(5);

        HashSet<Integer> even = new HashSet<Integer>();
        even.add(2);
        even.add(10);
        even.add(16);
        even.add(6);
        even.add(4);
        even.add(51);

        odd.addAll(even);
        odd.removeAll(even);

        HashSet<Integer> newodd = odd;
        System.out.println(newodd == odd); //true

        HashSet<Integer> odd2 = new HashSet<Integer>();
        System.out.println(odd2 == odd); //false

        for (Integer num : newodd) {
            System.out.println(num);
        }
    }
}