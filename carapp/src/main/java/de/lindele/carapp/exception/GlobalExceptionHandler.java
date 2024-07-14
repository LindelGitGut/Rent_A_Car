package de.lindele.carapp.exception;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/** Global exception handler. */
@ControllerAdvice
public class GlobalExceptionHandler {

  /**
   * Handles a resource not found exception.
   *
   * @param ex the exception
   * @param request the request
   * @return the response entity
   */
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<?> handleResourceNotFoundException(
      ResourceNotFoundException ex, WebRequest request) {
    ErrorDetails errorDetails =
        new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
  }

  /**
   * Handles a car already rented exception.
   *
   * @param ex the exception
   * @param request the request
   * @return the response entity
   */
  @ExceptionHandler(CarAlreadyRentedException.class)
  public ResponseEntity<?> handleCarAlreadyRentedException(
      CarAlreadyRentedException ex, WebRequest request) {
    ErrorDetails errorDetails =
        new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
  }

  /**
   * Handles a car not available exception.
   *
   * @param ex the exception
   * @param request the request
   * @return the response entity
   */

  // Beispiel für das Handhaben einer allgemeinen Ausnahme
  @ExceptionHandler(Exception.class)
  public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request) {
    ErrorDetails errorDetails =
        new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  // Weitere Exception-Handler-Methoden können hier hinzugefügt werden
}
