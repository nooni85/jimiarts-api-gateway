package com.jimiarts.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GwapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GwapiApplication.class, args);
    }

}
