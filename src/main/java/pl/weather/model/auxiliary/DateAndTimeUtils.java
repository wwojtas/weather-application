package pl.weather.model.auxiliary;

import pl.weather.model.config.ConfigMainSettings;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateAndTimeUtils {


    public static String updateClock(String timezone) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(ConfigMainSettings.CURRENT_TIME_PATTERN);
        LocalTime localTime = LocalTime.now(ZoneId.of(timezone));
        return localTime.format(dtf);
    }

    private static DateTimeFormatter setDateFormat() {
        return DateTimeFormatter.ofPattern(ConfigMainSettings.CURRENT_DATE_PATTERN);
    }

    private static DateTimeFormatter setNextDateFormat() {
        return DateTimeFormatter.ofPattern(ConfigMainSettings.NEXT_DATE_PATTERN);
    }

    public static String getDayTextContent(String timezone, long value) {
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of(timezone));
        return localDateTime.plusDays(value).format(setDateFormat());
    }

    public static String getNextDayTextContent(String timezone, long value) {
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of(timezone));
        return localDateTime.plusDays(value).format(setNextDateFormat());
    }


}
