package global.coda.hms.config;

import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type Fly way config.
 */
@Configuration
public class FlyWayConfig {

  /**
   * Flyway migration strategy flyway migration strategy.
   *
   * @return the flyway migration strategy
   */
  @Bean
  public FlywayMigrationStrategy flywayMigrationStrategy() {
    return new FlywayMigrationStrategy() {
      @Override
      public void migrate(org.flywaydb.core.Flyway flyway) {
        flyway.repair();
        flyway.migrate();

      }
    };
  }
}
