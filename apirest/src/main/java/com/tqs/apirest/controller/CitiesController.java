package com.tqs.apirest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tqs.apirest.cache.Cache;
import com.tqs.apirest.model.Cities;
import com.tqs.apirest.repository.CitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.List;

@RestController
public class CitiesController {
    
    @Autowired
    CitiesRepository citiesRepository;

    Cache cache = new Cache();
    public static int requests = 0;
    public static int stats = 0;

    // Request the data from the API
    @GetMapping("/api/{city}")
    public Cities apiData(@PathVariable(value = "city") String city) throws JsonProcessingException {
        final String uri = "https://api.waqi.info/feed/" + city + "/?token=1c26216b610f536bd4c9b745e9372912ff8fe97d";

        //HTTP requests on the client side
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        //Reading JSON
        ObjectMapper mapper = new ObjectMapper();

        HashMap infos = mapper.readValue(result, HashMap.class);
        HashMap data = (HashMap) infos.get("data");

        HashMap city_map = (HashMap) data.get("city");
        HashMap iaqi = (HashMap) data.get("iaqi");
        HashMap time = (HashMap) data.get("time");

        Long idx = Long.parseLong(data.get("idx").toString());          //ID for the city | region | station

        String name = city_map.get("name").toString();                  //Name of city | region | station

        String timestamp = time.get("s").toString();                    //Timestamp

        Double aqi = Double.parseDouble(data.get("aqi").toString());    //Air Quality Information

        HashMap no2_map = (HashMap) iaqi.get("no2");
        Double nitrogenDioxide = Double.parseDouble(no2_map.get("v").toString());   //Dióxido de nitrogénio

        HashMap so2_map = (HashMap) iaqi.get("so2");
        Double sulfurDioxide = Double.parseDouble(so2_map.get("v").toString());     //Dióxido de enxofre

        HashMap co_map = (HashMap) iaqi.get("co");
        Double carbonMonoxide = Double.parseDouble(so2_map.get("v").toString());     //Monóxido de Carbono

        HashMap o3_map = (HashMap) iaqi.get("o3");
        Double ozone = Double.parseDouble(o3_map.get("v").toString());              //Ozono

        HashMap pm25_map = (HashMap) iaqi.get("pm25");
        Double pm25 = Double.parseDouble(pm25_map.get("v").toString());             //PM 25

        HashMap pm10_map = (HashMap) iaqi.get("pm10");
        Double pm10 = Double.parseDouble(pm10_map.get("v").toString());             //PM 10

        HashMap t_map = (HashMap) iaqi.get("t");
        Double temperature = Double.parseDouble(t_map.get("v").toString());        //Temperature

        HashMap h_map = (HashMap) iaqi.get("h");
        Double humidity = Double.parseDouble(h_map.get("v").toString());           //Humidity

        HashMap p_map = (HashMap) iaqi.get("p");
        Double pressure = Double.parseDouble(p_map.get("v").toString());           //Pressure

        HashMap w_map = (HashMap) iaqi.get("w");
        Double wind = Double.parseDouble(w_map.get("v").toString());               //Wind

        Cities cities = new Cities(idx, name, timestamp, aqi, nitrogenDioxide, sulfurDioxide, carbonMonoxide, ozone, pm25, pm10,
                temperature, humidity, pressure, wind);
        citiesRepository.save(cities);

        incrementRequests();
        incrementStats();
        return cities;
    }

    @GetMapping("/cities/{idx}")
    public Cities citiesByIdx (@PathVariable(value = "idx") Long idx) throws JsonProcessingException {
        incrementRequests();
        incrementStats();
        if (citiesRepository.findByIdx(idx) == null || cache.isCache(idx)){
            cache.incrementRequests();
            cache.incrementMisses();

            Cities api;
            if (idx == 6637) {
                api = apiData("Valencia");
                cache.setCache(api);
            } else if (idx == 10027) {
                api = apiData("Vigo");
                cache.setCache(api);
            } else if (idx == 11812) {
                api = apiData("Valladolid");
                cache.setCache(api);
            } else if (idx == 6732) {
                api = apiData("Bilbao");
                cache.setCache(api);
            } else if (idx == 5754) {
                api = apiData("Coruña");
                cache.setCache(api);
            } else {
                api = apiData("Madrid");
                cache.setCache(api);
            }
            System.out.println("Miss! Porque não está em Cache e o Time to Live expirou");
            return api;

        } else {
            cache.incrementRequests();
            cache.incrementHits();
            System.out.println("Hit! Porque está em Cache e o Time to Live está válido");
            return cache.getCityCachedById(idx);
        }
    }

    @GetMapping("/cities")
    public List<Cities> getAllCities() {
        incrementRequests();
        incrementStats();
        return citiesRepository.findAll();
    }

    //To see the number of times we used the API
    @GetMapping("/api/stats")
    public String getStats(){
        return "Stats (Number of times): "+ stats + "\nHits: " + cache.getCacheHit() + "\nMisses: " + cache.getCacheMiss();
    }

    @GetMapping("/api/requests")
    public String getRequests(){
        return "Requests: "+ requests;
    }

    //To see the cache of a certain region | city | station
    @GetMapping("/cache")
    public String Cache(){
        return cache.toString();
    }

    public void incrementRequests(){
        requests++;
    }

    public void incrementStats(){
        stats++;
    }
}