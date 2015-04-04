package nyc.c4q.ac21.calendar;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("date? ");
        String dateString = scanner.nextLine();
        Calendar date = DateTools.parseDate(dateString);
        if (date == null)
            return;
        System.out.println();

        System.out.println("date:              " + DateTools.formatDate(date));

        // 1. Show the day of the week.
        HashMap<Integer, String> dayOfWeekNames = DateTools.getDayOfWeekNames();
        String weekday = dayOfWeekNames.get(date.get(Calendar.DAY_OF_WEEK));
        System.out.println("day of week:       " + weekday);

        // 2. Show whether this is a work day.
        HashMap<Integer, Boolean> workDays = WorkDays.getWorkDays();
        boolean workDay = workDays.get(date.get(Calendar.DAY_OF_WEEK));
        System.out.println("work day:          " + workDay);

        // 3. Show whether this is a national holiday, and if so, which.
        HashMap<Calendar, String> holidays = Holidays.getHolidays("National holiday");
        if (holidays.containsKey(date)) {
            System.out.println("national holiday:  " + holidays.get(date));
        }
        else {
            System.out.println("national holiday:  -");
        }
    
        // 4. Show whether this date is in DST.
        boolean isDST = DST.isDST(date);
        System.out.println("is DST:            " + isDST);

        // 5. Show the zodiac sign.
        String zodiacSign = Zodiac.getZodiacSign(date);
        System.out.println("Zodiac sign:       " + zodiacSign);

        // 6. Print out the monthly calendar.
        System.out.println();
        CalendarPrinter.printMonthCalendar(date);
    }
}
