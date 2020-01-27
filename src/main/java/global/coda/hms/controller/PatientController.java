package global.coda.hms.controller;

import global.coda.hms.exception.BusinessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.model.Patient;
import global.coda.hms.service.PatientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Patient controller.
 */
@RestController
@RequestMapping("/api/patients")
@CrossOrigin
public class PatientController {

  /**
   * The Logger.
   */
  private final Logger LOGGER = LogManager.getLogger(PatientController.class);

  @Autowired
  private PatientService patientService;

  /**
   * Create patient response entity.
   *
   * @param patient the patient
   * @return the response entity
   * @throws SystemException   the system exception
   * @throws BusinessException the business exception
   */
  @PostMapping("/")
  public ResponseEntity<?> createPatient(@RequestBody Patient patient) throws SystemException,
          BusinessException {
    LOGGER.traceEntry(patient.toString());
    Patient newPatient = patientService.createPatient(patient);
    LOGGER.traceExit(newPatient.toString());
    return new ResponseEntity<Patient>(newPatient, HttpStatus.OK);
  }

  /**
   * Read patient response entity.
   *
   * @param patientId the patient id
   * @return the response entity
   * @throws BusinessException the business exception
   * @throws SystemException   the system exception
   */
  @GetMapping("/{patientId}")
  public ResponseEntity<?> readPatient(@PathVariable int patientId) throws BusinessException,
          SystemException {
    LOGGER.traceEntry(Integer.toString(patientId));
    Patient patient = patientService.readPatient(patientId);
    LOGGER.traceExit(patientId);
    return new ResponseEntity<>(patient, HttpStatus.OK);

  }


  /**
   * Read patient response entity.
   *
   * @return the response entity
   * @throws BusinessException the business exception
   * @throws SystemException   the system exception
   */
  @GetMapping("/")
  public ResponseEntity<?> readPatients() throws BusinessException,
          SystemException {
    LOGGER.traceEntry();
    List<Patient> patients = patientService.readPatients();
    LOGGER.traceExit(patients);
    return new ResponseEntity<>(patients, HttpStatus.OK);

  }

  /**
   * Update patient response entity.
   *
   * @param patient the patient
   * @return the response entity
   * @throws BusinessException the business exception
   * @throws SystemException   the system exception
   */
  @PutMapping("/")
  public ResponseEntity<?> updatePatient(@RequestBody Patient patient) throws BusinessException,
          SystemException {
    LOGGER.traceEntry(patient.toString());
    Patient updatedPatient = patientService.updatePatient(patient);
    LOGGER.traceExit(updatedPatient);
    return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
  }

  /**
   * Delete patient response entity.
   *
   * @param patientId the patient id
   * @return the response entity
   * @throws BusinessException the business exception
   * @throws SystemException   the system exception
   */
  @DeleteMapping("/{patientId}")
  public ResponseEntity<?> deletePatient(@PathVariable int patientId) throws BusinessException,
          SystemException {
    LOGGER.traceEntry(Integer.toString(patientId));
    boolean isDeleted = patientService.deletePatient(patientId);
    if (isDeleted) {
      LOGGER.traceExit(isDeleted);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
      LOGGER.traceExit(isDeleted);
      return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
  }


}
