package com.zappgo.ashish.module1_demo.advices;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(NoSuchElementException.class)
//    public ResponseEntity<String> handleResourceNotFound (NoSuchElementException noSuchElementException) {
////        return new ResponseEntity<>("Resource not found !" , HttpStatus.NOT_FOUND);
//        return new ResponseEntity<>(noSuchElementException.getMessage() , HttpStatus.NOT_FOUND);
//    }


@ExceptionHandler(NoSuchElementException.class)
public ResponseEntity<ApiError> handleResourceNotFound (NoSuchElementException noSuchElementException) {
//        return new ResponseEntity<>("Resource not found !" , HttpStatus.NOT_FOUND);
    ApiError apiError = ApiError.builder().status(HttpStatus.NOT_FOUND).message(noSuchElementException.getMessage()).build();
    return new ResponseEntity<>(apiError ,  HttpStatus.NOT_FOUND);
}

}
