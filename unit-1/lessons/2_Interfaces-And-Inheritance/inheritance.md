# Objectives
- To understand the different forms of object relationships specifically inheritance
- Understand fundamental terminalogy required to make sense of the madness
- Intro to inheritance
- Review what can be done in a subclass
- Private methods of a superclass
- Casting objects
- Overriding instance methods
- Overriding static methods
- Using the @Override annotation
- Properties of the Object superclass
- Dive into `Interfaces`

## Recap

### Object relationships

[ Association, Aggregration, and Composition ] ( ./compositionAndAggregration.md)

In object oriented programming, relationships between objects can be classified as association, aggregation, composition and inheritance. 

- Assocation
  - Represents a relationship between two or more objects where all objects have their own lifecycle and there is no owner. Objects are independent of eachother.

>  - Example: Student and teacher, where multiple students can associate with single teacher and single student can associate with multiple teachers. Both can be added and removed independently. 

- Aggregration
  - Can be considered a “has-a” relationship. The parent object contains (has) child objects, but the child object can also survive or exist without the enclosing class. All object have their own lifecycle but there is ownership.

>  - Example: Room has a table, but the table can exist without the room.

- Composition
  - Strong form aggregation, where the part is inside exactly one whole. Composition is also known as a ‘is a part of’ relationship. The part may also be created and destroyed by the whole. The member object (part) cannot exist without the containing class. 

>  - Example: A department is part of a college and it cannot exist or has no meaning after the lifetime of the college. Another example is rooms in a house, which cannot exist after the lifetime of the house.

- Inheritance
  - A form of association where we form classes using classes that has already been defined. Inheritance can be considered as a “is-a” relationship. Inheritance is unidirectional. In OO, the concept of IS-A is based on class inheritance or interface implementation. 

>  - Example: For example, House is a building, Car is a vehicle.

----------

# Terminology

- super class
- base class
- upcast
- downcast
- typecast
- method overriding
- method stubs
- overloading
- extends
- implements
- method signature
- instanceof
- super
- public,protected,package-private,private
- implicit vs explicit
- polymorphism
- abstract
- override

#Inheritance
Classes can be derived from other classes, thereby inheriting fields and methods from those classes.

> Definition: A class that is derived from another class is called a `subclass` (also a derived class, extended class, or child class). The class from which the subclass is derived is called a `superclass` (also a base class or a parent class).

When you want to create a new class and there is already a class that includes some of the code that you want, you can derive your new class from the existing class. In doing this, you can reuse the fields and methods of the existing class without having to write (and debug!) them yourself in order to adapt your new class to new situations

![ Animal Hierarchy ] (img/animalHiearchy3.jpg)
![ upcasting downcasting ] ( img/updown_upcasting.png )


Other than `Object` ( shown above ), which has no superclass, every class has one and only one direct superclass. 

> This is referred to as `single inheritance`. Java does not support `multiple inheritance` although we can achieve similiar functionality via `interfaces`

In the absence of any other explicit superclass, every class is implicitly a subclass of Object.

Classes can be derived from classes that are derived from classes that are derived from classes, and so on, and ultimately derived from the topmost class,`Object`. Such a class is said to be descended from all the classes in the inheritance chain stretching back to `Object`.




A subclass inherits all the public methods and fields from its superclass. 

>Constructors are not members, so they are not inherited by subclasses, but the constructor of the superclass can be invoked from the subclass using the keyword `super`

#### The Java Platform Class Hierarchy

The Object class, defined in the java.lang package, defines and implements behavior common to all classes—including the ones that you write. In the Java platform, many classes derive directly from Object, other classes derive from some of those classes, and so on, forming a hierarchy of classes.

All Classes in the Java Platform are Descendants of Object
![classes-object] (img/classes-object.gif)

At the top of the hierarchy, Object is the most general of all classes. Classes near the bottom of the hierarchy provide more specialized behavior.

####An Example of Inheritance

Here is the sample code for a possible implementation of a Bicycle class.

```java
public class Bicycle {
        
    // the Bicycle class has three fields
    public int cadence;
    public int gear;
    public int speed;
        
    // the Bicycle class has one constructor
    public Bicycle(int startCadence, int startSpeed, int startGear) {
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;
    }
        
    // the Bicycle class has four methods
    public void setCadence(int newValue) {
        cadence = newValue;
    }
        
    public void setGear(int newValue) {
        gear = newValue;
    }
        
    public void applyBrake(int decrement) {
        speed -= decrement;
    }
        
    public void speedUp(int increment) {
        speed += increment;
    }
        
}
```

