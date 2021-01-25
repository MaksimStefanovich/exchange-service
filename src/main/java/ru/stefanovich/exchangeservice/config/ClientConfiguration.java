package ru.stefanovich.exchangeservice.config;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.stefanovich.exchangeservice.client.CurrencyClient;
import ru.stefanovich.exchangeservice.client.GiphyClient;

@Configuration
public class ClientConfiguration {

    @Value("${api.currency.url}")
    private String currencyUrl;

    @Value("${api.giphy.url}")
    private String giphyUrl;


    @Bean
    public CurrencyClient currencyClient() {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(CurrencyClient.class, currencyUrl);
    }

    @Bean
    public GiphyClient giphyClient() {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(GiphyClient.class, giphyUrl);
    }



}
