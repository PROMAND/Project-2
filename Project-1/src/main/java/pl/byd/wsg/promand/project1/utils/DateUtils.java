package pl.byd.wsg.promand.project1.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {

    private static final SimpleDateFormat HOUR_MINUTES_FORMAT = new SimpleDateFormat("hh:mm");
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yy");
    private static final SimpleDateFormat DATABASE_FORMAT = new SimpleDateFormat("dd.MM.yyyy / HH:mm:ss");

    public static String hoursMinutesFormat(Date date) {
        return HOUR_MINUTES_FORMAT.format(date);
    }

    public static String dateFormat(Date date) {
        return DATE_FORMAT.format(date);
    }

    public static Date createDate(int year, int month, int day, int hour, int minute) {
        return new GregorianCalendar(year, month - 1, day, hour, minute).getTime();
    }

    public static String convertToDatabaseFormat(Date date) {
        return DATABASE_FORMAT.format(date);
    }
    public static Date convertFromDatabaseFormat(String date) {
        try {
            return DATABASE_FORMAT.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
