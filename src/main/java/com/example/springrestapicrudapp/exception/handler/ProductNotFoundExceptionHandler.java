package com.example.springrestapicrudapp.exception.handler;

import com.example.springrestapicrudapp.exception.ProductNotFoundException;
import com.example.springrestapicrudapp.exception.response.ProductErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// you can use @Hidden to hide controllerAdvice from docs or swagger or use swagger 2.7 version
@ControllerAdvice
public class ProductNotFoundExceptionHandler {
   @ExceptionHandler
   public ResponseEntity<ProductErrorResponse> productNotFound(ProductNotFoundException exception){
       ProductErrorResponse response = new ProductErrorResponse();
       response.setCode(HttpStatus.NOT_FOUND.value());
       response.setMessage(exception.getMessage());
       response.setTimeStamp(System.currentTimeMillis());
       return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
   }
}
