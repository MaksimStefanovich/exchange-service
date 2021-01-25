package ru.stefanovich.exchangeservice.dto;

import lombok.Data;

@Data
public class GiphyDto {
    private GiphyItemDto data;

    @Data
    public static class GiphyItemDto {
        private String url;

    }
}
