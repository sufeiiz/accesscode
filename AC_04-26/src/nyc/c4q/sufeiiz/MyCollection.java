package nyc.c4q.sufeiiz;

import java.util.*;

/**
 * Created by sufeizhao on 4/26/15.
 * Create a class MyCollection which implements the Collection interface.
 * Feel free to be creative with this (if you happen to have a favorite data structure)
 * but it's strongly suggested that you create MyCollection to be a wrapper around an array
 * to create something similar to ArrayList.
 */
public class MyCollection<T> implements Collection<T>{

    private int max, size;
    private transient Object[] myArray;
    private Object[] empty = {};

    public MyCollection() {
        super();
        this.myArray = empty;
        this.size = myArray.length;
    }

    public MyCollection(int x) {
        super();
        this.size = x;

        if (x < 0)
            throw new IllegalArgumentException("Illegal Capacity: "+
                    x);
        this.myArray = new Object[x];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (Object obj : myArray) {
            if (obj.equals(o))
                return true;
        }
        return false;
    }



    @Override
    public boolean add(Object o) {
        myArray = Arrays.copyOf(myArray, size + 1);
        myArray[size] = o;
        size++;
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        Object[] newArray = c.toArray();
        int numNew = newArray.length;
        myArray = Arrays.copyOf(myArray, size + numNew);
        System.arraycopy(newArray, 0, myArray, size, numNew);
        size += numNew;
        return numNew != 0;
    }

    @Override
    public boolean remove(Object o) {
        if (!this.contains(o)) {
            return false;
        }

        Object[] newArray = new Object[myArray.length - 1];
        int j = 0;
        for (int i = 0; i < myArray.length; ++i) {
            if (!myArray[i].equals(o)) {
                newArray[j] = myArray[i];
                j++;
            }
        }
        myArray = newArray;
        return true;
    }

    @Override
    //TODO
    public boolean removeAll(Collection c) {

        return false;
    }



    @Override
    public void clear() {
        for (int i = 0; i < size; i++)
            myArray[i] = null;

        size = 0;
        myArray = empty;
    }



    @Override
    public boolean containsAll(Collection c) {
        Object[] a = c.toArray();
        int count = 0;

        for (int i = 0; i < a.length; i++) {
            for (int h = 0; h < size; h++) {
                if (a[i].equals(myArray[h])) {
                    count++;
                    break;
                }
            }
        }

        if (count == a.length)
            return true;
        else
            return false;
    }

    @Override
    //TODO
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return myArray;
    }

    @Override
    //TODO
    public T[] toArray(Object[] a) {
        return new T[a.length];
    }


    @Override
    //TODO
    public Iterator iterator() {
        Iterator iter;
        for (Object obj : myArray) {
            obj = iter.next();
        }
        return iter;
    }

}
