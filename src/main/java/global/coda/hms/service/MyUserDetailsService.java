package global.coda.hms.service;


import global.coda.hms.mapper.UserMapper;
import global.coda.hms.model.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * The type My user details service.
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

  /**
   * The Mapper.
   */
  @Autowired
  UserMapper mapper;

  @Override
  public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    global.coda.hms.model.UserDetails userDetails = mapper.findUserByUsername(username);
    if (userDetails == null) {
      throw new UsernameNotFoundException("Username not found!!!");
    } else {
      return new CustomUserDetails(userDetails);
    }

  }
}