package com.example.crudtesting.advice;

import com.example.crudtesting.exception.EmptyInputException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException ){
        System.out.println(emptyInputException.getErrorMessage() + ": ");
        return new ResponseEntity<>(emptyInputException.getErrorMessage() + ": " + emptyInputException.getErrorCode(), HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleWrongInput(MethodArgumentNotValidException ex){
        Map<String, String> responseMap = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            responseMap.put(error.getField(), error.getDefaultMessage());
         });

        return  responseMap;
    }

}
