package com.desafio.apirest.controller;

import java.util.NoSuchElementException;

import com.desafio.apirest.model.ErrorResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler
    protected ResponseEntity<ErrorResponse> handleException(NoSuchElementException exc) {
        String codigo = "PRODUCTO_NO_EXISTE";
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        return buildResponseEntity(codigo, httpStatus,
                new RuntimeException("El producto (id=" + exc.getMessage() + ") no existe"));
    }

    @ExceptionHandler
    protected ResponseEntity<ErrorResponse> handleException(Exception exc) {
        String codigo = "ERROR_DESCONOCIDO";
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        return buildResponseEntity(codigo, httpStatus,
                new RuntimeException("Se produjo un error desconocido"));
    }

    private ResponseEntity<ErrorResponse> buildResponseEntity(String codigo, HttpStatus httpStatus, Exception exc) {
        ErrorResponse error = new ErrorResponse(codigo, exc.getMessage());
        return new ResponseEntity<>(error, httpStatus);
    }
}
