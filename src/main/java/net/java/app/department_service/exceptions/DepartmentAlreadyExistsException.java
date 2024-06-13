package net.java.app.department_service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DepartmentAlreadyExistsException extends RuntimeException {
  public DepartmentAlreadyExistsException(String message) {
    super(message);
  }
}
