package pl.weather.model.auxiliaryMethods;

import javafx.application.Platform;
import javafx.scene.control.Label;
import pl.weather.model.config.ConfigMainSettings;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateAndTimeMethods {

    private static SimpleDateFormat setSimpleTimeFormat(){
        return new SimpleDateFormat(ConfigMainSettings.CURRENT_TIME_PATTERN);
    }

    public static void updateClockNow(Label label, boolean flag) {
        Thread thread = new Thread(() -> {
            while (!flag) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final String timeNow = setSimpleTimeFormat().format(new Date());
                Platform.runLater(() -> {
                    label.setText(timeNow);
                });
            }
        });
        thread.start();
    }

    private static LocalDate setLocalDate(){
        return LocalDate.now();
    }

    private static LocalDate setNextLocalDate(long value){
        return setLocalDate().plusDays(value);
    }

    private static DateTimeFormatter setDateFormat(){
        return DateTimeFormatter.ofPattern(ConfigMainSettings.CURRENT_DATE_PATTERN);
    }

    private static DateTimeFormatter setNextDateFormat(){
        return DateTimeFormatter.ofPattern(ConfigMainSettings.NEXT_DATE_PATTERN);
    }

    public static void setTextDayByLocalDate(Label label, long value) {
        String text = DateAndTimeMethods.setNextLocalDate(value).format(setDateFormat());
        label.setText(text);
    }

    public static void setTextNextDayByLocalDate(Label label, long value) {
        String text = DateAndTimeMethods.setNextLocalDate(value).format(setNextDateFormat());
        label.setText(text);
    }




}
