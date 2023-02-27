package lesson6_7.accuWeatherJsonClasses;

import com.fasterxml.jackson.annotation.*;

import java.util.Locale;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DayWeather {
    private String forecastPhrase;
@JsonCreator
    public DayWeather(@JsonProperty("ShortPhrase") String forecastPhrase){
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
