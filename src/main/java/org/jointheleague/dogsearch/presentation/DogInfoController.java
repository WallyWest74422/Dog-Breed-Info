package org.jointheleague.dogsearch.presentation;


import org.jointheleague.dogsearch.service.DogInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogInfoController {

    private final DogInfoService dis;

    public DogInfoController(DogInfoService dis){
        this.dis = dis;
    }

    @GetMapping("/searchLocResults")
    public String getResults(@RequestParam(value="q") String query){
    return "Finding dog facts related to "+query;
}

}
