package nyc.c4q.sufeiiz;

import java.util.Calendar;

/**
 * Access Code 2.1
 *
 * Author  Gregory Gundersen
 * Date    March 2015
 *
 * This class represents a person with a name and age.
 */

public class Person {

    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name) {
        this.name = name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int newAge) {
        this.age = newAge;
    }

    public int getAge() {
        return this.age;
    }

    public static void main(String[] args) {
        int n=0;

        Person fred = new Person("Fred", 10);
        System.out.println(fred.getAge());
        Person bob = new Person("Bob", 28);
        System.out.println(bob.getAge());

        Calendar c = Calendar.getInstance();
    }
}
