package com.edu.pt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.edu.pt.mapper")
@SpringBootApplication
@EnableCaching
public class PtApplication {

    public static void main(String[] args) {
        SpringApplication.run(PtApplication.class, args);
    }

}
