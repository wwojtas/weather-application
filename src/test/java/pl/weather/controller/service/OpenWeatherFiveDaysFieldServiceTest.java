package pl.weather.controller.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.weather.model.ConnectionToWeatherData;
import pl.weather.model.weather.WeatherForApp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;


class OpenWeatherFiveDaysFieldServiceTest {

    int numberOfDay = 0;

    OpenWeatherAPIService openWeatherAPIService;
    ConnectionToWeatherData connectionToWeatherData = Mockito.mock(ConnectionToWeatherData.class);

    OpenWeatherFiveDaysFieldService openWeatherFiveDaysFieldService;
    @BeforeEach
    void setOpenWeatherFiveDaysFieldService(){
        openWeatherFiveDaysFieldService = new OpenWeatherFiveDaysFieldService();
    }

    @BeforeEach
    void setInitialOpenWeatherAPIServiceData() {
        openWeatherAPIService = new OpenWeatherAPIService("51.2506", "22.5701", connectionToWeatherData);
    }

    @Test
    void getDailyTemperatureNextDayShouldBeNotEmpty() throws IOException {

        //given
        given(connectionToWeatherData.getResponseFromQueryToAPI(anyString())).willReturn(prepareWeatherTestData());

        //when
        WeatherForApp weatherForAppTest = openWeatherAPIService.getWeatherData();
        String dailyTemperature = openWeatherFiveDaysFieldService.getDailyTemperatureNextDay(weatherForAppTest, numberOfDay);
        String nightTemperature = openWeatherFiveDaysFieldService.getNightTemperatureNextDay(weatherForAppTest, numberOfDay);

        //then
        assertThat(dailyTemperature, equalTo("19"));
        assertThat(nightTemperature, containsString("9"));

    }

    private String prepareWeatherTestData() throws IOException {
        return new String(Files.readAllBytes(Path.of("src/test/resources/openWeatherTestData.json")));
    }


}