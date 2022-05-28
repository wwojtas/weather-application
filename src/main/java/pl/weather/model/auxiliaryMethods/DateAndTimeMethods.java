package pl.weather.model.auxiliaryMethods;

import javafx.scene.control.Label;
import pl.weather.model.config.ConfigMainSettings;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateAndTimeMethods {

    public static void updateClock(Label label, String timezone) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(ConfigMainSettings.CURRENT_TIME_PATTERN);
        LocalTime localTime = LocalTime.now(ZoneId.of(timezone));
        label.setText(localTime.format(dtf));
    }

    private static DateTimeFormatter setDateFormat() {
        return DateTimeFormatter.ofPattern(ConfigMainSettings.CURRENT_DATE_PATTERN);
    }

    private static DateTimeFormatter setNextDateFormat() {
        return DateTimeFormatter.ofPattern(ConfigMainSettings.NEXT_DATE_PATTERN);
    }

    public static void setTextDay(Label label, String timezone, long value) {
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of(timezone));
        String text = localDateTime.plusDays(value).format(setDateFormat());
        label.setText(text);
    }

    public static void setTextNextDay(Label label, String timezone, long value) {
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of(timezone));
        String text = localDateTime.plusDays(value).format(setNextDateFormat());
        label.setText(text);
    }


}
