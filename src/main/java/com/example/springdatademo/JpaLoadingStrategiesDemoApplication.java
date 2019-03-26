package com.example.springdatademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.springdatademo.domain")
public class JpaLoadingStrategiesDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaLoadingStrategiesDemoApplication.class, args);
    }

}
