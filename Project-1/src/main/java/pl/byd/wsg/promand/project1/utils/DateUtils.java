package pl.byd.wsg.promand.project1.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final SimpleDateFormat HOUR_MINUTES_FORMAT = new SimpleDateFormat("hh:mm");

    public static String hoursMinutesFormat(Date date) {
        return HOUR_MINUTES_FORMAT.format(date);
    }
}
