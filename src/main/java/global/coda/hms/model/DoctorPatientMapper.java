package global.coda.hms.model;


import java.util.ArrayList;
import java.util.List;

public class DoctorPatientMapper {
  Doctor doctor;
  List<Patient> patient = new ArrayList<Patient>();

  public DoctorPatientMapper() {
  }

  public Doctor getDoctor() {
    return doctor;
  }

  public void setDoctor(Doctor doctor) {
    this.doctor = doctor;
  }

  public List<Patient> getPatient() {
    return patient;
  }

  public void setPatient(List<Patient> patients) {
    patients.addAll(patients);
  }

}
