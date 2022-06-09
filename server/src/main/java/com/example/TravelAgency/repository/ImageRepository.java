package com.example.TravelAgency.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.TravelAgency.models.Destination;
import com.example.TravelAgency.models.Image;

public interface ImageRepository extends JpaRepository<Image, Integer> {

    @Query("SELECT i FROM Image i WHERE i.destination = ?1")
    List<Image> findAllByDestination(Destination d);
}