package lesson8;

import lesson6_7.accuWeatherJsonClasses.DailyForecast;

import java.sql.*;
import java.util.ArrayList;

public class Homework {

    public static class ForecastDailyDB{
        String city;
        String localDate;
        String weatherText;
        Double temperature;
        int id;

        public ForecastDailyDB(int id, String city, String localDate, String weatherText, Double temperature) {
            this.id = id;
            this.city = city;
            this.localDate = localDate;
            this.weatherText = weatherText;
            this.temperature = temperature;
        }

        public ForecastDailyDB(String city, String localDate, String weatherText, Double temperature) {
            this.city = city;
            this.localDate = localDate;
            this.weatherText = weatherText;
            this.temperature = temperature;
        }

        public String getCity() {
            return city;
        }

        public String getLocalDate() {
            return localDate;
        }

        public int getId() {
            return id;
        }

        public String getWeatherText() {
            return weatherText;
        }

        public Double getTemperature() {
            return temperature;
        }
    }

    public static void saveForecastIntoDB(DailyForecast[] forecastMassive) throws SQLException {
    //добавит все полученные записи в журнал
        ForecastDailyDB[] forecasts = convertForecastDB(forecastMassive);

        try{
            Class.forName("org.sqlite.JDBC");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:ForecastDatabase.db");
            Statement statement = connection.createStatement()){

            //создать таблицу, если отсутствует
            //пример создания БД
            performCreateDB(statement);

            for(int i = 0; i < forecasts.length; i++) {
                //запись в базу данных
                populateDB(statement, connection, forecasts[i]);
            }
        }
        System.out.println("Результаты сохранены в Журнале");
    }

    public static void saveOrUpdateForecastIntoDB(DailyForecast[] forecastMassive) throws SQLException {
        //обновит существующие или добавит новые записи в журнал
        ForecastDailyDB[] forecasts = convertForecastDB(forecastMassive);

        try{
            Class.forName("org.sqlite.JDBC");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:ForecastDatabase.db");
            Statement statement = connection.createStatement()){

            //создать таблицу, если отсутствует
            //пример создания БД
            performCreateDB(statement);

            //чтение и сохранение результов из БД
            ArrayList<ForecastDailyDB> forecastDailyFromDB = readDB(statement);

            int rowNumberInDB;

            for(int i = 0; i < forecasts.length; i++) {
                //поиск индекса в базе данных
                rowNumberInDB = searchInDB(forecastDailyFromDB,forecasts[i]);
                if(rowNumberInDB > 0){
                    //обновить БД
                    updateDB(statement, forecasts[i], rowNumberInDB);
                }else {
                    //запись в базу данных
                    populateDB(statement, connection, forecasts[i]);
                }
            }
        }
        System.out.println("Результаты сохранены в Журнале");

    }

    public static void updateDB(Statement statement, ForecastDailyDB forecast, int rowNumberInDB) throws SQLException {
//        String sqlString1 = "UPDATE dailyForecast SET weatherText = '"+ "ПЕРЕЗАПИСЬ" +"' where id="+rowNumberInDB+";";
//        String sqlString2 = "UPDATE dailyForecast SET temperature = "+ 999999 +" where id="+rowNumberInDB+";";

        String sqlString1 = "UPDATE dailyForecast SET weatherText = '"+ forecast.getWeatherText() +"' where id="+rowNumberInDB+";";
        String sqlString2 = "UPDATE dailyForecast SET temperature = '"+ forecast.getTemperature() +"' where id="+rowNumberInDB+";";
        statement.executeUpdate(sqlString1);
        statement.executeUpdate(sqlString2);

    }




    public static int searchInDB(ArrayList<ForecastDailyDB> forecastDailyFromDB, ForecastDailyDB forecast){
        int resultId = 0;

        for (int i = 0; i < forecastDailyFromDB.size();  i++){
            if(forecastDailyFromDB.get(i).getCity().intern() == forecast.getCity().intern() ){
                if(forecastDailyFromDB.get(i).getLocalDate().intern() == forecast.getLocalDate().intern()){
                    resultId = forecastDailyFromDB.get(i).getId();
                    break;
                }
            }
        }

        return resultId;
    }

