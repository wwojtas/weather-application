package pl.weather.model.auxiliary;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class DateAndTimeUtilsTest {

    private final String timezone = "Europe/Warsaw";

    @Test
    void updateClockShouldReturnTimeWithPatternHHmm() {

        //given
        String localTimePattern = "HH:mm";
        String localTime = setLocalTime(timezone, localTimePattern);

        //when
        String localTimeActual = DateAndTimeUtils.updateClock(timezone);

        //then
        assertEquals(localTime, localTimeActual);
        assertThat(localTimeActual, equalTo(localTime));
    }

    private String setLocalTime(String timezone, String pattern){
        LocalTime localTime = LocalTime.now(ZoneId.of(timezone));
        return localTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    @Test
    void getDayTextContentShouldReturnDayDate(){

        //given
        int actualDate = 0;
        String actualDateTimePattern = "E dd.MM.yyyy";
        String localDateTime = setLocalDateTime(timezone, actualDate, actualDateTimePattern);

        //when
        String localDateTimeAfter = DateAndTimeUtils.getDayTextContent(timezone, actualDate);

        //then
        assertEquals(localDateTime, localDateTimeAfter);
        assertThat(localDateTimeAfter, equalTo(localDateTime));
    }

    @Test
    void getNextDayTextContentShouldReturnNextDay(){

        //given
        int nextDayDate = 1;
        String nextDayDateTimePattern = "E dd.MM";
        String localDateTime = setLocalDateTime(timezone, nextDayDate, nextDayDateTimePattern);

        //when
        String localDateTimeAfterNextDay = DateAndTimeUtils.getNextDayTextContent(timezone, nextDayDate);

        //then
        assertEquals(localDateTime, localDateTimeAfterNextDay);
        assertThat(localDateTimeAfterNextDay, equalTo(localDateTime));
    }

    private String setLocalDateTime(String timezone, int value, String pattern){
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of(timezone));
        return localDateTime.plusDays(value).format(DateTimeFormatter.ofPattern(pattern));
    }


}