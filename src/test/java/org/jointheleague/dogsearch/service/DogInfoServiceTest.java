package org.jointheleague.dogsearch.service;

import org.jointheleague.dogsearch.repository.DogInfoRepository;
import org.jointheleague.dogsearch.repository.dto.Datum;
import org.jointheleague.dogsearch.service.DogInfoService;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static reactor.core.publisher.Mono.when;

public class DogInfoServiceTest {

    private DogInfoService dogInfoService = new DogInfoService();
    private DogInfoRepository dogInfoRepository = new DogInfoRepository();

    @Test
    void givenGoodQuery_whenGetResults_thenReturnListOfResults() {
        //given
        String query = "Java";
        Datum datum = new Datum();
        List<Datum> expectedResults = Collections.singletonList(datum);

        when(dogInfoService.getResults(query))
                .thenReturn(expectedResults);

        //when
        List<Datum> actualResults = dogInfoService.getResults(query);

        //then
        assertEquals(expectedResults, actualResults);
    }
}
