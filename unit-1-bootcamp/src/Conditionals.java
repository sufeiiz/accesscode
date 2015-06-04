import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Sufei Zhao on 4/14/15.
 */
public class Conditionals {

    // takes in an int n and returns a true if n is odd, and false otherwise.
    public static boolean isOdd(int n) {
        return !(n % 2 == 0);
    }

    // takes in an int n and returns true if n is a multiple of three, and false otherwise.
    public static boolean isMultipleOfThree(int n) {
        return n % 3 == 0;
    }

    // takes in an int n and returns true if n is both odd and a multiple of three, and false otherwise.
    public static boolean isOddAndIsMultipleOfThree(int n) {
        return isOdd(n) && isMultipleOfThree(n);
    }

    // if you used isOdd and isMultipleofThree in your last solution, don't use it this time
    public static boolean isOddAndIsMultipleOfThree2(int n) {
        return !(n % 2 == 0) && (n % 3 == 0);
    }

    // takes an int n and prints "Fizz" if n is a multiple of three, and prints n otherwise.
    public static void fizzMultipleOfThree(int n) {
        if (isMultipleOfThree(n))
            System.out.println("Fizz");
        else
            System.out.println(n);
    }

    // takes in a Person and returns true if the person is from London, and false otherwise.
    public static boolean isFromLondon(Person person) {
        return (person.getCity().equalsIgnoreCase("London"));
    }

    // takes in a Person and prints the name if the person has a name longer than 5 characters,
    // and otherwise prints "Name is too short."
    public static void printName(Person person) {
        if (person.getName().length() > 5)
            System.out.println(person.getName());
        else
            System.out.println("Name is too short.");
    }

    // A squirrel party is successful when the number of cigars is between 40 and 60, inclusive.
    // Unless it is the weekend, in which case there is no upper bound on the number of cigars.
    // Write a method called cigarParty that takes an int (the number of cigars) and
    // boolean (whether or not it is the weekend) as parameters, and returns true if the party with
    // the given values is successful, or false otherwise.
    public static boolean cigarParty(int cigars, boolean weekend) {
        if (weekend)
            return cigars >= 40;
        else
            return cigars >= 40 && cigars <= 60;
    }

    // You are driving a little too fast, and a police officer stops you.
    // If speed is 60 or less, the result is 0.
    // If speed is between 61 and 80 inclusive, the result is 1.
    // If speed is 81 or more, the result is 2.
    // Unless it is your birthday -- on that day, your speed can be 5 higher in all cases.
    public static int ticketCode(int speed, boolean birthday) {
        if (birthday)
            speed -= 5;
        if (speed <= 60)
            return 0;
        else if (speed > 60 && speed <= 80)
            return 1;
        else
            return 2;
    }

    // Given a day of the week encoded as 0=Sun...6=Sat, and a boolean indicating if
    // we are on vacation, return a string indicating when the alarm clock should ring.
    // Weekdays, the alarm should be "7:00" and on the weekend it should be "10:00".
    // On vacation -- then on weekdays it should be "10:00" and weekends it should be "off".
    public static String alarm(int day, boolean vacation) {
        if (vacation) {
            if (day == 0 || day == 6)
                return "off";
            else
                return "10:00";
        } else {
            if (day == 0 || day == 6)
                return "10:00";
            else
                return "7:00";
        }
    }

    // You have a green lottery ticket, with ints a, b, and c on it.
    // If the numbers are all different from each other, the result is 0.
    // If all of the numbers are the same, the result is 20.
    // If two of the numbers are the same, the result is 10.
    // Write a method that takes 3 ints as parameters and returns the correct result.
    public static int lottery(int a, int b, int c) {
        if (a == b && b == c && c == a)
            return 20;
        else if (a != b && b != c && c != a)
            return 0;
        else
            return 10;
    }

    // Given 2 int values greater than 0, return whichever value is nearest to 21 without going over.
    // Return 0 if they both go over.
    public static int blackjack(int x, int y) {
        if (x > 21 && y > 21)
            return 0;
        else if (x > 21)
            return y;
        else if (y > 21)
            return x;
        else
            return Math.max(x, y);
    }

    // Given three ints, a b c, one of them is small, one is medium and one is large.
    // Return true if the three values are evenly spaced, so the difference between
    // small and medium is the same as the difference between medium and large.
    public static boolean evenlySpaced(int a, int b, int c) {
        List<Integer> nums = new ArrayList<Integer>();
        Collections.sort(nums);
        if (nums.get(2) - nums.get(1) == nums.get(1) - nums.get(0))
            return true;
        else
            return false;
    }
}