A class declaration for a MountainBike class that is a subclass of Bicycle might look like this:

```java
public class MountainBike extends Bicycle {
        
    // the MountainBike subclass adds one field
    public int seatHeight;

    // the MountainBike subclass has one constructor
    public MountainBike(int startHeight,
                        int startCadence,
                        int startSpeed,
                        int startGear) {
        super(startCadence, startSpeed, startGear);
        seatHeight = startHeight;
    }   
        
    // the MountainBike subclass adds one method
    public void setHeight(int newValue) {
        seatHeight = newValue;
    }   
}
```
MountainBike inherits all the fields and methods of Bicycle and adds the field `seatHeight` and a method, `setHeight`, to set it. Except for the constructor, it is as if you had written a new MountainBike class entirely from scratch, with four fields and five methods. However, you didn't have to do all the work! This would be especially valuable if the methods in the Bicycle class were complex and had taken substantial time to debug.

###What You Can Do in a Subclass

A subclass inherits all of the public and protected members of its parent, no matter what package the subclass is in. 

>####Side Note: Don't remember the difference between public, protected and package-private?
>[java access modifiers ] (img/java_accessmodifiers.jpg)
<br />
>[java access modifiers (graphic ) ] (img/java_accessmodifiers_graphic.jpg)

If the subclass is in the same package as its parent, it also inherits the package-private members of the parent. You can use the inherited members as is, replace them, hide them, or supplement them with new members:

* The inherited fields can be used directly, just like any other fields.
* You can declare a field in the subclass with the same name as the one in the superclass, thus hiding it (not recommended).
* You can declare new fields in the subclass that are not in the superclass.
* The inherited methods can be used directly as they are.
* You can write a new instance method in the subclass that has the same signature as the one in the superclass, thus overriding it. ( You remember what a method signature is right? [ method signature ] (img/static-method.png) )
* You can write a new static method in the subclass that has the same signature as the one in the superclass, thus hiding it.
* You can declare new methods in the subclass that are not in the superclass.
* You can write a subclass constructor that invokes the constructor of the superclass, either implicitly or by using the keyword super.

### Private Members in a Superclass

A subclass does not inherit the private members of its parent class. However, if the superclass has public or protected methods for accessing its private fields, these can also be used by the subclass.

### Casting Objects

We have seen that an object is of the data type of the class from which it was instantiated. For example, if we write
```java
MountainBike myBike = new MountainBike();
```
then `myBike` is of type `MountainBike`.


`MountainBike` is descended from `Bicycle` and `Object`. Therefore, a `MountainBike` is a `Bicycle` and is also an `Object`, and it can be used wherever `Bicycle` or `Object` objects are called for.

####The reverse is not necessarily true: a Bicycle may be a MountainBike, but it isn't necessarily. Similarly, an Object may be a Bicycle or a MountainBike, but it isn't necessarily.

Casting shows the use of an object of one type in place of another type, among the objects permitted by inheritance and implementations. For example, if we write

```java 
Object obj = new MountainBike();
```
then obj is both an Object and a MountainBike (until such time as obj is assigned another object that is not a MountainBike). This is called implicit casting.

If, on the other hand, we write
```java
MountainBike myBike = obj;
```
we would get a compile-time error because obj is not known to the compiler to be a MountainBike. However, we can tell the compiler that we promise to assign a MountainBike to obj by explicit casting:

```java
MountainBike myBike = (MountainBike)obj;
```

This cast inserts a runtime check that obj is assigned a MountainBike so that the compiler can safely assume that obj is a MountainBike. If obj is not a MountainBike at runtime, `an exception will be thrown`!!

Note: You can make a logical test as to the type of a particular object using the instanceof operator. This can save you from a runtime error owing to an improper cast. For example:
```java
if (obj instanceof MountainBike) {
    MountainBike myBike = (MountainBike)obj;
}
```
Here the instanceof operator verifies that obj refers to a MountainBike so that we can make the cast with knowledge that there will be no runtime exception thrown.

##Overriding and Hiding Methods

![ method overriding ] (img/methodOverriding.gif)


###Instance Methods

An instance method in a subclass with the same signature and return type as an instance method in the superclass overrides the superclass's method.

