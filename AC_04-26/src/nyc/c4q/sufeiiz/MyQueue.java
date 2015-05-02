package nyc.c4q.sufeiiz;

import java.util.AbstractQueue;
import java.util.Iterator;

/**
 * Created by sufeizhao on 4/26/15.
 * Create a class MyQueue which implements AbstractQueue.
 * Create an instance of MyQueue and add Strings to this instance.
 * Create an instance of MyQueue and add ints to this instance.
 * Create an instance of MyQueue and add all the elements of the String queue and Integer queue.
 */
public class MyQueue<E> extends AbstractQueue<E> {

    private MyQueue<Object> q;
    

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public int size() {
        int count = 0;
        for (Object obj : q) {
            count++;
        }
        return count;
    }

    @Override
    public boolean offer(Object o) {
        q = o;
        return false;
    }

    @Override
    public Object poll() {
        return null;
    }

    @Override
    public Object peek() {
        return null;
    }

    public static void main(String[] args) {
        MyQueue<String> stringQ = new MyQueue<String>();
        stringQ.add("Hello");
        stringQ.add("World");
        MyQueue<Integer> intQ = new MyQueue<Integer>();
        intQ.add(13);
        MyQueue<Object> all = new MyQueue<Object>();
        all.addAll(stringQ);
        all.addAll(intQ);
    }
}
