package global.coda.hms.mapper;

import global.coda.hms.model.Doctor;
import global.coda.hms.model.DoctorPatientMapper;
import global.coda.hms.model.Patient;
import global.coda.hms.model.UserDetails;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
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
 * The interface Doctor mapper.
 */
@Mapper
@Component
public interface DoctorMapper {

  /**
   * Create doctor int.
   *
   * @param doctor the doctor
   * @return the int
   */
  @Insert("INSERT INTO `hms`.`t_doctor` (`doctor_specialization`, `fk_user_id`) VALUES "
          + "(#{doctorSpecialization}, "
          + "#{userId})")
  @Options(useGeneratedKeys = true, keyProperty = "doctorId", keyColumn = "pk_doctor_id")
  int createDoctor(Doctor doctor);

  /**
   * Read doctor doctor.
   *
   * @param doctorId the doctor id
   * @return the doctor
   */
  @Select("SELECT `t_doctor`.`pk_doctor_id` as doctor_id,`t_doctor`.`doctor_specialization`, "
          + "`t_doctor`"
          + ".`is_active`, `t_doctor`.`created_date` as created_time,`t_doctor`.`updated_date` as"
          + " updated_time,`t_doctor`"
          + ".`fk_user_id` as user_id FROM `hms`.`t_doctor` where pk_doctor_id = #{doctorId} and "
          + "is_active = 1")
  @Results(id = "selectMap", value = {

          @Result(property = "userDetails", javaType = UserDetails.class, column =
                  "user_id", one = @One(select = "global.coda.hms.mapper.UserMapper.getUser"))
  })
  Doctor readDoctor(int doctorId);

  /**
   * Update doctor int.
   *
   * @param doctor the doctor
   * @return the int
   */
  @Update("update t_doctor set doctor_specialization= #{doctorSpecialization} where pk_doctor_id "
          + "= #{doctorId}")
  int updateDoctor(Doctor doctor);

  /**
   * Delete doctor int.
   *
   * @param doctorId the doctor id
   * @return the int
   */
  @Update("update t_doctor set is_active = 0 where pk_doctor_id = #{doctorId}")
  int deleteDoctor(int doctorId);

  /**
   * Gets all patients of doctor.
   *
   * @param doctorId the doctor id
   * @return the all patients of doctor
   */
  @Select("<script> select distinct fk_doctor_id from t_record " +
          "<if test='doctorId!=0'>where fk_doctor_id = #{doctorId} and is_active = 1</if>" +
          "</script>")
  @Results({
          @Result(
                  column = "fk_doctor_id", property = "doctor", one = @One(select = "readDoctor")
          ),
          @Result(
                  column = "fk_doctor_id", property = "patient",
                  many = @Many(select = "readPatients")
          )
  })
  List<DoctorPatientMapper> getAllPatientsOfDoctor(int doctorId);

  /**
   * Read patients list.
   *
   * @param doctorId the doctor id
   * @return the list
   */
  @Select(" select record.fk_patient_id,patient.fk_user_id as user_id,patient.blood_group,patient" +
          ".weight,patient.is_active,patient.created_date as created_time,patient.updated_date as" +
          " updated_time from t_record as record left join t_patient as patient on pk_patient_id " +
          "= fk_patient_id where patient.is_active = 1 and record.fk_doctor_id = #{doctorId} " +
          "group by patient.pk_patient_id  ")
  @Results(
          @Result(
                  column = "user_id", property = "userDetails", javaType = UserDetails.class,
                  one = @One(select = "global.coda" +
                          ".hms.mapper.UserMapper.getUser")
          )
  )
  List<Patient> readPatients(int doctorId);


  /**
   * Read doctors list.
   *
   * @return the list
   */
  @Select("SELECT `t_doctor`.`pk_doctor_id` as doctor_id,`t_doctor`.`doctor_specialization`, "
          + "`t_doctor`"
          + ".`is_active`, `t_doctor`.`created_date` as created_time,`t_doctor`.`updated_date` as"
          + " updated_time,`t_doctor`"
          + ".`fk_user_id` as user_id FROM `hms`.`t_doctor` where "
          + "is_active = 1")
  @Results(id = "selectPatients", value = {

          @Result(property = "userDetails", javaType = UserDetails.class, column =
                  "user_id", one = @One(select = "global.coda.hms.mapper.UserMapper.getUser"))
  })
  List<Doctor> readDoctors();
}
