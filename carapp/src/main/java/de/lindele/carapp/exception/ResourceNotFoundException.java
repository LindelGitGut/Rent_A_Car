package de.lindele.carapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** Exception thrown when a resource is not found. */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

  /**
   * Constructor with message.
   *
   * @param message the message
   */
  public ResourceNotFoundException(String message) {
    super(message);
  }

  /**
   * Constructor with message and cause.
   *
   * @param message the message
   * @param cause the cause
   */
  public ResourceNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }
}
