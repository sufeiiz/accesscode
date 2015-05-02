package nyc.c4q.sufeiiz;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by sufeizhao on 4/26/15.
 * In a class MyMapReduce, write a method Iterable<V> map(Iterable<E>, Mapper<E,V>).
 * This takes in an iterable collection of Es. For each E in the collection,
 * it applies f() and creates a new iterable collection of Vs.
 * For example, we might want to take in [1, 2, 3] and return [2, 3, 4], or take in [1, 2, 3] and return ['A', 'B', 'C'].
 * map() will allow us to apply the map method to every element in the collection and get back a new collection.
 *
 * In MyMapReduce, write a method V reduce(Iterable<E>, Reducer<E, V>).
 * This takes in an iterable of Es and returns a V by applying g() to all of the Es.
 * For example, if the Reducer sums up Es, then it will sum the first element with the second,
 * and then that sum with the third and so on, so that [1, 2, 3] becomes 6.
 *
 * In MyMapReduce, write a method map_and_reduce which takes in a generic Iterable, a Mapper,
 * and a Reducer, and applies map and reduce in succession to turn the iterable into a single output.
 */

public class MapReduce<E, V>{
    public Iterable<V> map(Iterable<E> iter, Mapper<E, V> m) {
        ArrayList<V> array = new ArrayList<V>();

        for (E e : iter) {
            array.add(m.f(e));
        }

        return array;
    }

    public E reduce(Iterable<E> iter, Reducer<E, V> red) {
        ArrayList<E> array = new ArrayList<E>();
        E one, two, total;

        for (E e : iter) {
            array.add(e);
        }

        one = array.get(0);
        for (int i = 1; i < array.size(); i++) {
            two = array.get(i);
            total = red.g(one, two);
            one = total;
        }

        return one;
    }
}
