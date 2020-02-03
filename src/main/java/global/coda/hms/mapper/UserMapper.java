package global.coda.hms.mapper;

import global.coda.hms.model.UserDetails;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

/**
 * The interface User mapper.
 */
@Component
@Mapper
public interface UserMapper {

  /**
   * Create user int.
   *
   * @param userDetails the user details
   * @return the int
   */
  @Insert("INSERT INTO `t_user_details` (`username`, `password`, `fk_role_id`, `firstname`, "
          + "`lastname`, `city`, `state`, `phone_number`)VALUES (#{username}, #{password}, "

          + "#{roleId}, #{firstName}, #{lastName}, #{city}, #{state},#{phoneNumber})")
  @Options(useGeneratedKeys = true, keyProperty = "userId", keyColumn = "pk_user_id")
  int createUser(UserDetails userDetails);

  /**
   * Gets user.
   *
   * @param userId the user id
   * @return the user
   */
  @Select("select pk_user_id as user_id, username,password,firstname as firstName,lastname as " +
          "lastName,city,state,"
          + "created_time,updated_time,"
          + "phone_number,fk_role_id as role_id,is_active from t_user_details where pk_user_id = "
          + "#{userId} and is_active = 1")
  UserDetails getUser(int userId);

  /**
   * Update user int.
   *
   * @param userDetails the user details
   * @return the int
   */
  @Update("update t_user_details set firstname = #{firstName},lastName = #{lastName},"
          + "city=#{city},state=#{state},phone_number = #{phoneNumber} where pk_user_id = "
          + "#{userId}")
  int updateUser(UserDetails userDetails);

  /**
   * Delete user int.
   *
   * @param userId the user id
   * @return the int
   */
  @Update("update t_user_details set is_active = 0 where pk_user_id = #{userId}")
  int deleteUser(int userId);

  /**
   * Find user by username user details.
   *
   * @param username the username
   * @return the user details
   */
  @Select("select username,password from t_user_details where username = #{username}")
  UserDetails findUserByUsername(String username);

}
