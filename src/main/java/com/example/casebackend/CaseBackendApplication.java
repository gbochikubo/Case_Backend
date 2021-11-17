package com.example.casebackend;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@Log4j2
@SpringBootApplication
public class CaseBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CaseBackendApplication.class, args);
        log.info("CaseBackend foi iniciado com sucesso as {}", LocalDateTime.now());
    }

}
