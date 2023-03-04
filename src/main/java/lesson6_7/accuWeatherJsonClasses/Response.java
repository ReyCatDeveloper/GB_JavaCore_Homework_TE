package lesson6_7.accuWeatherJsonClasses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Response {
    private Object headline;
    private Object dailyForecasts;
    private String dailyForecastsJsonForDeserialized;
    private DailyForecast[] deserializedDailyForecasts;

    @JsonCreator
    public  Response(@JsonProperty("Headline") Object headline, @JsonProperty("DailyForecasts") Object hailyForecasts) throws JsonProcessingException {
        //System.out.println("Конструктор Java-Response");
        this.headline = headline;
        this.dailyForecasts = hailyForecasts;
        ObjectMapper mapper = new ObjectMapper();
        this.dailyForecastsJsonForDeserialized = mapper.writeValueAsString(dailyForecasts);//dailyForecasts.toString();
        //System.out.println(dailyForecastsJsonForDeserialized);
        this.deserializedDailyForecasts              = mapper.readValue(dailyForecastsJsonForDeserialized,     DailyForecast[].class);

 //       DailyForecast[] testJsonToArrayDailyForecast = mapper.readValue(string_json_forecastJSON_dailyForecast,DailyForecast[].class);

    }

@JsonGetter("Headline")
    public Object getHeadline() {
        return headline;
    }
@JsonSetter("Headline")
    public void setHeadline(String headline) {
        this.headline = headline;
    }
@JsonGetter("DailyForecasts")
    public Object getDailyForecasts() {
        return dailyForecasts;
    }
@JsonSetter("DailyForecasts")
    public void setDailyForecasts(Object hailyForecasts) {
        this.dailyForecasts = hailyForecasts;
    }

    public void showDailyForecasts(){
        System.out.println("Прогноз погоды на 5 дней:");
        for(int i = 0; i < deserializedDailyForecasts.length; i++){
            System.out.println(deserializedDailyForecasts[i]);
        }
        System.out.println();
    }

    public DailyForecast[] getDeserializedDailyForecasts(){
        return deserializedDailyForecasts;
    }
}
