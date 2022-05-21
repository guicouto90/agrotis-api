package com.agrotis.apitest.exceptions;

import java.util.Date;

import javax.persistence.EntityExistsException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizeResponseExceptionHandler extends ResponseEntityExceptionHandler{
  
  @ExceptionHandler(Exception.class)
  public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
    ExceptionResponse exceptionResponse = 
      new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public final ResponseEntity<ExceptionResponse> handleNotFound(Exception ex, WebRequest request) {
    ExceptionResponse exceptionResponse = 
      new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(StringIndexOutOfBoundsException.class)
  public final ResponseEntity<ExceptionResponse> handleCnpj(Exception ex, WebRequest request) {
    ExceptionResponse exceptionResponse = 
      new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(EntityExistsException.class)
  public final ResponseEntity<ExceptionResponse> handleDuplicated(Exception ex, WebRequest request) {
    ExceptionResponse exceptionResponse = 
      new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);
  }

}


//REF: https://www.youtube.com/watch?v=IKkr-GbObAQ
