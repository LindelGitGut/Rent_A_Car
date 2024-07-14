package de.lindele.carapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** Exception thrown when a car is already rented. */
@ResponseStatus(value = HttpStatus.CONFLICT)
public class CarAlreadyRentedException extends RuntimeException {

  /**
   * Constructor with message.
   *
   * @param message the message
   */
  public CarAlreadyRentedException(String message) {
    super(message);
  }

  /**
   * Constructor with message and cause.
   *
   * @param message the message
   * @param cause the cause
   */
  public CarAlreadyRentedException(String message, Throwable cause) {
    super(message, cause);
  }
}
