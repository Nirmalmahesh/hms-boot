package global.coda.hms.patient;

import global.coda.hms.model.Patient;
import global.coda.hms.model.UserDetails;

import java.util.concurrent.ThreadLocalRandom;

public class PatientConstant {
  public static Patient getMockPatient(){
    Patient newPatient = new Patient();
    UserDetails userDetails = new UserDetails();
    userDetails.setUsername(Integer.toString(ThreadLocalRandom.current().nextInt()));
    userDetails.setPassword("Password");
    userDetails.setRoleId(3);
    newPatient.setPatientId(ThreadLocalRandom.current().nextInt());
    newPatient.setUserDetails(userDetails);
    return newPatient;

  }


}
