package com.example.springsecuritoauth2jwt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.springsecuritoauth2jwt.mapper")
public class Springsecuritoauth2jwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springsecuritoauth2jwtApplication.class, args);
    }

}
