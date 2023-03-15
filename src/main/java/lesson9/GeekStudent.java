package lesson9;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeekStudent implements Student{

    String name;
    List<Course> courseList;
    int courseValue;

    public GeekStudent(String name){
        this.name = name;
    }
    
    public GeekStudent(String name, List<Course> courseList){
        this.name = name;
        this.courseList = courseList;
        this.courseValue = this.courseList.size();
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return getName();
    }

    @Override
    public List<Course> getAllCourse() {
        return courseList;
    }
    
    static public List<Course> assignmentCourse(List<Course> coursesBlock){
        Random randomCourseValue = new Random();
        int courseNumber;// = randomCourseValue.nextInt(courses.size());
        //int courseValue = randomCourseValue.nextInt(courses.size());
        int courseValue = randomCourseValue.nextInt((4))+1;

        System.out.println("Назначенное количество курсов: "+courseValue);

        List<Course> selectedCourses = new ArrayList<>();
        //System.out.println(courseNumber);
        //System.out.println(courseValue);

        for(int i = 0; i < courseValue;i++){
            do {
                courseNumber = randomCourseValue.nextInt(coursesBlock.size());
                for (int j = 0; j < selectedCourses.size(); j++) {
                    //courseNumber = randomCourseValue.nextInt(coursesBlock.size());
                    if (coursesBlock.get(courseNumber).getName().intern() == selectedCourses.get(j).getName().intern()) {
                        courseNumber = -1;
                        break;
                    }
                }
            }while (courseNumber == -1);
            selectedCourses.add(coursesBlock.get(courseNumber));
            // System.out.println("Назначенные номер курса: "+ courseNumber);
        }
        return  selectedCourses;
    }
}
