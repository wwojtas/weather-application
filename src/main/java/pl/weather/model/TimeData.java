package pl.weather.model;

import pl.weather.controller.services.TimeService;

public class TimeData {

    private TimeService timeService;
    private String currentTime;

    public TimeData(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    private void setCurrentTime(TimeService timeService) {
        this.currentTime = timeService.getHours() + ":" + timeService.getMinutes();
    }
}
