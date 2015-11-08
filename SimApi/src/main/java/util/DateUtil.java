package util;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationFieldType;
import org.joda.time.MutableDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateUtil
{
    public static DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");

    public static void main(String[] args)
    {
        System.out.println(toGanttDate(1439371037000l));
    }

    public static String toGanttDate(long epoch)
    {
        DateTime time = new DateTime(epoch);
        return dtf.print(time);

    }

    public static String dateTimeToStringUTC(DateTime date)
    {
        String pattern = "yyyy-MM-dd HH:mm:ss.SSS";
        DateTimeFormatter format = DateTimeFormat.forPattern(pattern).withZoneUTC();
        return date.toString(format);

    }

    public static String dateTimeToStringLocal(DateTime date)
    {
        String pattern = "yyyy-MM-dd HH:mm:ss.SSS";
        DateTimeFormatter format = DateTimeFormat.forPattern(pattern).withZone(DateTimeZone.getDefault());
        return date.toString(format);

    }

    public static DateTime dbDateToDateTimeLocal(String date)
    {
        String pattern = "yyyy-MM-dd HH:mm:ss.SSS";
        return DateTime.parse(date, DateTimeFormat.forPattern(pattern));

    }

    public static DateTime dbDateToDateTimeUTC(String date)
    {
        String pattern = "yyyy-MM-dd HH:mm:ss.SSS";
        return DateTime.parse(date, DateTimeFormat.forPattern(pattern).withZoneUTC());

    }

    public static long dbDateLocalToEpoch(String date)
    {
        String pattern = "yyyy-MM-dd HH:mm:ss.SSS";
        return DateTime.parse(date, DateTimeFormat.forPattern(pattern).withZoneUTC()).getMillis();
    }

    public static long getCleanUnitStartTime(long time, DurationFieldType fieldType)
    {
        MutableDateTime active = new MutableDateTime(time);
        if(fieldType == DurationFieldType.months())
        {
            active.setDayOfMonth(0);
            active.setMillisOfDay(0);
        }
        else if(fieldType == DurationFieldType.weeks())
        {
            active.setDayOfWeek(0);
            active.setMillisOfDay(0);
        }
        else if(fieldType == DurationFieldType.days())
        {
            active.setMillisOfDay(0);
        }
        else if(fieldType == DurationFieldType.hours())
        {
            active.setMinuteOfHour(0);
            active.setSecondOfMinute(0);
            active.setMillisOfSecond(0);
        }
        return active.getMillis();
    }

    public static MutableDateTime getLocalFromParts(int year, int month, int day, int hour)
    {
        MutableDateTime date = new MutableDateTime(DateTimeZone.getDefault());
        date.setYear(year);
        date.setMonthOfYear(month);
        date.setDayOfMonth(day);
        date.setHourOfDay(hour);
        date.setMinuteOfHour(0);
        date.setSecondOfMinute(0);
        date.setMillisOfSecond(0);
        return date;
    }
}

