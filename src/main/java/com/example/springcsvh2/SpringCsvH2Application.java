package com.example.springcsvh2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example")
public class SpringCsvH2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCsvH2Application.class, args);
    }

}
