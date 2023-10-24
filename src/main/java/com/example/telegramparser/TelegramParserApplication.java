package com.example.telegramparser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TelegramParserApplication {

    public static void main(String[] args) {
        SpringApplication.run(TelegramParserApplication.class, args);
    }

}
