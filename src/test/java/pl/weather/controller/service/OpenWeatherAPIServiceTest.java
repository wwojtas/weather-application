package pl.weather.controller.service;

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

    @Test
    void dataWeatherStubShouldReturnDailyTemperature() throws MalformedURLException {

        //given
        OpenWeatherDataRepository openWeatherAPIServiceStub = new OpenWeatherAPIServiceStub();

        //when
        ArrayList<String> dailyTemperature = openWeatherAPIServiceStub.getWeatherData().getDailyTemperatureNextDay();
        String dailyTemperatureString = dailyTemperature.get(0);

        //then
        assertThat(dailyTemperature, hasSize(1));
        assertThat(dailyTemperature, is(not(empty())));
        assertThat(dailyTemperature, contains("30"));
        assertThat(dailyTemperatureString, equalTo("30"));
        assertEquals(dailyTemperatureString, "30");
    }

    @Test
    void referenceToTheSameObjectShouldBeEqual(){

        //given
        WeatherForApp weatherForApp = prepareNotEmptyWeatherDataForTestApp();

        //when
        WeatherForApp weatherForAppTestSecond = weatherForApp;

        //then
        assertSame(weatherForApp, weatherForAppTestSecond);
    }

    @Test
    void referenceToTheDifferentObjectShouldBeNotSame() {

        //given
        WeatherForApp weatherForApp = prepareNotEmptyWeatherDataForTestApp();

        //when
        WeatherForApp weatherForAppSecond = prepareNotEmptyWeatherDataForTestApp();

        //then
        assertNotSame(weatherForApp, weatherForAppSecond);
    }

    @Test
    void getWeatherDataMethodShouldReturnTheSameTimezone() throws MalformedURLException {

        //given
        OpenWeatherAPIService openWeatherAPIService = mock(OpenWeatherAPIService.class);
        given(openWeatherAPIService.getWeatherData()).willReturn(prepareNotEmptyWeatherDataForTestApp());

        //when
        String timezoneFromMock = openWeatherAPIService.getWeatherData().getTimezone();

        //then
        assertThat(timezoneFromMock, equalTo("Europe/Warsaw"));
    }

    @Test
    void allWeatherDataShouldBeNotEmpty() throws MalformedURLException {

        //given
        OpenWeatherAPIService openWeatherAPIService = mock(OpenWeatherAPIService.class);
        given(openWeatherAPIService.getWeatherData()).willReturn(prepareNotEmptyWeatherDataForTestApp());

        //when
        String timezone = openWeatherAPIService.getWeatherData().getTimezone();
        String currentTemperature = openWeatherAPIService.getWeatherData().getCurrentTemperature();
        String currentPressure = openWeatherAPIService.getWeatherData().getCurrentPressure();
        String currentHumidity = openWeatherAPIService.getWeatherData().getCurrentHumidity();
        String currentDayIconIdCode = openWeatherAPIService.getWeatherData().getCurrentDayIconIdCode();
        ArrayList<String> nextDayIconIdCode = openWeatherAPIService.getWeatherData().getNextDayIconIdCode();
        ArrayList<String> nightTemperatureNextDay = openWeatherAPIService.getWeatherData().getNightTemperatureNextDay();
        ArrayList<String> dailyTemperatureNextDay = openWeatherAPIService.getWeatherData().getDailyTemperatureNextDay();

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
    void allWeatherDataShouldBeEmpty() throws MalformedURLException {

        //given
        OpenWeatherAPIService openWeatherAPIService = mock(OpenWeatherAPIService.class);
        WeatherForApp weatherForAppForEmptyExample = mock(WeatherForApp.class);
        given(openWeatherAPIService.getWeatherData()).willReturn(weatherForAppForEmptyExample);

        //when
        String timezone = openWeatherAPIService.getWeatherData().getTimezone();
        String currentTemperature = openWeatherAPIService.getWeatherData().getCurrentTemperature();
        String currentPressure = openWeatherAPIService.getWeatherData().getCurrentPressure();
        String currentHumidity = openWeatherAPIService.getWeatherData().getCurrentHumidity();
        String currentDayIconIdCode = openWeatherAPIService.getWeatherData().getCurrentDayIconIdCode();
        ArrayList<String> nextDayIconIdCode = openWeatherAPIService.getWeatherData().getNextDayIconIdCode();
        ArrayList<String> nightTemperatureNextDay = openWeatherAPIService.getWeatherData().getNightTemperatureNextDay();
        ArrayList<String> dailyTemperatureNextDay = openWeatherAPIService.getWeatherData().getDailyTemperatureNextDay();

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

    private WeatherForApp prepareNotEmptyWeatherDataForTestApp(){

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