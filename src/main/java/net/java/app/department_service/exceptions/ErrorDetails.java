package net.java.app.department_service.exceptions;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
  private LocalDateTime timestamp;
  private String message;
  private String path;
  private String errorCode;
}
