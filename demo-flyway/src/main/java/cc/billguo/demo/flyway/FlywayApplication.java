package cc.billguo.demo.flyway;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * flyway
 *
 * @author Bill Guo
 * @since 2023-08-10
 */
@SpringBootApplication
public class FlywayApplication {
    public static void main(String[] args) {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:h2:file:./target/test", "sa", null)
                .locations("migration")
                .schemas("PUBLIC")
                .baselineOnMigrate(true)
                .load();

        flyway.migrate();
    }
}
