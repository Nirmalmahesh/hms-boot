package global.coda.hms.constant;

/**
 * Global constants for an application .
 */
public final class ApplicationConstant {

  /**
   * The constant RESOURCE_FILE.
   */
  public static final String RESOURCE_FILE = "user/userMessages";
  /**
   * The constant USER_NOT_FOUND.
   */
  public static final String USER_NOT_FOUND = "USER NOT FOUND!!!";
  /**
   * The constant PATIENT_NOT_FOUND.
   */
  public static final String PATIENT_NOT_FOUND = "PATIENT NOT FOUND!!!";
  /**
   * The constant DOCTOR_NOT_FOUND.
   */
  public static final String DOCTOR_NOT_FOUND = "DOCTOR_NOT_FOUND!!!";
  /**
   * The constant EXPECTED_INTEGER.
   */
  public static final String EXPECTED_INTEGER = "Expected Integer Input only";

  /**
   * The constant HOSPITAL_NOT_FOUND.
   */
  public static final String HOSPITAL_NOT_FOUND = "HOSPITAL NOT FOUND!!!";
  /**
   * The constant LOGIN_AGAIN.
   */
  public static final String LOGIN_AGAIN = "Login failed, try again!!";
  /**
   * The constant PATIENT_ASSIGN_FAILED.
   */
  public static final String PATIENT_ASSIGN_FAILED = "Unable Assign patient to a doctor!!!";
  /**
   * The constant NO_PATIENT_FOUND_FOR_DOCTOR.
   */
  public static final String NO_PATIENT_FOUND_FOR_DOCTOR = "Doctor didn't have any patient";
  /**
   * The constant NO_RECORD_FOUND.
   */
  public static final String NO_RECORD_FOUND = "No Data Found !!";
  /**
   * The constant WENT_WRONG.
   */
  public static final String WENT_WRONG = "Something Went Wrong!!!";
  /**
   * The constant USERNAME_NOT_AVAILABLE.
   */
  public static final String USERNAME_NOT_AVAILABLE = "Username Not Available";
  /**
   * The constant REQUIRED_ALL_FIELDS.
   */
  public static final String REQUIRED_ALL_FIELDS = "Please provide all fields";
  /**
   * The constant DOCTOR_NOT_DELETED.
   */
  public static final String DOCTOR_NOT_DELETED = "Failed to delete Doctor";
  /**
   * The constant USER_NOT_DELETED.
   */
  public static final String USER_NOT_DELETED = "Failed to delete User";
  /**
   * The constant PATIENT_NOT_DELETED.
   */
  public static final String PATIENT_NOT_DELETED = "Failed to delete Patient";

  /**
   * Constructor .
   */
  private ApplicationConstant() {
  }

  /**
   * Role of an users .
   */
  public enum ROLE {
    /**
     * Admin role.
     */
    ADMIN,
    /**
     * Global admin role.
     */
    GLOBAL_ADMIN,
    /**
     * Patient role.
     */
    PATIENT,
    /**
     * Doctor role.
     */
    DOCTOR
  }
}
