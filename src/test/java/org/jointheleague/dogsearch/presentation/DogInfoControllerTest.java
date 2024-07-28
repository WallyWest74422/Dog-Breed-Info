package org.jointheleague.dogsearch.presentation;

import org.jointheleague.dogsearch.presentation.DogInfoController;
import org.jointheleague.dogsearch.repository.dto.DogFact;
import org.jointheleague.dogsearch.service.DogInfoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static reactor.core.publisher.Mono.when;

public class DogInfoControllerTest {
    private DogInfoController dogInfoController;

    private DogInfoService dogInfoService;

    @BeforeEach
    void setUp() {
        dogInfoController = new DogInfoController(dogInfoService);
    }

    @Test
    void givenGoodQuery_whenGetResults_thenReturnListOfResults() {
        //given
        String query = "Java";
        DogFact dogFact = new DogFact();
        List<DogFact> expectedResults = Collections.singletonList(dogFact);

        when(dogInfoService.getResults(query))
                .thenReturn(expectedResults);

        //when
        List<DogFact> actualResults = dogInfoController.getResults(query);

        //then
        assertEquals(expectedResults, actualResults);
    }

    @Test
    void givenBadQuery_whenGetResults_thenThrowsException() {
        //given
        String query = "Java";
        //when
        //then
        Throwable exceptionThrown = assertThrows(ResponseStatusException.class, () -> dogInfoController.getResults(query));
        assertEquals(exceptionThrown.getMessage(), "404 NOT_FOUND \"Result(s) not found.\"");
    }
}
