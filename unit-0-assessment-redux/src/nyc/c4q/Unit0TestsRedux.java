package nyc.c4q;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.junit.Assert.*;

public class Unit0TestsRedux {

    // http://stackoverflow.com/a/1119559/198348
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void testPrintHelloWorld() throws Exception {
        Unit0Exercises.print();
        assertEquals("I'm sorry Dave, I'm afraid I can't let you do that.\n", outContent.toString());
    }

    @Test
    public void testReturnPrimitiveBooleanFalseType() throws Exception {
        Class returnType = Unit0Exercises.class.getMethod("returnPrimitiveBooleanFalse").getReturnType();
        assertEquals(boolean.class, returnType);
    }

    @Test
    public void testReturnPrimitiveBooleanFalse() throws Exception {
        assertEquals(false, Unit0Exercises.returnPrimitiveBooleanFalse());
    }

    @Test
    public void testReturnPrimitiveInt55Plus44Type() throws Exception {
        Class returnType = Unit0Exercises.class.getMethod("returnPrimitiveInt55Plus44", null).getReturnType();
        assertEquals(int.class, returnType);
    }

    @Test
    public void testReturnPrimitiveInt55Plus44() throws Exception {
        assertEquals(99, Unit0Exercises.returnPrimitiveInt55Plus44());
    }

    @Test
    public void testReturnPrimitiveDouble2Point718Type() throws Exception {
        Class returnType = Unit0Exercises.class.getMethod("returnPrimitiveDouble2Point718").getReturnType();
        assertEquals(double.class, returnType);
    }

    @Test
    public void testReturnPrimitiveDouble2Point718() throws Exception {
        assertNotEquals(null, Unit0Exercises.returnPrimitiveDouble2Point718());
        assertEquals(2.718, (Double) Unit0Exercises.returnPrimitiveDouble2Point718(), 0.01);
    }

    @Test
    public void testReturnPrimitiveCharASCII35Type() throws Exception {
        Class returnType = Unit0Exercises.class.getMethod("returnPrimitiveCharASCII35").getReturnType();
        assertEquals(char.class, returnType);
    }

    @Test
    public void testReturnPrimitiveCharASCII35() throws Exception {
        assertEquals('#', Unit0Exercises.returnPrimitiveCharASCII35());
    }

    @Test
    public void testIsEven() throws Exception {
        assertTrue(Unit0Exercises.isEven(0));
        assertFalse(Unit0Exercises.isEven(1));
        assertTrue(Unit0Exercises.isEven(2));
        assertFalse(Unit0Exercises.isEven(3));
        assertTrue(Unit0Exercises.isEven(4));
        assertFalse(Unit0Exercises.isEven(5));
        assertTrue(Unit0Exercises.isEven(6));
    }

    @Test
    public void testIsMultipleOfX() throws Exception {
        assertTrue(Unit0Exercises.isMultipleOfX(0, 3));
        assertFalse(Unit0Exercises.isMultipleOfX(1, 3));
        assertFalse(Unit0Exercises.isMultipleOfX(2, 3));
        assertTrue(Unit0Exercises.isMultipleOfX(3, 3));
        assertFalse(Unit0Exercises.isMultipleOfX(10, 3));
        assertTrue(Unit0Exercises.isMultipleOfX(28, 7));
        assertTrue(Unit0Exercises.isMultipleOfX(-14, 7));
        assertFalse(Unit0Exercises.isMultipleOfX(-6, 7));
    }

    @Test
    public void testReturnSumOfOddNumbersBetween1And100(){
        assertEquals(2500, Unit0Exercises.returnSumOfOddNumbersBetween1And100());
    }

    @Test
    public void testReturnSumOfTheFirst200MultiplesOf3(){
        assertEquals(59700, Unit0Exercises.returnSumOfTheFirst200MultiplesOf3());
    }

    @Test
    public void testIsEmptyString(){
        assertTrue(Unit0Exercises.isEmptyString(""));
        assertFalse(Unit0Exercises.isEmptyString("hello"));
    }

