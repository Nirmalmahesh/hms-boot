package global.coda.hms.controller;

import global.coda.hms.exception.BusinessException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.model.Doctor;
import global.coda.hms.model.DoctorPatientMapper;
import global.coda.hms.service.DoctorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Doctor controller.
 */
@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

  private final Logger LOGGER = LogManager.getLogger(DoctorController.class);

  /**
   * The Doctor service.
   */
  @Autowired
  DoctorService doctorService;

  /**
   * Create patient response entity.
   *
   * @param doctor the doctor
   * @return the response entity
   * @throws BusinessException the business exception
   * @throws SystemException   the system exception
   */
  @PostMapping("/")
  public ResponseEntity<?> createPatient(@RequestBody Doctor doctor) throws BusinessException,
          SystemException {
    LOGGER.traceEntry(doctor.toString());
    Doctor newDoctor = doctorService.createDoctor(doctor);
    LOGGER.traceExit(newDoctor);
    return new ResponseEntity<>(newDoctor, HttpStatus.OK);
  }


  /**
   * Read doctor response entity.
   *
   * @param doctorId the doctor id
   * @return the response entity
   * @throws BusinessException the business exception
   * @throws SystemException   the system exception
   */
  @GetMapping("/{doctorId}")
  public ResponseEntity<?> readDoctor(@PathVariable("doctorId") int doctorId) throws BusinessException, SystemException {
    LOGGER.traceEntry(Integer.toString(doctorId));
    Doctor doctor = doctorService.readDoctor(doctorId);
    LOGGER.traceExit(doctor);
    return new ResponseEntity<>(doctor, HttpStatus.OK);
  }

  /**
   * Update doctor response entity.
   *
   * @param doctor the doctor
   * @return the response entity
   * @throws BusinessException the business exception
   * @throws SystemException   the system exception
   */
  @PutMapping("/")
  public ResponseEntity<?> updateDoctor(@RequestBody Doctor doctor) throws BusinessException,
          SystemException {
    LOGGER.traceEntry(doctor.toString());
    Doctor updatedDoctor = doctorService.updateDoctor(doctor);
    LOGGER.traceExit(updatedDoctor.toString());
    return new ResponseEntity<>(updatedDoctor, HttpStatus.OK);
  }

  /**
   * Delete doctor response entity.
   *
   * @param doctorId the doctor id
   * @return the response entity
   * @throws BusinessException the business exception
   * @throws SystemException   the system exception
   */
  @DeleteMapping("/{doctorId}")
  public ResponseEntity<?> deleteDoctor(@PathVariable int doctorId) throws BusinessException,
          SystemException {
    LOGGER.traceEntry(Integer.toString(doctorId));
    boolean isDoctorDeleted = doctorService.deleteDoctor
            (doctorId);
    LOGGER.traceExit(isDoctorDeleted);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @GetMapping("/{doctorId}/patients")
  public ResponseEntity<?> getAllPatientsOfDoctor(@PathVariable int doctorId) throws BusinessException, SystemException {
    LOGGER.traceEntry(Integer.toString(doctorId));
    DoctorPatientMapper doctorPatientMapper = doctorService.getAllPatientsOfDoctor(doctorId);
    return new ResponseEntity<>(doctorPatientMapper, HttpStatus.OK);
  }
}
