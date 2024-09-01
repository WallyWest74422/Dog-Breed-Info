package org.jointheleague.dogsearch.presentation;

//import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import org.jointheleague.dogsearch.repository.dto.DogFact;
import org.jointheleague.dogsearch.service.DogInfoService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static reactor.core.publisher.Mono.when;

@WebMvcTest(DogInfoController.class)
public class DogInfoControllerIntTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DogInfoService dogInfoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        DogInfoController dogInfoController = new DogInfoController(dogInfoService);
    }
    @Test
    public void givenGoodQuery_whenSearchForResults_thenIsOkAndReturnsResults() throws Exception {
        //given
        String query = "3";
        //when
        List<DogFact> actualResults = dogInfoService.getResults(query);
        //then
        assertTrue(actualResults.size()==3);
        assertTrue(actualResults.get(0)!=actualResults.get(1));
        assertTrue(actualResults.get(1)!=actualResults.get(2));
        assertTrue(actualResults.get(0)!=actualResults.get(2));

        MvcResult mvcResult = mockMvc.perform(get("/searchLocResults?q=" + query))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(MediaType.APPLICATION_JSON_VALUE, mvcResult.getResponse().getContentType());
    }

}
