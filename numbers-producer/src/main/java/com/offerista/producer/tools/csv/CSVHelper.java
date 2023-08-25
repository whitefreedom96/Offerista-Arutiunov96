package com.offerista.producer.tools.csv;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CSVHelper {
    public static void clearCsvFile(String path) {
        try (PrintWriter writer = new PrintWriter(path)) {
            writer.print("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
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
