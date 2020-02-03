package global.coda.hms.service;

import global.coda.hms.constant.ApplicationConstant;
import global.coda.hms.exception.BusinessException;
import global.coda.hms.exception.DeletionFailedException;
import global.coda.hms.exception.DoctorNotFoundException;
import global.coda.hms.exception.SystemException;
import global.coda.hms.mapper.DoctorMapper;
import global.coda.hms.mapper.UserMapper;
import global.coda.hms.model.Doctor;
import global.coda.hms.model.DoctorPatientMapper;
import global.coda.hms.model.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The type Doctor service.
 */
@Service
public class DoctorService {
  private final Logger LOGGER = LogManager.getLogger(DoctorService.class);
  /**
   * The Doctor mapper.
   */
  @Autowired
  private DoctorMapper doctorMapper;
  /**
   * The User mapper.
   */
  @Autowired
  private UserMapper userMapper;

  /**
   * Create doctor doctor.
   *
   * @param doctor the doctor
   * @return the doctor
   * @throws SystemException   the system exception
   * @throws BusinessException the business exception
   */
  @Transactional
  public Doctor createDoctor(Doctor doctor) throws SystemException, BusinessException {
    LOGGER.traceEntry(doctor.toString());
    try {
      int usersInserted = userMapper.createUser(doctor.getUserDetails());
      doctor.setUserId(doctor.getUserDetails().getUserId());
      int doctorsInserted = doctorMapper.createDoctor(doctor);
      if (doctorsInserted == 1 && usersInserted == 1) {
        LOGGER.traceExit(doctor);
        return doctor;
      } else {
        throw new SystemException(new Exception(ApplicationConstant.WENT_WRONG));
      }
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


  }

  /**
   * Read doctor doctor.
   *
   * @param doctorId the doctor id
   * @return the doctor
   * @throws BusinessException the business exception
   * @throws SystemException   the system exception
   */
  public Doctor readDoctor(int doctorId) throws BusinessException, SystemException {
    LOGGER.traceEntry(Integer.toString(doctorId));
    Doctor doctor = doctorMapper.readDoctor(doctorId);
    try {
      if (doctor == null) {
        throw new DoctorNotFoundException(ApplicationConstant.DOCTOR_NOT_FOUND);
      }
    } catch (DoctorNotFoundException e) {
      LOGGER.traceExit(e.getMessage());
      throw new BusinessException(e.getMessage());
    } catch (Exception e) {
      LOGGER.traceExit(e.getMessage());
      throw new SystemException(e);
    }
    LOGGER.traceExit(doctor.toString());
    return doctor;
  }

  /**
   * Update doctor doctor.
   *
   * @param doctor the doctor
   * @return the doctor
   * @throws BusinessException the business exception
   * @throws SystemException   the system exception
   */
  @Transactional
  public Doctor updateDoctor(Doctor doctor) throws BusinessException, SystemException {
    LOGGER.traceEntry(doctor.toString());
    try {
      int userAffected = userMapper.updateUser(doctor.getUserDetails());
      int doctorsAffected = doctorMapper.updateDoctor(doctor);
      if (userAffected == 1 && doctorsAffected == 1) {
        Doctor updatedDoctor = readDoctor(doctor.getDoctorId());
        LOGGER.traceExit(updatedDoctor);
        return updatedDoctor;
      } else {
        throw new SystemException(new Exception(ApplicationConstant.WENT_WRONG));
      }
    } catch (BusinessException e) {
      LOGGER.traceExit(e.getMessage());
      throw e;
    } catch (SystemException e) {
      LOGGER.traceExit(e.getMessage());
      throw e;
    }
  }

  /**
   * Delete doctor boolean.
   *
   * @param doctorId the doctor id
   * @return the boolean
   * @throws BusinessException the business exception
   * @throws SystemException   the system exception
   */
  @Transactional(rollbackFor = {BusinessException.class, SystemException.class})
  public boolean deleteDoctor(int doctorId) throws BusinessException, SystemException {
    LOGGER.traceEntry(Integer.toString(doctorId));
    Doctor doctor = readDoctor(doctorId);
    try {
      int doctorsAffected = doctorMapper.deleteDoctor(doctorId);
      int usersAffected = userMapper.deleteUser(doctor.getUserDetails().getUserId());
      if (doctorsAffected == 1 && usersAffected == 1) {
        LOGGER.traceExit(true);
        return true;
      } else {
        if (doctorsAffected == 0) {
          throw new DeletionFailedException(ApplicationConstant.DOCTOR_NOT_DELETED);
        } else {
          throw new DeletionFailedException(ApplicationConstant.USER_NOT_DELETED);
        }

      }
    } catch (DeletionFailedException e) {
      LOGGER.error(e.getMessage());
      throw new SystemException(new Exception(e.getMessage()));
    } catch (Exception e) {

      LOGGER.error(e.getMessage());
      throw new SystemException(e);
    }
  }

  /**
   * Gets all patients of doctor.
   *
   * @param doctorId the doctor id
   * @return the all patients of doctor
   * @throws SystemException   the system exception
   * @throws BusinessException the business exception
   */
  public List<DoctorPatientMapper> getAllPatientsOfDoctor(int doctorId) throws SystemException,
          BusinessException {
    LOGGER.traceEntry(Integer.toString(doctorId));
   /* DoctorPatientMapper doctorPatientMapper = new DoctorPatientMapper();
    Doctor doctor = readDoctor(doctorId);*/
    List<DoctorPatientMapper> doctorPatientMapper = doctorMapper.getAllPatientsOfDoctor(doctorId);
   /* doctorPatientMapper.setDoctor(doctor);
    doctorPatientMapper.setPatient(patients);*/
    return doctorPatientMapper;
  }

  /**
   * Check list.
   *
   * @param doctorId the doctor id
   * @return the list
   */
  public List<Patient> check(int doctorId) {
    Integer[] patients = {1, 2, 3};
    return null;
  }

  /**
   * Read doctor list.
   *
   * @return the list
   * @throws BusinessException the business exception
   * @throws SystemException   the system exception
   */
  public List<Doctor> readDoctor() throws BusinessException, SystemException {
    LOGGER.traceEntry();
    List<Doctor> doctor = doctorMapper.readDoctors();
    try {
      if (doctor == null) {
        throw new DoctorNotFoundException(ApplicationConstant.DOCTOR_NOT_FOUND);
      }
    } catch (DoctorNotFoundException e) {
      LOGGER.traceExit(e.getMessage());
      throw new BusinessException(e.getMessage());
    } catch (Exception e) {
      LOGGER.traceExit(e.getMessage());
      throw new SystemException(e);
    }
    LOGGER.traceExit(doctor.toString());
    return doctor;
  }
}
