package pl.weather.model;

public class WeatherData {

    private String temperatureDay;
    private String temperatureNight;
    private String pressure;
    private String humidity;

    public WeatherData(String temperatureDay, String temperatureNight, String pressure, String humidity) {
        this.temperatureDay = temperatureDay;
        this.temperatureNight = temperatureNight;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public String getTemperatureDay() {
        return temperatureDay;
    }

    public String getTemperatureNight() {
        return temperatureNight;
    }

    public String getPressure() {
        return pressure;
    }

    public String getHumidity() {
        return humidity;
    }
}
