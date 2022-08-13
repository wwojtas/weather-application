package pl.weather.controller.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.weather.model.weather.WeatherForApp;

import java.net.MalformedURLException;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class OpenWeatherAPIServiceTest {

    private WeatherForApp weatherForApp;
    @BeforeEach
    void initializeWeatherForAppObject(){
        weatherForApp = prepareMockDataWeatherForTestApp();
    }

    @Test
    void referenceToTheSameObjectShouldBeEqual(){

        //given
        //when
        WeatherForApp weatherForAppTestSecond = weatherForApp;

        //then
        assertSame(weatherForApp, weatherForAppTestSecond);
    }

    @Test
    void referenceToTheDifferentObjectShouldBeNotSame() {

        //given
        //when
        WeatherForApp weatherForAppTestSecond = prepareMockDataWeatherForTestApp();

        //then
        assertNotSame(weatherForApp, weatherForAppTestSecond);
    }

    @Test
    void getWeatherForAppObjectMethodShouldReturnTheSameTimezone() throws MalformedURLException {

        //given
        OpenWeatherAPIService openWeatherAPIService = mock(OpenWeatherAPIService.class);
        given(openWeatherAPIService.getWeatherForAppObject()).willReturn(weatherForApp);

        //when
        String timezoneForTestApp = weatherForApp.getTimezone();

        //then
        assertThat(timezoneForTestApp, equalTo("Europe/Warsaw"));
    }

    @Test
    void allWeatherForAppFieldsShouldBeNotEmpty() throws MalformedURLException {

        //given
        OpenWeatherAPIService openWeatherAPIService = mock(OpenWeatherAPIService.class);
        given(openWeatherAPIService.getWeatherForAppObject()).willReturn(weatherForApp);

        //when
        String timezone = weatherForApp.getTimezone();
        String currentTemperature = weatherForApp.getCurrentTemperature();
        String currentPressure = weatherForApp.getCurrentPressure();
        String currentHumidity = weatherForApp.getCurrentHumidity();
        String currentDayIconIdCode = weatherForApp.getCurrentDayIconIdCode();
        ArrayList<String> nextDayIconIdCode = weatherForApp.getNextDayIconIdCode();
        ArrayList<String> nightTemperatureNextDay = weatherForApp.getNightTemperatureNextDay();
        ArrayList<String> dailyTemperatureNextDay = weatherForApp.getDailyTemperatureNextDay();

        //then
        assertAll(
                ()-> assertThat(timezone, equalTo("Europe/Warsaw")),
                ()-> assertThat(currentTemperature, equalTo("15")),
                ()-> assertThat(currentPressure, equalTo("1012")),
                ()-> assertThat(currentHumidity, equalTo("50")),
                ()-> assertThat(currentDayIconIdCode, equalTo("10d")),
                ()-> assertThat(nextDayIconIdCode.get(0), equalTo("04d")),
                ()-> assertThat(nightTemperatureNextDay.get(0), equalTo("20")),
                ()-> assertThat(dailyTemperatureNextDay.get(0), equalTo("30"))
        );
    }

    private WeatherForApp prepareMockDataWeatherForTestApp(){
        ArrayList<String> nextDayIconIdCode = new ArrayList<String>();
        nextDayIconIdCode.add("04d");
        ArrayList<String> nightTemperatureNextDay = new ArrayList<String>();
        nightTemperatureNextDay.add("20");
        ArrayList<String> dailyTemperatureNextDay = new ArrayList<String>();
        dailyTemperatureNextDay.add("30");
        return new WeatherForApp("Europe/Warsaw",
                "15",
                "1012",
                "50",
                "10d",
                nextDayIconIdCode,
                nightTemperatureNextDay,
                dailyTemperatureNextDay
                );
    }
}