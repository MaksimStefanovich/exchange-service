package ru.stefanovich.exchangeservice.client;

import feign.Param;
import feign.RequestLine;
import ru.stefanovich.exchangeservice.dto.GiphyDto;
import ru.stefanovich.exchangeservice.dto.RandomGiphyDto;

public interface GiphyClient {
    @RequestLine("GET gifs/random?api_key={key}&tag=rich&random_id={randomKey}")
    GiphyDto getRich(@Param("key") String key, @Param("randomKey") String randomKey);

    @RequestLine("GET gifs/random?api_key={key}&tag=broke&random_id={randomKey}")
    GiphyDto getBroke(@Param("key") String key, @Param("randomKey") String randomKey);

    @RequestLine("GET randomid?api_key={key}")
    RandomGiphyDto getRandomGiphy(@Param("key") String key);

}
