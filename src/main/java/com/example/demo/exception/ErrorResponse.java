package com.example.demo.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ErrorResponse {
  @JsonProperty("errorCode")
  private Integer responseCode;

  @JsonProperty("errorMessage")
  private String errorMessage;

  @JsonProperty("timestamp")
  private Instant timestamp;
}
