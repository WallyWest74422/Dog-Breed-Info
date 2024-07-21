package org.jointheleague.dogsearch.service;

import org.springframework.stereotype.Service;

@Service
public class DogInfoService {

    public String getResults(String query){
        return "Searching for dogs related to " + query;
    }

}