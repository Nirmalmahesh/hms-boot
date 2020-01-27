package global.coda.hms.exception.handler;

import global.coda.hms.constant.ApplicationConstant;
import global.coda.hms.exception.SystemException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * The type System exception handler.
 */
@ControllerAdvice
public class SystemExceptionHandler {
  private final Logger LOGGER = LogManager.getLogger(SystemExceptionHandler.class);

  /**
   * Exception response entity.
   *
   * @param exception the exception
   * @return the response entity
   */
  @ExceptionHandler(value = SystemException.class)
  public ResponseEntity<?> exception(SystemException exception) {
    LOGGER.error(exception.getMessage());
    return new ResponseEntity<>(ApplicationConstant.WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
  }

}
