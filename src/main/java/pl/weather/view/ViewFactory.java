package pl.weather.view;

import pl.weather.WeatherManager;

public class ViewFactory {

    private WeatherManager weatherManager;

    public ViewFactory(WeatherManager weatherManager) {
        this.weatherManager = weatherManager;
    }

    public void showGeneralWindow(){
        System.out.println("show general window");
    }
}
