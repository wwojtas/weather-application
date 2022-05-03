package pl.weather.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "dt",
        "sunrise",
        "sunset",
        "moonrise",
        "moonset",
        "moon_phase",
        "temp",
        "feels_like",
        "pressure",
        "humidity",
        "dew_point",
        "wind_speed",
        "wind_deg",
        "wind_gust",
        "weather",
        "clouds",
        "pop",
        "rain",
        "uvi"
})
@Generated("jsonschema2pojo")
public class Daily {

    @JsonProperty("dt")
    private Double dt;
    @JsonProperty("sunrise")
    private Double sunrise;
    @JsonProperty("sunset")
    private Double sunset;
    @JsonProperty("moonrise")
    private Double moonrise;
    @JsonProperty("moonset")
    private Double moonset;
    @JsonProperty("moon_phase")
    private Double moonPhase;
    @JsonProperty("temp")
    private Temp temp;
    @JsonProperty("feels_like")
    private FeelsLike feelsLike;
    @JsonProperty("pressure")
    private Double pressure;
    @JsonProperty("humidity")
    private Double humidity;
    @JsonProperty("dew_point")
    private Double dewPoint;
    @JsonProperty("wind_speed")
    private Double windSpeed;
    @JsonProperty("wind_deg")
    private Double windDeg;
    @JsonProperty("wind_gust")
    private Double windGust;
    @JsonProperty("weather")
    private List<Weather__1> weather = null;
    @JsonProperty("clouds")
    private Double clouds;
    @JsonProperty("pop")
    private Double pop;
    @JsonProperty("rain")
    private Double rain;
    @JsonProperty("uvi")
    private Double uvi;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("dt")
    public Double getDt() {
        return dt;
    }

    @JsonProperty("dt")
    public void setDt(Double dt) {
        this.dt = dt;
    }

    @JsonProperty("sunrise")
    public Double getSunrise() {
        return sunrise;
    }

    @JsonProperty("sunrise")
    public void setSunrise(Double sunrise) {
        this.sunrise = sunrise;
    }

    @JsonProperty("sunset")
    public Double getSunset() {
        return sunset;
    }

    @JsonProperty("sunset")
    public void setSunset(Double sunset) {
        this.sunset = sunset;
    }

    @JsonProperty("moonrise")
    public Double getMoonrise() {
        return moonrise;
    }

    @JsonProperty("moonrise")
    public void setMoonrise(Double moonrise) {
        this.moonrise = moonrise;
    }

    @JsonProperty("moonset")
    public Double getMoonset() {
        return moonset;
    }

    @JsonProperty("moonset")
    public void setMoonset(Double moonset) {
        this.moonset = moonset;
    }

    @JsonProperty("moon_phase")
    public Double getMoonPhase() {
        return moonPhase;
    }

    @JsonProperty("moon_phase")
    public void setMoonPhase(Double moonPhase) {
        this.moonPhase = moonPhase;
    }

    @JsonProperty("temp")
    public Temp getTemp() {
        return temp;
    }

    @JsonProperty("temp")
    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    @JsonProperty("feels_like")
    public FeelsLike getFeelsLike() {
        return feelsLike;
    }

    @JsonProperty("feels_like")
    public void setFeelsLike(FeelsLike feelsLike) {
        this.feelsLike = feelsLike;
    }

    @JsonProperty("pressure")
    public Double getPressure() {
        return pressure;
    }

    @JsonProperty("pressure")
    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    @JsonProperty("humidity")
    public Double getHumidity() {
        return humidity;
    }

    @JsonProperty("humidity")
    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    @JsonProperty("dew_point")
    public Double getDewPoint() {
        return dewPoint;
    }

    @JsonProperty("dew_point")
    public void setDewPoint(Double dewPoint) {
        this.dewPoint = dewPoint;
    }

    @JsonProperty("wind_speed")
    public Double getWindSpeed() {
        return windSpeed;
    }

    @JsonProperty("wind_speed")
    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    @JsonProperty("wind_deg")
    public Double getWindDeg() {
        return windDeg;
    }

    @JsonProperty("wind_deg")
    public void setWindDeg(Double windDeg) {
        this.windDeg = windDeg;
    }

    @JsonProperty("wind_gust")
    public Double getWindGust() {
        return windGust;
    }

    @JsonProperty("wind_gust")
    public void setWindGust(Double windGust) {
        this.windGust = windGust;
    }

    @JsonProperty("weather")
    public List<Weather__1> getWeather() {
        return weather;
    }

    @JsonProperty("weather")
    public void setWeather(List<Weather__1> weather) {
        this.weather = weather;
    }

    @JsonProperty("clouds")
    public Double getClouds() {
        return clouds;
    }

    @JsonProperty("clouds")
    public void setClouds(Double clouds) {
        this.clouds = clouds;
    }

    @JsonProperty("pop")
    public Double getPop() {
        return pop;
    }

    @JsonProperty("pop")
    public void setPop(Double pop) {
        this.pop = pop;
    }

    @JsonProperty("rain")
    public Double getRain() {
        return rain;
    }

    @JsonProperty("rain")
    public void setRain(Double rain) {
        this.rain = rain;
    }

    @JsonProperty("uvi")
    public Double getUvi() {
        return uvi;
    }

    @JsonProperty("uvi")
    public void setUvi(Double uvi) {
        this.uvi = uvi;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}