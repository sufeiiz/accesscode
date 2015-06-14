#Abstract Classes and Generics

####Lesson Objective

* Students will understand how to extend an Abstract Class.
* Students will understand how to read Generic notation and when to use it.
* Students will be better equipped to organize their code in an object-oriented fashion.

####Lesson

##### Abstract Classes

[Abstract classes](https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html) are a special kind of class that is just used for inheritance. That is, you cannot instantiate abstract classes, but you can create subclasses which you can then instantiate.

Here are a few differences between an abstract class and an interface:
* Abstract classes can provide default method implementations. (Interfaces can do this in JDK 8.)
* All interface methods are public, but abstract methods can be private or protected.
* Instance variables in interfaces become public static final when implemented.
* A class can implement multiple interfaces, but only inherit from one class (abstract or concrete).
* Abstract classes may have static fields and methods.

Example: MyCollection1 and MyCollection2

Example: MyNode

> Why would we use an abstract class over an interface?
> An interface defines what an object can do, while an abstract class defines what an object is.

##### Generics

Generics are a way of creating a class that works for any Object, while the type isn't specified until instantiation. The syntax for Generics is angle brackets and an uppercase letter, e.g. `ArrayList<E>`. Some interesting things to note:
* You can add a `SubClass` to `ContainerClass<SuperClass>`.
* `ContainerClass<SubClass>` is not a subtype of `ContainerClass<SuperClass>`.
* The superclass of all `ContainerClass<E>` is `ContainerClass<?>`. See also: [wildcards](https://docs.oracle.com/javase/tutorial/extra/generics/wildcards.html).

Example: `MyNode<E>`

##### Aside: The Diamond Problem

####Assessment

[Exit ticket](http://goo.gl/forms/85INMf7Gs2)

