package com.jchallak.BancoAzimov.controllers.handlers;

import com.jchallak.BancoAzimov.dtos.CustomError;
import com.jchallak.BancoAzimov.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        return new ResponseEntity<>(new CustomError(Instant.now(), HttpStatus.NOT_FOUND.value(), e.getMessage(), request.getRequestURI()),
                HttpStatus.NOT_FOUND);
    }


}
