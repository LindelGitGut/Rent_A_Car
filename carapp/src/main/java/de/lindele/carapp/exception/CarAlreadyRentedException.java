package de.lindele.carapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class CarAlreadyRentedException extends RuntimeException {
  public CarAlreadyRentedException(String message) {
    super(message);
  }

  public CarAlreadyRentedException(String message, Throwable cause) {
    super(message, cause);
  }
}
