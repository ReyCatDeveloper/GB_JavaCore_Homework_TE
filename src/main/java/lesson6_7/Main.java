package lesson6_7;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lesson6_7.accuWeatherJsonClasses.BodyResponse;
import lesson6_7.accuWeatherJsonClasses.Response;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;

import static lesson6_7.Interface.continueAsk;
import static lesson6_7.WeatherRequest.buildUserRequest;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("|| ПОЛУЧИТЬ СВОДКУ ПОГОДЫ ||");
        OkHttpClient client = new OkHttpClient();

        while (true) {
            String requestURL = buildUserRequest();

            Request request = new Request.Builder()
                    //.url("http://dataservice.accuweather.com/forecasts/v1/daily/5day/222844?apikey=pp0fIcvt4V9GTyAqCEG1O6cJCX71LYcZ")
                    //        .url("http://dataservice.accuweather.com/forecasts/v1/daily/5day/222844?apikey=pp0fIcvt4V9GTyAqCEG1O6cJCX71LYcZ&language=ru-ru&details=true")
                    .url(requestURL)
                    .build();


            // //      Call call = client.newCall(request);
            // //      Response response = call.execute();
            ObjectMapper mapper = new ObjectMapper();

            String jsonResponse = client.newCall(request).execute().body().string();
            //(диагностика) вывод     jsonResponse
            //    System.out.println("jsonResponse: \n"+jsonResponse);
            Response responseJava = mapper.readValue(jsonResponse, Response.class);
            responseJava.showDailyForecasts();

            continueAsk();
        }

        //BodyResponse json = mapper.readValue(jsonResponse,BodyResponse.class);


//        System.out.println(response.body());
    //    System.out.println("вывод response.body().string() в консоль");
    //    assert response.body() != null;
    //    System.out.println(response.body().string());
//        System.out.println(response.headers());
    //    System.out.println("вывод response.message() в консоль");
    //    System.out.println(response.message());



//










     //   String forecastJSON_5days = "{\"Headline\":{\"EffectiveDate\":\"2023-02-26T07:00:00+06:00\",\"EffectiveEpochDate\":1677373200,\"Severity\":7,\"Text\":\"Cold Sunday\",\"Category\":\"cold\",\"EndDate\":\"2023-02-26T19:00:00+06:00\",\"EndEpochDate\":1677416400,\"MobileLink\":\"http://www.accuweather.com/en/kg/bishkek/222844/daily-weather-forecast/222844?lang=en-us\",\"Link\":\"http://www.accuweather.com/en/kg/bishkek/222844/daily-weather-forecast/222844?lang=en-us\"},\"DailyForecasts\":[{\"Date\":\"2023-02-26T07:00:00+06:00\",\"EpochDate\":1677373200,\"Temperature\":{\"Minimum\":{\"Value\":24.0,\"Unit\":\"F\",\"UnitType\":18},\"Maximum\":{\"Value\":36.0,\"Unit\":\"F\",\"UnitType\":18}},\"Day\":{\"Icon\":3,\"IconPhrase\":\"Partly sunny\",\"HasPrecipitation\":false},\"Night\":{\"Icon\":33,\"IconPhrase\":\"Clear\",\"HasPrecipitation\":false},\"Sources\":[\"AccuWeather\"],\"MobileLink\":\"http://www.accuweather.com/en/kg/bishkek/222844/daily-weather-forecast/222844?day=1&lang=en-us\",\"Link\":\"http://www.accuweather.com/en/kg/bishkek/222844/daily-weather-forecast/222844?day=1&lang=en-us\"},{\"Date\":\"2023-02-27T07:00:00+06:00\",\"EpochDate\":1677459600,\"Temperature\":{\"Minimum\":{\"Value\":30.0,\"Unit\":\"F\",\"UnitType\":18},\"Maximum\":{\"Value\":44.0,\"Unit\":\"F\",\"UnitType\":18}},\"Day\":{\"Icon\":6,\"IconPhrase\":\"Mostly cloudy\",\"HasPrecipitation\":false},\"Night\":{\"Icon\":34,\"IconPhrase\":\"Mostly clear\",\"HasPrecipitation\":false},\"Sources\":[\"AccuWeather\"],\"MobileLink\":\"http://www.accuweather.com/en/kg/bishkek/222844/daily-weather-forecast/222844?day=2&lang=en-us\",\"Link\":\"http://www.accuweather.com/en/kg/bishkek/222844/daily-weather-forecast/222844?day=2&lang=en-us\"},{\"Date\":\"2023-02-28T07:00:00+06:00\",\"EpochDate\":1677546000,\"Temperature\":{\"Minimum\":{\"Value\":33.0,\"Unit\":\"F\",\"UnitType\":18},\"Maximum\":{\"Value\":50.0,\"Unit\":\"F\",\"UnitType\":18}},\"Day\":{\"Icon\":1,\"IconPhrase\":\"Sunny\",\"HasPrecipitation\":false},\"Night\":{\"Icon\":33,\"IconPhrase\":\"Clear\",\"HasPrecipitation\":false},\"Sources\":[\"AccuWeather\"],\"MobileLink\":\"http://www.accuweather.com/en/kg/bishkek/222844/daily-weather-forecast/222844?day=3&lang=en-us\",\"Link\":\"http://www.accuweather.com/en/kg/bishkek/222844/daily-weather-forecast/222844?day=3&lang=en-us\"},{\"Date\":\"2023-03-01T07:00:00+06:00\",\"EpochDate\":1677632400,\"Temperature\":{\"Minimum\":{\"Value\":35.0,\"Unit\":\"F\",\"UnitType\":18},\"Maximum\":{\"Value\":55.0,\"Unit\":\"F\",\"UnitType\":18}},\"Day\":{\"Icon\":1,\"IconPhrase\":\"Sunny\",\"HasPrecipitation\":false},\"Night\":{\"Icon\":33,\"IconPhrase\":\"Clear\",\"HasPrecipitation\":false},\"Sources\":[\"AccuWeather\"],\"MobileLink\":\"http://www.accuweather.com/en/kg/bishkek/222844/daily-weather-forecast/222844?day=4&lang=en-us\",\"Link\":\"http://www.accuweather.com/en/kg/bishkek/222844/daily-weather-forecast/222844?day=4&lang=en-us\"},{\"Date\":\"2023-03-02T07:00:00+06:00\",\"EpochDate\":1677718800,\"Temperature\":{\"Minimum\":{\"Value\":39.0,\"Unit\":\"F\",\"UnitType\":18},\"Maximum\":{\"Value\":59.0,\"Unit\":\"F\",\"UnitType\":18}},\"Day\":{\"Icon\":1,\"IconPhrase\":\"Sunny\",\"HasPrecipitation\":false},\"Night\":{\"Icon\":35,\"IconPhrase\":\"Partly cloudy\",\"HasPrecipitation\":false},\"Sources\":[\"AccuWeather\"],\"MobileLink\":\"http://www.accuweather.com/en/kg/bishkek/222844/daily-weather-forecast/222844?day=5&lang=en-us\",\"Link\":\"http://www.accuweather.com/en/kg/bishkek/222844/daily-weather-forecast/222844?day=5&lang=en-us\"}]}";

