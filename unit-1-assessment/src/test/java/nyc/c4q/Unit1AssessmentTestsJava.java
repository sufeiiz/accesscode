package nyc.c4q;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(RobolectricTestRunner.class)
@Config(manifest = "src/main/AndroidManifest.xml", emulateSdk = 18)
public class Unit1AssessmentTestsJava {

    @Test
    public void test01SubFunClassInheritsFromSuperFunClass() throws Exception {
        SubFunClass funObject = new SubFunClass();
        assertThat(funObject, instanceOf(SuperFunClass.class));
    }

    @Test
    public void test02SubFunClassImplementsAwesomeInterface() throws Exception{
        SubFunClass funObject = new SubFunClass();
        assertThat(funObject, instanceOf(AwesomeInterface.class));
    }

   @Test
    public void test03AbstractAwesomeClassImplementsAwesomeInterface() throws Exception{
        AbstractAwesomeClass awesomeObject = new ConcreteAwesomeClass();
        assertEquals(awesomeObject.getData(), 4);
        awesomeObject.setData(5);
        assertEquals(awesomeObject.getData(), 5);
    }

    @Test
    public void test04AwesomeContainerContainsAwesomeObject() throws Exception{
        Collection myList = AwesomeContainer.createAwesomeContainer();
        assertEquals(myList.getClass(), ArrayList.class);
        AwesomeContainer.addAwesomeObject(myList);
        assertEquals(((ArrayList) myList).get(0).getClass(), ConcreteAwesomeClass.class);
    }

}
