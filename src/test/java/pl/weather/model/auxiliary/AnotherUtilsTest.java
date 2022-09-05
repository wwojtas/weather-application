package pl.weather.model.auxiliary;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class AnotherUtilsTest {

    @Test
    void shouldReturnFirstLetterCapitalize() {

        // given
        String testWord = "word";

        //when
        String testWordAfterFunctionOperation = AnotherUtils.writeFirstLetterCapitalize(testWord);

        //then
        assertEquals("Word", testWordAfterFunctionOperation); // org.junit
        assertThat(testWordAfterFunctionOperation, equalTo("Word")); // org.hamcrest
    }

    @Test
    void addedTemperatureUnitIsTheSameLikeExpectedTempUnit() {

        // given
        //when
        String temperatureUnit = AnotherUtils.addTempUnit();

        //then
        assertSame(" \u00B0C", temperatureUnit);
        assertThat(temperatureUnit, equalTo(" \u00B0C"));
    }

    @Test
    void addedPressureUnitIsTheSameLikeExpectedPressureUnit() {

        // given
        //when
        String pressureUnit = AnotherUtils.addPressureUnit();

        //then
        assertSame(" hPa", pressureUnit);
        assertThat(pressureUnit, equalTo(" hPa"));
    }

    @Test
    void addedHumidityUnitIsTheSameLikeExpectedHumidityUnit() {

        // given
        //when
        String humidityUnit = AnotherUtils.addHumidityUnit();

        //then
        assertSame(" %", humidityUnit);
        assertThat(humidityUnit, equalTo(" %"));
    }



}