package wnbook.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeHelper {
    public static Date stringToDate(String time, String pattern){
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try{
            return format.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String getDate(String pattern){
        SimpleDateFormat format =new SimpleDateFormat(pattern);
        Date date =new Date();
        return format.format(date);
    }
}
