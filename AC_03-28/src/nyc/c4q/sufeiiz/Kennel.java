package nyc.c4q.sufeiiz;

/**
 * Created by rosmary & sufeiiz on 3/28/15.
 * Access Code 2.1
 * Kennel.java
 * Kennel class includes methods that can be used for kennel ArrayList
 */

import java.util.ArrayList;
import java.util.Iterator;

public class Kennel {
    private ArrayList <Dog> kennel;

    // adds new dog to arraylist
    public void addDog(Dog dog) {
        kennel.add(dog);
    }

    // returns how many dogs we have
    public int numOfDogs() {
        return kennel.size();
    }

    // checks to see if kennel has dogs
    public boolean hasDogs() {
        return  kennel.isEmpty();
    }

    // empties kennel arraylist
    public void shutdownKennel() {
        kennel.clear();
    }

    // removes specific dog from arraylist
    public Dog removeDog(Dog dog) {
        int index = kennel.indexOf(dog);
        kennel.remove(index);

        //removing dog from kennel, but dog is still alive so return dog
        return dog;
    }

    // calls removeRange() behind the scene (removeRange is protected cannot be called)
    public void putDogToSleep (int start, int end) {
        kennel.subList(start, end).clear();
    }

    // finds index of dog and returns dog
    public Dog getDog(Dog dog) {
        int index = kennel.indexOf(dog);
        return kennel.get(index);
    }

    // exchanges old dog at index with new dog
    public Dog exchangeDog(int index, Dog newDog) {
        kennel.set(index, newDog);

        return newDog;
    }

    // returns true if dog is in kennel
    public boolean isDogInKennel(Dog dog) {
        return kennel.contains(dog);
    }

    // returns index of dog in kennel; if not in kennel return -1
    public int returnDogIndex(Dog dog) {
        if(kennel.contains(dog))
            return kennel.indexOf(dog);
        else
            return -1;
    }

    // creates an iterator for kennel
    public Iterator returnIterator () {
        Iterator <Dog> kennelIter= kennel.iterator();
        return kennelIter;
    }

    // prints list of dogs in kennel
    public void printKennel() {
        Iterator iter = returnIterator();

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}


