package pl.weather.controller.services;

import javafx.application.Platform;
import javafx.scene.control.Label;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Klasa {

    public Klasa() {
    }

    public static void updateClockNow(Label label, boolean flag) {
        Thread thread = new Thread(()->{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            while(!flag){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final String timeNow = simpleDateFormat.format(new Date());
                Platform.runLater(()->{
                    label.setText(timeNow);
                });
            }
        }); thread.start();
    }

}
