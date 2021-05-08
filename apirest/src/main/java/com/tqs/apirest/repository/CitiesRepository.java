package com.tqs.apirest.repository;

import com.tqs.apirest.model.Cities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitiesRepository extends JpaRepository<Cities, Long> {

    Cities findById(long id);
    Cities findTopByIdOrderByIdDesc(Long id);

}
