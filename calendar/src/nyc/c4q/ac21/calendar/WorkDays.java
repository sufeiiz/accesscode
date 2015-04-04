package nyc.c4q.ac21.calendar;

import java.io.BufferedOutputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

public class WorkDays {

    /**
     * Builds a map from day of week to whether this is a work day.
     * @return
     *   A map with keys 'Calendar.MONDAY' through 'Calendar.SUNDAY', indicating whether each is a work day.
     */
    public static HashMap<Integer, Boolean> getWorkDays() {
        HashMap <Integer, Boolean> workDays = new HashMap<Integer, Boolean>();
        workDays.put(Calendar.SUNDAY, false);
        workDays.put(Calendar.MONDAY, true);
        workDays.put(Calendar.TUESDAY, true);
        workDays.put(Calendar.WEDNESDAY, true);
        workDays.put(Calendar.THURSDAY, true);
        workDays.put(Calendar.FRIDAY, true);
        workDays.put(Calendar.SATURDAY, false);
        return workDays;
    }

}
