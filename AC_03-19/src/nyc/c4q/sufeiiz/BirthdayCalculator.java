package nyc.c4q.sufeiiz;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by sufeiiz && personabe1984 on 3/19/15.
 * Access Code 2.1
 * BirthdayCalculator.java
 * Counts down how many days until your next birthday
 */

public class BirthdayCalculator {

    public static boolean isLeapYear(int year) {
        boolean check = false;

        if ( (year%4 == 0 && year%100 != 0) || year%400 == 0 ) {
            check = true;
        }
        return check;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Calendar current = Calendar.getInstance();
        Calendar birthday = Calendar.getInstance();
        int currDate, currMonth, birthMonth, birthDate, numToday, numBirth, countdown;

        System.out.println("Please enter your birthday - ");
        System.out.print("Month (1-12): ");
        birthMonth = input.nextInt() - 1; // Calendar months start from 0
        System.out.print("Day (1-31): ");
        birthDate = input.nextInt();

        // set birthday to calendar, use getter for #days in year
        birthday.set(Calendar.YEAR +1, birthMonth, birthDate);
        numBirth = birthday.get(Calendar.DAY_OF_YEAR);

        // use getter for #days in year for today
        numToday = current.get(Calendar.DAY_OF_YEAR);
        currDate = current.get(Calendar.DATE);
        currMonth = current.get(Calendar.MONTH);

        if (birthMonth == currMonth && birthDate == currDate)
            System.out.println("Today is your birthday! Happy birthday!");
        else if (birthMonth < currMonth || (birthMonth == currMonth && birthDate < currDate)) {
            birthday.set(Calendar.YEAR +1, birthMonth, birthDate);
            countdown = 365 - (numToday - numBirth);
            System.out.println(countdown + " days until your birthday!");
        } else {
            countdown = numBirth - numToday;
            System.out.println(countdown + " days until your birthday!");
        }
    }
}
