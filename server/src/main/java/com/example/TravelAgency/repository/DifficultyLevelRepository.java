package com.example.TravelAgency.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TravelAgency.models.DifficultyLevel;

public interface DifficultyLevelRepository extends JpaRepository<DifficultyLevel, Integer> {
}