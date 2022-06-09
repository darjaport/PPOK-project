package com.example.TravelAgency.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.TravelAgency.models.Destination;
import com.example.TravelAgency.models.Guide;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Integer> {

    @Query("SELECT d FROM Destination d WHERE d.guide = ?1")
    List<Destination> findAllGuidesByGuideId(Guide guide);
}