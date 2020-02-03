package global.coda.hms.mapper;

import global.coda.hms.model.Patient;
import global.coda.hms.model.UserDetails;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * The interface Patient mapper.
 */
@Mapper
@Component
public interface PatientMapper {

  /**
   * Create patient int.
   *
   * @param patient the patient
   * @return the int
   */
  @Insert("INSERT INTO `t_patient` (`fk_user_id`,`blood_group`, `weight`) VALUES (#{userId}, "
          + "#{bloodGroup}, #{weight})")
  @Options(useGeneratedKeys = true, keyProperty = "patientId", keyColumn = "pk_patient_id")
  int createPatient(Patient patient);


  /**
   * Read patient patient.
   *
   * @param patientId the patient id
   * @return the patient
   */
  @Select("select pk_patient_id as patient_id, fk_user_id as user_id,blood_group ,weight,"
          + "is_active,created_date as created_time,updated_date as updated_time from t_patient "
          + "where pk_patient_id = #{patientId} and is_active = 1")
  @Results(id = "selectMap", value = {
          @Result(property = "userDetails", javaType = UserDetails.class, column =
                  "user_id", one = @One(select = "global.coda.hms.mapper.UserMapper.getUser"))
  })
  Patient readPatient(int patientId);

  /**
   * Update patient int.
   *
   * @param patient the patient
   * @return the int
   */
  @Update("update t_patient set weight = #{weight},blood_group=#{bloodGroup} where pk_patient_id "
          + "= #{patientId}")
  int updatePatient(Patient patient);

  /**
   * Delete patient int.
   *
   * @param patientId the patient id
   * @return the int
   */
  @Update("update t_patient set is_active = 0 where pk_patient_id = #{patientId}")
  int deletePatient(int patientId);

  /**
   * Read patients list.
   *
   * @return the list
   */
  @Select("select pk_patient_id as patient_id, fk_user_id as user_id,blood_group ,weight,"
          + "is_active,created_date as created_time,updated_date as updated_time from t_patient "
          + "where is_active = 1")
  @Results(id = "selectMapAllPatients", value = {
          @Result(property = "userDetails", javaType = UserDetails.class, column =
                  "user_id", one = @One(select = "global.coda.hms.mapper.UserMapper.getUser"))
  })
  List<Patient> readPatients();
}
