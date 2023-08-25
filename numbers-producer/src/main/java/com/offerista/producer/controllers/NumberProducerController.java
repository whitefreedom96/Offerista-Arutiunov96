package com.offerista.producer.controllers;

import com.offerista.producer.services.NumberProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/numbers")
public class NumberProducerController {
    private final NumberProducerService numberProducerService;

    @Autowired
    public NumberProducerController(NumberProducerService numberProducerService) {
        this.numberProducerService = numberProducerService;
    }

    @PostMapping("/generated-batches")
    public ResponseEntity<String> generateNumberBatch() {
        numberProducerService.startGeneratingNumbers();
        return ResponseEntity.ok("Number batch generation triggered");
    }
}
