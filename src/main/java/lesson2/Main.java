package lesson2;

public class Main {

    public static void main(String[] args) throws MyArraySizeExсeption, MyArrayDataException {
        receivingMassive_4x4(testMassive_4x4);

        /**
         Любой из следующих вызовов приведет к исключению.
        Раскамментировать и вызвать 1 из них
        **/
        //ошибка данных MyArrayDataException
        receivingMassive_4x4(testMassive_4x4_bugData);

        //ошибка размера строки массива MyArraySizeExсeption
        //receivingMassive_4x4(testBugMassive4x);

        //ошибка размера длины массива MyArraySizeExсeption
        //receivingMassive_4x4(testBugMassive_5x3);
    }


    //ОБЪЯВЛЕНИЕ МАССИВОВ
    static String[][] testMassive_4x4 = new String[][]{
            new String[]{"1","1","1","1"},
            new String[]{"1","1","1","1"},
            new String[]{"1","1","1","1"},
            new String[]{"1","1","1","1"}
    };

    static String[][] testMassive_4x4_bugData = new String[][]{
            new String[]{"1","1","1","1"},
            new String[]{"1","a","1","1"},
            new String[]{"","1","1","1"},
            new String[]{"1","1",".","1"}
    };

    static String[][] testBugMassive4x = new String[][]{
            new String[]{"","","",""},
            new String[]{"","",""},
            new String[]{"","","",""},
            new String[]{"","","",""}
    };

    static String[][] testBugMassive_5x3 = new String[][]{
            new String[]{"","","",""},
            new String[]{"","",""},
            new String[]{"","",""},
            new String[]{"","",""},
            new String[]{"","",""}
    };

    //МЕТОД ОБРАБОТКИ МАССИВОВ
    public static void receivingMassive_4x4(String[][] massive) throws MyArraySizeExсeption, MyArrayDataException{
        System.out.println("Обработка массива");
        if (massive.length == 4){
           for(int i = 0; i < massive.length; i++){
               if(massive[i].length != 4){
                   throw new MyArraySizeExсeption("Длина строки массива №"+i+" не = 4!");
               }
           }
       }else {
           throw new MyArraySizeExсeption("Длинна массива не 4!");
       }
       int massiveSum = 0;
        int processedCell = 0;
       for(int i = 0; i < massive.length; i++){
           for (int j = 0; j < massive[i].length; j++){
           //    int processedCell;
           //    processedCell = Integer.parseInt(massive[i][j]);
               try{
                   //int processedCell;
                   processedCell = Integer.parseInt(massive[i][j]);
               }catch (NumberFormatException nfe){
                    throw new MyArrayDataException("Ошибка: строка "+(i+1)+" ячейка "+(j+1)+" содержит неформатируемые данные.\n"+"Детали: \""+massive[i][j]+"\""+" невозможно привести к числу");
               }
               massiveSum += processedCell;
           }
       }
        System.out.printf("Массив обработан успешно\n");
        System.out.printf("Сумма массива = %s\n\n", massiveSum);
    }

}
