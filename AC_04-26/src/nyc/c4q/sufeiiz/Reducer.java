package nyc.c4q.sufeiiz;

/**
 * Created by sufeizhao on 4/26/15.
 * Create an interface Reducer which contains method g(). g() takes in two Es returns a single value of type V.
 */

public interface Reducer<E, V> {
    E g(E e, E f);
}
