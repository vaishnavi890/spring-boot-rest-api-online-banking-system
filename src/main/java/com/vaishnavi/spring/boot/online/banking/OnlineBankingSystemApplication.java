package com.vaishnavi.spring.boot.online.banking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling              // For scheduled tasks (e.g., notification, reports)
@EnableEurekaServer           // Makes this a Eureka service registry
public class OnlineBankingSystemApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(OnlineBankingSystemApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(OnlineBankingSystemApplication.class, args);
        logger.info(" Cab Booking System started successfully!");
    }

    @Override
    public void run(String... args) {
        if (args.length == 0) {
            logger.info("No command-line arguments provided.");
        } else {
            for (String arg : args) {
                logger.info("Argument received: {}", arg);
            }
        }
    }
}


