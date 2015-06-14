/*
Create a class MyQueue<E> which implements AbstractQueue.
 */

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyQueue<E> extends AbstractQueue<E> {
    private List<E> contents;

    public MyQueue() {
        this.contents = new ArrayList<E>();
    }

    @Override
    // return an iterator object to iterate over this queue
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index != contents.size();
            }

            @Override
            public E next() {
                return contents.get(index++);
            }

            @Override
            public void remove() {
                contents.remove(index);
            }
        };
    }

    @Override
    public int size() {
        return contents.size();
    }

    @Override
    // add to the end of this queue
    public boolean offer(E e) {
        contents.add(e);
        return true;
    }

    @Override
    // remove from the front of this queue
    public E poll() {
        if(contents.isEmpty())
            return null;

        return contents.remove(0);
    }

    @Override
    // "peek" at the front of this queue
    public E peek() {
        if(contents.isEmpty())
            return null;

        return contents.get(0);
    }

    // Run this main to see if the results are what you expected...
    public static void main(String[] args) {
        MyQueue<String> mq = new MyQueue<String>();

        System.out.println("test empty queue");
        System.out.println(mq.size());
        System.out.println(mq.peek());
        System.out.println(mq.poll());
        System.out.println(mq.size());

        System.out.println("test non-empty queue");
        mq.offer("first");
        mq.offer("second");
        mq.offer("third");
        System.out.println(mq.size());
        System.out.println(mq.peek());
        System.out.println(mq.poll());
        System.out.println(mq.size());

        System.out.println("test iterate");
        Iterator<String> itr = mq.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}