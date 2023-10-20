package com.nenavizion;
import com.nenavizion.config.FlywayUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories("com.nenavizion.repository")
@EntityScan("com.nenavizion.model")
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        FlywayUtil.initMigration();

        SpringApplication.run(Main.class, args);

    }
}
