package pl.weather.model.auxiliaryMethods;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeWork {

    public static String timeToString(LocalTime localTime, String pattern){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        if(localTime == null){
            return "";
        }
        return dateTimeFormatter.format(localTime);
    }

}
