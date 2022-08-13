package pl.weather.controller.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.weather.model.weather.WeatherForApp;

import java.net.MalformedURLException;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
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
                ()-> assertThat(currentTemperature, containsString("15")),
                ()-> assertThat(currentPressure, containsString("1012")),
                ()-> assertThat(currentHumidity, containsString("50")),
                ()-> assertThat(currentDayIconIdCode, equalTo("10d")),
                ()-> assertThat(nextDayIconIdCode.get(0), equalTo("04d")),
                ()-> assertThat(nightTemperatureNextDay.get(0), equalTo("20")),
                ()-> assertThat(dailyTemperatureNextDay.get(0), equalTo("30"))
        );
    }

    @Test
    void allWeatherForAppFieldsShouldBeEmpty() throws MalformedURLException {

        //given
        OpenWeatherAPIService openWeatherAPIService = mock(OpenWeatherAPIService.class);
        WeatherForApp weatherForAppForEmptyExample = mock(WeatherForApp.class);
        given(openWeatherAPIService.getWeatherForAppObject()).willReturn(weatherForAppForEmptyExample);

        //when
        String timezone = weatherForAppForEmptyExample.getTimezone();
        String currentTemperature = weatherForAppForEmptyExample.getCurrentTemperature();
        String currentPressure = weatherForAppForEmptyExample.getCurrentPressure();
        String currentHumidity = weatherForAppForEmptyExample.getCurrentHumidity();
        String currentDayIconIdCode = weatherForAppForEmptyExample.getCurrentDayIconIdCode();
        ArrayList<String> nextDayIconIdCode = weatherForAppForEmptyExample.getNextDayIconIdCode();
        ArrayList<String> nightTemperatureNextDay = weatherForAppForEmptyExample.getNightTemperatureNextDay();
        ArrayList<String> dailyTemperatureNextDay = weatherForAppForEmptyExample.getDailyTemperatureNextDay();

        //then
        assertAll(
                ()-> assertNull(timezone),
                ()-> assertNull(currentTemperature),
                ()-> assertNull(currentPressure),
                ()-> assertNull(currentHumidity),
                ()-> assertNull(currentDayIconIdCode),
                ()-> assertThat(nextDayIconIdCode, empty()),
                ()-> assertThat(nightTemperatureNextDay, empty()),
                ()-> assertThat(dailyTemperatureNextDay, empty())
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