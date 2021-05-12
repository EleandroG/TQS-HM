package com.tqs.apirest;

import com.tqs.apirest.model.Cities;
import com.tqs.apirest.repository.CitiesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

//TODO: the entire class
@SpringBootTest
public class CitiesTest {

    Cities city;

    @Autowired
    private CitiesRepository citiesRepository;

    @BeforeEach
    void beforeEach(){
        Cities city = new Cities((long) 11812, "Arco de ladrillo II, Valladolid, Spain", "2021-05-10 13:00:00",
                53.0, 6.0, 4.6, 4.6, 33.3, 53.0, 9.0,
                15.2, 56.0, 1008.5, 0.6);
        citiesRepository.save(city);
    }

    @Test
    public void notNull(){
        Cities city_found = citiesRepository.findByIdx(11812);
        System.out.println(city_found);
        assertThat(city_found).isNotNull();
    }
}
