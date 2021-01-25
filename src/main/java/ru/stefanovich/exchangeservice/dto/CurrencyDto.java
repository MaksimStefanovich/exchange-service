package ru.stefanovich.exchangeservice.dto;

import lombok.Data;

import java.util.Map;

@Data
public class CurrencyDto {
    private Map<String, Double> rates;
}
