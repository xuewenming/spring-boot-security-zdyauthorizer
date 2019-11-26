package com.sam.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({"com.sam.security.mappper"})
@SpringBootApplication
public class SpringBootSecurityZdyauthorizeApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityZdyauthorizeApplication.class, args);
    }

}
