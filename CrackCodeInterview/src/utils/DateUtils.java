package utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils
{
    public static Date createDate(int year, int month, int date, int hourOfDay, int minute)
    {
        Calendar calendar  = Calendar.getInstance();
        calendar.set(year, month, date, hourOfDay, minute);
        return calendar.getTime();
    }
}
