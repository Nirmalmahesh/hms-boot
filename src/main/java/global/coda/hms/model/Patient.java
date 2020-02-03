package global.coda.hms.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

/**
 * The type Patient.
 */
public final class Patient {
  private int patientId;
  private int userId;
  private String bloodGroup;
  private int weight;
  private int isActive;
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private Date createdTime;
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private Date updatedTime;
  private UserDetails userDetails;

  /**
   * Instantiates a new Patient.
   */
  public Patient() {
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

  @Override
  public String toString() {
    return "Patient{"
            + "patientId=" + patientId
            + ", userId=" + userId
            + ", bloodGroup='" + bloodGroup + '\''
            + ", weight=" + weight
            + ", isActive=" + isActive
            + ", createdTime=" + createdTime
            + ", updatedTime=" + updatedTime
            + ", userDetails=" + userDetails
            + '}';
  }

  /**
   * Gets patient id.
   *
   * @return the patient id
   */
  public int getPatientId() {
    return patientId;
  }

  /**
   * Sets patient id.
   *
   * @param patientId the patient id
   */
  public void setPatientId(int patientId) {
    this.patientId = patientId;
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
   * Gets blood group.
   *
   * @return the blood group
   */
  public String getBloodGroup() {
    return bloodGroup;
  }

  /**
   * Sets blood group.
   *
   * @param bloodGroup the blood group
   */
  public void setBloodGroup(String bloodGroup) {
    this.bloodGroup = bloodGroup;
  }

  /**
   * Gets weight.
   *
   * @return the weight
   */
  public int getWeight() {
    return weight;
  }

  /**
   * Sets weight.
   *
   * @param weight the weight
   */
  public void setWeight(int weight) {
    this.weight = weight;
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
}
