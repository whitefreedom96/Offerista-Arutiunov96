package com.offerista.producer.services;

import com.offerista.producer.tools.csv.CSVHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class NumberProducerService {
    private static final Logger logger = LoggerFactory.getLogger(NumberProducerService.class);


    private final String csvFilePath = "boot/generated_numbers.csv";

    @Autowired
    private StreamBridge streamBridge;


    private final AtomicInteger generatedCount = new AtomicInteger(0);



        public void startGeneratingNumbers() {
            CSVHelper.clearCsvFile(csvFilePath);
        while (generatedCount.get() < 100) {
            generateAndSendBatchOfNumbers();
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    private void generateAndSendBatchOfNumbers() {
        int batchSize = 5;
        for (int i = 0; i < batchSize; i++) {
            if (generatedCount.get() >= 100) {
                return;
            }

            int randomNumber = generateRandomNumber();

            streamBridge.send("generaterandomnumbers-out-0", randomNumber);

            System.out.println("Sent " + randomNumber);
            CSVHelper.saveNumberToCsv(randomNumber, csvFilePath); // Save the number to CSV
            generatedCount.incrementAndGet();

        }
    }


    private int generateRandomNumber() {
        int min = 1;
        int max = 1000;
        return min + (int) (Math.random() * (max - min + 1));
    }


}
