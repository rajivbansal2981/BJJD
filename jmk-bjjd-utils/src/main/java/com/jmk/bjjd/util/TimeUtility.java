package com.jmk.bjjd.util;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeUtility {
	/**
     * Determines current system time.
     * 
     * @return time as a <code>Calendar</code>
     */
    public static Calendar getSystemTime() {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        return calendar;
    }
    
    /**
    * Determines current system time.
    * 
    * @return time as a <code>Calendar</code>
    */
   public static Date getSystemDate() {
       Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
       return calendar.getTime();
   }

}
