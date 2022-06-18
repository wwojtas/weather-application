package pl.weather.model.weather;

import java.util.ArrayList;

public class WeatherForApp {

    private final String timezone;
    private final String currentTemperature;
    private final String currentPressure;
    private final String currentHumidity;
    private final String currentDayIconIdCode;
    private final ArrayList<String> nextDayIconIdCode;
    private final ArrayList<String> nightTemperatureNextDay;
    private final ArrayList<String> dailyTemperatureNextDay;

    public WeatherForApp(String timezone, String currentTemperature, String currentPressure, String currentHumidity, String currentDayIconIdCode, ArrayList<String> nextDayIconIdCode, ArrayList<String> nightTemperatureNextDay, ArrayList<String> dailyTemperatureNextDay) {
        this.timezone = timezone;
        this.currentTemperature = currentTemperature;
        this.currentPressure = currentPressure;
        this.currentHumidity = currentHumidity;
        this.currentDayIconIdCode = currentDayIconIdCode;
        this.nextDayIconIdCode = nextDayIconIdCode;
        this.nightTemperatureNextDay = nightTemperatureNextDay;
        this.dailyTemperatureNextDay = dailyTemperatureNextDay;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getCurrentTemperature() {
        return currentTemperature;
    }

    public String getCurrentPressure() {
        return currentPressure;
    }

    public String getCurrentHumidity() {
        return currentHumidity;
    }

    public String getCurrentDayIconIdCode() {
        return currentDayIconIdCode;
    }

    public ArrayList<String> getNextDayIconIdCode() {
        return nextDayIconIdCode;
    }

    public ArrayList<String> getNightTemperatureNextDay() {
        return nightTemperatureNextDay;
    }

    public ArrayList<String> getDailyTemperatureNextDay() {
        return dailyTemperatureNextDay;
    }
}
