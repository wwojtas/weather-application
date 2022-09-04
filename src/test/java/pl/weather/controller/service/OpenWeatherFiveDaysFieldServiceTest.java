package pl.weather.controller.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.weather.model.ConnectionToWeatherData;
import pl.weather.model.weather.WeatherForApp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;


class OpenWeatherFiveDaysFieldServiceTest {

    int numberOfDay = 0;


    @Test
    void getDailyTemperatureNextDayShouldBeNotEmpty() throws IOException {

        //given
        OpenWeatherFiveDaysFieldService openWeatherFiveDaysFieldService = new OpenWeatherFiveDaysFieldService();
        ConnectionToWeatherData connectionToWeatherData = Mockito.mock(ConnectionToWeatherData.class);
        OpenWeatherAPIService openWeatherAPIService = new OpenWeatherAPIService("51.2506", "22.5701", connectionToWeatherData);
        given(connectionToWeatherData.getResponseFromQueryToAPI(anyString())).willReturn(prepareWeatherTestData());

        //when
        WeatherForApp weatherForAppTest = openWeatherAPIService.getWeatherData();
        String dailyTemperature = openWeatherFiveDaysFieldService.getDailyTemperatureNextDay(weatherForAppTest, numberOfDay);
        String nightTemperature = openWeatherFiveDaysFieldService.getNightTemperatureNextDay(weatherForAppTest, numberOfDay);


        //then

    }

    private String prepareWeatherTestData() throws IOException {
        return new String(Files.readAllBytes(Path.of("src/test/resources/openWeatherTestData.json")));
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