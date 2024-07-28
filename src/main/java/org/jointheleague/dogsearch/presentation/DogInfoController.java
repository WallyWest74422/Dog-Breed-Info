package org.jointheleague.dogsearch.presentation;


import org.jointheleague.dogsearch.repository.DogInfoRepository;
import org.jointheleague.dogsearch.repository.dto.DogFact;
import org.jointheleague.dogsearch.service.DogInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class DogInfoController {

    private final DogInfoService dis;

    public DogInfoController(DogInfoService dis){
        this.dis = dis;
    }

    @GetMapping("/searchLocResults")
    public List getResults(@RequestParam(value="q") String query){
    List<DogFact> dogFacts = dis.getResults(query);
        if(CollectionUtils.isEmpty(dogFacts)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Result(s) not found.");
        }
        return dogFacts;
}

}
