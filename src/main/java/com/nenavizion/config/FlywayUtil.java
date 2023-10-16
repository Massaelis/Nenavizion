package com.nenavizion.config;

import org.flywaydb.core.Flyway;

public class FlywayUtil {
    public static void initMigration() {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/nenavizion", "postgres", "route")
                .baselineOnMigrate(true)
                .locations("db/migration")
                .load();
        flyway.migrate();
    }
}