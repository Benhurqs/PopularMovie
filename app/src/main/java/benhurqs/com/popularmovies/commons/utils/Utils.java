package benhurqs.com.popularmovies.commons.utils;

import java.text.NumberFormat;

/**
 * Created by Benhur on 01/05/17.
 */

public class Utils {

    public static String formatNumber(long value){
        NumberFormat format = NumberFormat.getCurrencyInstance();
        return String.valueOf(format.format(value));
    }

    public static String convertTime(long runtime){
        String time = "";

        int hour = (int)(runtime/60);
        int min = (int)(runtime % 60);

        if(hour > 0){
            time = hour + "h";
        }

        if(min > 0){
            time = time + " " + min + "min";
        }

        return time;
    }

    public static String getYear(String date){
        //"2014-10-10"

        String year = "";
        String[] dateSplit = date.split("-");
        if(dateSplit != null && dateSplit.length > 0){
            year = dateSplit[0];
        }

        return year;
    }
}