//        String jsonString = response.body().string();
//        System.out.println(jsonString);

//        String tjs = mapper.writeValueAsString(response.body().string());
//        System.out.println(tjs);

        //String jsonBody1 = mapper.writeValueAsString(response.body().string());
        //ПОЛУЧИЛИ ЗАПРОС и СОХРАНИЛИ ЕГО КАК СТРОКУ-json
//        String jsonBody2 = mapper.writeValueAsString(response.body());
        //System.out.println(jsonBody1);
     //   System.out.println("вывод /String jsonBody2 = mapper.writeValueAsString(response.body());/ в консоль");
//        System.out.println(jsonBody2);

     //   System.out.println("вывод в консоль /mapper.readValue(jsonBody2,BodyResponse.class);/");
 //       BodyResponse bodyResponse1 = mapper.readValue(jsonBody2,BodyResponse.class);
 //       System.out.println(bodyResponse1);


   //     BodyResponse bodyResponse2 = mapper.readValue((DataInput) response.body(),BodyResponse.class);
   //     System.out.println(bodyResponse1);
   //     System.out.println(bodyResponse2);


//       WeatherResponse thisResponse = new WeatherResponse(tjs);
//        thisResponse.showForecast();
    }

    public static void executeForecastProgram() throws IOException {
        System.out.println("|| ПОЛУЧИТЬ СВОДКУ ПОГОДЫ ||");
        OkHttpClient client = new OkHttpClient();

        while (true) {
            String requestURL = buildUserRequest();

            Request request = new Request.Builder()
                    //.url("http://dataservice.accuweather.com/forecasts/v1/daily/5day/222844?apikey=pp0fIcvt4V9GTyAqCEG1O6cJCX71LYcZ")
                    //        .url("http://dataservice.accuweather.com/forecasts/v1/daily/5day/222844?apikey=pp0fIcvt4V9GTyAqCEG1O6cJCX71LYcZ&language=ru-ru&details=true")
                    .url(requestURL)
                    .build();


            // //      Call call = client.newCall(request);
            // //      Response response = call.execute();
            ObjectMapper mapper = new ObjectMapper();

            String jsonResponse = client.newCall(request).execute().body().string();
            //(диагностика) вывод     jsonResponse
            //    System.out.println("jsonResponse: \n"+jsonResponse);
            Response responseJava = mapper.readValue(jsonResponse, Response.class);

            responseJava.showDailyForecasts();

            continueAsk();
        }
    }


}
