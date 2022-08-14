package pl.weather.controller.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.weather.model.weather.WeatherForApp;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;


class OpenWeatherFiveDaysFieldServiceTest {

    private WeatherForApp weatherForApp;
    private final int numberOfDay = 0;

    @BeforeEach
    void initializeWeatherForApp(){
        weatherForApp = prepareMockDataWeatherForTestApp();
    }

    @Test
    void getDailyTemperatureNextDayShouldBeNotEmpty() {

        //given
        OpenWeatherFiveDaysFieldService openWeatherFiveDaysFieldService = mock(OpenWeatherFiveDaysFieldService.class);
        given(openWeatherFiveDaysFieldService.getDailyTemperatureNextDay(weatherForApp, numberOfDay))
                .willReturn(weatherForApp.getDailyTemperatureNextDay().get(numberOfDay));

        //when
        String dailyTemperature = weatherForApp.getDailyTemperatureNextDay().get(numberOfDay);

        //then
        assertEquals(dailyTemperature, "30");
        assertThat(weatherForApp.getDailyTemperatureNextDay(), hasSize(1));
        assertThat(weatherForApp.getDailyTemperatureNextDay(), contains("30"));
        assertThat(weatherForApp.getDailyTemperatureNextDay(), hasItem("30"));
    }

    @Test
    void getDailyTemperatureNextDayShouldReturnEmptyString() {

        //given
        OpenWeatherFiveDaysFieldService openWeatherFiveDaysFieldService = mock(OpenWeatherFiveDaysFieldService.class);
        WeatherForApp weatherForAppExampleForTest = mock(WeatherForApp.class);
        System.out.println(weatherForAppExampleForTest.getNightTemperatureNextDay());

        given(openWeatherFiveDaysFieldService.getDailyTemperatureNextDay(weatherForAppExampleForTest, numberOfDay))
                .willReturn("");

        //when
        String dailyTemperature = weatherForAppExampleForTest.getDailyTemperatureNextDay().get(numberOfDay);

        //then
        assertEquals(dailyTemperature, "");
//        assertThat(weatherForApp.getDailyTemperatureNextDay(), hasSize(1));
//        assertThat(weatherForApp.getDailyTemperatureNextDay(), contains("30"));
//        assertThat(weatherForApp.getDailyTemperatureNextDay(), hasItem("30"));
    }

    @Test
    void getNightTemperatureNextDay() {

        //given
        OpenWeatherFiveDaysFieldService openWeatherFiveDaysFieldService = mock(OpenWeatherFiveDaysFieldService.class);
        given(openWeatherFiveDaysFieldService.getNightTemperatureNextDay(weatherForApp, numberOfDay))
                .willReturn(weatherForApp.getNightTemperatureNextDay().get(numberOfDay));
        //when
        String nightTemperature = weatherForApp.getNightTemperatureNextDay().get(numberOfDay);

        //then
        assertEquals(nightTemperature, "20");
    }

    private WeatherForApp prepareMockDataWeatherForTestApp() {

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