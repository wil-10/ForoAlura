package com.forohub.infra.errores;


import org.springframework.http.ResponseEntity;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class TratadorDeErrores {
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity tratarError404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarError400(MethodArgumentNotValidException e){
        var errores = e.getFieldErrors().stream().map(ErrorValidacion::new).toList();
        return ResponseEntity.badRequest().body(errores);
    }
    private record ErrorValidacion(String campo, String error){
        public ErrorValidacion(FieldError error){
            this(error.getField(),error.getDefaultMessage());
        }

    }

}
