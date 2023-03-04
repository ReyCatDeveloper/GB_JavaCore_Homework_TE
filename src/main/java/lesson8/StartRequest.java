package lesson8;

import com.fasterxml.jackson.databind.ObjectMapper;
import lesson6_7.Interface;
import lesson6_7.accuWeatherJsonClasses.Response;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;
import java.sql.SQLException;

import static lesson6_7.Interface.continueAsk;
import static lesson6_7.Interface.userAsk;
import static lesson6_7.WeatherRequest.buildUserRequest;
import static lesson8.Homework.*;

public class StartRequest {
    public static void main(String[] args) throws IOException, SQLException {
        executeForecastProgram();
    }

    public static void executeForecastProgram() throws IOException, SQLException {
        System.out.println("|| ПОЛУЧИТЬ СВОДКУ ПОГОДЫ ||");
        OkHttpClient client = new OkHttpClient();

        while (true) {
            userAsk();
            switch (Interface.getUserSelect().intern()){
                case("0"):
                    //System.out.println("ЖУРНАЛ ЖУРНАЛ ЖУРНАЛ\nЖУРНАЛ ЖУРНАЛ ЖУРНАЛ\nЖУРНАЛ ЖУРНАЛ ЖУРНАЛ\nЖУРНАЛ ЖУРНАЛ ЖУРНАЛ\nЖУРНАЛ ЖУРНАЛ ЖУРНАЛ\nЖУРНАЛ ЖУРНАЛ ЖУРНАЛ\n");
                    showAllForecasts();
                    continueAsk();
                    break;
                case("exit"):
                    System.out.println("ВЫХОД");
                    System.exit(0);
                    break;
                default:
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

                    //старая версия, где записи только добавляются
//                 saveForecastIntoDB(responseJava.getDeserializedDailyForecasts());

                    //новая версия, где записи обновляются или добавляются, если не созданы
                    saveOrUpdateForecastIntoDB(responseJava.getDeserializedDailyForecasts());

//            отображение информации в пользовательском виде
                    responseJava.showDailyForecasts();

                    continueAsk();

                    break;
            }
        }
    }



}
