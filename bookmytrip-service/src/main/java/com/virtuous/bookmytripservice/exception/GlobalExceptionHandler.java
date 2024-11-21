package com.virtuous.bookmytripservice.exception;

import com.virtuous.bookmytripservice.dto.response.GenericResponse;
import com.virtuous.bookmytripservice.service.KafkaProducerService;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final KafkaProducerService kafkaProducerService;

    public GlobalExceptionHandler(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @ExceptionHandler(BookMyTripException.class)
    public GenericResponse handleBookMyTripException(Exception ex){
        // Send the exception details to Kafka
        kafkaProducerService.sendException(ex.getMessage());

        // Optionally return a generic error response
        return GenericResponse.failed("An error occurred: " + ex.getMessage());
    }
}
