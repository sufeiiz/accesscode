package nyc.c4q.sufeiiz;

import java.util.ArrayList;

/**
 * Created by sufeizhao on 10/11/15.
 */
public class ListStack extends ArrayList {

    public boolean push(Object a) {
        this.add(a);
        return true;
    }

    public Object pop() {
        if (this.size() == 0)
            return null;

        Object removed = top();
        this.remove(this.size() - 1);
        return removed;
    }

    public Object top() {
        if (this.size() == 0)
            return null;

        return this.get(this.size() - 1);
    }
}
