package pl.weather.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.weather.controller.service.OpenWeatherGeocodingAPIService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

public class ExampleTest {

    private OpenWeatherGeocodingAPIService underTest;
    private final ConnectionToWeatherData connectionToOpenWeather = Mockito.mock(ConnectionToWeatherData.class);

    @BeforeEach
    void setUp() {
        underTest = new OpenWeatherGeocodingAPIService("Lublin", connectionToOpenWeather);
    }
    @Test
    void shouldGetGeoIP() throws IOException {

        //given
        given(connectionToOpenWeather.getResponseFromQueryToAPI(anyString())).willReturn(prepareLocationTestData());

        //when
        GeoIP result = underTest.getGeocodingFromOpenWeather();

        // then
        assertEquals("Lublin", result.getCity());
        assertEquals("PL", result.getCountry());
        assertEquals("51,25000000", result.getLatitude());
        assertEquals("22,57000000", result.getLongitude());
    }

    private String prepareLocationTestData() throws IOException {
        return new String(Files.readAllBytes(Path.of("src/test/resources/localTestData.json")));
    }







}





