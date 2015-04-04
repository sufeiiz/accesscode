package nyc.c4q.ac21.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Zodiac {

    /**
     * Parses a month and date of the similar to "January 1".
     *
     * @param
     *   string The month and date to parse.
     * @return
     *   A 'Calendar' object with that month and date set.  The year may be any value.
     */
    @SuppressWarnings("deprecation")
    public static Calendar parseMonthAndDate(String string) {
        // We use an older API for parsing, which returns an old (deprecated) 'Date' object.
        SimpleDateFormat format = new SimpleDateFormat("MMMMM dd");
        Date parseDate;
        try {
            parseDate = format.parse(string);
        } catch (ParseException exception) {
            exception.printStackTrace();
            return null;
        }

        // Convert the 'Date' to 'Calendar'.
        Calendar date = Calendar.getInstance();
        date.set(1900, parseDate.getMonth(), parseDate.getDate(), 0, 0, 0);
        date.set(Calendar.MILLISECOND, 0);
        return date;
    }

    public static String getZodiacSign(Calendar date) {
        int year = date.get(Calendar.YEAR);

        // Load lines from the file with zodiac dates.
        ArrayList<String> lines = FileTools.readLinesFromFile("zodiac.csv");
        // Process them.
        for (String line : lines) {
            // Each line is of the form "sign,startDate,endDate".  Split it.
            int comma1 = line.indexOf(',');
            String sign = line.substring(0, comma1);
            int comma2 = line.indexOf(',', comma1 + 1);
            String start = line.substring(comma1 + 1, comma2);
            String end = line.substring(comma2 + 1);

            // Parse the start and end dates to dates.  Make sure to set
            // the year to this year, so that we can compare them to 'date'.
            Calendar startDate = parseMonthAndDate(start);
            startDate.set(Calendar.YEAR, year);
            Calendar endDate = parseMonthAndDate(end);
            endDate.set(Calendar.YEAR, year);
            // Tricky: one sign straddles January 1.  Adjust it either to
            // start in the previous year or end in the next year, depending
            // on if our 'date' is in January or not.
            if (endDate.compareTo(startDate) == -1) {
                if (date.get(Calendar.MONTH) == Calendar.JANUARY)
                    startDate.add(Calendar.YEAR, -1);
                else
                    endDate.add(Calendar.YEAR, 1);
            }

            // Now see if our date falls between the start and end for this sign.
            if (date.compareTo(startDate) != -1 && date.compareTo(endDate) != 1)
                return sign;
        }

        // No match.  :(
        return null;
    }

}
