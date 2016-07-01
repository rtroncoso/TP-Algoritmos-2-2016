package com.cst.util;

import java.util.Calendar;

/**
 * DateHelper class
 */
public class DateHelper {

    /**
     * Tests whether a date is on a weekend or not
     * @param cal
     * @return boolean
     */
    public static boolean isWeekend(Calendar cal) {
        if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
           cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            return true;
        }

        return false;
    }

}
