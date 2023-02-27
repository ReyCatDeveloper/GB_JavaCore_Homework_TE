package lesson6_7.SandBox;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Book {

    public String title;
    public String author;
    public int pages;

    @JsonCreator
    public Book(@JsonProperty("title") String title, @JsonProperty("author")String author, @JsonProperty("pages")int pages){
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                '}';
    }
}
