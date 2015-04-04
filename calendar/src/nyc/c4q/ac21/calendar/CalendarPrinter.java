package nyc.c4q.ac21.calendar;

import java.util.Calendar;
import java.util.HashMap;

public class CalendarPrinter
{

    /**
     * Prints a calendar for a month.
     *
     * Prints the calendar in the traditional format with one week per line.
     * Each week starts on Sunday and shows the days of month for days in
     * that week.  The current date is marked with an asterisk.
     *
     * For example, for 2015-04-03, prints this:
     *
     *     April 2015
     *                  1   2   3*  4
     *      5   6   7   8   9  10  11
     *     12  13  14  15  16  17  18
     *     19  20  21  22  23  24  25
     *     26  27  28  29  30
     *
     * @param date
     *   The date containing the month to print.
     */
    public static void printMonthCalendar(Calendar date) {
        HashMap<Integer, String> getMonth = DateTools.getMonthNames();
        String month = getMonth.get(date.get(Calendar.MONTH));
        int dayInMonth = date.getActualMaximum(Calendar.DAY_OF_MONTH);
        int today = date.get(Calendar.DATE);

        System.out.println(month + " " + date.get(Calendar.YEAR));

        // sets cal to first day of month and find which weekday that is
        date.set(Calendar.DAY_OF_MONTH, 1);
        int position = date.get(Calendar.DAY_OF_WEEK);

        for (int i=1; i<position; i++) {
            System.out.print("    ");
        }

        for (int j=1; j<=dayInMonth; j++) {
            int current = date.get(Calendar.DATE);
            int currPosition = date.get(Calendar.DAY_OF_WEEK);
            String printDay = String.valueOf(current);

            if (current < 10)
                printDay = " " + current;

            if (current == today) {
                System.out.print(printDay + "* ");
                if (currPosition == 7)
                    System.out.print("\n");
            }
            else if (currPosition == 7)
                System.out.print(printDay + "  \n");
            else
                System.out.print(printDay + "  ");

            date.add(Calendar.DATE, 1);
        }
    }
}