    @Test
    public void testAlternateS1AndS2XTimes(){
        assertEquals("",                                    Unit0Exercises.alternateS1AndS2Xtimes("abra", "cadabra", 0));
        assertEquals("abracadabra",                         Unit0Exercises.alternateS1AndS2Xtimes("abra", "cadabra", 1));
        assertEquals("abracadabraabracadabra", Unit0Exercises.alternateS1AndS2Xtimes("abra", "cadabra", 2));
        assertEquals("abracadabraabracadabraabracadabra", Unit0Exercises.alternateS1AndS2Xtimes("abra", "cadabra", 3));
    }

    @Test
    public void testStringSplit(){
        assertEquals("ubi", Unit0Exercises.stringSplit("ubiquitous", "q"));
        assertEquals("hello", Unit0Exercises.stringSplit("hellogoodbye", "good"));
        assertEquals("", Unit0Exercises.stringSplit("fancy seeing you", "there"));
    }

    @Test
    public void testReturnBeyonce(){
      Singer singer = Unit0Exercises.returnBeyonce();
      assertNotEquals(null, singer);
      assertEquals("Beyonce", singer.getName());
      assertEquals("USA", singer.getLocation());
    }

    @Test
    public void testReturnSingerChild(){
      Singer s1 = new Singer("Beyonce", "USA");
      Singer s2 = new Singer("Madonna", "USA");
      Singer s3 = new Singer("Rihanna", "Barbados");
      Singer child1 = Unit0Exercises.returnSingerChild(s1, s2);
      Singer child2 = Unit0Exercises.returnSingerChild(s2, s3);
      assertNotEquals(null, child1);
      assertNotEquals(null, child2);
      assertEquals("Beyonce", child1.getName());
      assertEquals("USA", child1.getLocation());
      assertEquals("Madonna", child2.getName());
      assertEquals("Barbados", child2.getLocation());
    }

    @Test
    public void testReturnSingers(){
        HashMap<String, Singer> people = Unit0Exercises.returnSingers();
        assertNotEquals(null, people);

        assertTrue(people.containsKey("Beyonce"));
        assertTrue(people.containsKey("Jay-Z"));
        assertTrue(people.containsKey("Bieber"));
        assertTrue(people.containsKey("Drake"));
        assertTrue(people.containsKey("Jepsen"));

        assertEquals("USA", people.get("Beyonce").getLocation());
        assertEquals("USA", people.get("Jay-Z").getLocation());
        assertEquals("Canada", people.get("Bieber").getLocation());
        assertEquals("Canada", people.get("Drake").getLocation());
        assertEquals("Canada", people.get("Jepsen").getLocation());

    }

  @Test
  public void testIsFromCanada() {
    Singer s1 = new Singer("Bieber", "Canada");
    Singer s2 = new Singer("Beyonce", "USA");
    assertTrue(Unit0Exercises.isFromCanada(s1));
    assertFalse(Unit0Exercises.isFromCanada(s2));
  }

  @Test
  public void testChangeJayZsLocationToLosAngeles() {
    HashMap<String, Singer> singers = new HashMap<String, Singer>();
    singers.put("Beyonce", new Singer("Beyonce", "USA"));
    singers.put("Jay-Z", new Singer("Jay-Z", "USA"));
    singers.put("Bieber", new Singer("Bieber", "Canada"));
    Singer jayz = singers.get("Jay-Z");
    Unit0Exercises.changeJayZsLocationToLosAngeles(singers);
    assertEquals("Los Angeles", jayz.getLocation());
  }

  @Test
  public void testRemoveJepsenFromSingers() {
    HashMap<String, Singer> singers = new HashMap<String, Singer>();
    singers.put("Beyonce", new Singer("Beyonce", "USA"));
    singers.put("Jay-Z", new Singer("Jay-Z", "USA"));
    singers.put("Bieber", new Singer("Bieber", "Canada"));
    singers.put("Drake", new Singer("Drake", "Canada"));
    singers.put("Jepsen", new Singer("Jepsen", "Canada"));

    Unit0Exercises.removeJepsenFromSingers(singers);
    assertFalse(singers.containsKey("Jepsen"));
  }
}
