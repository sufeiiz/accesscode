package nyc.c4q.sufeiiz;

/**
 * Access Code 2.1
 * Person.java
 * You are provided with a Person class.
 * This class has private fields name, phoneNumber and city, along with their getter and setter methods.
 *   - Write a function called checkSameCity which accepts as input two Person instances and
 *     checks if they live in the same city. The function should return a boolean value.
 *   - A Person has recently had a child, whose name is 'Abc'.
 *     Write a function called registerChild which accepts as input a Person instance(Parent) and
 *     returns a new Person instance for the child, which has the same phoneNumber and city as the parent.
 */

public class Person {

    private String name;
    private String phoneNumber;
    private String city;

    public void Person(){
    }

    public void Person(String name){
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static boolean checkSameCity(Person person1, Person person2) {
        String city1 = person1.getCity();
        String city2 = person2.getCity();

        if (city1.equalsIgnoreCase(city2))
            return true;
        else
            return false;
    }

    public static Person registerChild(Person parent, String name) {
        Person child = new Person();
        child.setName(name);
        child.setPhoneNumber(parent.getPhoneNumber());
        child.setCity(parent.getCity());

        return child;
    }
}
