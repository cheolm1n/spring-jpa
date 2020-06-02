package com.roytuts.spring.data.jpa.batch.insertion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        log.debug("hello world?");
    }
}
