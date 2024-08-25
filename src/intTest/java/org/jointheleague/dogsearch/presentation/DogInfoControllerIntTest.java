package org.jointheleague.dogsearch.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(DogInfoController.class)
public class DogInfoControllerIntTest {

    @Autowired
    private MockMvc mockMvc;

}