The ability of a subclass to override a method allows a class to inherit from a superclass whose behavior is "close enough" and then to modify behavior as needed. The overriding method has the same name, number and type of parameters, and return type as the method that it overrides. An overriding method can also return a subtype of the type returned by the overridden method. This subtype is called a covariant return type.

*IMPORTANT* - When overriding a method, you should use the @Override annotation that instructs the compiler that you intend to override a method in the superclass. If, for some reason, the compiler detects that the method does not exist in one of the superclasses, then it will generate an error. 

![overrides](img/overrides.png)

###Static Methods

If a subclass defines a static method with the same signature as a static method in the superclass, then the method in the subclass hides the one in the superclass.

The distinction between hiding a static method and overriding an instance method has important implications:

The version of the overridden instance method that gets invoked is the one in the subclass.
The version of the hidden static method that gets invoked depends on whether it is invoked from the superclass or the subclass.
Consider an example that contains two classes. The first is Animal, which contains one instance method and one static method:
```java
public class Animal {
    public static void testClassMethod() {
        System.out.println("The static method in Animal");
    }
    public void testInstanceMethod() {
        System.out.println("The instance method in Animal");
    }
}
```
The second class, a subclass of Animal, is called Cat:
```java
public class Cat extends Animal {
    public static void testClassMethod() {
        System.out.println("The static method in Cat");
    }
    public void testInstanceMethod() {
        System.out.println("The instance method in Cat");
    }

    public static void main(String[] args) {
        Cat myCat = new Cat();
        Animal myAnimal = myCat;
        Animal.testClassMethod();
        myAnimal.testInstanceMethod();
    }
}
```
The Cat class overrides the instance method in Animal and hides the static method in Animal. The main method in this class creates an instance of Cat and invokes testClassMethod() on the class and testInstanceMethod() on the instance.

The output from this program is as follows:
```
The static method in Animal
The instance method in Cat
```
As promised, the version of the hidden static method that gets invoked is the one in the superclass, and the version of the overridden instance method that gets invoked is the one in the subclass.

The following table summarizes what happens when you define a method with the same signature as a method in a superclass.

|  | Superclass Instance Method | Superclass Static Method |
|---|---|---|
| `Subclass Instance Method` | `Overrides` | Generates a compile-time error |
| `Subclass Static Method` | `Generates a compile-time error` | Hides |

###Modifiers

The access specifier for an overriding method can allow more, but not less, access than the overridden method. For example, a protected instance method in the superclass can be made public, but not private, in the subclass.

You will get a compile-time error if you attempt to change an instance method in the superclass to a static method in the subclass, and vice versa.

Note: In a subclass, you can overload the methods inherited from the superclass. Such overloaded methods neither hide nor override the superclass instance methods—they are new methods, unique to the subclass.

###Object as a Superclass

The Object class, in the java.lang package, sits at the top of the class hierarchy tree. Every class is a descendant of the Object class. Every class you use or write inherits the instance methods of Object. You need not use any of these methods, but, if you choose to do so, you may need to override them with code that is specific to your class. The methods inherited from Object that are discussed in this section are:

```java
protected Object clone() throws CloneNotSupportedException
      Creates and returns a copy of this object.
public boolean equals(Object obj)
      Indicates whether some other object is "equal to" this one.
protected void finalize() throws Throwable
      Called by the garbage collector on an object when garbage
      collection determines that there are no more references to the object
public final Class getClass()
      Returns the runtime class of an object.
public int hashCode()
      Returns a hash code value for the object.
public String toString()
      Returns a string representation of the object.
```

The notify, notifyAll, and wait methods of Object all play a part in synchronizing the activities of independently running threads in a program. There are five of these methods:

```java
public final void notify()
public final void notifyAll()
public final void wait()
public final void wait(long timeout)
public final void wait(long timeout, int nanos)
```

This is an advanced topic and will not be discussed further.


##Interfaces 

#### At this point in the lesson you really should know something about interfaces. 
- Go checkout interfaces and come back. [ interfaces ] ( ./interfaces.md)

##The toString() Method

You should always consider overriding the toString() method in your classes.

The Object's toString() method returns a String representation of the object, which is very useful for debugging. The String representation for an object depends entirely on the object, which is why you need to override toString() in your classes.

You can use toString() along with System.out.println() to display a text representation of an object, such as an instance of Book:

