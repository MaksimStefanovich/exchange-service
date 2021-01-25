package ru.stefanovich.exchangeservice.client;

import feign.Param;
import feign.RequestLine;
import ru.stefanovich.exchangeservice.dto.CurrencyDto;

import java.time.LocalDate;

public interface CurrencyClient {
    @RequestLine("GET latest.json?app_id={key}")
    CurrencyDto findCurrency(@Param("key") String key);

    @RequestLine("GET historical/{date}.json?app_id={key}")
    CurrencyDto findCurrencyYesterday(@Param("date") LocalDate date, @Param("key") String key);
}
