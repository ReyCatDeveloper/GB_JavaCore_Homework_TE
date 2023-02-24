package lesson3.task1;

public class Main {

    public static TestClass[] rearrangingElement(TestClass[] editableArray, int numberForRearranging1, int numberForRearranging2){
        TestClass[] newMassive = new TestClass[editableArray.length];
        for(int i = 0; i < editableArray.length; i++){
            if(i == numberForRearranging1){
                newMassive[i] = editableArray[numberForRearranging2];
            }else if(i == numberForRearranging2){
                newMassive[i] = editableArray[numberForRearranging1];
            }else  {
                newMassive[i] = editableArray[i];
            }
        }
        return newMassive;
    }




}
