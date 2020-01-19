package global.coda.hms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The type Hms application.
 */
@MapperScan("global.coda.hms.mapper")
@SpringBootApplication
public class HmsApplication {

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    SpringApplication.run(HmsApplication.class, args);
  }


}
