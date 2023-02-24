package lesson3.task2;

public class Main {

    public static void main(String[] args) {

        Box<Orange> currentBox = new Box<>();
        System.out.println("вес пустой коробки");
        currentBox.getWeight();
        currentBox.putInBox(new Orange());
        System.out.println("вес коробки с одним апельсином");
        currentBox.getWeight();
        currentBox.putInBox(new Orange(),3);
        System.out.println("вес коробки с 1+3 апельсинами");
        currentBox.getWeight();

        Box<Apple> newAppleBox = new Box<>();
        newAppleBox.putInBox(new Apple(),4);
        System.out.println("вес новой коробки с яблоками");
        newAppleBox.getWeight();

        currentBox.compare(newAppleBox);

        Box<Orange> newOrangeBox = new Box<>();
        newOrangeBox.putInBox(new Orange(),4);
        System.out.println("вес новой коробки с апельсинаями");
        newOrangeBox.getWeight();

        currentBox.compare(newOrangeBox);

        System.out.println("переложили апельсины из первой коробки в новую");
        currentBox.transfer(newOrangeBox);
        currentBox.getWeight();
        newOrangeBox.getWeight();

    }

}
