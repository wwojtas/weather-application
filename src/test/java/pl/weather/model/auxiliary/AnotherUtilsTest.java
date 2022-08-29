package pl.weather.model.auxiliary;

import org.junit.jupiter.api.Test;
import pl.weather.model.config.ConfigMainSettings;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

class AnotherUtilsTest {

    @Test
    void shouldReturnAddedTemperatureUnit() {

        // given
        //when
        String actualTempUnitFromApp = ConfigMainSettings.TEMPERATURE_UNIT;
        String expectedTempUnit = " \u00B0C";

        //then
        assertEquals(expectedTempUnit, actualTempUnitFromApp); // org.junit
        assertThat(actualTempUnitFromApp, equalTo(expectedTempUnit)); // org.hamcrest
    }

    @Test
    void addedTemperatureUnitIsNotTheSameLikeExpectedTempUnit() {

        // given
        //when
        String notCorrectTempUnit = "is not good temperature Unit";
        String expectedTempUnit = " \u00B0C";

        //then
        assertNotSame(notCorrectTempUnit, expectedTempUnit);
    }

    @Test
    void shouldReturnAddedPressureUnit() {

        // given
        //when
        String actualPressureUnit = ConfigMainSettings.PRESSURE_UNIT;
        String expectedPressureUnit = " hPa";

        //then
        assertEquals(expectedPressureUnit, actualPressureUnit); // org.junit
        assertThat(actualPressureUnit, equalTo(expectedPressureUnit)); // org.hamcrest
    }

    @Test
    void addedPressureUnitIsNotTheSameLikeExpectedPressureUnit() {

        // given
        //when
        String notCorrectPressureUnit = "is not good pressure Unit";
        String expectedPressureUnit = " hPa";

        //then
        assertNotSame(notCorrectPressureUnit, expectedPressureUnit);
    }

    @Test
    void shouldReturnAddedHumidityUnit() {

        // given
        //when
        String actualHumidityUnit = ConfigMainSettings.HUMIDITY_UNIT;
        String expectedHumidityUnit = " %";

        //then
        assertEquals(expectedHumidityUnit, actualHumidityUnit); // org.junit
        assertThat(actualHumidityUnit, equalTo(expectedHumidityUnit)); // org.hamcrest
    }

    @Test
    void addedHumidityUnitIsNotTheSameLikeExpectedHumidityUnit() {

        // given
        //when
        String notCorrectHumidityUnit = "is not good humidity Unit";
        String expectedHumidityUnit = " %";

        //then
        assertNotSame(notCorrectHumidityUnit, expectedHumidityUnit);
    }


}