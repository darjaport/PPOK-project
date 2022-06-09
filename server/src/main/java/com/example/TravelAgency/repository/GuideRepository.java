package com.example.TravelAgency.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.TravelAgency.models.Guide;

@Repository
public interface GuideRepository extends JpaRepository<Guide, Integer> {

    @Query("SELECT g FROM Guide g WHERE g.name = ?1 AND g.lastName = ?2")
    Optional<Guide> findByNameOrLastName(String name, String lastName);
}