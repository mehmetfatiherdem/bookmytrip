package com.virtuous.bookmytripgw.exception;

import com.virtuous.bookmytripgw.dto.response.GenericResponse;
import com.virtuous.bookmytripgw.service.KafkaProducerService;
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
