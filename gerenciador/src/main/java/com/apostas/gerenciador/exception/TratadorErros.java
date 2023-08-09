package com.apostas.gerenciador.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorErros {

    @ExceptionHandler(ApostadorNaoEncontrado.class)
    public ResponseEntity<String> apostadorNaoEncontrado(ApostadorNaoEncontrado error){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error.getMensagem());
    }
}
