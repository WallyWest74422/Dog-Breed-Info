package org.jointheleague.dogsearch.repository;

import org.jointheleague.dogsearch.repository.dto.DogDTO;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Repository
public class DogInfoRepository {

    private final WebClient webClient;

    public static final String baseUrl = "https://dogapi.dog/api/v2/facts";

    public DogInfoRepository() {
        webClient = WebClient
                .builder()
                .baseUrl(baseUrl)
                .build();
    }

    public List getResults(String query){
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("limit", query)
                        .build()
                )
                .retrieve()
                .bodyToMono(DogDTO.class)
                .block()
                .getDogFacts();
    }

}