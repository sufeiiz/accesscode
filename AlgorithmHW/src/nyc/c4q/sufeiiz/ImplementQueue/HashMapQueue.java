package nyc.c4q.sufeiiz.ImplementQueue;

import java.util.HashMap;

/**
 * Created by sufeizhao on 12/3/15.
 */
public class HashMapQueue<T> {

    HashMap<Integer, T> queue;
    int startIndex;
    int endIndex;

    public HashMapQueue() {
        this.queue = new HashMap<Integer, T>();
        this.startIndex = 0;
        this.endIndex = 0;
    }

    public void push(T object) {
        queue.put(endIndex, object);
        endIndex++;
    }

    public T pop() {
        if (queue.isEmpty())
            return null;

        T object = peek();
        queue.remove(startIndex);
        startIndex++;

        return object;
    }

    public T peek() {
        if (queue.isEmpty())
            return null;

        return queue.get(startIndex);
    }
}
