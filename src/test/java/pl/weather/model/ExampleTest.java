package pl.weather.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.weather.controller.service.OpenWeatherGeocodingAPIService;

import java.net.MalformedURLException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

public class ExampleTest {

    private OpenWeatherGeocodingAPIService underTest;
    private final ConnectionToOpenWeather connectionToOpenWeather = Mockito.mock(ConnectionToOpenWeather.class);

    @BeforeEach
    void setUp() {
        underTest = new OpenWeatherGeocodingAPIService("Krakow", connectionToOpenWeather);
    }

    @Test
    void shouldGetGeoIP() throws MalformedURLException {
        //given
        given(connectionToOpenWeather.getResponseFromQueryToAPI(anyString()))
                .willReturn(
                        "[\n" +
                                "  {\n" +
                                "    \"name\": \"test\",\n" +
                                "    \"lat\": 111,\n" +
                                "    \"lon\": 222,\n" +
                                "    \"country\": \"Poland\",\n" +
                                "    \"state\": \"Małopolskie\",\n" +
                                "    \"local_names\" : {\n" +
                                "    \"pl\": \"local name\"\n" +
                                "    }\n" +
                                "  }\n" +
                                "]"
                );
        //when
        GeoIP result = underTest.getGeocodingFromOpenWeather();

        // then
//        assertEquals("local name", result.getCity());
//        assertEquals("Poland", result.getCountry());
        // more assertions
    }
}



