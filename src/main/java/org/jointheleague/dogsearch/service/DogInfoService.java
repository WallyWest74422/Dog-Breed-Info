package org.jointheleague.dogsearch.service;

import org.jointheleague.dogsearch.repository.DogInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogInfoService {

    DogInfoRepository dir;

    public DogInfoService(){
        dir = new DogInfoRepository();
    }
    public List getResults(String query){
        return dir.getResults(query);
    }

}