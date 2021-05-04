package com.tqs.apirest.repository;

import com.tqs.apirest.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    City findById(long id);
    City findTopByIdOrderByIdDesc(Long id);

}
