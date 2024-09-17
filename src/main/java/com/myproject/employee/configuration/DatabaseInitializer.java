package com.myproject.employee.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.r2dbc.core.DatabaseClient;
import reactor.core.publisher.Mono;

@Configuration
public class DatabaseInitializer {

    @Bean
    @Order(1)
    public CommandLineRunner initDatabase(DatabaseClient databaseClient) {
        return args -> {
            String createDatabaseSql = "CREATE DATABASE IF NOT EXISTS employee_db;";

            Mono.from(databaseClient.sql(createDatabaseSql).then())
                    .doOnError(error -> System.err.println("Error creating database: " + error.getMessage()))
                    .doOnSuccess(success -> System.out.println("Database created successfully"))
                    .block();

            databaseClient.sql("USE employee_db;").then().block();
        };
    }
}