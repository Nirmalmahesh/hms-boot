package global.coda.hms.service;

import global.coda.hms.constant.ApplicationConstant;
import global.coda.hms.exception.BusinessException;
import global.coda.hms.exception.DeletionFailedException;
import global.coda.hms.exception.PatientNotFoundException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.mapper.PatientMapper;
import global.coda.hms.mapper.UserMapper;
import global.coda.hms.model.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * The type Patient service.
 */
@Service
public class PatientService {
  private final Logger LOGGER = LogManager.getLogger(PatientService.class);
  /**
   * The User mapper.
   */
  @Autowired
  private UserMapper userMapper;
  /**
   * The Patient mapper.
   */
  @Autowired
  private PatientMapper patientMapper;

  /**
   * Create patient patient.
   *
   * @param patient the patient
   * @return the patient
   * @throws BusinessException the business exception
   * @throws SystemException   the system exception
   */
  public Patient createPatient(Patient patient) throws BusinessException, SystemException {
    LOGGER.traceEntry(patient.toString());
    userMapper.createUser(patient.getUserDetails());
    try {
      patient.setUserId(patient.getUserDetails().getUserId());
      patientMapper.createPatient(patient);

    } catch (DuplicateKeyException e) {
      LOGGER.traceExit(e.getMessage());
      throw new BusinessException(ApplicationConstant.USERNAME_NOT_AVAILABLE);
    } catch (DataIntegrityViolationException e) {
      LOGGER.traceExit(e.getMessage());
      throw new BusinessException(ApplicationConstant.REQUIRED_ALL_FIELDS);
    } catch (Exception e) {
      LOGGER.traceExit(e.getMessage());
      throw new SystemException(e);
    }
    LOGGER.traceExit(patient.toString());
    return patient;
  }

  /**
   * Read patient patient.
   *
   * @param patientId the patient id
   * @return the patient
   * @throws BusinessException the business exception
   * @throws SystemException   the system exception
   */
  public Patient readPatient(int patientId) throws BusinessException, SystemException {
    LOGGER.traceEntry(Integer.toString(patientId));
    Patient patient = patientMapper.readPatient(patientId);
    try {
      if (patient == null) {
        throw new PatientNotFoundException(ApplicationConstant.PATIENT_NOT_FOUND);
      } else {
        LOGGER.traceExit(patient);
        return patient;
      }
    } catch (PatientNotFoundException e) {
      LOGGER.traceExit(e.getMessage());
      throw new BusinessException(e.getMessage());
    } catch (Exception e) {
      LOGGER.traceExit(e.getMessage());
      throw new SystemException(e);
    }

  }


  /**
   * Update patient patient.
   *
   * @param patient the patient
   * @return the patient
   * @throws BusinessException the business exception
   * @throws SystemException   the system exception
   */
  public Patient updatePatient(Patient patient) throws BusinessException, SystemException {
    LOGGER.traceEntry(patient.toString());
    try {
      int userRowsAffected = userMapper.updateUser(patient.getUserDetails());
      int patientRowsAffected = patientMapper.updatePatient(patient);
      if (userRowsAffected == 1 && patientRowsAffected == 1) {
        return readPatient(patient.getPatientId());
      } else {
        throw new SystemException(new Exception(ApplicationConstant.WENT_WRONG));
      }
    } catch (SystemException e) {
      LOGGER.traceExit(e.getMessage());
      throw e;
    } catch (Exception e) {
      LOGGER.traceExit(e.getMessage());
      throw new SystemException(e);
    }
  }

  /**
   * Delete patient boolean.
   *
   * @param patientId the patient id
   * @return the boolean
   * @throws BusinessException the business exception
   * @throws SystemException   the system exception
   */
  public boolean deletePatient(int patientId) throws BusinessException, SystemException {
    Patient patient = readPatient(patientId);
    int patientDeleted;
    int userDeleted;
    try {

      patientDeleted = patientMapper.deletePatient(patientId);
      userDeleted = userMapper.deleteUser(patient.getUserDetails().getUserId());
      if (patientDeleted == 1 && userDeleted == 1) {
        return true;
      } else {
        if (userDeleted == 0) {
          throw new DeletionFailedException(ApplicationConstant.USER_NOT_DELETED);
        } else {
          throw new DeletionFailedException(ApplicationConstant.PATIENT_NOT_DELETED);
        }
      }

    } catch (DeletionFailedException e) {
      LOGGER.traceExit(e.getMessage());
      throw new SystemException(e);
    } catch (Exception e) {
      LOGGER.traceExit(e.getMessage());
      throw new SystemException(e);
    }
  }

  /**
   * Read patients list.
   *
   * @return the list
   * @throws BusinessException the business exception
   * @throws SystemException   the system exception
   */
  public List<Patient> readPatients() throws BusinessException, SystemException {
    LOGGER.traceEntry();
    List<Patient> patient = patientMapper.readPatients();
    try {
      if (patient == null) {
        throw new PatientNotFoundException(ApplicationConstant.PATIENT_NOT_FOUND);
      } else {
        LOGGER.traceExit(patient);
        return patient;
      }
    } catch (PatientNotFoundException e) {
      LOGGER.traceExit(e.getMessage());
      throw new BusinessException(e.getMessage());
    } catch (Exception e) {
      LOGGER.traceExit(e.getMessage());
      throw new SystemException(e);
    }
  }
}
