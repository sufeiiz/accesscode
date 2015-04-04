package nyc.c4q.ac21.calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 * Daylight Savings Time (DST) computations.
 */
public class DST {

    /**
     * Populates hash maps with the start and end time for DST in each year.
     * @param startDates
     *   A hash map of the start date of DST in each year.
     * @param endDates
     *   A hash map of the end date of DST in each year.
     */
    public static void getDSTDates(HashMap<Integer, Calendar> startDates, HashMap<Integer, Calendar> endDates) {
        // Each line in the file is of the form "start,end", where both dates
        // are in the same year.  This represents the dates DST starts and
        // ends in this year.
        ArrayList<String> lines = FileTools.readLinesFromFile("dst.csv");
        String current;
        Calendar calendar;
        int year;

        for (String date : lines) {
            String[] parsed = date.split(",");

            for (int i=0; i<parsed.length; i++) {
                current = parsed[i];
                if (i % 2 == 0) {
                    year = Integer.valueOf(current.substring(0, 4));
                    calendar = DateTools.parseDate(current);
                    startDates.put(year, calendar);
                } else {
                    year = Integer.valueOf(current.substring(0, 4));
                    calendar = DateTools.parseDate(current);
                    endDates.put(year, calendar);
                }
            }
        }
    }

    /**
     * Returns true if 'date' is during Daylight Savings Time.
     * @param date
     *   The date to check.
     * @return
     *   True if DST is in effect on this date.
     */
    public static boolean isDST(Calendar date) {
        // Create hash maps to contain the start and end dates for DST in each year.
        HashMap<Integer, Calendar> dstStartDates = new HashMap<Integer, Calendar>();
        HashMap<Integer, Calendar> dstEndDates = new HashMap<Integer, Calendar>();
        // Populate them.
        DST.getDSTDates(dstStartDates, dstEndDates);
        int year = date.get(Calendar.YEAR);

        if (date.after(dstStartDates.get(year)) && date.before(dstEndDates.get(year))
                || date.equals(dstStartDates.get(year)))
            return true;
        else
            return false;
    }

}
