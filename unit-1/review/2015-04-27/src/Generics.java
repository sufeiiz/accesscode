import java.util.HashMap;

public class Generics {
    public static void main(String[] args) {
        HashMap<String, Foo> map1 = new HashMap<String, Foo>();
        HashMap<String, Bar> map2 = new HashMap<String, Bar>();

        // This is the signature/definition of HashMap's putAll method:
        // public void putAll(Map<? extends K, ? extends V> m)

        // this line will not compile, since Foo is not necessarily a Bar
        // map2.putAll(map1);

        // this line will compile, since Bar is always a Foo
        map1.putAll(map2);
    }
}

class Foo {
}

class Bar extends Foo {

}
