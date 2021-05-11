package com.tqs.apirest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tqs.apirest.cache.Cache;
import com.tqs.apirest.controller.CitiesController;
import com.tqs.apirest.model.Cities;
import com.tqs.apirest.repository.CitiesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class CitiesControllerTest {

        Cache cache;

        @Autowired
        CitiesRepository citiesRepository;

        @Autowired
        CitiesController citiesController;


        @BeforeEach
        void beforeEach(){
            cache = new Cache();
        }

        @Test
        public void getCityDataFromApi() throws JsonProcessingException {
            assertEquals(citiesController.apiData("Valladolid").getId(), citiesRepository.findByIdx(11812).getId());
        }

        @Test
        public void citiesByID() throws JsonProcessingException {
            Cities city = new Cities((long) 11812, "Arco de ladrillo II, Valladolid, Spain", "2021-05-10 13:00:00",
                    53.0, 6.0, 4.6, 4.6, 33.3, 53.0, 9.0,
                    15.2, 56.0, 1008.5, 0.6);
            citiesRepository.save(city);
            Cities city1 = citiesController.citiesByIdx((long) 6637);
            assertNotEquals(city.getId(), city1.getId());
        }

        //Erro
        @Test
        public void stats(){
            CitiesController citiesController = new CitiesController();
            citiesController.incrementRequests();
            citiesController.incrementStats();

            String stats = "Stats (Number of times): " + CitiesController.stats;
            String statsFromApi = citiesController.getStats();
            assertEquals(stats, statsFromApi);
        }

        @Test
        public void cache(){
            assertEquals(cache.toString(), citiesController.Cache());
        }
}
