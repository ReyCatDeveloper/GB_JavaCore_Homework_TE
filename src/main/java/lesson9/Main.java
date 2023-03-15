package lesson9;


import jdk.jfr.Name;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import static lesson9.GeekStudent.assignmentCourse;
//import static lesson9.Student.listStudentCourse;

public class Main {
    public static void main(String[] args) {

        //Задание 1. Реализация. Функция возврата списка уникальных курсов, на которые подписаны студенты
        Function<List<Student>,List<Course>> getUniqueListStudentCourse =  (students)->{
            return students.stream().flatMap(student -> student.getAllCourse().stream())
                    .distinct().collect(Collectors.toList());
        };

        //Задание 2. Реализация. Функция возвращающая 3-х самых любознательных студентов (по количеству курсов)
        Comparator<Student> valueCourseComparator
                = (o1, o2) -> o1.getAllCourse().size() - o2.getAllCourse().size();
        Function<List<Student>,List<Student>> getMostInquiringStudents =  (students)->{
            return students.stream().sorted(valueCourseComparator.reversed()).limit(3).collect( Collectors.toList() );
        };

        //Задание 3. Реализация. Функция возвращающая список студентов, посещающих указанный курс
        BiFunction<List<Student>,Course,List<Student>> getStudentsForCurrentCourse = ((students, course) -> {
            return  students.stream().filter(student -> {
                return student.getAllCourse().stream().anyMatch(course1 -> course1.getName().intern() == course.getName().intern()) ;
            })
                    .collect(Collectors.toList());
        });

        //Задание 1. Пример работы. Функция возврата списка уникальных курсов, на которые подписаны студенты
        List<Course> uniqueCourses = getUniqueListStudentCourse.apply( getStudentsList(getCoursesList()) );
        System.out.println(uniqueCourses);

        //Задание 2. Пример работы. Функция возвращающая 3-х самых любознательных студентов (по количеству курсов)
        List<Student> mostInquiringStudents = getMostInquiringStudents.apply( getStudentsList(getCoursesList()) );
        System.out.println(mostInquiringStudents);

        //Задание 3. Пример работы. Функция возвращающая список студентов, посещающих указанный курс
        List<Student> studentsFromCurrentCourse = getStudentsForCurrentCourse.apply( getStudentsList(getCoursesList()),  getCoursesList().get(1)) ;
        System.out.println(studentsFromCurrentCourse);
    }

    private static List<Course> getCoursesList(){
        List<Course> courses= new ArrayList<>(Arrays.asList(
                new GeekCourse("Java Level1"),
                new GeekCourse("JavaCore for Testers"),
                new GeekCourse("Automation testing WebUI"),
                new GeekCourse("Backend testing with Java"),
                new GeekCourse("Git Basic"),
                new GeekCourse("Entering to testing"),
                new GeekCourse("Web-application testing"),
                new GeekCourse("Data Base. Basic")
        ));
        return courses;
    }

    private static List<Student> getStudentsList(List<Course> coursesForStudents){

        List<Student> students= new ArrayList<>(Arrays.asList(
                new GeekStudent("Mark", assignmentCourse(coursesForStudents)),
                new GeekStudent("Robert", assignmentCourse(coursesForStudents)),
                new GeekStudent("Harold", assignmentCourse(coursesForStudents)),
            new GeekStudent("David", assignmentCourse(coursesForStudents)),
            new GeekStudent("Brad", assignmentCourse(coursesForStudents)),
            new GeekStudent("Bernard", assignmentCourse(coursesForStudents))/*,
            new GeekStudent("Eric", assignmentCourse(coursesForStudents)),
            new GeekStudent("Joe", assignmentCourse(coursesForStudents)),
            new GeekStudent("Richard", assignmentCourse(coursesForStudents)),
            new GeekStudent("John", assignmentCourse(coursesForStudents))*/
        ));

    return students;
    }
}
