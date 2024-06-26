package com.tarasov.footballproject.repositores;

import com.tarasov.footballproject.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
//    @Query("select c from City c where c.name = ?1")
//    City findCityByCityNameIgnoreCase(String name);

    @Transactional(readOnly = true)
    City findCityByNameContainingIgnoreCase(String name);
}
