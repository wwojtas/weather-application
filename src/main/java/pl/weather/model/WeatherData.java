package pl.weather.model;

public class WeatherData {

    private int temperatureDay;
    private int temperatureNight;
    private int pressure;
    private int humidity;

    public WeatherData(int temperatureDay, int temperatureNight, int pressure, int humidity) {
        this.temperatureDay = temperatureDay;
        this.temperatureNight = temperatureNight;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public int getTemperatureDay() {
        return temperatureDay;
    }

    public int getTemperatureNight() {
        return temperatureNight;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }
}
