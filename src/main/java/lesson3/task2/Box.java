package lesson3.task2;

import java.util.ArrayList;

public class Box <T extends Fruit> {

    ArrayList<T> value;
    double weightBox = 0.5;
    double weightNet = 0;
    double weightGross;

    public Box(){
        this.weightGross = this.weightBox;
        this.value = new ArrayList<T>();
    }

    public double getWeight(){
        if(value.size() == 0){
            weightNet = 0;
        }else {
            weightNet = value.get(0).weight * value.size();
        }
 //       weightNet = type.weight * value.size();
        weightGross = weightNet + weightBox;
        System.out.println("weightNet = " + weightNet);
        System.out.println("weightGross = " + weightGross);
        System.out.println();
        return weightNet;
    }

    public void putInBox(T t){
        value.add(t);
        weightNet += t.weight;
        weightGross += t.weight;
    }
    public void putInBox(T t, int fruitValue){

        for(int i = 0; i < fruitValue; i ++ ){
        value.add(t);
        weightNet += t.weight;
        weightGross += t.weight;
        }
    }

    public Boolean compare(Box boxForCompare){
        if(this.weightGross == boxForCompare.weightGross){
            System.out.println(true);
            return true;
        }
        System.out.println(false);
        return false;
    }

    public void transfer (Box<T> targetBox){
        for (int i = 0; i < value.size(); i ++){
            targetBox.value.add(this.value.get(i));
        }
        this.value.clear();
    }
}
