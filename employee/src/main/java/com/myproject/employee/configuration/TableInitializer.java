package com.myproject.employee.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.r2dbc.core.DatabaseClient;
import reactor.core.publisher.Mono;

@Configuration
public class TableInitializer {

    @Bean
    @Order(2)
    public CommandLineRunner initTables(DatabaseClient databaseClient) {
        return args -> {
            String createTableSql = """
                CREATE TABLE IF NOT EXISTS employee (
                    id BIGINT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(255) NOT NULL,
                    position VARCHAR(255) NOT NULL,
                    department VARCHAR(255) NOT NULL,
                    salary DECIMAL(10, 2) NOT NULL
                );
            """;

            Mono.from(databaseClient.sql(createTableSql).then())
                    .doOnError(error -> System.err.println("Error creating tables: " + error.getMessage()))
                    .doOnSuccess(success -> System.out.println("Tables created successfully"))
                    .block();
        };
    }
}
