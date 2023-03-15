package lesson9;

public class GeekCourse implements Course{
    String name;
    public GeekCourse(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return "\""+getName()+"\"";
    }

}
