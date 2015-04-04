package nyc.c4q.sufeiiz;

/**
 * Created by rosmary & sufeiiz on 3/28/15.
 * Access Code 2.1
 * Dog.java
 * Dog class includes Dog constructor
 */

public class Dog {
    private String name;
    private String breed;
    private int age;

    public Dog (String name) {
        this.name = name;
    }

    public Dog (String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return this.breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

