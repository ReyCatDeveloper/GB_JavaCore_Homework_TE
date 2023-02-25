package lesson4.task2;

public class Main {

    public static void main(String[] args) {

        TelephoneDirectory newTelephoneDirectory = new TelephoneDirectory();

        newTelephoneDirectory.add("surname1", 1231111111);
        newTelephoneDirectory.add("surname2", 1232222222);
        newTelephoneDirectory.add("surname3", 1233333333);
        newTelephoneDirectory.add("surname4", 1234444444);
        newTelephoneDirectory.add("surname1", 1235555555);
        newTelephoneDirectory.add("surname2", 1236666666);

        newTelephoneDirectory.get("surname1");
    }
}
