package org.jointheleague.dogsearch.repository;

import org.jointheleague.dogsearch.repository.dto.DogDTO;
import org.jointheleague.dogsearch.repository.dto.DogFact;
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

    public DogInfoRepository(WebClient wc){
        webClient = wc;
    }

    public List getResults(String query){
        DogFact Intermediate = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("limit", query)
                        .build()
                )
                .retrieve()
                .bodyToMono(DogFact.class)
                .block();
        System.out.println(Intermediate.getData());
                return Intermediate.getData();
    }

}