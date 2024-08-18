package org.jointheleague.dogsearch.repository;

import org.jointheleague.dogsearch.repository.dto.Datum;
import org.jointheleague.dogsearch.repository.dto.DogFact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Mono;


import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class DogInfoRepositoryTest
{
    private DogInfoRepository dir;

    @Mock
    WebClient webClientMock;

    @Mock
    WebClient.RequestHeadersUriSpec requestHeadersUriSpecMock;

    @Mock
    WebClient.RequestHeadersSpec requestHeadersSpecMock;

    @Mock
    WebClient.ResponseSpec responseSpecMock;

    @Mock
    Mono<DogFact> dirMonoMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        dir = new DogInfoRepository(webClientMock);
    }

    @Test
    void whenGetResults_thenReturnLocResponse() {
        String query = "Java";
        DogFact dogFact = new DogFact();
        Datum datum = new Datum();
        List<Datum> expectedResults = Collections.singletonList(datum);
        dogFact.setData(expectedResults);

        when(webClientMock.get())
                .thenReturn(requestHeadersUriSpecMock);
        when(requestHeadersUriSpecMock.uri((Function<UriBuilder, URI>) any()))
                .thenReturn(requestHeadersSpecMock);
        when(requestHeadersSpecMock.retrieve())
                .thenReturn(responseSpecMock);
        when(responseSpecMock.bodyToMono(DogFact.class))
                .thenReturn(dirMonoMock);
        when(dirMonoMock.block())
                .thenReturn(dogFact);

        //when
        List<DogFact> actualResults = dir.getResults(query);

        //then
        assertEquals(expectedResults, actualResults);
    }
}
