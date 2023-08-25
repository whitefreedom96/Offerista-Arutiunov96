package com.offerista.consumer.tools.csv;

import java.io.FileWriter;
import java.io.IOException;

public class CSVHelper {
    public static void saveNumberToCsv(int number, String path) {
        try (FileWriter csvWriter = new FileWriter(path, true)) {
            csvWriter.append(String.valueOf(number));
            csvWriter.append(",");
            csvWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
