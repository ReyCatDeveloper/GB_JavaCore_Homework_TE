package lesson6_7.accuWeatherJsonClasses;

import com.fasterxml.jackson.annotation.JsonCreator;

public class AccuDate {
    private String accuDate;
    private String date;


    public AccuDate(String accuDate){
        this.accuDate = accuDate;
        this.date = parseDate(this.accuDate);
    }

    public String getAccuDate() {
        return accuDate;
    }

    public void setAccuDate(String accuDate) {
        this.accuDate = accuDate;
    }

    String parseDate(String stringDateToParse){
        String parseResult = stringDateToParse.substring(0, stringDateToParse.indexOf('T')).replace('-', '/');

        return parseResult;
    }

    @Override
    public String toString(){
        return date;
    }
}
