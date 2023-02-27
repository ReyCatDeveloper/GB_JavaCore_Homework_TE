package lesson6_7.parseForecats;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        String json_forecastJSON_5days = "{\"Headline\":{\"EffectiveDate\":\"2023-02-26T07:00:00+06:00\",\"EffectiveEpochDate\":1677373200,\"Severity\":7,\"Text\":\"Cold Sunday\",\"Category\":\"cold\",\"EndDate\":\"2023-02-26T19:00:00+06:00\",\"EndEpochDate\":1677416400,\"MobileLink\":\"http://www.accuweather.com/en/kg/bishkek/222844/daily-weather-forecast/222844?lang=en-us\",\"Link\":\"http://www.accuweather.com/en/kg/bishkek/222844/daily-weather-forecast/222844?lang=en-us\"},\"DailyForecasts\":[{\"Date\":\"2023-02-26T07:00:00+06:00\",\"EpochDate\":1677373200,\"Temperature\":{\"Minimum\":{\"Value\":24.0,\"Unit\":\"F\",\"UnitType\":18},\"Maximum\":{\"Value\":36.0,\"Unit\":\"F\",\"UnitType\":18}},\"Day\":{\"Icon\":3,\"IconPhrase\":\"Partly sunny\",\"HasPrecipitation\":false},\"Night\":{\"Icon\":33,\"IconPhrase\":\"Clear\",\"HasPrecipitation\":false},\"Sources\":[\"AccuWeather\"],\"MobileLink\":\"http://www.accuweather.com/en/kg/bishkek/222844/daily-weather-forecast/222844?day=1&lang=en-us\",\"Link\":\"http://www.accuweather.com/en/kg/bishkek/222844/daily-weather-forecast/222844?day=1&lang=en-us\"},{\"Date\":\"2023-02-27T07:00:00+06:00\",\"EpochDate\":1677459600,\"Temperature\":{\"Minimum\":{\"Value\":30.0,\"Unit\":\"F\",\"UnitType\":18},\"Maximum\":{\"Value\":44.0,\"Unit\":\"F\",\"UnitType\":18}},\"Day\":{\"Icon\":6,\"IconPhrase\":\"Mostly cloudy\",\"HasPrecipitation\":false},\"Night\":{\"Icon\":34,\"IconPhrase\":\"Mostly clear\",\"HasPrecipitation\":false},\"Sources\":[\"AccuWeather\"],\"MobileLink\":\"http://www.accuweather.com/en/kg/bishkek/222844/daily-weather-forecast/222844?day=2&lang=en-us\",\"Link\":\"http://www.accuweather.com/en/kg/bishkek/222844/daily-weather-forecast/222844?day=2&lang=en-us\"},{\"Date\":\"2023-02-28T07:00:00+06:00\",\"EpochDate\":1677546000,\"Temperature\":{\"Minimum\":{\"Value\":33.0,\"Unit\":\"F\",\"UnitType\":18},\"Maximum\":{\"Value\":50.0,\"Unit\":\"F\",\"UnitType\":18}},\"Day\":{\"Icon\":1,\"IconPhrase\":\"Sunny\",\"HasPrecipitation\":false},\"Night\":{\"Icon\":33,\"IconPhrase\":\"Clear\",\"HasPrecipitation\":false},\"Sources\":[\"AccuWeather\"],\"MobileLink\":\"http://www.accuweather.com/en/kg/bishkek/222844/daily-weather-forecast/222844?day=3&lang=en-us\",\"Link\":\"http://www.accuweather.com/en/kg/bishkek/222844/daily-weather-forecast/222844?day=3&lang=en-us\"},{\"Date\":\"2023-03-01T07:00:00+06:00\",\"EpochDate\":1677632400,\"Temperature\":{\"Minimum\":{\"Value\":35.0,\"Unit\":\"F\",\"UnitType\":18},\"Maximum\":{\"Value\":55.0,\"Unit\":\"F\",\"UnitType\":18}},\"Day\":{\"Icon\":1,\"IconPhrase\":\"Sunny\",\"HasPrecipitation\":false},\"Night\":{\"Icon\":33,\"IconPhrase\":\"Clear\",\"HasPrecipitation\":false},\"Sources\":[\"AccuWeather\"],\"MobileLink\":\"http://www.accuweather.com/en/kg/bishkek/222844/daily-weather-forecast/222844?day=4&lang=en-us\",\"Link\":\"http://www.accuweather.com/en/kg/bishkek/222844/daily-weather-forecast/222844?day=4&lang=en-us\"},{\"Date\":\"2023-03-02T07:00:00+06:00\",\"EpochDate\":1677718800,\"Temperature\":{\"Minimum\":{\"Value\":39.0,\"Unit\":\"F\",\"UnitType\":18},\"Maximum\":{\"Value\":59.0,\"Unit\":\"F\",\"UnitType\":18}},\"Day\":{\"Icon\":1,\"IconPhrase\":\"Sunny\",\"HasPrecipitation\":false},\"Night\":{\"Icon\":35,\"IconPhrase\":\"Partly cloudy\",\"HasPrecipitation\":false},\"Sources\":[\"AccuWeather\"],\"MobileLink\":\"http://www.accuweather.com/en/kg/bishkek/222844/daily-weather-forecast/222844?day=5&lang=en-us\",\"Link\":\"http://www.accuweather.com/en/kg/bishkek/222844/daily-weather-forecast/222844?day=5&lang=en-us\"}]}";
        String json = mapper.writeValueAsString(json_forecastJSON_5days);

        System.out.println(json);
        Object jsonObject = mapper.readValue(json_forecastJSON_5days, Object.class);
//        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject));

        ParseForecast java_forecastJSON_5days = new ObjectMapper().readValue( json_forecastJSON_5days, ParseForecast.class );
        java_forecastJSON_5days.showDailyForecast();



    }
}
