package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestConnectMySqlApplication  implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TestConnectMySqlApplication.class, args);
        System.out.println("NamVH");
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