System.out.println(firstBook.toString());
which would, for a properly overridden toString() method, print something useful, like this:
```
ISBN: 0201914670; The Swing Tutorial; A Guide to Constructing GUIs, 2nd Edition
```

##The clone() Method

If a class, or one of its superclasses, implements the Cloneable interface, you can use the clone() method to create a copy from an existing object. To create a clone, you write:

```java
aCloneableObject.clone();
```

Object's implementation of this method checks to see whether the object on which clone() was invoked implements the Cloneable interface. If the object does not, the method throws a CloneNotSupportedException exception. Exception handling will be covered at a future point. For the moment, you need to know that clone() must be declared as

```java
protected Object clone() throws CloneNotSupportedException
```

or:

```java
public Object clone() throws CloneNotSupportedException
```
if you are going to write a clone() method to override the one in `Object`.

If the object on which clone() was invoked does implement the Cloneable interface, Object's implementation of the clone() method creates an object of the same class as the original object and initializes the new object's member variables to have the same values as the original object's corresponding member variables.

The simplest way to make your class cloneable is to add `implements Cloneable` to your class's declaration. then your objects can invoke the clone() method.

For some classes, the default behavior of Object's clone() method works just fine. If, however, an object contains a reference to an external object, say ObjExternal, you may need to override clone() to get correct behavior. Otherwise, a change in ObjExternal made by one object will be visible in its clone also. This means that the original object and its clone are not independent—to decouple them, you must override clone() so that it clones the object and ObjExternal. Then the original object references ObjExternal and the clone references a clone of ObjExternal, so that the object and its clone are truly independent.

##The equals() Method

The equals() method compares two objects for equality and returns true if they are equal. The equals() method provided in the Object class uses the identity operator (==) to determine whether two objects are equal. For primitive data types, this gives the correct result. For objects, however, it does not. The equals() method provided by Object tests whether the object references are equal—that is, if the objects compared are the exact same object.

To test whether two objects are equal in the sense of equivalency (containing the same information), you must override the equals() method. Here is an example of a Book class that overrides equals():

```java
public class Book {
    ...
    public boolean equals(Object obj) {
        if (obj instanceof Book)
            return ISBN.equals((Book)obj.getISBN()); 
        else
            return false;
    }
}
```
Consider this code that tests two instances of the Book class for equality:
```java
// Swing Tutorial, 2nd edition
Book firstBook  = new Book("0201914670");
Book secondBook = new Book("0201914670");
if (firstBook.equals(secondBook)) {
    System.out.println("objects are equal");
} else {
    System.out.println("objects are not equal");
}
```
This program displays objects are equal even though firstBook and secondBook reference two distinct objects. They are considered equal because the objects compared contain the same ISBN number.

You should always override the equals() method if the identity operator is not appropriate for your class.

Note: If you override equals(), you must override hashCode() as well.


##The hashCode() Method

The value returned by hashCode() is the object's hash code, which is the object's memory address in hexadecimal.

By definition, if two objects are equal, their hash code must also be equal. If you override the equals() method, you change the way two objects are equated and Object's implementation of hashCode() is no longer valid. Therefore, if you override the equals() method, you must also override the hashCode() method as well.

##The finalize() Method

The Object class provides a callback method, finalize(), that may be invoked on an object when it becomes garbage. Object's implementation of finalize() does nothing—you can override finalize() to do cleanup, such as freeing resources.

The finalize() method may be called automatically by the system, but when it is called, or even if it is called, is uncertain. Therefore, you should not rely on this method to do your cleanup for you. For example, if you don't close file descriptors in your code after performing I/O and you expect finalize() to close them for you, you may run out of file descriptors.

##The getClass() Method

You cannot override getClass.

The getClass() method returns a Class object, which has methods you can use to get information about the class, such as its name (getSimpleName()), its superclass (getSuperclass()), and the interfaces it implements (getInterfaces()). For example, the following method gets and displays the class name of an object:

```java
void printClassName(Object obj) {
    System.out.println("The object's" + " class is " +
        obj.getClass().getSimpleName());
}
```

The Class class, in the java.lang package, has a large number of methods (more than 50). For example, you can test to see if the class is an annotation (isAnnotation()), an interface (isInterface()), or an enumeration (isEnum()). You can see what the object's fields are (getFields()) or what its methods are (getMethods()), and so on.


###Writing Final Classes and Methods

You can declare some or all of a class's methods final. You use the final keyword in a method declaration to indicate that the method cannot be overridden by subclasses. The Object class does this—a number of its methods are final.

