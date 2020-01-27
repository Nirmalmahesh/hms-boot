package global.coda.hms.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * The type User details.
 */
public class UserDetails {
  private int userId;
  private String username;
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String password;
  private int roleId;
  private String firstName;
  private String lastName;
  private String city;
  private String state;
  private int isActive;
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private Date createdTime;
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private Date updatedTime;
  private String phoneNumber;


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
   * Gets username.
   *
   * @return the username
   */
  public String getUsername() {
    return username;
  }

  /**
   * Sets username.
   *
   * @param username the username
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * Gets password.
   *
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * Sets password.
   *
   * @param password the password
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Gets role id.
   *
   * @return the role id
   */
  public int getRoleId() {
    return roleId;
  }

  /**
   * Sets role id.
   *
   * @param roleId the role id
   */
  public void setRoleId(int roleId) {
    this.roleId = roleId;
  }

  /**
   * Gets firstname.
   *
   * @return the firstname
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Sets firstname.
   *
   * @param firstName the firstname
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Gets lastname.
   *
   * @return the lastname
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Sets lastname.
   *
   * @param lastName the lastname
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Gets city.
   *
   * @return the city
   */
  public String getCity() {
    return city;
  }

  /**
   * Sets city.
   *
   * @param city the city
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * Gets state.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * Sets state.
   *
   * @param state the state
   */
  public void setState(String state) {
    this.state = state;
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

  @Override
  public String toString() {
    return "UserDetails{"
            + "userId=" + userId
            + ", username='" + username + '\''
            + ", password='" + password + '\''
            + ", roleId=" + roleId
            + ", firstname='" + firstName + '\''
            + ", lastname='" + lastName + '\''
            + ", city='" + city + '\''
            + ", state='" + state + '\''
            + ", isActive=" + isActive
            + ", createdTime=" + createdTime
            + ", updatedTime=" + updatedTime
            + ", phoneNumber='" + phoneNumber + '\''
            + '}';
  }

  /**
   * Gets phone number.
   *
   * @return the phone number
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * Sets phone number.
   *
   * @param phoneNumber the phone number
   */
  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  /**
   * Instantiates a new User details.
   */
  public UserDetails() {
  }


}
