package lesson4.task1;

public class ArrayCounter {
    private String string;
    private int value;
    public ArrayCounter(String string, int value){
        this.string = string;
        this.value = value;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
