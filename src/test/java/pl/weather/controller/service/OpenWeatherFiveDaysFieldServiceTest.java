package pl.weather.controller.service;

import org.junit.jupiter.api.Test;
import pl.weather.model.weather.WeatherForApp;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;


class OpenWeatherFiveDaysFieldServiceTest {

    private final int numberOfDay = 0;

    @Test
    void getDailyTemperatureNextDayShouldBeNotEmpty() {

        //given
        WeatherForApp weatherForApp = prepareNotEmptyWeatherDataForTestApp();

        OpenWeatherFiveDaysFieldService openWeatherFiveDaysFieldService = mock(OpenWeatherFiveDaysFieldService.class);
        given(openWeatherFiveDaysFieldService.getDailyTemperatureNextDay(weatherForApp, numberOfDay))
                .willReturn(weatherForApp.getDailyTemperatureNextDay().get(numberOfDay));

        //when
        String dailyTemperature = openWeatherFiveDaysFieldService.getDailyTemperatureNextDay(weatherForApp, numberOfDay);

        //then
        assertEquals(dailyTemperature, "30");
        assertThat(dailyTemperature, containsString("30"));
    }

    @Test
    void getDailyTemperatureNextDayShouldReturnEmptyString() {

        //given
        WeatherForApp weatherForAppForEmptyExample = mock(WeatherForApp.class);

        OpenWeatherFiveDaysFieldService openWeatherFiveDaysFieldService = mock(OpenWeatherFiveDaysFieldService.class);
        given(openWeatherFiveDaysFieldService.getDailyTemperatureNextDay(weatherForAppForEmptyExample, numberOfDay))
                .willReturn("");

        //when
        String dailyTemperature = openWeatherFiveDaysFieldService.getDailyTemperatureNextDay(weatherForAppForEmptyExample, numberOfDay);

        //then
        assertEquals(dailyTemperature, "");
        assertThat(dailyTemperature, containsString(""));
    }

    @Test
    void getNightTemperatureNextDayShouldBeNotEmpty() {

        //given
        WeatherForApp weatherForApp = prepareNotEmptyWeatherDataForTestApp();

        OpenWeatherFiveDaysFieldService openWeatherFiveDaysFieldService = mock(OpenWeatherFiveDaysFieldService.class);
        given(openWeatherFiveDaysFieldService.getNightTemperatureNextDay(weatherForApp, numberOfDay))
                .willReturn(weatherForApp.getNightTemperatureNextDay().get(numberOfDay));

        //when
        String nightTemperature = openWeatherFiveDaysFieldService.getNightTemperatureNextDay(weatherForApp, numberOfDay);

        //then
        assertEquals(nightTemperature, "20");
        assertThat(nightTemperature, containsString("20"));
    }

    @Test
    void getNightTemperatureNextDayShouldBeEmpty() {

        //given
        WeatherForApp weatherForAppForEmptyExample = mock(WeatherForApp.class);

        OpenWeatherFiveDaysFieldService openWeatherFiveDaysFieldService = mock(OpenWeatherFiveDaysFieldService.class);
        given(openWeatherFiveDaysFieldService.getNightTemperatureNextDay(weatherForAppForEmptyExample, numberOfDay))
                .willReturn("");

        //when
        String nightTemperature = openWeatherFiveDaysFieldService.getNightTemperatureNextDay(weatherForAppForEmptyExample, numberOfDay);

        //then
        assertEquals(nightTemperature, "");
        assertThat(nightTemperature, containsString(""));
    }

    private WeatherForApp prepareNotEmptyWeatherDataForTestApp() {

        ArrayList<String> nextDayIconIdCode = new ArrayList<>();
        nextDayIconIdCode.add("04d");
        ArrayList<String> nightTemperatureNextDay = new ArrayList<>();
        nightTemperatureNextDay.add("20");
        ArrayList<String> dailyTemperatureNextDay = new ArrayList<>();
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