/**
 * Created by Sufei Zhao on 4/14/15.
 * Classes and Objects with Person.java and Cat.java
 */

public class ClassesAndObjects {
    // Write a method called isOlder that takes 2 Cats as parameters and returns whether or not the first Cat is older than the second.
    public static boolean isOlder(Cat one, Cat two) {
        return one.getAge() > two.getAge();
    }

    // Write a method called makeBestFriends that takes 2 Cats as parameters and sets both of their favorite foods to the same thing.
    public static void makeBestFriends(Cat one, Cat two) {
        one.setFavoriteFood("Ice Cream");
        two.setFavoriteFood("Ice Cream");
    }

    // Write a method called makeKitten that takes 2 Cats as parameters and returns a new Cat with a
    // name that is the combination of the 2 parent Cats' names. The age of the new Cat should be 0.
    public static Cat makeKitten(Cat one, Cat two) {
        Cat kitten = new Cat(one.getName() + two.getName());
        kitten.setAge(0);
        return kitten;
    }

    // Write a method called adoption that takes 1 Cat and 1 Person as a paramater and sets the Cat's owner to be the Person.
    // If the Cat's name is Catwoman, don't set the owner, but instead print: "Catwoman will never be anyone's pet!"
    public static void adoption(Person person, Cat cat) {
        if (cat.getName().equals("Catwoman"))
            System.out.println("Catwoman will never be anyone's pet!");
        else
            cat.setOwner(person);
    }

    // Write a method called isFree that checks whether or not a Cat has an owner.
    public static boolean isFree(Cat cat) {
        if (cat.getOwner() == null)
            return true;
        else
            return false;
    }

    // Write a method called isSibling that checks whether or not 2 Cats have the same owner.
    public static boolean isSibling(Cat one, Cat two ) {
        if (one.getOwner() == null || two.getOwner() == null)
            return false;
        else if (one.getOwner().equals(two.getOwner()))
            return true;
        else
            return false;
    }

    public static void main (String args[]) {
        // Create 3 cats named Garfield, Pink Panther, and Catwoman.
        Cat garfield = new Cat("Garfield");
        garfield.setFavoriteFood("Lasagna");
        garfield.setAge(12);
        Cat pink = new Cat("Pink Panther");
        pink.setFavoriteFood("Cats");
        pink.setAge(30);
        Cat catwoman = new Cat("Catwoman");
        catwoman.setFavoriteFood("Men");
        catwoman.setAge(25);
    }
}
