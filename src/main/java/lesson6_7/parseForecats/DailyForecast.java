package lesson6_7.parseForecats;

import com.fasterxml.jackson.annotation.*;

import java.awt.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyForecast {
    private String date;
    private java.util.List<Temperature> temperature;
    @JsonCreator
    DailyForecast(@JsonProperty("Date")String date
            , @JsonProperty("Temperature")java.util.List<Temperature> temperature
                 ){
        this.date = date;
        this.temperature = temperature;
    }

    @JsonSetter("Date")
    public String getDate() {
        return date;
    }
    @JsonSetter("Date")
    public void setDate(String forecastForDay) {
        this.date = forecastForDay;
    }
    @JsonGetter("Temperature")
    public java.util.List<Temperature> getTemperature() {
        return temperature;
    }
    @JsonSetter("Temperature")
    public void setTemperature(java.util.List<Temperature> temperature) {
        this.temperature = temperature;
    }

/*    @Override
    public String toString() {
        return "date{" + date  +   '}';

    }
*/

}
