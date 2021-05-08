package com.tqs.apirest.cache;

import com.tqs.apirest.model.Cities;

import java.util.Calendar;
import java.util.HashMap;

public class Cache {

    private HashMap<Long, Cities> cache;
    private HashMap<Long, Calendar> timeToLive;
    private Integer requests;
    private Integer hits;
    private Integer misses;

    public Cache() {
        cache = new HashMap<>();
        timeToLive = new HashMap<>();
        requests = 0;
        hits = 0;
        misses = 0;
    }

    public HashMap<Long, Cities> getCache() {
        return cache;
    }

    public Cities getCityCachedById(Long id){
        return cache.get(id);
    }

    public void setCache(Cities city) {
        setTimeToLive(city.getId());
        cache.put(city.getId(), city);
        System.out.println("Cidade adicionada: " + cache + "\n com um Time To Live de: " + timeToLive.get(city.getId()).getTime());
    }

    public HashMap<Long, Calendar> getTimeToLive() {
        return timeToLive;
    }

    public void setTimeToLive(Long id) {
        Calendar calendar_time = Calendar.getInstance();
        calendar_time.add(Calendar.MINUTE, 1);
        timeToLive.put(id, calendar_time);
    }

    public Integer getRequests() {
        return requests;
    }

    public void setRequests(Integer requests) {
        this.requests = requests;
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

    public void incrementRequests() {
        requests++;
    }

    //Method to see if the cache exists
    public boolean isCache(Long id){
        Calendar calendar_time = Calendar.getInstance();

        if (calendar_time.before(timeToLive.get(id)) || calendar_time.equals(timeToLive.get(id))){
            System.out.println("Cache: " + cache.get(id).getName() + "\n\t with a Time To Live: " + timeToLive.get(id).getTime());
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "Cache{" +
                "cache=" + cache +
                ", timeToLive=" + timeToLive +
                ", hits=" + hits +
                ", misses=" + misses +
                ", requests=" + requests +
                '}';
    }
}
