package com.example.bookshopapp.controller;

import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException e) {
        String errorMessages = e.getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining("; "));
        return new ResponseEntity<>(
                Map.of("success", false, "message", errorMessages), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    private ResponseEntity<?> handleExceptions(Exception e) {
        return new ResponseEntity<>(
                Map.of("success", false, "message", e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
