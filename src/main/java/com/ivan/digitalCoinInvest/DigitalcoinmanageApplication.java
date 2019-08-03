package com.ivan.digitalCoinInvest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ivan.digitalCoinInvest.mapper")
public class DigitalcoinmanageApplication {

    public static void main(String[] args) {
        SpringApplication.run(DigitalcoinmanageApplication.class, args);
    }

}
