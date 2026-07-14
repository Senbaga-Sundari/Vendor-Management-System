package com.psiddhi.ivms;

import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseTestRunner implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    public DatabaseTestRunner(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

   @Override
public void run(String... args) {

    System.out.println("DatabaseTestRunner Started");

    Integer result = jdbcTemplate.queryForObject(
            "SELECT 1",
            Integer.class);

    System.out.println("Azure SQL Connection Successful : " + result);
}

}
