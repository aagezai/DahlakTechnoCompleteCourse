package com.dahlaktechnosprindatajpa.dahlaktechnospringdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration;

@SpringBootApplication//(exclude = {DataSourceAutoConfiguration.class})//(exclude = SqlInitializationAutoConfiguration.class)

public class DahlakTechnoSpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DahlakTechnoSpringDataJpaApplication.class, args);
    }

}
