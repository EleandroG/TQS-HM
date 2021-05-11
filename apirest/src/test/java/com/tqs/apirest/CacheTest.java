package com.tqs.apirest;

import com.tqs.apirest.cache.Cache;
import com.tqs.apirest.model.Cities;
import com.tqs.apirest.repository.CitiesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CacheTest {

    Cache cache;
    Cities city;

    @Autowired
    CitiesRepository citiesRepository;

    //Before each test, create the cache of a specific city | region | station and save it
    @BeforeEach
    void beforeEach() {
        cache = new Cache();
        city = new Cities((long) 11812, "Arco de ladrillo II, Valladolid, Spain", "2021-05-10 13:00:00",
                53.0, 6.0, 4.6, 4.6, 33.3, 53.0, 9.0,
                15.2, 56.0, 1008.5, 0.6);
        citiesRepository.save(city);
    }

    @Test
    public void Cache() {
        cache.setCache(city);
        Long cityIdx = cache.getCitiesCache().get((long) 11812).getIdx();
        assertEquals(cityIdx, city.getIdx());
        assertEquals(city, cache.getCityCachedById((long) 11812));
    }

    //Tests to check TTL
    @Test
    public void timeToLive() {
        cache.setCache(city);
        assertFalse(cache.isCache((long) 11812));
    }

    //Tests for the stats (Requests - Hits - Misses)
    @Test
    public void hitsMissesAndRequests() {
        cache.incrementRequests();
        cache.incrementHits();
        assertEquals(cache.getCacheHit(), 1);
        cache.incrementMisses();
        assertEquals(cache.getCacheMiss(), 1);
    }
}
