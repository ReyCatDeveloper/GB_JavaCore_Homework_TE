package lesson6_7.accuWeatherJsonClasses;

import com.fasterxml.jackson.annotation.*;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyForecasts {
    private java.awt.List dailyForecasts;
    @JsonCreator
    public DailyForecasts(@JsonProperty("DailyForecasts")java.awt.List dailyForecasts){
        this.dailyForecasts = dailyForecasts;
    }
@JsonGetter("DailyForecasts")
    public java.awt.List getDailyForecasts() {
        return dailyForecasts;
    }
@JsonSetter("DailyForecasts")
    public void setDailyForecasts(java.awt.List dailyForecasts) {
        this.dailyForecasts = dailyForecasts;
    }
}
