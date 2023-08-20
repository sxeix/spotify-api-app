package com.sxeix.genrecalculator.util;

import java.util.Date;

/**
 * Date time url
 */
public class DateTimeUtil {

    /**
     * Conver date to seconds
     *
     * @param date the date
     * @return date in seconds
     */
    public static long dateToSeconds(Date date) {
        return date.getTime() / 1000;
    }

}
