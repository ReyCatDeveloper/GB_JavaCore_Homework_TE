package lesson6_7.parseForecats;

import com.fasterxml.jackson.annotation.*;

import java.awt.*;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParseForecast {

    //private String dailyForecasts;
    //private List<String> START_ARRAY;
    private List dailyForecasts;

    private DailyForecast START_ARRAY;
    @JsonCreator
    public ParseForecast(//@JsonProperty("START_ARRAY") String dailyForecasts,
                         @JsonProperty("DailyForecasts")
                         List START_ARRAY){
        //this.dailyForecasts = dailyForecasts;
        this.dailyForecasts = START_ARRAY;

    }
/*
    @JsonGetter("DailyForecasts")
    public String getDailyForecasts() {
        return dailyForecasts;
    }
    @JsonSetter("DailyForecasts")
    public void setDailyForecasts(String dailyForecasts) {
        this.dailyForecasts = dailyForecasts;
    }
  */
    public void showDailyForecast(){
        System.out.println("вывод всего списка");
        System.out.println(dailyForecasts);
        System.out.println("вывод первой позиции1");
        System.out.println(dailyForecasts.get(0).toString());
        System.out.println("вывод первой позиции2");
        System.out.println(dailyForecasts.get(1));
        System.out.println("вывод первой позиции3");
        System.out.println(dailyForecasts.get(2));
        System.out.println();
//        System.out.println(dailyForecasts.get(0).getDate());
    }
/*
    @JsonGetter("DailyForecasts")
    public List getSTART_ARRAY() {
        return dailyForecasts;
    }
    @JsonSetter("DailyForecasts")
    public void setSTART_ARRAY(List START_ARRAY) {
        this.dailyForecasts = START_ARRAY;
    }
    */

}
