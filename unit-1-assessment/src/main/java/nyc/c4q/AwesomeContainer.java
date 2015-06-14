package nyc.c4q;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by amyquispe on 5/19/15.
 */
public class AwesomeContainer {

    public static Collection<AwesomeContainer> createAwesomeContainer(){
        ArrayList<AwesomeContainer> myList = new ArrayList<AwesomeContainer>();
        return myList;
    }

    public static void addAwesomeObject(Collection awesomeContainer){
        awesomeContainer.add(new ConcreteAwesomeClass());
    }
}
