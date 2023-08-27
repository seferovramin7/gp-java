package com.demo.gpapp.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericExceptions(Exception ex,
                                                                 WebRequest webRequest) {

        HttpStatus errorCode = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorResponse errorResponse =
                new ErrorResponse("Could not be able to reach to the server.");
        log.error("Could not be able to reach to the server :  ==> {}", ex.getMessage());

        return new ResponseEntity<>(errorResponse, errorCode);
    }
}

