package nyc.c4q.sufeiiz.ImplementQueue;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;

/**
 * Created by sufeizhao on 12/3/15.
 */
public class LinkedListQueue<T> {
    // Using a Linked List
    LinkedList<T> queue;

    public LinkedListQueue() {
        this.queue = new LinkedList<T>();
    }

    public void push(T object) {
        queue.add(object);
    }

    public T peek() {
        if (queue.isEmpty())
            return null;

        return queue.get(0);
    }

    public T pop() {
        if (queue.isEmpty())
            return null;

        T object = peek();
        queue.remove(0);

        return object;
    }

}
