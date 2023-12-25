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

        if (twelveHoursDisplay) { // If user has called set23HoursClock method, then...
            if (clockBase.get(Calendar.HOUR_OF_DAY) < 12) { // Compares if the actual hour, in 24 hours format, is greater than 12. If so, then it's PM and adds PM to the String
                return String.format("%d:%02d:%02d %s\n%s\n",clockBase.get(Calendar.AM_PM),clockBase.get(Calendar.MINUTE),clockBase.get(Calendar.SECOND), "AM", clockBase.getTimeZone().getID());
            } else { // If the actual hour of the day is lesss than 12, then it's before noon, so it's AM.
                return String.format("%d:%02d:%02d %s\n%s\n",clockBase.get(Calendar.AM_PM),clockBase.get(Calendar.MINUTE),clockBase.get(Calendar.SECOND), "PM", clockBase.getTimeZone().getID());
            }
        }
        // Default return in 24 hours format.
        return String.format("%d:%02d:%02d\n%s\n",clockBase.get(Calendar.HOUR_OF_DAY),clockBase.get(Calendar.MINUTE),clockBase.get(Calendar.SECOND), clockBase.getTimeZone().getID());
    }
}
