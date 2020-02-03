package global.coda.hms.model;


import java.util.List;

/**
 * The type Doctor patient mapper.
 */
public class DoctorPatientMapper {
  /**
   * The Doctor.
   */
  Doctor doctor;
  /**
   * The Patient.
   */
  List<Patient> patient;

  /**
   * Instantiates a new Doctor patient mapper.
   */
  public DoctorPatientMapper() {
  }

  /**
   * Gets doctor.
   *
   * @return the doctor
   */
  public Doctor getDoctor() {
    return doctor;
  }

  /**
   * Sets doctor.
   *
   * @param doctor the doctor
   */
  public void setDoctor(Doctor doctor) {
    this.doctor = doctor;
  }

  /**
   * Gets patient.
   *
   * @return the patient
   */
  public List<Patient> getPatient() {
    return patient;
  }

  /**
   * Sets patient.
   *
   * @param patient the patient
   */
  public void setPatient(List<Patient> patient) {
    this.patient = patient;
  }
}