    public static ArrayList<ForecastDailyDB> readDB(Statement statement) throws SQLException {
        int returnIndex = 0;
        ResultSet resultSet = statement.executeQuery("SELECT * FROM dailyForecast");
        //в данном случае resultSet выгружает всю результирующую выборку
        ArrayList<ForecastDailyDB> forecastDailyFromDB = new ArrayList<>();

        while (resultSet.next()){
        /*    System.out.println(
                    resultSet.getString("city") + " - " +
                            resultSet.getString("localDate") + " - " +
                            resultSet.getString("weatherText") + " - " +
                            resultSet.getDouble("temperature") +  (char)186  +"C"
            );
        */    forecastDailyFromDB.add(new ForecastDailyDB(
                    resultSet.getInt("id"),
                    resultSet.getString("city"),
                    resultSet.getString("localDate"),
                    resultSet.getString("weatherText"),
                    resultSet.getDouble("temperature")));
        }

        return forecastDailyFromDB;
    }


    public static void showAllForecasts() throws SQLException {
        try{
            Class.forName("org.sqlite.JDBC");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:ForecastDatabase.db");
            Statement statement = connection.createStatement()){

            readForecastFromDB(statement);
        }
    }

    private static ForecastDailyDB[] convertForecastDB(DailyForecast[] forecastMassive){
        ForecastDailyDB[] packageForDB = new ForecastDailyDB[forecastMassive.length];
        String weatherText;
        for(int i = 0; i < packageForDB.length; i++){
            weatherText = "днем: "+forecastMassive[i].getDayWeather().toString()+", ночью: "+forecastMassive[i].getNightWeather().toString();
            //System.out.println(forecastMassive[i].getForecastCity());
            packageForDB[i] = new ForecastDailyDB(
                    forecastMassive[i].getForecastCity(),
                    forecastMassive[i].getDate(),
                    weatherText,
                    forecastMassive[i].getMaxTemperature());
            //packageForDB[i].city = forecastMassive[i].getForecastCity();
            //packageForDB[i].localDate = forecastMassive[i].getDate();
            //packageForDB[i].weatherText = "днем: "+forecastMassive[i].getDayWeather().toString()+", ночью: "+forecastMassive[i].getNightWeather().toString();
            //packageForDB[i].temperature = forecastMassive[i].getMaxTemperature();
        }
        return packageForDB;
    }

    public static void main(String[] args) throws SQLException {
        //load JDBC driver
        try{
            Class.forName("org.sqlite.JDBC");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:ForecastDatabase.db");
        Statement statement = connection.createStatement()){

            //очистка таблицы
            performDropTable(statement);

            //performDropTableSQNC(statement);

         /*   //создание таблицы
            performCreateDB(statement);

            int localDateDay = 5;
            double temperature = 17.5;
            for(int i = 0; i < 5; i++) {
                String localDate = localDateDay + ".3.2023";
                ForecastDailyForDB forecast = new ForecastDailyForDB("Moscow", localDate, "weatherText", temperature);
                //запись в базу данных
                populateDB(statement, connection, forecast);
                localDateDay++;
                temperature += 0.5;
                }
                */
        }
    }

    private static void performCreateDB(Statement statement) throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS dailyForecast (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "city STRING, localDate STRING, weatherText STRING, temperature REAL);");
    }

    private static void populateDB(Statement statement, Connection connection, ForecastDailyDB forecastDailyForDataBase) throws SQLException {
        String sqlREQUEST = "INSERT INTO dailyForecast (city, localDate, weatherText, temperature) VALUES (" +
                "'"+forecastDailyForDataBase.city+"', " +
                "'"+forecastDailyForDataBase.localDate+"', " +
                "'"+forecastDailyForDataBase.weatherText+"', " +
                ""+forecastDailyForDataBase.temperature+")";
        statement.executeUpdate(sqlREQUEST);
    }
    private static void performDropTable(Statement statement) throws SQLException {
        statement.executeUpdate("DROP TABLE IF EXISTS dailyForecast");
        //удаляется таблица со всеми данными, которые в ней были
    }

    private static void performDropTableSQNC(Statement statement) throws SQLException {
        statement.executeUpdate("DROP TABLE IF EXISTS sqlite_sequence");
        //удаляется таблица со всеми данными, которые в ней были
    }

    private static void readForecastFromDB(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM dailyForecast");
        //в данном случае resultSet выгружает всю результирующую выборку
        ArrayList<ForecastDailyDB> forecastDailyFromDB = new ArrayList<>();
        while (resultSet.next()){
            System.out.println(
                    resultSet.getString("city") + " - " +
                    resultSet.getString("localDate") + " - " +
                    resultSet.getString("weatherText") + " - " +
                    resultSet.getDouble("temperature") +  (char)186  +"C"
            );
            forecastDailyFromDB.add(new ForecastDailyDB(
                    resultSet.getInt("id"),
                    resultSet.getString("city"),
                    resultSet.getString("localDate"),
                    resultSet.getString("weatherText"),
                    resultSet.getDouble("temperature")));
        }
        System.out.println();
    }

}
