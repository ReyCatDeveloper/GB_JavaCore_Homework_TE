package lesson5.task2;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        File testCSV_forRead = new File("src/main/resources/testRead.csv");

        AppData importCSV = importCSV(testCSV_forRead, true);

        importCSV.showHeaders();
        importCSV.showData();
    }

    static AppData importCSV(File file, boolean headers) throws IOException {
        //инициализация переменных
        int i;
        int rowCounter = 0;
        int headerCounter = 0;
        String buffer = "";
        AppData importAppData;

        //запись из файла в служебный буфер
        FileInputStream fileInputStream2 = new FileInputStream(file);
        i = 0;
        do{
            i = fileInputStream2.read();
            if(i == -1){
                break;
            }
            buffer += "" + ((char) i);
        }while (i != -1);

        //ОПРЕДЕЛЕНИЕ РАЗМЕРА
        //разделить буфер на строки и определить число строк
        String[] bufferRowSplit = buffer.split("\n");
        if(headers == true){
            rowCounter = bufferRowSplit.length - 1;
        }
        System.out.println("число строк разделением: " + rowCounter);
        //определить число столбцов
        String[] headersSplit = bufferRowSplit[0].split(";");
            headerCounter = headersSplit.length;
        System.out.println("число заголовков разделением: " + headerCounter);

        //преобразование буфера в общий двумерный строковый массив
        String[][] bufferDivide = new String[rowCounter][headerCounter];
        for(int iRows = 0; iRows < rowCounter; iRows++){
        //    System.out.print("\nстрока "+iRows+": ");
            for(int iHeaders = 0; iHeaders < headerCounter; iHeaders++){
                bufferDivide[iRows][iHeaders] = bufferRowSplit[iRows].split(";")[iHeaders];
        //        System.out.print("элемент "+ iHeaders  +"("+bufferDivide[iRows][iHeaders]+")"+ "; ");
            }
        }

        //выделение табличной части в двумерный числовой массив
        int[][] importDataBody = new int[rowCounter - 1][headerCounter];
        for (int edbRow = 0; edbRow < importDataBody.length; edbRow++){
            for(int edbColumn = 0; edbColumn < importDataBody[edbRow].length; edbColumn++){
                importDataBody[edbRow][edbColumn] = Integer.parseInt(bufferDivide[edbRow+1][edbColumn]);
            }
        }

        //ФОРМИРОВАНИЕ ОБЪЕКТА ПЕРЕДАЧИ ДАННЫХ
        //построение шаблона данных
        importAppData = new AppData(headersSplit, importDataBody);

/*
            //передача заголовков в AppData
            importAppData.setHeader(headersSplit);
            //передача данных таблицы
            importAppData.setData(importDataBody);
*/

//  вывод буфера для просмотра в консоли (диагностика)
//        System.out.println("\nbuffer :\n" + buffer);

//  вывод буфера в числовом формате посимвольно (диагностика
/*
        FileInputStream fileInputStream4 = new FileInputStream(file);
        System.out.println("новый вывод");
        i = 0;
        while (i != -1){
            if(i == -1){
                break;
            }
            i = fileInputStream4.read();
            if(i == -1){
                break;
            }
            System.out.println(i);
        }

        System.out.println("конец");;
*/
        return importAppData;
    }
}
