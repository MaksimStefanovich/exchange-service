package ru.stefanovich.exchangeservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.stefanovich.exchangeservice.client.CurrencyClient;
import ru.stefanovich.exchangeservice.client.GiphyClient;
import ru.stefanovich.exchangeservice.dto.CurrencyDto;
import ru.stefanovich.exchangeservice.dto.GiphyDto;
import ru.stefanovich.exchangeservice.dto.RandomGiphyDto;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@RestController
@Slf4j
@RequiredArgsConstructor
public class MainController {

    private final CurrencyClient currencyClient;

    @Value("${api.currency.key}")
    private String currencyKey;

    @Value("${api.currency.value}")
    private String currencyValue;

    private final GiphyClient giphyClient;

    @Value("${api.giphy.key}")
    private String giphyKey;

    private String randomGiphyKey;


    @PostConstruct
    private void getRandomGiphyKey() {
        log.info("Request giphyRandomKey");
        RandomGiphyDto randomGiphyDto = giphyClient.getRandomGiphy(giphyKey);
        randomGiphyKey = randomGiphyDto.getData().get("random_id");
        log.info("Request giphy completed. Result = {}", randomGiphyKey);
    }

    @GetMapping
    public void getCurrency(HttpServletResponse httpServletResponse) throws IOException {
        log.info("Method started");

        log.info("Request currency");
        CurrencyDto currency = currencyClient.findCurrency(currencyKey);
        log.info("Request currency completed. Result = {}", currency);

        log.info("Request yesterday currency");
        CurrencyDto yesterdayCurrency = currencyClient.findCurrencyYesterday(LocalDate.now().minusDays(1), currencyKey);
        log.info("Request yesterday currency completed. Result = {}", yesterdayCurrency);

        Double todayRub = currency.getRates().get(currencyValue);
        Double yesterdayRub = yesterdayCurrency.getRates().get(currencyValue);

        log.info("Request giphy");
        GiphyDto giphyDto = todayRub > yesterdayRub ? giphyClient.getRich(giphyKey, randomGiphyKey) : giphyClient.getBroke(giphyKey, randomGiphyKey);
        log.info("Request giphy completed. Result = {}", giphyDto);


        log.info("Method completed");

        httpServletResponse.sendRedirect(giphyDto.getData().getUrl());

    }


}
