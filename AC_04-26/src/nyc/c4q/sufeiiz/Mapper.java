package nyc.c4q.sufeiiz;

/**
 * Created by sufeizhao on 4/26/15.
 * Create an interface Mapper which contains method f().
 * f() takes in something of type E and returns something of type V.
 */

public interface Mapper<E, V> {
    V f(E something);
}
