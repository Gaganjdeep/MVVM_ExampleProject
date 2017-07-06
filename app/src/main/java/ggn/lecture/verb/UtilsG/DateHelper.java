package ggn.lecture.verb.UtilsG;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by G-Expo on 17 Apr 2017.
 */

// WishDropMVP


public class DateHelper
{
    //                                                                        2017-02-20 03:08:23",
    public static SimpleDateFormat serverDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static SimpleDateFormat onlyHoursFormat = new SimpleDateFormat("hh:mm a");

    public static SimpleDateFormat DOB     = new SimpleDateFormat("dd-MMM-yyyy");
    public static SimpleDateFormat COMMENT = new SimpleDateFormat("MMMM dd, hh:mm a");

    public static SimpleDateFormat CHAT = new SimpleDateFormat("MMMM dd, hh:mm a");

    private static DateHelper ourInstance = new DateHelper();

    public static DateHelper getInstance()
    {
        return ourInstance;
    }

    private DateHelper()
    {
    }

    public String getFormattedDateOfBirth(Date date)
    {
        return DOB.format(date);
    }

    public String getDateString(String date, SimpleDateFormat simeSimpleDateFormat)
    {
        try {
            Date date1 = serverDate.parse(date);
            return simeSimpleDateFormat.format(date1);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public String getCurrentDateString()
    {
        try {
            return serverDate.format(new Date(System.currentTimeMillis()));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public Date getFormattedDateOfBirthString(String dob)
    {
        try {
            return DOB.parse(dob);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date(System.currentTimeMillis());
    }

    public String getCurrentDateForChat()
    {
        try {
            return serverDate.format(new Date(System.currentTimeMillis()));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getDateForComment(String date)
    {
        try {
            return COMMENT.format(serverDate.parse(date));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getDateForNotification(String date)
    {
        try {
            return COMMENT.format(serverDate.parse(date));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getDateForChat(String date)
    {
        try {
            return CHAT.format(serverDate.parse(date));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
