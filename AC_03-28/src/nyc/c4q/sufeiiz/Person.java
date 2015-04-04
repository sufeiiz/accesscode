package nyc.c4q.sufeiiz;

/**
 * Created by rosmary & sufeiiz on 3/28/15.
 * Access Code 2.1
 * Person.java
 * Person class includes Person constructor and methods to adopt dog
 */

public class Person {
    private String name;
    private Dog dog;

    public Person(String name) {
        this.name = name;
        this.dog = null;
    }

    public Person(String name, Dog dog) {
        this.name = name;
        this.dog = dog;
    }

    public boolean hasDog() {
        if (dog != null)
            return true;
        else
            return false;
    }

    public void adoptDog(Dog dog) {
        this.dog = dog;
    }
}
