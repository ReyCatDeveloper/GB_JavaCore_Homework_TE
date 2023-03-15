package lesson9;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface Student {
    String getName();
    List<Course> getAllCourse();

}


interface Course{
    String getName();


}
