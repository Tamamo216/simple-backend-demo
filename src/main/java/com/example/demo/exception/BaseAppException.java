package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BaseAppException extends RuntimeException {
  protected Integer responseCode = 500;
  protected String errorMessage;
  protected Instant timestamp = Instant.now();

  public BaseAppException(String message) {
      super(message);
      errorMessage = message;
  }

  public BaseAppException(String message, Throwable cause) {
      super(message, cause);
      errorMessage = message;
  }
}
