import java.util.Objects;

/**
 * Created by sufeizhao on 5/28/15.
 */
public class MyObject {

    private String name;
    private int age;

    public MyObject(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object obj) {
        MyObject object = (MyObject) obj;
        return this.name.equalsIgnoreCase((object.getName())) && this.age == object.getAge();
    }

    public static void main(String[] args) {
        MyObject test = new MyObject("Object", 13);
        System.out.println("Initial object name: " + test.getName());
        System.out.println("Initial object age: " + test.getAge());

        test.setName("New Object");
        test.setAge(1);
        System.out.println("Modified object name: " + test.getName());
        System.out.println("Modified object age: " + test.getAge());
    }
}
