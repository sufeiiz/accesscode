package nyc.c4q.sufeiiz;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by sufeizhao on 4/26/15.
 *  * Create a class MyList which implements the List interface.
 *  Notice that the List interface extends the Collection interface.
 *  You may choose to work with MyCollection or create an entirely new structure.
 */

public class MyList extends MyCollection implements List{

    public MyList() {
        super();
        this.myArray = empty;
        this.size = myArray.length;
    }

    public MyList(int x) {
        super();
    }

    @Override
    public Object get(int index) {

        return null;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }
}
