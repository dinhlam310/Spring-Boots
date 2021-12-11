package org.aibles.training.userservices.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class HandlerException {

    @ExceptionHandler (AbstractException.class)
    public ResponseEntity <String> handleCommonException(AbstractException e){
        return new ResponseEntity<>(e.getMessage(), e.getStatus());
    }

    @ExceptionHandler (MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidation (MethodArgumentNotValidException e){
        Map<String,String> m = new HashMap<>();
        for (ObjectError er : e.getBindingResult().getAllErrors()){
            m.put(((FieldError)er).getField(),er.getDefaultMessage());
        }
        return new ResponseEntity<> (m, HttpStatus.BAD_REQUEST);
    }
}

