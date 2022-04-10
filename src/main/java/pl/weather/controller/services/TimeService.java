package pl.weather.controller.services;

import java.time.LocalTime;

import static pl.weather.model.auxiliaryMethods.TimeWork.timeToString;

public class TimeService {

    private LocalTime localTime = LocalTime.now();
    private String hours;
    private String minutes;

    protected void setHours(LocalTime localTime){
        timeToString(localTime, "HH");
    }

    protected void setMinutes(LocalTime localTime){
        timeToString(localTime, "mm");
    }

    public String getHours() {
        return hours;
    }

    public String getMinutes() {
        return minutes;
    }
}
