package com.rates.exchangerates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExchangeratesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExchangeratesApplication.class, args);
    }

}
