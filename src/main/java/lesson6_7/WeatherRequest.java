package lesson6_7;

import static lesson6_7.Interface.userAsk;

public class WeatherRequest {
    private String cityCode;
    private String cityName;
    private String fullURL;

    private static WeatherRequest currentRequest = null;

    public static String getCurrentRequestCity(){
        return currentRequest.cityName;
    }

    public WeatherRequest(String cityCode){
        this.cityCode = cityCode;
        String mainRequest = "http://dataservice.accuweather.com/forecasts/v1/daily/5day/";
        String apikey = "?apikey=pp0fIcvt4V9GTyAqCEG1O6cJCX71LYcZ";
        String tailMeta = "&language=ru-ru&details=true";
        this.fullURL = mainRequest + cityCode + apikey + tailMeta;

    }

    public static String buildUserRequest(){

        String cityNumber = Interface.getUserSelect();

        switch (cityNumber.intern()){
            case  ("1"):
                System.out.println("Москва");
                WeatherRequest requestMoscow = new WeatherRequest("294021");
                requestMoscow.cityName = "Москва";
                currentRequest = requestMoscow;
                break;
            case ("2"):
                System.out.println("Санкт-Петербург");
                WeatherRequest requestSaintPetersburg = new WeatherRequest("295212");
                requestSaintPetersburg.cityName = "Санкт-Петербург";
                currentRequest = requestSaintPetersburg;
                break;
            case ("3"):
                System.out.println("Ташкент");
                WeatherRequest requestTashkent = new WeatherRequest("351199");
                requestTashkent.cityName = "Ташкент";
                currentRequest = requestTashkent;
                break;
            case ("4"):
                System.out.println("Баку");
                WeatherRequest requestBaku = new WeatherRequest("27103");
                requestBaku.cityName = "Баку";
                currentRequest = requestBaku;
                break;
            case ("5"):
                System.out.println("Минск");
                WeatherRequest requestMinsk = new WeatherRequest("28580");
                requestMinsk.cityName = "Минск";
                currentRequest = requestMinsk;
                break;
            case ("0"):
                System.out.println("ПРОСМОТР ДАННЫХ ЖУРНАЛА:");
                Interface.setUserSelect("0");
                break;
            case ("exit"):
                System.out.println("ВЫХОД");
                System.exit(0);
                break;
        }

        assert currentRequest != null;
        return currentRequest.fullURL;

    }


















    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getFullURL() {
        return fullURL;
    }

    public void setFullURL(String fullURL) {
        this.fullURL = fullURL;
    }

    //        "222844"
}
