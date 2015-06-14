import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tests {

    @Test
    public void test01InheritanceParent() throws Exception {
        Exercises.Parent p = new Exercises.Parent();
        assertEquals("parent", p.doStuff());
        assertThat(p, instanceOf(Exercises.Parent.class));
        assertThat(p, not(instanceOf(Exercises.Child.class)));

    }

    @Test
    public void test02InheritanceChild() throws Exception {
        Exercises.Parent c = new Exercises.Child();
        assertEquals("child", c.doStuff());
        assertThat(c, instanceOf(Exercises.Parent.class));
        assertThat(c, instanceOf(Exercises.Child.class));
        assertEquals("Howdy", ((Exercises.Child) c).doStuff("Howdy"));
    }

    @Test
    public void test03MyObjectNodeInheritsMyNode() throws Exception {
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        Class<?> klass = cl.loadClass("MyObjectNode");
        Object node = klass.newInstance();
        assertThat(node, instanceOf(MyNode.class));
    }

    @Test
    public void test04MyObjectNodeImplementsSetters() throws Exception {
        // not the smartest test...
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        Class<?> klass = cl.loadClass("MyObjectNode");
        Method[] methods = klass.getMethods();
        ArrayList<String> methodNames = new ArrayList<String>();
        for (Method m : methods){
            methodNames.add(m.getName());
        }

        for (String s : new String[] {"setLeft", "setRight", "setData"}){
            assertThat(methodNames, hasItem(s));
        }
    }

    @Test
    public void test05MyObjectHasNameAndAge() throws Exception {
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        Class<?> klass = cl.loadClass("MyObject");

        Method[] methods = klass.getMethods();
        ArrayList<String> methodNames = new ArrayList<String>();
        for (Method m : methods){
            methodNames.add(m.getName());
        }

        for (String s : new String[] {"setName", "setAge", "getName", "getAge"}){
            assertThat(methodNames, hasItem(s));
        }

        Object myObject = klass.getConstructor(String.class, int.class).newInstance("Michael Jackson", 50);
    }
}
