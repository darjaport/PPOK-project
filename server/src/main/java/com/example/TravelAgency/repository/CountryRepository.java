package com.example.TravelAgency.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.TravelAgency.models.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    @Query("SELECT c FROM Country c WHERE c.name = ?1")
    Optional<Country> findByName(String name);
}