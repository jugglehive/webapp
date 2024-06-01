package com.jugglehive.backend.exception.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.jugglehive.backend.exception.ExceptionResponse;
import com.jugglehive.backend.exception.customExceptions.NoCharactersFoundException;

// Class to handle custom exceptions
@ControllerAdvice
public class CustomExceptionHandler {

    // NoCharactersFoundException handler
    @ExceptionHandler(NoCharactersFoundException.class)
    public final ResponseEntity<Object> handleNoCharactersFoundException(NoCharactersFoundException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setUserId(request.getParameter("USER_ID"));
        exceptionResponse.setStatus(HttpStatus.NOT_FOUND.value());
        exceptionResponse.setMessage(ex.getMessage());
        exceptionResponse.setDetails(request.getDescription(false));
        exceptionResponse.setExceptionClass(ex.getClass().getSimpleName());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

}