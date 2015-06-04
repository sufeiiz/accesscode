import java.util.Calendar;

/**
 * Created by Sufei Zhao on 4/16/15.
 * Answer the following question:
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 * What day of the week were you born?
 */

public class CountingSundays {

    // return how many sundays fell on the first of the month within years in parameter
    public static int countSundays(int yearStart, int yearEnd) {
        Calendar cal = Calendar.getInstance();
        cal.set(yearStart, Calendar.JANUARY, 1);
        int count = 0;

        while (cal.get(Calendar.YEAR) != yearEnd+1) {
            if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                count++;
            }
            cal.add(Calendar.MONTH, 1);
        }
        return count;
    }

    // find which day of the week from date
    public static String dayOfWeek(int year, int month, int date) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month-1, date);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        String day = "";
        switch (dayOfWeek) {
            case Calendar.MONDAY :
                day = "Monday";
                break;
            case Calendar.TUESDAY :
                day = "Tuesday";
                break;
            case Calendar.WEDNESDAY :
                day = "Wednesday";
                break;
            case Calendar.THURSDAY :
                day = "Thursday";
                break;
            case Calendar.FRIDAY :
                day = "Friday";
                break;
            case Calendar.SATURDAY :
                day = "Saturday";
                break;
            case Calendar.SUNDAY :
                day = "Sunday";
                break;
        }

        return day;
    }

    public static void main(String[] args) {
        int sundays = countSundays(1901, 2000);
        System.out.println("During the twentieth century, " + sundays + " Sundays fell on the first of the month.");

        String birthday = dayOfWeek(1991, 5, 2);
        System.out.println("I was born on a " + birthday + ".");
    }
}
