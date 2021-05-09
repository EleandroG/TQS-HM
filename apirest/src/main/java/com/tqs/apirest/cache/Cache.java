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

    public void incrementHits() {
        hits++;
    }

    public void incrementMisses() {
        misses++;
    }

    public void incrementRequests() {
        requests++;
    }

    public void setTimeToLive(Long id) {
        Calendar current_time = Calendar.getInstance();
        current_time.add(Calendar.MINUTE, 1);
        timeToLive.put(id, current_time);
    }

    public void setCache(Cities city) {
        cache.put(city.getIdx(), city);
        setTimeToLive(city.getIdx());
        //System.out.println("CITIES CACHE HASHMAP: " + cache);
        System.out.println("CITI ADDED: " + cache + "\nWITH timeToLive: " + timeToLive.get(city.getIdx()).getTime());
    }

    public HashMap<Long, Cities> getCitiesCache() {
        return cache;
    }

    public Cities getCityCachedById(Long idx){
        return cache.get(idx);
    }

    public boolean cachenotValid(Long idx){
        Calendar current_time = Calendar.getInstance();
        //System.out.println("timeToLive HASHMAP: " + timeToLive.values());
        if (current_time.before(timeToLive.get(idx)) || current_time.equals(timeToLive.get(idx))){
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