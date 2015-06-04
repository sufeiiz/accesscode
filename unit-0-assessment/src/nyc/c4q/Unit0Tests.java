package nyc.c4q;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;

public class Unit0Tests {

    /*
     * Name of the method implies what the method should do.
     * Some of these methods require that the method return signature change.
     * For example, `returnPrimitiveBooleanTrue()` should return `boolean`, not `Object`.
     */
    public static void main (String args[]) {
      // Use main to test your methods
        printHelloWorld();
        System.out.println(fibonacci(10));
        bonusPrintOutSumOfFirstTenFibonacciNumbers();
        bonusPrintOutSumOfFirstFortyFibonacciNumbers();
    }

    public static void printHelloWorld() {
      System.out.println("Hello World");
    }

    public static boolean returnPrimitiveBooleanTrue() {
      return true;
    }

    public static int returnPrimitiveInt1729() {
      return 1729;
    }

    public static double returnPrimitiveDoubleThreePointOneFour() {
      return 3.14;
    }

    public static char returnPrimitiveCharZ() {
        return 'Z';
    }

    public static void printSumOf1Upto10UsingForLoop() {
        int sum = 0;
        for (int i=1; i < 10; i++) {
            sum += i;
        }

        System.out.println(sum);
    }

    public static void printSumOf1Upto10000UsingForLoop() {
        int sum = 0;
        for (int i=1; i < 10000; i++) {
            sum += i;
        }

        System.out.println(sum);
    }

    public static boolean isOdd(int n) {
        return !(n % 2 == 0);
    }

    public static boolean isMultipleOfThree(int n) {
      return (n % 3 == 0);
    }

    public static boolean isOddAndIsMultipleOfThree(int n) {
      return (isOdd(n) && isMultipleOfThree(n));
    }

    public static String repeatStringXTimes(String input, int times) {
        // Given string "input" and a positive integer "times",
        // return a string that is equal to the input string repeated X times.
        // If "times" is 0 negative, return a blank string.
        // For example, repeatStringXTimes("potato", 5) should return "potatopotatopotatopotatopotato".
        String repeated = "";

        if (times > 0) {
            for (int i = 0; i < times; i++) {
                repeated += input;
            }
            return repeated;
        } else
            return "";
    }

    public static String returnStringUntilQ(String input) {
        // Given string "input", return a string that stops at the first occurrence of the character 'q'.
        // For example, given the string "ubiquitous", return "ubi".
        // If the string does not contain a q, then return the empty string "".
        String stopQ = "";

        if (input.contains("q")) {
            for (int i = 0; i < input.length(); i++) {
                char curr = input.charAt(i);
                if (curr == 'q')
                    break;
                else
                    stopQ += curr;
            }

            return stopQ;
        } else
            return "";
    }

    public static Person declareAndReturnPersonNamedAda() {
        Person ada = new Person("Ada");

        return ada;
    }

    public static Person declareAndReturnPersonNamedAlanTuringFromLondon() {
        Person alan = new Person("Alan Turing");
        alan.setCity("London");

        return alan;
    }

    public static boolean isFromLondon(Person person) {
        return person.getCity().equalsIgnoreCase("London");
    }

    public static ArrayList<Place> declareAndReturnArrayListOfThreePlaces() {
        ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place("New York City"));
        places.add(new Place("London", -0.13, 51.51));
        places.add(new Place("Shanghai", 121.5, 31.2));

        return places;
    }

    public static HashMap<String, Person> declareAndReturnHashmapOfAlanTuringAndGraceHopper() {
      // The HashMap should have key-value pairs of:
      // - key: `Alan Turing`, value: instance of Person with name `Alan Turing`
      // - key: `Grace Hopper`, value: instance of Person with name `Grace Hopper`
        HashMap<String, Person> geniuses = new HashMap<String, Person>();
        Person alan = new Person("Alan Turing");
        alan.setCity("London");
        Person grace = new Person("Grace Hopper");
        grace.setCity("Arlington");

        geniuses.put("Alan Turing", alan);
        geniuses.put("Grace Hopper", grace);

        return geniuses;
    }

    public static void changeTuringsCityToPrinceton(HashMap<String, Person> people) {
        people.get("Alan Turing").setCity("Princeton");
    }

    // Bonus Problems
    public static void bonusPrintOutSumOfFirstTenFibonacciNumbers() {
        ArrayList<Integer> nums = new ArrayList<Integer>(fibonacci(10));
        long sum = 0;

        for (Integer num : nums) {
            sum += num;
        }

        System.out.println(sum);
    }

    public static void bonusPrintOutSumOfFirstFortyFibonacciNumbers() {
        ArrayList<Integer> nums = new ArrayList<Integer>(fibonacci(40));
        long sum = 0;

        for (Integer num : nums) {
            sum += num;
        }

        System.out.println(sum);
    }

    public static ArrayList<Integer> fibonacci(int n) {
        ArrayList<Integer> nums = new ArrayList<Integer>();

        int first = 0, second = 1, fibonacci;
        nums.add(0);
        nums.add(1);

        for (int i = 0; i <= n-3; i++) {
            fibonacci = first + second;
            nums.add(fibonacci);
            first = second;
            second = fibonacci;
        }

        return nums;
    }
}
