package org.jointheleague.dogsearch.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@CrossOrigin
public class HomeController {

    @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
    @GetMapping("/")
    public String home(){
        return "redirect:swagger-ui.html";
    }

}
