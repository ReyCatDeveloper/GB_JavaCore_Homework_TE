package lesson6_7.accuWeatherJsonClasses;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.Locale;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NightWeather {
    private String forecastPhrase;

    public NightWeather(@JsonProperty("ShortPhrase") String forecastPhrase){
        this.forecastPhrase = forecastPhrase;
    }

@JsonGetter("ShortPhrase")
    public String getForecastPhrase() {
        return forecastPhrase;
    }
@JsonSetter("ShortPhrase")
    public void setForecastPhrase(String forecastPhrase) {
        this.forecastPhrase = forecastPhrase;
    }

    @Override
    public String toString() {
        return forecastPhrase.toLowerCase();
    }
}
