package pl.weather.controller.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.weather.model.ConnectionToWeatherData;
import pl.weather.model.GeoIP;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

public class OpenWeatherGeocodingAPIServiceSecondTest {

    private OpenWeatherGeocodingAPIService underTest;
    private final ConnectionToWeatherData connectionToWeatherData = Mockito.mock(ConnectionToWeatherData.class);

    @BeforeEach
    void setInitialOpenWeatherGeocodingAPIServiceData() {
        underTest = new OpenWeatherGeocodingAPIService("Lublin", connectionToWeatherData);
    }
    @Test
    void shouldReturnGeoIPData() throws IOException {

        //given
        given(connectionToWeatherData.getResponseFromQueryToAPI(anyString())).willReturn(prepareLocationTestData());

        //when
        GeoIP result = underTest.getGeocodingFromOpenWeather();

        // then
        assertEquals("Lublin", result.getCity());
        assertEquals("PL", result.getCountry());
        assertEquals("51,25000000", result.getLatitude());
        assertEquals("22,57000000", result.getLongitude());
    }

    private String prepareLocationTestData() throws IOException {
        return new String(Files.readAllBytes(Path.of("src/test/resources/geoIPTestData.json")));
    }







}





