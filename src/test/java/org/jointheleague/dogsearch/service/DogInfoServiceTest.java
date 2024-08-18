package org.jointheleague.dogsearch.service;

import org.jointheleague.dogsearch.repository.DogInfoRepository;
import org.jointheleague.dogsearch.repository.dto.Datum;
import org.jointheleague.dogsearch.repository.dto.DogFact;
import org.jointheleague.dogsearch.service.DogInfoService;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static reactor.core.publisher.Mono.when;

public class DogInfoServiceTest {

    private DogInfoService dogInfoService = new DogInfoService();
    private DogInfoRepository dogInfoRepository = new DogInfoRepository();

    @Test
    void givenGoodQuery_whenGetResults_thenReturnListOfResults() {
        //given
        String query = "3";
        //when
        List<DogFact> actualResults = dogInfoService.getResults(query);
        //then
        assertTrue(actualResults.size()==3);
        assertTrue(actualResults.get(0)!=actualResults.get(1));
        assertTrue(actualResults.get(1)!=actualResults.get(2));
        assertTrue(actualResults.get(0)!=actualResults.get(2));
    }
}
