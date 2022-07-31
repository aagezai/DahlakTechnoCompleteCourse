package com.dahlaktechnomicroservicehystrixservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class DahlakTechnoMicroServiceHystrixServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DahlakTechnoMicroServiceHystrixServiceApplication.class, args);
	}

}
