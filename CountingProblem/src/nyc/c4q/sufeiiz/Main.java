package nyc.c4q.sufeiiz;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        ListSet set = new ListSet();
        set.add("hello");
        set.removeAll(set);
        set.retainAll(set);
    }

    public static class ListSet extends ArrayList implements Set {
        @Override
        public boolean add(Object o) { // n
            if (!this.contains(o)) { // n
                this.add(o); // 1
                return true; // 1
            }

            return false;
        }

        @Override
        public boolean removeAll(Collection c) { // n^2
            for (Object t : c) { // n
                this.remove(t); // n
            }

            return true; // 1
        }

        @Override
        public boolean retainAll(Collection c) { // n^2
            ListSet temp = new ListSet(); // 1

            for (Object t : c) { // n
                if (this.contains(t)) { // n^2
                    temp.add(t);
                }
            }

            this.clear(); // n
            this.addAll(temp); // n
            return true; // 1
        }
    }
}
