package com.virtuous.bookmytripservice.exception;

import com.virtuous.bookmytripservice.dto.response.GenericResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookMyTripException.class)
    public GenericResponse handleBookMyTripException(BookMyTripException bookMyTripException){
        return GenericResponse.failed(bookMyTripException.getMessage());
    }
}
