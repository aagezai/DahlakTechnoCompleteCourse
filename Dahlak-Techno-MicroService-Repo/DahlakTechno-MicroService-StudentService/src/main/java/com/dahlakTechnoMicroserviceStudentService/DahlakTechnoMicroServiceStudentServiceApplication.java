package com.dahlakTechnoMicroserviceStudentService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DahlakTechnoMicroServiceStudentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DahlakTechnoMicroServiceStudentServiceApplication.class, args);
    }

}
