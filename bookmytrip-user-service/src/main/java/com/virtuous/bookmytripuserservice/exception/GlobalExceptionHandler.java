package com.virtuous.bookmytripuserservice.exception;

import com.virtuous.bookmytripuserservice.dto.response.GenericResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookMyTripException.class)
    public GenericResponse handleBlogHubException(BookMyTripException bookMyTripException){
        return GenericResponse.failed(bookMyTripException.getMessage());
    }
}
