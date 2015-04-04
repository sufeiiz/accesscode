package nyc.c4q.sufeiiz;

/**
 * Created by sufeizhao on 3/12/15.
 * Access Code 2.1
 * Learning about methods
 */

public class Methods {

    public static void speak() {
        System.out.println("Hello");
    }

    public static void shoutOut(String name, int age) {
        System.out.println("Hey " + name + ", you are " + age + " years old.");
    }

    public static void main(String[] args) {
        speak();
        shoutOut("Man", 23);
    }
}
