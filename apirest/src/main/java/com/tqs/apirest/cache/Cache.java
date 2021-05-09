package com.tqs.apirest.cache;

import com.tqs.apirest.model.Cities;

import java.util.Calendar;
import java.util.HashMap;

public class Cache {

    private HashMap<Long, Cities> cache;
    private Integer hits;
    private Integer misses;
    private Integer requests;
    private HashMap<Long, Calendar> timeToLive;

    public Cache() {
        cache = new HashMap<>();
        hits = 0;
        misses = 0;
        requests = 0;
        timeToLive = new HashMap<>();
    }

    public Integer getCacheHit() {
        return hits;
    }

    public Integer getCacheMiss() {
        return misses;
    }

    public Integer getCacheRequests() {
        return requests;
    }

    public HashMap<Long, Cities> getCache() {
        return cache;
    }

    public HashMap<Long, Calendar> getTimeToLive() {
        return timeToLive;
    }

    public HashMap<Long, Cities> getCitiesCache() {
        return cache;
    }

    public Cities getCityCachedById(Long idx){
        return cache.get(idx);
    }

    public void setTimeToLive(Long id) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 1);
        timeToLive.put(id, calendar);
    }

    public void setCache(Cities city) {
        cache.put(city.getIdx(), city);
        setTimeToLive(city.getIdx());

        System.out.println("Cidade: " + cache + "\nTime To Live: " + timeToLive.get(city.getIdx()).getTime());
    }

    public void incrementHits() {
        hits++;
    }

    public void incrementMisses() {
        misses++;
    }

    public void incrementRequests() {
        requests++;
    }

    //Method to confirm if this is a cache of a city | region | station
    public boolean isCache(Long idx){
        Calendar calendar = Calendar.getInstance();

        if (calendar.before(timeToLive.get(idx)) || calendar.equals(timeToLive.get(idx))){
            System.out.println("-- CACHE timeToLive VALID: " + cache.get(idx).getName() + "\n\ttimeToLive Value: " + timeToLive.get(idx).getTime());
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "CacheManager{" +
                ",\ncache=" + cache +
                " \nhits=" + hits +
                ",\nmisses=" + misses +
                ",\nrequests=" + requests +
                ",\ntimeToLive=" + timeToLive +
                '}';
    }
}