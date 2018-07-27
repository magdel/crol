package com.ridelr.crol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrolApplication {
    private static final Logger logger = LoggerFactory.getLogger(CrolApplication.class);

    public static void main(String[] args) {
        logger.info("Entering..");
        System.out.println("Starting..");
        SpringApplication.run(CrolApplication.class, args);
        System.out.println("Started");
    }
}
