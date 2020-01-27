package global.coda.hms.exception.handler;

import global.coda.hms.exception.BusinessException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * The type Business exception handler.
 */
@ControllerAdvice
public class BusinessExceptionHandler {

  private final Logger LOGGER = LogManager.getLogger(BusinessExceptionHandler.class);

  /**
   * Exception response entity.
   *
   * @param exception the exception
   * @return the response entity
   */
  @ExceptionHandler(value = BusinessException.class)
  public ResponseEntity<?> exception(BusinessException exception) {
    return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