You might wish to make a method final if it has an implementation that should not be changed and it is critical to the consistent state of the object. For example, you might want to make the getFirstPlayer method in this ChessAlgorithm class final:
```java
class ChessAlgorithm {
    ...
    final ChessPlayer getFirstPlayer() {
        return ChessPlayer.WHITE;
    }
    ...
}
```
Methods called from constructors should generally be declared final. If a constructor calls a non-final method, a subclass may redefine that method with surprising or undesirable results.

Note that you can also declare an entire class final. A class that is declared final cannot be subclassed. This is particularly useful, for example, when creating an immutable class like the String class.


##Polymorphism

The dictionary definition of polymorphism refers to a principle in biology in which an organism or species can have many different forms or stages. This principle can also be applied to object-oriented programming and languages like the Java language. Subclasses of a class can define their own unique behaviors and yet share some of the same functionality of the parent class.

Polymorphism can be demonstrated with a minor modification to the Bicycle class. For example, a printDescription method could be added to the class that displays all the data currently stored in an instance.
```java
public void printDescription(){
    System.out.println("\nBike is " + "in gear " + this.gear
        + " with a cadence of " + this.cadence +
        " and travelling at a speed of " + this.speed + ". ");
}
```
To demonstrate polymorphic features in the Java language, extend the Bicycle class with a MountainBike and a RoadBike class. For MountainBike, add a field for suspension, which is a String value that indicates if the bike has a front shock absorber, Front. Or, the bike has a front and back shock absorber, Dual.

Here is the updated class:
```java
public class MountainBike extends Bicycle {
    private String suspension;

    public MountainBike(
               int startCadence,
               int startSpeed,
               int startGear,
               String suspensionType){
        super(startCadence,
              startSpeed,
              startGear);
        this.setSuspension(suspensionType);
    }

    public String getSuspension(){
      return this.suspension;
    }

    public void setSuspension(String suspensionType) {
        this.suspension = suspensionType;
    }

    public void printDescription() {
        super.printDescription();
        System.out.println("The " + "MountainBike has a" +
            getSuspension() + " suspension.");
    }
} 
```
Note the overridden printDescription method. In addition to the information provided before, additional data about the suspension is included to the output.

Next, create the RoadBike class. Because road or racing bikes have skinny tires, add an attribute to track the tire width. Here is the RoadBike class:
```java
public class RoadBike extends Bicycle{
    // In millimeters (mm)
    private int tireWidth;

    public RoadBike(int startCadence,
                    int startSpeed,
                    int startGear,
                    int newTireWidth){
        super(startCadence,
              startSpeed,
              startGear);
        this.setTireWidth(newTireWidth);
    }

    public int getTireWidth(){
      return this.tireWidth;
    }

    public void setTireWidth(int newTireWidth){
        this.tireWidth = newTireWidth;
    }

    public void printDescription(){
        super.printDescription();
        System.out.println("The RoadBike" + " has " + getTireWidth() +
            " MM tires.");
    }
}
```
Note that once again, the printDescription method has been overridden. This time, information about the tire width is displayed.

To summarize, there are three classes: Bicycle, MountainBike, and RoadBike. The two subclasses override the printDescription method and print unique information.

Here is a test program that creates three Bicycle variables. Each variable is assigned to one of the three bicycle classes. Each variable is then printed.
```java
public class TestBikes {
  public static void main(String[] args){
    Bicycle bike01, bike02, bike03;

    bike01 = new Bicycle(20, 10, 1);
    bike02 = new MountainBike(20, 10, 5, "Dual");
    bike03 = new RoadBike(40, 20, 8, 23);

    bike01.printDescription();
    bike02.printDescription();
    bike03.printDescription();
  }
}
```
The following is the output from the test program:
```java
Bike is in gear 1 with a cadence of 20 and travelling at a speed of 10. 

Bike is in gear 5 with a cadence of 20 and travelling at a speed of 10. 
The MountainBike has a Dual suspension.

Bike is in gear 8 with a cadence of 40 and travelling at a speed of 20. 
The RoadBike has 23 MM tires.
```
The Java virtual machine (JVM) calls the appropriate method for the object that is referred to in each variable. It does not call the method that is defined by the variable's type. This behavior is referred to as virtual method invocation and demonstrates an aspect of the important polymorphism features in the Java language.
