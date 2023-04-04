package com.noobdev.dailyblog.dailyblog.exceptions;

import com.noobdev.dailyblog.dailyblog.payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException e)
    {
       String msg =  e.getMessage();
       ApiResponse apiResponse =  new ApiResponse(msg,false);
       return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        Map<String , String > response = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((err)-> {
           String msg  =  err.getDefaultMessage();
           String field = ((FieldError)err).getField();
           response.put( field, msg);

        });

                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }


}
