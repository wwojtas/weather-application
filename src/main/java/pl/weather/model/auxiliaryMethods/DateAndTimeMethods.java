package pl.weather.model.auxiliaryMethods;

import javafx.application.Platform;
import javafx.scene.control.Label;
import pl.weather.model.config.ConfigMainSettings;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateAndTimeMethods {

    public static void updateClockNow(Label label, String timezone) {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern(ConfigMainSettings.CURRENT_TIME_PATTERN);
                LocalTime localTime = LocalTime.now(ZoneId.of(timezone));
                final String timeNow = localTime.format(dtf);
                Platform.runLater(() -> {
                    label.setText(timeNow);
                });
            }
        });
        thread.start();
    }

    private static DateTimeFormatter setDateFormat(){
        return DateTimeFormatter.ofPattern(ConfigMainSettings.CURRENT_DATE_PATTERN);
    }

    private static DateTimeFormatter setNextDateFormat(){
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
