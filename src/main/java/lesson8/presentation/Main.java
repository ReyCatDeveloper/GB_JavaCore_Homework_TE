package lesson8.presentation;

import java.sql.*;
import java.util.AbstractList;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {

        //load JDBC driver
        try{
            Class.forName("org.sqlite.JDBC");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            Statement statement = connection.createStatement()){

            //пример очистки при запуске .
            performDropTable(statement);

            //пример создания БД
            performCreateDB(statement);

            readStudentsFromDB(statement);


        }


    }

    private static void performDropTable(Statement statement) throws SQLException {
        statement.executeUpdate("DROP TABLE IF EXISTS students");
        //удаляется таблица со всеми данными, которые в ней были
    }
    private static void performCreateDB(Statement statement) throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS students (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name STRING, score INTEGER NOT NULL);");
    }

    private static void readStudentsFromDB(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM students");
        //в данном случае resultSet выгружает всю результирующую выборку
        ArrayList<MyClass> arrayList = new ArrayList<>();
        while (resultSet.next()){
            System.out.println(
                    resultSet.getInt(1) + " - " +
                            resultSet.getString(2) + " - " +
                            resultSet.getDouble("score") + " - "

            );
            arrayList.add(new MyClass(resultSet.getInt(1), resultSet.getString(2), resultSet.getDouble("score")));
        }
        System.out.println("");
     }

     public static class MyClass{
        private  Integer id;
        private String name;
        private Double score;

         public MyClass(Integer id, String name, Double score) {
             this.id = id;
             this.name = name;
             this.score = score;
         }
     }
}
