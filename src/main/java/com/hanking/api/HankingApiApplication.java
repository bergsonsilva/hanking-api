package com.hanking.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.hanking.api.repository")
public class HankingApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HankingApiApplication.class, args);
    }

}
