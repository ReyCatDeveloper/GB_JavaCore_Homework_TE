package lesson5.task1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        File testCSV_forWrite = new File("src/main/resources/file.csv");
        FileOutputStream fileOutputStream = new FileOutputStream(testCSV_forWrite);

        String stringForWrite = "Тестовая запись в файл";
        fileOutputStream.write(stringForWrite.getBytes(StandardCharsets.UTF_8));
        fileOutputStream.close();
    }

}
