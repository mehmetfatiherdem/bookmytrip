package com.virtuous.bookmytripuserservice.exception;

import com.virtuous.bookmytripuserservice.dto.response.GenericResponse;
import com.virtuous.bookmytripuserservice.service.KafkaProducerService;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public GenericResponse handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return GenericResponse.failed(errors);
    }
}
