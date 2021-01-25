package ru.stefanovich.exchangeservice;

import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.stefanovich.exchangeservice.client.CurrencyClient;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ExchangeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExchangeServiceApplication.class, args);
    }

}
