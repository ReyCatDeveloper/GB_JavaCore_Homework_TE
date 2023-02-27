package lesson6_7.SandBox;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Solution {
    public static void main(String[] args) throws Exception {
        Book book = new Book("Обитаемый остров","Стругацкий А., Стругацкий Б.",413);
    //    book.title = "Обитаемый остров";
    //    book.author = "Стругацкий А., Стругацкий Б.";
    //    book.pages = 413;

        ObjectMapper mapper = new ObjectMapper();
 //       mapper.enable(SerializationFeature.INDENT_OUTPUT);   //красивое отображение

        String jsonBook = mapper.writeValueAsString(book);


        System.out.println(jsonBook);

        String jsonString = "{\"title\":\"Обитаемый остров\",\"author\":\"Стругацкий А., Стругацкий Б.\",\"pages\":413}";
        Book book2 = new ObjectMapper().readValue(jsonString, Book.class);
        System.out.println("Book2---class Book----------------------------\n"+book2+"\n-----------------------------------------");



        String JSON_STRING ="{\"age\":2,\"name\":\"j4web\",\"messages\":[\"msg 1\",\"msg 2\",\"msg 3\"]}";
        Object jsonObject = mapper.readValue(JSON_STRING, Object.class);
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject));

    }
}
