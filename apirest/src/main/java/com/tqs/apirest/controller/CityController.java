package com.tqs.apirest.controller;

import com.tqs.apirest.cache.Cache;
import com.tqs.apirest.repository.CityRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class CityController {

    Cache cache = new Cache();
    CityRepository cityRepository;
    public static int stats = 0;


    /*@GetMapping("/cities")
    public List<City> getAllCities() {
        incrementStatsCount();
        return cityRepository.findAll();
    }*/


    @GetMapping("/api/stats")
    public String getStats(){
        return "Stats: " + stats;
    }

    @GetMapping("/cache")
    public String Cache(){
        return cache.toString();
    }

    public void incrementStatsCount(){
        stats++;
    }
}
