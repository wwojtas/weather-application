package pl.weather.controller.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.weather.model.GeoIP;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class OpenWeatherGeocodingAPIServiceTest {

    private GeoIP geoIP;

    @BeforeEach
    void initializeGeoIPObject(){
        geoIP = prepareGeoIPObject();
    }


    @Test
    void referenceToTheSameObjectShouldBeEqual() {

        //given
        //when
        GeoIP geoIPSecond = geoIP;

        //then
        assertSame(geoIP, geoIPSecond);
    }

    @Test
    void referenceToTheDifferentObjectShouldBeNotSame(){

        //given
        //when
        GeoIP geoIPSecond = prepareGeoIPObject();

        //then
        assertNotSame(geoIP, geoIPSecond);
    }

    @Test
    void allGeoIPFieldsShouldBeNotEmpty() throws MalformedURLException {

        //given
        OpenWeatherGeocodingAPIService openWeatherGeocodingAPIService = mock(OpenWeatherGeocodingAPIService.class);
        given(openWeatherGeocodingAPIService.getGeocodingFromOpenWeather()).willReturn(geoIP);

        //when
        String city = geoIP.getCity();
        String country = geoIP.getCountry();
        String latitude = geoIP.getLatitude();
        String longitude = geoIP.getLongitude();

        //then
        assertAll(
                () -> assertThat(city, containsString("Warsaw")),
                () -> assertThat(country, containsString("Poland")),
                () -> assertThat(latitude, containsString("52.237049")),
                () -> assertThat(longitude, containsString("21.017532"))
        );
    }

    @Test
    void allGeoIPFieldsShouldBeNull() throws MalformedURLException {

        //given
        OpenWeatherGeocodingAPIService openWeatherGeocodingAPIService = mock(OpenWeatherGeocodingAPIService.class);
        GeoIP geoIPForEmptyExample = mock(GeoIP.class);
        given(openWeatherGeocodingAPIService.getGeocodingFromOpenWeather()).willReturn(geoIPForEmptyExample);

        //when
        List<String> geoIP = new ArrayList<>();
        geoIP.add(geoIPForEmptyExample.getCity());
        geoIP.add(geoIPForEmptyExample.getCountry());
        geoIP.add(geoIPForEmptyExample.getLatitude());
        geoIP.add(geoIPForEmptyExample.getLongitude());

        //then
        assertAll(
                () -> assertNull(geoIP.get(0)),
                () -> assertNull(geoIP.get(1)),
                () -> assertNull(geoIP.get(2)),
                () -> assertNull(geoIP.get(3))
        );
    }

    private GeoIP prepareGeoIPObject() {
        return new GeoIP("Warsaw", "Poland", "52.237049", "21.017532");
    }

}