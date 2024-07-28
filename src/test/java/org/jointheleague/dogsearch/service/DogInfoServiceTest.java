package org.jointheleague.dogsearch.service;

import org.jointheleague.dogsearch.repository.DogInfoRepository;
import org.jointheleague.dogsearch.repository.dto.DogFact;
import org.jointheleague.dogsearch.service.DogInfoService;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static reactor.core.publisher.Mono.when;

public class DogInfoServiceTest {

    private DogInfoService dogInfoService;
    private DogInfoRepository dogInfoRepository;

    @Test
    void givenGoodQuery_whenGetResults_thenReturnListOfResults() {
        //given
        String query = "Java";
        DogFact dogFact = new DogFact();
        List<DogFact> expectedResults = Collections.singletonList(dogFact);

        when(dogInfoService.getResults(query))
                .thenReturn(expectedResults);

        //when
        List<DogFact> actualResults = dogInfoService.getResults(query);

        //then
        assertEquals(expectedResults, actualResults);
    }
}
