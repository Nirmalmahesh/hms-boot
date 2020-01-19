package global.coda.hms.exception;

/**
 * The type Patient not found exception.
 */
public class PatientNotFoundException extends Exception {
  /**
   * Instantiates a new Patient not found exception.
   *
   * @param errorMsg the error msg
   */
  public PatientNotFoundException(String errorMsg) {
    super(errorMsg);
  }
}
