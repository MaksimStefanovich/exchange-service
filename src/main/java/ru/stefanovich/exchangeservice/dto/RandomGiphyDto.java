package ru.stefanovich.exchangeservice.dto;

import lombok.Data;

import java.util.Map;

@Data
public class RandomGiphyDto {

    private Map<String, String> data;
}
