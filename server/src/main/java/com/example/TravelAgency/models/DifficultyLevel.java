package com.example.TravelAgency.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class DifficultyLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int difficultyLevelId;
    private String name;

    @OneToMany(mappedBy = "difficultyLevel")
    private List<Destination> destinations;

    public DifficultyLevel() {
    }

    public DifficultyLevel(String name, List<Destination> destinations) {
        this.name = name;
        this.destinations = destinations;
    }

    public DifficultyLevel(int difficultyLevelId, String name, List<Destination> destinations) {
        this.difficultyLevelId = difficultyLevelId;
        this.name = name;
        this.destinations = destinations;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDifficultyLevelId() {
        return difficultyLevelId;
    }

    public void setDifficultyLevelId(int difficultyLevelId) {
        this.difficultyLevelId = difficultyLevelId;
    }
}
