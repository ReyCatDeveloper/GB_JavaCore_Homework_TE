package lesson6_7.accuWeatherJsonClasses;

import com.fasterxml.jackson.annotation.*;

import java.awt.*;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class BodyResponse {
    private List dailyForecasts;
    @JsonCreator
    public  BodyResponse(List dailyForecasts){
        this.dailyForecasts = dailyForecasts;
    }

//@JsonGetter("DailyForecasts")
    public List getDailyForecasts() {
        return dailyForecasts;
    }
//@JsonSetter("DailyForecasts")
    public void setDailyForecasts(List dailyForecasts) {
        this.dailyForecasts = dailyForecasts;
    }

    @Override
    public String toString() {
        return dailyForecasts.toString();
    }
}
