package pl.weather.controller.services;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateAndTimeMethods {


    public static void updateClockNow(Label label, boolean flag) {
        Thread thread = new Thread(() -> {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            while (!flag) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final String timeNow = simpleDateFormat.format(new Date());
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
        LocalDate localDate = LocalDate.now();
        return localDate.plusDays(value);
    }

    public static void setDayByLocalDate(Label label, long value) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String text = DateAndTimeMethods.setNextLocalDate(value).format(formatter);
        label.setText(text);
    }




}
