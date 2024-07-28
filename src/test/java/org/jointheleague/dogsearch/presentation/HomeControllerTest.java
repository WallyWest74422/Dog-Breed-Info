package org.jointheleague.dogsearch.presentation;

import org.jointheleague.dogsearch.presentation.HomeController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeControllerTest {

    HomeController home;

    @BeforeEach
    public void setup(){
        home = new HomeController();
    }

    @Test
    void whenHome_thenReturnRedirect() {
        //given
        String expected = "redirect:swagger-ui.html";

        //when
        String actual = home.home();

        //then
        assertEquals(expected, actual);
    }

}
