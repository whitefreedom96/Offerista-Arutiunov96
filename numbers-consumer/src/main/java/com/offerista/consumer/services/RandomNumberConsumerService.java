package com.offerista.consumer.services;

import com.offerista.consumer.tools.csv.CSVHelper;
import org.apache.commons.math3.primes.Primes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class RandomNumberConsumerService {
    private static final Logger logger = LoggerFactory.getLogger(RandomNumberConsumerService.class);

    private final String csvFilePathT = "boot/received_prime_numbers.csv";

    @Bean
    public Consumer<Integer> readRandomNumbers() {
        return value -> {
            logger.info("Receiving: " + value);
            if (Primes.isPrime(value)) {
                logger.info(value + " is a prime. Saving to the csv...");
                CSVHelper.saveNumberToCsv(value, csvFilePathT);
            }
        };
    }


}