package com.example.daycaree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@SpringBootApplication

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class DayCareeApplication {

    public static void main(String[] args) {


        SpringApplication.run(DayCareeApplication.class, args);

    }

}
