# AC_03-24

## Objectives
- Create a new `ArrayList`
- Add objects to list
- Get objects from the list

## DaysUntil
- [DaysUntil.java](https://github.com/accesscode-2-1/unit-0/blob/master/in-class%20exercise%20solutions/DaysUntil/DaysUntil.java)
- [DaysUntilWLD.java](https://github.com/accesscode-2-1/unit-0/blob/master/in-class%20exercise%20solutions/DaysUntil/DaysUntilWLD.java)


## ArrayLists

A *collection* is a group of objects. Today, we'll be looking at a very useful collection, the `ArrayList`. A *list* is an ordered collection, and an `ArrayList` is one type of list.

Create a class `NameTracker` and follow along in it.

Before we can use an `ArrayList`, we have to `import` it:

```java
import java.util.ArrayList;
```

Next, we call the constructor; but we have to declare the type of object the `ArrayList` is going to hold. This is how you create a new `ArrayList` holding `String` objects. 

```java
ArrayList<String> names = new ArrayList<String>();
```

Notice the word "`String`" in angle brackets: "<String>". This is the Java syntax for constructing an `ArrayList` of `String` objects.

We can add a new `String` to `names` using the `add()` method.

```java
names.add("Ana");
```

> **Exercise:** Write a program that asks the user for some names and then stores them in an `ArrayList`. Here is an example program:
> ```
> Please give me some names:
> Sam
> Alecia
> Trey
> Enrique
> Dave
> Your name(s) are saved!
> ```

We can see how many objects are in our `ArrayList` using the `size()` method.

```java
System.out.println(names.size()); // 5
```

> **Exercise:** Modify your program to notify the user how many words they have added.
> ```
> Please give me some names:
> Mary
> Judah
> Your 2 name(s) are saved!
> ```

Remember how the `String.charAt()` method returns the `char` at a particular index? We can do the same with `names`. Just call `get()`:

```java
names.add("Noah");
names.add("Jeremiah");
names.add("Ezekiel");
System.out.println(names.get(2)); // "Ezekiel"
```

> **Exercise:** Update your program to repeat the names back to the user in reverse order. Your solution should use a for loop and the `size()` method. For example:
> ```
> Please give me some names:
> Ying
> Jordan
> 
> Your 2 name(s) are saved! They are:
> Jordan
> Ying
> ```

Finally, we can ask our `names` `ArrayList` whether or not it has a particular string.

```java
names.add("Veer");
System.out.println(names.contains("Veer")); // true
```

> *Exercise:* Update your program to check if a name was input by the user. For example:
> ```
> Please give me some names:
> Ying
> Jordan
> 
> Search for a name:
> Ying
> Yes!
> ```

An `ArrayList` can hold any type of object! For example, here is a constructor for an `ArrayList` holding our `Person` class from last week.

```java
ArrayList<Person> people = new ArrayList<Person>();
```

> **Exercise:** Modify our program to save the user's input names as `Person` instances. Rather than storing `String` objects in the `ArrayList`, store `Person` objects by constructing them with the input name. You'll need to use the `Person` constructor to get a `Person` instance!

## In-class assignment

Write a class `BlueBook` that tells the user the price of their car, depending on the make, model, and year. You should use [`Car.java`](https://github.com/accesscode-2-1/unit-0/blob/master/in-class%20exercise%20solutions/BlueBook/Car.java) and the stencil file provided, [`BlueBook.java`](https://github.com/accesscode-2-1/unit-0/blob/master/in-class%20exercise%20solutions/BlueBook/BlueBook.java).

Your program depends on what cars your `BlueBook` supports, but here is an example program:

```
What is your car's make?
Toyota
What is your Toyota's model?
Corolla
What is your Toyota Corolla's year?
1999

Your 1999 Toyota Corolla is worth $2000.
```

> **Bonus exercise:** Notify the user if the car is not in your `BlueBook`.

> **Bonus exercise:** Clean up `main` by putting your code for creating the `ArrayList` in a separate method. What type should the method return?

> **Bonus exercise:** If the car is not in the `BlueBook`, ask the user to input the relevant data, construct a new `Car` instance, add it to your `ArrayList`.

# AC_03-26

## Objectives
- To be able to create an `Iterator` from an `ArrayList`.
- To be able to loop over an `ArrayList` in 3 different ways.


## Looping over lists

Before we get started, let's create an `ArrayList` we can play with. Create a class `Adder` and `import` the `ArrayList`. We're going to use an `ArrayList` of integers. We can't add primitive types but Java has a "wrapper class", a reference type that wraps a primitive type, that we can use. It's call `Integer`. Create an `ArrayList` holding objects of type `Integer`.

```java
ArrayList<Integer> numbers = new ArrayList();
```

> **Exercise:** Write a program that asks the user for some integers and adds them to your `ArrayList`. Use a `while` loop and `break` when the user gives you a `-2`.
> ``` 
> Give me some numbers to add:
> 1
> 1
> 2
> -2
> Thanks!
>```

#### For loop

On Tuesday, we saw that we could loop over a list like this:

```java
for (int i = 0; i < numbers.size(); i++) {
    System.out.println( numbers.get(i) );
}
```

#### For each loop

We're going to look at two different ways of iterating over `ArrayList`s. The first is a *for each loop*. The syntax is this:

```java
for (Integer num : numbers) {
    System.out.println(num);
}
```

> **Exercise:** Using a for each loop, calculate the sum of numbers that the user input.
> ```
> Give me some numbers to add:
> 1
> 1
> 2
> -2
> Thanks! Your sum is 4.
>```

#### Iterator

Finally, we can iterate using an object of type `Iterator`. First, we need to import the class:

```java
import java.util.Iterator;
```

Next, we want to create an object of type `Iterator` by calling the `iterator()` method on `numbers`; you can call this method on any collection:

```java
Iterator<Integer> numbersIter = numbers.iterator();
```

Notice we have to give the `Iterator` a reference type, just like the `ArrayList`. Now we can use `numberIter`'s methods `hasNext()` and `next()` to loop or iterate over the collection:

while (numbersIter.hasNext()) {
    // numbersIter.next() will return the next integer
}

An iterator is *stateful*, meaning as you call the method `next()`, the contents of the iterator change. You *cannot* access them again! Try it...

```java
while (numbersIter.hasNext()) {
    numbersIter.next();
}
numbersIter.next(); // Exception in thread "main" java.util.NoSuchElementException
```

When would we want to do this? Perhaps if our input is stateful and we do not want the user to be able to "go back". For example, the `Scanner` class is an `Iterator`. You can't call `nextInt()` twice in a row for the same user input.

> **Exercise:** Rewrite your sum functionality to use an `Iterator` rather than a for each loop.

## clear()

`ArrayList`s have a nice method `clear()` that will remove any added objects. Try it:

```java
numbers.add(1);
numbers.clear();
System.out.println(numbers.size()); // 0
```

> **Exercise:** Update your program so that the adder's stored values are cleared if the user inputs `-1`. It will keep waiting for more positive integers until the user types `-2`.
> ```
> Give me some numbers to add:
> 2
> 3
> 4
> -1
> 33
> 33
> -2
> 66

## In-class assignment: Counting and graphing the number of subway entrances in NYC

#### Parsing the data

[NYC Open Data](https://nycopendata.socrata.com/) is a public repository of data about New York City. We're going to be analyzing and graphing the dataset for [subway entrances](https://data.cityofnewyork.us/Transportation/Subway-Entrances/drex-xx56). Our end goal is to produce a [colored and labeled bar chart](https://github.com/accesscode-2-1/unit-0/blob/master/in-class%20exercise%20solutions/Subway/subway-bar-chart.png) comparing the number of entrances per line. Don't worry, you'll get to use two classes that will help you with this!

I've already downloaded the data, but you can also do so [here](https://github.com/accesscode-2-1/unit-0/blob/master/in-class%20exercise%20solutions/Subway/subway-data.txt). The text file should look like this:

```
http://www.mta.info/nyct/service/,Smith St & Bergen St At Ne Corner (To Manhattan And Queens Only),F-G
http://www.mta.info/nyct/service/,Court St & Montague St At Sw Corner,2-3-4-5-N-R
http://www.mta.info/nyct/service/,Court St & Montague St At Sw Corner,2-3-4-5-N-R
http://www.mta.info/nyct/service/,Clinton St & Montague St At Nw Corner,2-3-4-5-N-R
http://www.mta.info/nyct/service/,Flatbush Ave & Empire Blvd At Sw Corner,B-Q-S
...
```

Use the provided [File class](https://github.com/accesscode-2-1/unit-0/blob/master/in-class%20exercise%20solutions/Subway/File.java) to read in the text file. You create a new file like this:

```java
File f = new File("/Subway/src/subway-data.txt");
```

Next, you can call `getLines` on the `File` instance and it will return you an `ArrayList` of `ArrayList` of `Strings`. Each inner `ArrayList` is a line and each `String` is the string between the commas. Call the method, store it in a variable, and play with it. How can you get the number of subway entrances per line?

#### Graphing the data

Use the [DrawingPanel](https://github.com/accesscode-2-1/unit-0/blob/master/in-class%20exercise%20solutions/Subway/DrawingPanel.java) class--credit to Marty Stepp for writing this--to create a `Graphics2D` object. Don't worry about how all this works; just use this snippet:

```
DrawingPanel panel = new DrawingPanel(500, 250);
Graphics2D g = panel.getGraphics();
```

Now `g` is a `Graphics2D` object. Use [its API](http://docs.oracle.com/javase/7/docs/api/java/awt/Graphics2D.html) to draw the necessary objects. You will want to use `setColor()`, `setStroke()`, `drawString()`, and `drawLine()`.

Refer to the [stencil file](https://github.com/accesscode-2-1/unit-0/blob/master/in-class%20exercise%20solutions/Subway/Subway.java) for more specific instructions.

#### Bonus questions

> Use `setStroke` and the `BasicStroke` class create a thicker bar graph.

> You can use `Color.BLACK`, `Color.WHITE`, etc. to create the bar graph. Now use the `Color` constructor, which takes a hexidecimal number, to print more interesting colors.
