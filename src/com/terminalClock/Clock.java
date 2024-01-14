package com.terminalClock;

import java.util.Calendar;

public class Clock {
    private Calendar clockBase;
    private boolean twelveHoursDisplay = false; // Flag used to control whether the user wants the clock in 12 or 24 hours format
    
    void set12HoursClock() { // setter method to set the 12 hours format
        twelveHoursDisplay = true;
    }
    
    String getTimeNow() {
        clockBase = Calendar.getInstance(); // Instance a Calendar object called clockBase.
        int minute = clockBase.get(Calendar.MINUTE);
        int second = clockBase.get(Calendar.SECOND);
        String timezoneID = clockBase.getTimeZone().getID();

        if (twelveHoursDisplay) { // If user has called set23HoursClock method, then...
            int hour = clockBase.get(Calendar.HOUR);

            if (clockBase.get(Calendar.AM_PM) < 12) { // Compares if the actual hour, in 24 hours format, is greater than 12. If so, then it's PM and adds PM to the String

                return String.format("%d:%02d:%02d %s\n%s\n", hour, minute, second, "AM", timezoneID);

            } else { // If the actual hour of the day is lesss than 12, then it's before noon, so it's AM.
                return String.format("%d:%02d:%02d %s\n%s\n", hour, minute, second, "PM", timezoneID);
            }
            
        }
        // Default return in 24 hours format.
        return String.format("%02d:%02d:%02d\n%s\n",clockBase.get(Calendar.HOUR_OF_DAY), minute, second, timezoneID);
    }
}
