package cc.billguo.demo.flyway.initdata;

import jakarta.annotation.Resource;
import org.flywaydb.core.Flyway;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;


@Component
public class FlywayRunner implements ApplicationRunner {

    @Resource(name="primaryDataSource")
    private DataSource dataSource;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:migration")
                .baselineOnMigrate(true)
                .load();

        flyway.migrate();
    }
}
