package com.example.TravelAgency.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.TravelAgency.models.Continent;

public interface ContinentRepository extends JpaRepository<Continent, Integer> {
    @Query("SELECT c FROM Continent c WHERE c.name = ?1")
    Optional<Continent> findByName(String name);
}