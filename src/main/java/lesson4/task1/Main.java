package lesson4.task1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String[] words = new String[]{
                "Водород",
                "Кислород",
                "Аммиак",
                "Кислород",
                "Натрий",
                "Водород",
                "Гелий",
                "Углекислый газ",
                "Азот",
                "Азот",
                "Аргон"
        };
        checkUniqueElement(words);
    }
    static void checkUniqueElement(String[] testArray){
        ArrayList<ArrayCounter> uniqueArray = new ArrayList<>();
        ArrayList<String> unique = new ArrayList<>();
        int currentPosition;
        String currentPositionString;
        int currentPositionCount;
        boolean isUniquePosition = true;
        //поочередно принимаем решение по каждому элементу в списке
        for (int i = 0; i < testArray.length; i++) {
            currentPosition = i;
            currentPositionCount = 0;
            isUniquePosition = true;
            //сверяем текущий элемент массива со списком найденных уникальных значений
            for (int j = 0; j < unique.size(); j++) {
                //если такое значение уже встречалось, то нет смысла продолжать операцию
                if (testArray[i].intern() == unique.get(j).intern()) {
                    isUniquePosition = false;
                }
            }
            if (isUniquePosition == true) {
                //для начала дополним список уникальных значений
                unique.add(testArray[i]);
                currentPositionString = testArray[i];
                //далее подсчитаем сколько раз встречается это значение
                for (int iPosition = currentPosition; iPosition < testArray.length; iPosition++) {
                    if (testArray[currentPosition].intern() == testArray[iPosition].intern()) {
                        currentPositionCount++;
                    }
                }
                uniqueArray.add(new ArrayCounter(currentPositionString, currentPositionCount));
            }
        }
        System.out.println("Количество  позиций  списка: " + testArray.length);
        System.out.println("Уникальных позиций в списке " + uniqueArray.size() + ":");
        for (int iprint = 0; iprint < uniqueArray.size(); iprint++){
            System.out.printf("%s (%s)\n", uniqueArray.get(iprint).getString(), uniqueArray.get(iprint).getValue());
        }
    }

}
