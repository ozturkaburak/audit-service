package com.rabbitsoft.clinked;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class AuditServiceAPIApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuditServiceAPIApplication.class, args);
    }
}



