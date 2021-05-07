package com.tqs.apirest.cache;

import com.tqs.apirest.model.City;

import java.util.Calendar;
import java.util.HashMap;

public class Cache {

    private HashMap<Long, City> cache;
    private HashMap<Long, Calendar> timeToLive;
    private Integer hits;
    private Integer misses;

    public Cache() {
        cache = new HashMap<>();
        timeToLive = new HashMap<>();
        hits = 0;
        misses = 0;
    }

    public HashMap<Long, City> getCache() {
        return cache;
    }

    public void setCache(City city) {
        setTimeToLive(city.getId());
        cache.put(city.getId(), city);
        System.out.println("Cidade adicionada: " + cache + "\n com um TimeToLive: " + timeToLive.get(city.getId()).getTime());
    }

    public HashMap<Long, Calendar> getTimeToLive() {
        return timeToLive;
    }

    public void setTimeToLive(Long id) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 1);
        timeToLive.put(id, calendar);
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public Integer getMisses() {
        return misses;
    }

    public void setMisses(Integer misses) {
        this.misses = misses;
    }

    public void incrementHits() {
        hits++;
    }

    public void incrementMisses() {
        misses++;
    }

    @Override
    public String toString() {
        return "Cache{" +
                "cache=" + cache +
                ", timeToLive=" + timeToLive +
                ", hits=" + hits +
                ", misses=" + misses +
                '}';
    }
}
