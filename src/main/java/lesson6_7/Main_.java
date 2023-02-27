package lesson6_7;

import com.fasterxml.jackson.databind.ObjectMapper;
import lesson6_7.SandBox.Example;
import lesson6_7.SandBox.ExampleShort;
import lesson6_7.SandBox.Packet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main_ {
    public static void main(String[] args) throws IOException, Exception{
/*
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://dataservice.accuweather.com/forecasts/v1/daily/5day/222844?apikey=pp0fIcvt4V9GTyAqCEG1O6cJCX71LYcZ")
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

//        System.out.println(response.body());
        System.out.println(response.body().string());
//        System.out.println(response.headers());
        System.out.println(response.message());

        String forecastJSON_5days = "{\"Headline\":{\"EffectiveDate\":\"2023-02-26T07:00:00+06:00\",\"EffectiveEpochDate\":1677373200,\"Severity\":7,\"Text\":\"Cold Sunday\",\"Category\":\"cold\",\"EndDate\":\"2023-02-26T19:00:00+06:00\",\"EndEpochDate\":1677416400,\"MobileLink\":\"http://www.accuweather.com/en/kg/bishkek/222844/daily-weather-forecast/222844?lang=en-us\",\"Link\":\"http://www.accuweather.com/en/kg/bishkek/222844/daily-weather-forecast/222844?lang=en-us\"},\"DailyForecasts\":[{\"Date\":\"2023-02-26T07:00:00+06:00\",\"EpochDate\":1677373200,\"Temperature\":{\"Minimum\":{\"Value\":24.0,\"Unit\":\"F\",\"UnitType\":18},\"Maximum\":{\"Value\":36.0,\"Unit\":\"F\",\"UnitType\":18}},\"Day\":{\"Icon\":3,\"IconPhrase\":\"Partly sunny\",\"HasPrecipitation\":false},\"Night\":{\"Icon\":33,\"IconPhrase\":\"Clear\",\"HasPrecipitation\":false},\"Sources\":[\"AccuWeather\"],\"MobileLink\":\"http://www.accuweather.com/en/kg/bishkek/222844/daily-weather-forecast/222844?day=1&lang=en-us\",\"Link\":\"http://www.accuweather.com/en/kg/bishkek/222844/daily-weather-forecast/222844?day=1&lang=en-us\"},{\"Date\":\"2023-02-27T07:00:00+06:00\",\"EpochDate\":1677459600,\"Temperature\":{\"Minimum\":{\"Value\":30.0,\"Unit\":\"F\",\"UnitType\":18},\"Maximum\":{\"Value\":44.0,\"Unit\":\"F\",\"UnitType\":18}},\"Day\":{\"Icon\":6,\"IconPhrase\":\"Mostly cloudy\",\"HasPrecipitation\":false},\"Night\":{\"Icon\":34,\"IconPhrase\":\"Mostly clear\",\"HasPrecipitation\":false},\"Sources\":[\"AccuWeather\"],\"MobileLink\":\"http://www.accuweather.com/en/kg/bishkek/222844/daily-weather-forecast/222844?day=2&lang=en-us\",\"Link\":\"http://www.accuweather.com/en/kg/bishkek/222844/daily-weather-forecast/222844?day=2&lang=en-us\"},{\"Date\":\"2023-02-28T07:00:00+06:00\",\"EpochDate\":1677546000,\"Temperature\":{\"Minimum\":{\"Value\":33.0,\"Unit\":\"F\",\"UnitType\":18},\"Maximum\":{\"Value\":50.0,\"Unit\":\"F\",\"UnitType\":18}},\"Day\":{\"Icon\":1,\"IconPhrase\":\"Sunny\",\"HasPrecipitation\":false},\"Night\":{\"Icon\":33,\"IconPhrase\":\"Clear\",\"HasPrecipitation\":false},\"Sources\":[\"AccuWeather\"],\"MobileLink\":\"http://www.accuweather.com/en/kg/bishkek/222844/daily-weather-forecast/222844?day=3&lang=en-us\",\"Link\":\"http://www.accuweather.com/en/kg/bishkek/222844/daily-weather-forecast/222844?day=3&lang=en-us\"},{\"Date\":\"2023-03-01T07:00:00+06:00\",\"EpochDate\":1677632400,\"Temperature\":{\"Minimum\":{\"Value\":35.0,\"Unit\":\"F\",\"UnitType\":18},\"Maximum\":{\"Value\":55.0,\"Unit\":\"F\",\"UnitType\":18}},\"Day\":{\"Icon\":1,\"IconPhrase\":\"Sunny\",\"HasPrecipitation\":false},\"Night\":{\"Icon\":33,\"IconPhrase\":\"Clear\",\"HasPrecipitation\":false},\"Sources\":[\"AccuWeather\"],\"MobileLink\":\"http://www.accuweather.com/en/kg/bishkek/222844/daily-weather-forecast/222844?day=4&lang=en-us\",\"Link\":\"http://www.accuweather.com/en/kg/bishkek/222844/daily-weather-forecast/222844?day=4&lang=en-us\"},{\"Date\":\"2023-03-02T07:00:00+06:00\",\"EpochDate\":1677718800,\"Temperature\":{\"Minimum\":{\"Value\":39.0,\"Unit\":\"F\",\"UnitType\":18},\"Maximum\":{\"Value\":59.0,\"Unit\":\"F\",\"UnitType\":18}},\"Day\":{\"Icon\":1,\"IconPhrase\":\"Sunny\",\"HasPrecipitation\":false},\"Night\":{\"Icon\":35,\"IconPhrase\":\"Partly cloudy\",\"HasPrecipitation\":false},\"Sources\":[\"AccuWeather\"],\"MobileLink\":\"http://www.accuweather.com/en/kg/bishkek/222844/daily-weather-forecast/222844?day=5&lang=en-us\",\"Link\":\"http://www.accuweather.com/en/kg/bishkek/222844/daily-weather-forecast/222844?day=5&lang=en-us\"}]}";

*/
       ObjectMapper mapper = new ObjectMapper();
        List<String> values = List.of("123","456","789");
        List<Packet> packetsList = new ArrayList<>();

        Packet packet1 = new Packet("1","11","111");
        Packet packet2 = new Packet("2","22","222");
        Packet packet3 = new Packet("3","33","333");

        packetsList.add(packet1);
        packetsList.add(packet2);
        packetsList.add(packet3);

        Example example = new Example(packetsList);

        String json = mapper.writeValueAsString(example);
        System.out.println(json);

        Example exampleFromJSON = new ObjectMapper().readValue(json,Example.class);
        System.out.println(exampleFromJSON);

        ExampleShort exampleShortFromJSON = new ObjectMapper().readValue(json,ExampleShort.class);
        System.out.println(exampleShortFromJSON);

    }
}
