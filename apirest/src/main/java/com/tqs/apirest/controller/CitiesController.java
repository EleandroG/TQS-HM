package com.tqs.apirest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tqs.apirest.cache.Cache;
import com.tqs.apirest.model.Cities;
import com.tqs.apirest.repository.CitiesRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

public class CitiesController {

    Cache cache = new Cache();
    CitiesRepository citiesRepository;
    public static int stats = 0;

    @GetMapping("/cities")
    public List<Cities> getCities() {
        incrementStatsCount();
        return citiesRepository.findAll();
    }

    @PostMapping("/cities")
    public Cities newCity (@Valid @RequestBody Cities cities){
        incrementStatsCount();
        return citiesRepository.save(cities);
    }

    //Get data from the API
    @GetMapping("/api/{city}")
    public Cities getAPIData(@PathVariable(value = "city") String city) throws JsonProcessingException {
        final String uri = "https://api.waqi.info/feed/" + city + "/?token=1c26216b610f536bd4c9b745e9372912ff8fe97d";

        //HTTP Requests on client side
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        HashMap infos = mapper.readValue(result, HashMap.class);
        HashMap data = (HashMap) infos.get("data");

        //System.out.println(data);

        HashMap city_map = (HashMap) data.get("city");
        HashMap time_map = (HashMap) data.get("time");
        HashMap iaqi_map = (HashMap) data.get("iaqi");

        Long idx = Long.parseLong(data.get("idx").toString()); //Unique ID for the city monitoring station.
        String name = city_map.get("name").toString(); //Name of the monitoring station.
        String timestamp = time_map.get("s").toString(); //Tempo da leitura
        Double aqi = Double.parseDouble(data.get("aqi").toString()); //Real-time air quality information.

        HashMap pm25_map = (HashMap) iaqi_map.get("pm25");
        Double pm25 = Double.parseDouble(pm25_map.get("v").toString()); //PM 2.5

        HashMap pm10_map = (HashMap) iaqi_map.get("pm10");
        Double pm10 = Double.parseDouble(pm10_map.get("v").toString()); //PM 10

        HashMap o3_map = (HashMap) iaqi_map.get("ozone");
        Double o3 = Double.parseDouble(o3_map.get("v").toString());   //Ozono

        HashMap no2_map = (HashMap) iaqi_map.get("nitrogenDioxide");
        Double no2 = Double.parseDouble(no2_map.get("v").toString()); //Dióxido de nitrogénio

        HashMap so2_map = (HashMap) iaqi_map.get("sulfurDioxide");
        Double so2 = Double.parseDouble(so2_map.get("v").toString()); //Dióxido de enxofre

        HashMap t_map = (HashMap) iaqi_map.get("temperature");
        Double t = Double.parseDouble(t_map.get("v").toString());    //Temperature

        HashMap p_map = (HashMap) iaqi_map.get("pressure");
        Double p = Double.parseDouble(p_map.get("v").toString());

        HashMap h_map = (HashMap) iaqi_map.get("humidity");
        Double h= Double.parseDouble(h_map.get("v").toString());     //Humidity

        HashMap w_map = (HashMap) iaqi_map.get("wind");
        Double w= Double.parseDouble(w_map.get("v").toString());

        //System.out.println("idx: "+idx+", name: " +  name +", timestamp: " +timestamp+", aqi: "+ aqi+", pm25: " +pm25+", pm10: "+ pm10+", o3: "+o3+", no2: " +no2+ ", so2"+ so2+ ", t"+ t+", p: "+ p+ ", h: "+ h+", w: " +w);

        Cities cities = new Cities(idx, name, timestamp, aqi, pm25, pm10, o3, no2, so2, t, p, h, w);
        citiesRepository.save(cities);

        //System.out.println(cities);
        incrementStatsCount();
        return cities;
    }

    @GetMapping("/city/{id}")
    public Cities getCitiesById (@PathVariable(value = "id") Long id) throws JsonProcessingException {
        // SE nao encontrar nada OU SE o que encontrar já não estiver c/ TTL
        incrementStatsCount();
        if (citiesRepository.findTopByIdOrderByIdDesc(id) == null || cache.isCache(id)){
            cache.incrementMisses();

            //Porto
            Cities api;

            if (id == 8373) {
                api = getAPIData("Porto");
                cache.setCache(api);
            } // Se o pedido for Madrid
            else { // Madrid: 5725
                api = getAPIData("Madrid");
                cache.setCache(api);
            }
            System.out.println("-> MISS, nao esta em cache ou expirou TTL!");
            return api;

        } else {
            cache.incrementHits();
            System.out.println("-> HIT, esta em cache e TTL válido!");
            // Vai busca-lo mesmo a cache
            return cache.getCityCachedById(id);
        }
    }

    @GetMapping("/api/requests")
    public String getRequests(){
        return "Requests: " + cache.getRequests();
    }

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
