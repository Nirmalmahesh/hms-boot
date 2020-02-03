package global.coda.hms.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Doctor model .
 *
 * @author Nirmalmahesh
 */
public final class Doctor {
  private int doctorId;
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private int userId;
  private String doctorSpecialization;
  private int isActive;
  private Date createdTime;
  private Date updatedTime;
  /**
   * The User details.
   */
  private UserDetails userDetails;

  /**
   * Instantiates a new Doctor.
   */
  public Doctor() {

  }

  @Override
  public String toString() {
    return "Doctor{"
            + "doctorId=" + doctorId
            + ", userId=" + userId
            + ", doctorSpecialization='" + doctorSpecialization + '\''
            + ", isActive=" + isActive
            + ", createdTime=" + createdTime
            + ", updatedTime=" + updatedTime
            + ", userDetails=" + userDetails
            + '}';
  }

  /**
   * Gets user details.
   *
   * @return the user details
   */
  public UserDetails getUserDetails() {
    return userDetails;
  }

  /**
   * Sets user details.
   *
   * @param userDetails the user details
   */
  public void setUserDetails(UserDetails userDetails) {
    this.userDetails = userDetails;
  }

  /**
   * Gets user id.
   *
   * @return the user id
   */
  public int getUserId() {
    return userId;
  }

  /**
   * Sets user id.
   *
   * @param userId the user id
   */
  public void setUserId(int userId) {
    this.userId = userId;
  }

  /**
   * Gets doctor specialization.
   *
   * @return the doctor specialization
   */
  public String getDoctorSpecialization() {
    return doctorSpecialization;
  }

  /**
   * Sets doctor specialization.
   *
   * @param doctorSpecialization the doctor specialization
   */
  public void setDoctorSpecialization(String doctorSpecialization) {
    this.doctorSpecialization = doctorSpecialization;
  }

  /**
   * Gets is active.
   *
   * @return the is active
   */
  public int getIsActive() {
    return isActive;
  }

  /**
   * Sets is active.
   *
   * @param isActive the is active
   */
  public void setIsActive(int isActive) {
    this.isActive = isActive;
  }

  /**
   * Gets created time.
   *
   * @return the created time
   */
  public Date getCreatedTime() {
    return createdTime;
  }

  /**
   * Sets created time.
   *
   * @param createdTime the created time
   */
  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  /**
   * Gets updated time.
   *
   * @return the updated time
   */
  public Date getUpdatedTime() {
    return updatedTime;
  }

  /**
   * Sets updated time.
   *
   * @param updatedTime the updated time
   */
  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  /**
   * Gets doctor id.
   *
   * @return the doctor id
   */
  public int getDoctorId() {
    return doctorId;
  }

  /**
   * Sets doctor id.
   *
   * @param doctorId the doctor id
   */
  public void setDoctorId(int doctorId) {
    this.doctorId = doctorId;
  }
}
