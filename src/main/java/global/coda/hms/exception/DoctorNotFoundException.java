package global.coda.hms.exception;

/**
 * The type Doctor not found exception.
 */
public class DoctorNotFoundException extends Exception {
  /**
   * Instantiates a new Doctor not found exception.
   *
   * @param errorMsg the error msg
   */
  public DoctorNotFoundException(String errorMsg) {
    super(errorMsg);
  }
}
