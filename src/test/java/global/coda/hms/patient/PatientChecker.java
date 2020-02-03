package global.coda.hms.patient;

import global.coda.hms.exception.BusinessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.model.Patient;
import global.coda.hms.model.UserDetails;
import global.coda.hms.service.PatientService;
import io.jsonwebtoken.lang.Assert;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.constraints.AssertTrue;


@SpringBootTest
public class PatientChecker {
  @Autowired
  private PatientService patientService;
  private static Patient tempPatient;

  @BeforeAll
  public static void assignTempPatient() {
    tempPatient = PatientConstant.getMockPatient();
  }


  @Test
  public void checkCreate() {
    try {
      Patient createdPatient = patientService.createPatient(tempPatient);
      tempPatient.setPatientId(createdPatient.getPatientId());
      assertEquals(tempPatient.getUserDetails().getUsername(),createdPatient.getUserDetails().getUsername());
    } catch (BusinessException e) {
      fail(e.getMessage());
    } catch (SystemException e) {
      fail(e.getMessage());
    }

  }

  @Test
  public void checkRead(){
    try {
      Patient patient = patientService.readPatient(tempPatient.getPatientId());
      assertEquals(patient.getUserDetails().getUsername(),tempPatient.getUserDetails().getUsername());
    } catch (BusinessException e) {
      fail(e.toString());
    } catch (SystemException e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void updatePatient(){
    UserDetails userDetails = tempPatient.getUserDetails();
    userDetails.setFirstName("Changed");
    tempPatient.setUserDetails(userDetails);
    try {
      Patient updatedPatient =  patientService.updatePatient(tempPatient);
      assertEquals(updatedPatient.getUserDetails().getUsername(),tempPatient.getUserDetails().getUsername());
    } catch (BusinessException e) {
      fail(e.getMessage());
    } catch (SystemException e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void deletePatient(){
    try {
      assertTrue(patientService.deletePatient(tempPatient.getPatientId()));
    } catch (BusinessException e) {
      fail(e.getMessage());
    } catch (SystemException e) {
      fail(e.getMessage());
    }
  }

}
