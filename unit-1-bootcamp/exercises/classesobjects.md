#Classes & Objects

###Resources

* [Video - Classes and Objects](https://www.udemy.com/java-tutorial/#/lecture/137826)
* [Unit 0 - Classes pt. I](https://github.com/accesscode-2-1/unit-0/blob/master/lessons/week-2/2015-03-17_classes-part-1.md)
* [Unit 0 - Classes pt. II](https://github.com/accesscode-2-1/unit-0/blob/master/lessons/week-2/2015-03-19_classes-part-2.md)
* [Unit 0 - Classes pt. III](https://github.com/accesscode-2-1/unit-0/blob/master/lessons/week-2/2015-03-21_classes-part-3.md)
* [Java Tutorial - Classes](https://docs.oracle.com/javase/tutorial/java/javaOO/classes.html)
* [Java Tutorial - Objects](https://docs.oracle.com/javase/tutorial/java/javaOO/objects.html)

###Exercises

Complete these exercises in `ClassesAndObjects.java`. Please use the `Cat.java` and `Person.java` classes to complete these exercises.

####1. Cool cats

1. Create 3 cats named `Garfield`, `Pink Panther`, and `Catwoman`.
2. Assign each of them a favorite food (Garfield's favorite food should be `Lasagna`).
3. Assign each of them an age.

####2. isOlder

Write a method called `isOlder` that takes 2 Cats as parameters and returns whether or not the first Cat is older than the second.

```
ex: // if Garfield is 9 years old and Catwoman is 10 years old
    isOlder(garfield, catwoman) returns false
```

####3. Best Friends

Write a method called `makeBestFriends` that takes 2 Cats as parameters and sets both of their favorite foods to the same thing.

*Hint: this method does not return anything!*

####4. Kitten

Write a method called `makeKitten` that takes 2 Cats as parameters and returns a new Cat with a name that is the combination of the 2 parent Cats' names. The age of the new Cat should be `0`.

```
ex: makeKitten(garfield, catwoman) returns a Cat named "GarfieldCatwoman" with age 0
```

####5. Adoption

Write a method called `adoption` that takes 1 Cat and 1 Person as a paramater and sets the Cat's owner to be the Person.

```
ex: Person jon = Person('Jon');
    adoption(garfield, jon); // Jon is now Garfield's owner!
```

*Hint: this method does not return anything!*

**Bonus Challenge**

If the Cat's name is `Catwoman`, don't set the owner, but instead print: "Catwoman will never be anyone's pet!"

####6. isFree

Write a method called `isFree` that checks whether or not a Cat has an owner.

```
ex: isFree(garfield) returns false
```

####7. isSibling

Write a method called `isSibling` that checks whether or not 2 Cats have the same owner.

