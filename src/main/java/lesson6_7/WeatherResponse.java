package lesson6_7;

import lesson6_7.accuWeatherJsonClasses.DailyForecast;

import java.io.IOException;

public class WeatherResponse {
    private String serializedJSON;

    private DailyForecast[] deserializedJSON;

    public WeatherResponse(String serializedJSON) throws IOException {
        this.serializedJSON = serializedJSON;

    }

    public void showForecast(){
        for(int i= 0; i < deserializedJSON.length; i++){
            System.out.println(deserializedJSON[i]);
        }
    }





//            System.out.println("перезапись json как массива");
//    lesson6_7.accuWeatherJsonClasses.DailyForecast[] testJsonToArrayDailyForecast = mapper.readValue(string_json_forecastJSON_dailyForecast, DailyForecast[].class);

    public String getSerializedJSON() {
        return serializedJSON;
    }

    public void setSerializedJSON(String serializedJSON) {
        this.serializedJSON = serializedJSON;
    }

}
