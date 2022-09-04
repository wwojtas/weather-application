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
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

class OpenWeatherAPIServiceSecondTest {

    OpenWeatherAPIService openWeatherAPIService;
    private final ConnectionToWeatherData connectionToWeatherData = Mockito.mock(ConnectionToWeatherData.class);

    @BeforeEach
    void setInitialOpenWeatherAPIServiceData() {
        openWeatherAPIService = new OpenWeatherAPIService("51.2506", "22.5701", connectionToWeatherData);
    }

    @Test
    void shouldReturnWeatherData() throws IOException {

        //given
        given(connectionToWeatherData.getResponseFromQueryToAPI(anyString())).willReturn(prepareWeatherTestData());

        //when
        WeatherForApp weatherForAppTest = openWeatherAPIService.getWeatherData();
        String timezone = openWeatherAPIService.getWeatherData().getTimezone();
        String currentTemperature = openWeatherAPIService.getWeatherData().getCurrentTemperature();
        String currentPressure = openWeatherAPIService.getWeatherData().getCurrentPressure();
        String currentHumidity = openWeatherAPIService.getWeatherData().getCurrentHumidity();
        String currentDayIconIdCode = openWeatherAPIService.getWeatherData().getCurrentDayIconIdCode();
        String nextDayIconIdCode = openWeatherAPIService.getWeatherData().getNextDayIconIdCode().get(0);
        String nightTemperatureNextDay = openWeatherAPIService.getWeatherData().getNightTemperatureNextDay().get(0);
        String dailyTemperatureNextDay = openWeatherAPIService.getWeatherData().getDailyTemperatureNextDay().get(0);

        //then
        assertAll(
                () -> assertEquals("Europe/Warsaw", weatherForAppTest.getTimezone()),
                () -> assertEquals("Europe/Warsaw", timezone),
                () -> assertThat(timezone, equalTo("Europe/Warsaw")),
                () -> assertEquals("20", currentTemperature),
                () -> assertThat(currentTemperature, containsString("20")),
                () -> assertEquals("1019", currentPressure),
                () -> assertThat(currentPressure, equalTo("1019")),
                () -> assertEquals("51", currentHumidity),
                () -> assertEquals("01d", currentDayIconIdCode),
                () -> assertEquals("02d", nextDayIconIdCode),
                () -> assertEquals("9", nightTemperatureNextDay),
                () -> assertEquals("19", dailyTemperatureNextDay)
        );
    }


    private String prepareWeatherTestData() throws IOException {
        return new String(Files.readAllBytes(Path.of("src/test/resources/openWeatherTestData.json")));
    }
}