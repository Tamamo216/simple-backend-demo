package com.example.demo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(BaseAppException.class)
  public ResponseEntity<ErrorResponse> handleBaseAppException(BaseAppException ex) {
    ErrorResponse errorResponse = ErrorResponse.builder()
      .responseCode(ex.getResponseCode())
      .errorMessage(ex.getErrorMessage())
      .timestamp(ex.getTimestamp())
      .build();
    return ResponseEntity.status(errorResponse.getResponseCode()).body(errorResponse);
  }
}
