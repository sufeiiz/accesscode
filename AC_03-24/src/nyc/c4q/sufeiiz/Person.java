package nyc.c4q.sufeiiz;

import java.util.ArrayList;

/**
 * Access Code 2.1
 *
 * Author  Sufei Zhao
 * Date    March 24 2015
 *
 * This class asks the user which car they have and prints its price.
 */

public class Person {
    private String name;

    public Person() {
    }

    public static Person school(String name) {

        Person p1 = new Person();
        p1.setName(name);

        return p1;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<Person>();
    }
}
