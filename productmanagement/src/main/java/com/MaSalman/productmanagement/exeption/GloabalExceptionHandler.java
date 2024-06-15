package com.MaSalman.productmanagement.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GloabalExceptionHandler {

    @ExceptionHandler(ProductNotFoundExeption.class)
    public ResponseEntity<ErrorDetails> handleProductNotFoundException(ProductNotFoundExeption ex){
        ErrorDetails errorDetails = new ErrorDetails(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return new  ResponseEntity<>(errorDetails , HttpStatus.NOT_FOUND);
    }


}
