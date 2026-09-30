package com.nirmaansetu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * NirmaanSetu Spring Boot entry point.
 *
 * Keep this class intentionally small: application configuration, security,
 * database setup, and web routing live in their dedicated configuration/classes.
 */
@SpringBootApplication
public class NirmaanSetuApplication {

    public static void main(String[] args) {
        SpringApplication.run(NirmaanSetuApplication.class, args);
    }
}
