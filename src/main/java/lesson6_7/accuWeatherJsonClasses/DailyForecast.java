package lesson6_7.accuWeatherJsonClasses;

import com.fasterxml.jackson.annotation.*;
import lesson6_7.WeatherRequest;
import lesson6_7.accuWeatherJsonClasses.Temperature;

import static lesson6_7.WeatherRequest.getCurrentRequestCity;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyForecast {
    private String date;
    private AccuDate parsingDate;
    private Temperature temperature;
    private String forecastCity;// = getCurrentRequestCity();
    private DayWeather dayWeather;
    private NightWeather nightWeather;


    @JsonCreator
    public DailyForecast(@JsonProperty("Temperature") Temperature temperature, @JsonProperty("Date") String date, @JsonProperty("Day") DayWeather dayWeather, @JsonProperty("Night") NightWeather nightWeather){
        this.temperature = temperature;
        this.date = date;
        this.parsingDate = new AccuDate(this.date);
        this.dayWeather = dayWeather;
        this.nightWeather = nightWeather;
        this.forecastCity = getCurrentRequestCity();

    }
@JsonGetter("Temperature")
    public Temperature getTemperature() {
        return temperature;
    }
@JsonSetter("Temperature")
    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }


@JsonGetter("Date")
    public String getDate() {
        return date;
    }
@JsonSetter("Date")
    public void setDate(String date) {
        this.date = date;
    }


@JsonGetter("Day")
    public DayWeather getDayWeather() {
        return dayWeather;
    }
@JsonSetter("Day")
    public void setDayWeather(DayWeather dayWeather) {
        this.dayWeather = dayWeather;
    }
@JsonGetter("Night")
    public NightWeather getNightWeather() {
        return nightWeather;
    }
@JsonSetter("Night")
    public void setNightWeather(NightWeather nightWeather) {
        this.nightWeather = nightWeather;
    }

    public String getForecastCity() {
        return forecastCity;
    }

    public double getMaxTemperature(){
        return Double.parseDouble(temperature.getMaximum().getCelsius());
    }

    @Override
    public String toString() {
        return "В городе "+forecastCity+" на дату "+parsingDate.toString()+" ожидается днем: "+dayWeather.toString()+", ночью: "+nightWeather.toString()+", температура - "+temperature;
    }
}
