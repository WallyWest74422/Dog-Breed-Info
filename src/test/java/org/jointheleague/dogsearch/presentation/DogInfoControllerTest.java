package org.jointheleague.dogsearch.presentation;

import org.jointheleague.dogsearch.presentation.DogInfoController;
//import org.jointheleague.dogsearch.repository.dto.DogFact;
import org.jointheleague.dogsearch.repository.dto.Datum;
import org.jointheleague.dogsearch.repository.dto.DogFact;
import org.jointheleague.dogsearch.service.DogInfoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static reactor.core.publisher.Mono.when;

public class DogInfoControllerTest {
    private DogInfoController dogInfoController;

    private DogInfoService dogInfoService;

    @BeforeEach
    void setUp() {
        dogInfoService = new DogInfoService();
        dogInfoController = new DogInfoController(dogInfoService);

    }

    @Test
    void givenGoodQuery_whenGetResults_thenReturnListOfResults() {
        //given
        String query = "3";
        //when
        List<DogFact> actualResults = dogInfoController.getResults(query);
        //then
        assertTrue(actualResults.size()==3);
        assertTrue(actualResults.get(0)!=actualResults.get(1));
        assertTrue(actualResults.get(1)!=actualResults.get(2));
        assertTrue(actualResults.get(0)!=actualResults.get(2));
    }

    @Test
    void givenBadQuery_whenGetResults_thenThrowsException() throws WebClientResponseException{
        //given
        String query = "-1";
        //when
        //then
        Throwable exceptionThrown = assertThrows(WebClientResponseException.class, () -> dogInfoController.getResults(query));
        assertEquals(exceptionThrown.getMessage(), "500 Internal Server Error from GET https://dogapi.dog/api/v2/facts");
    }
}
