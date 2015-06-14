## Morning Exercises
#### MyCollection
* Create a class MyCollection which implements the [Collection](https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html) interface. Feel free to be creative with this (if you happen to have a favorite data structure) but it's strongly suggested that you create MyCollection to be a wrapper around an [array](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html) to create something similar to [`ArrayList<E>`](http://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html).
* Create a class MyList which implements the [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html) interface. Notice that the List interface extends the Collection interface. You may choose to work with MyCollection or create an entirely new structure.

#### Bonus
* Implement a binary search tree using the Collection interface.

## Afternoon Exercises

#### MyQueue
* Create a class `MyQueue<E>` which implements [AbstractQueue<E>](http://docs.oracle.com/javase/7/docs/api/java/util/AbstractQueue.html).
* Create an instance of `MyQueue<String>` and add Strings to this instance.
* Create an instance of `MyQueue<Integer>` and add ints to this instance.
* Create an instance of `MyQueue<Object>` and add all the elements of the String queue and Integer queue.
* Write an Abstract class, `MyAbstractCollection<E>` which implements the Collection interface. Confirm that having MyCollection inherit from My AbstractCollection yields the same effect. Check `MyAbstractCollection<E>` against [`AbstractCollection<E>`](http://docs.oracle.com/javase/7/docs/api/java/util/AbstractCollection.html).
* Consider the advantages and disadvantages of using an Abstract class versus and Interface.

#### MapReduce
* Create an interface `Mapper<E,V>` which contains method f(). f() takes in something of type E and
returns something of type V.

* In a class MyMapReduce, write a method `Iterable<V> map(Iterable<E>, Mapper<E,V>)`. This takes in an iterable collection of Es. For each E in the collection, it applies f() and creates a new iterable collection of Vs. For example, we might want to take in [1, 2, 3] and return [2, 3, 4], or take in [1, 2, 3] and return ['A', 'B', 'C']. map() will allow us to apply the map method to every element in the collection and get back a new collection.

* Create an interface `Reducer<V>` which contains method g(). g() takes in two Vs returns a single value of type V.

* In MyMapReduce, write a method `V reduce(Iterable<V>, Reducer<V>)`. This takes in an iterable of Vs and returns a V by applying g() to all of the Vs. For example, if the Reducer sums up Vs, then it will sum the first element with the second, and then that sum with the third and so on, so that [1, 2, 3] becomes 6.

* In MyMapReduce, write a method map_and_reduce which takes in a generic Iterable, a Mapper, and a Reducer, and
applies map and reduce in succession to turn the iterable into a single output.

* Congratulations! You've now written [MapReduce](http://en.wikipedia.org/wiki/MapReduce).

#### FindMax

* Write a find_max_int method for `List<Integer>`, which returns the index of the max element.

* Write a find_max_comp method for `List<Comparable<E>>`, which returns the index of the max element. Note that
this method works for `List<Integer>`.

#### Bonus
* Implement a type of self-balancing tree with generics, for example a splay tree or a red-black tree. This may require some research.
