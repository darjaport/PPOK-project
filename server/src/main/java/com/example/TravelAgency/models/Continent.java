package com.example.TravelAgency.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int continentId;
    private String name;

    @OneToMany(mappedBy = "continent")
    private List<Country> countries;

    public Continent() {
    }

    public Continent(String name, List<Country> countries) {
        this.name = name;
        this.countries = countries;
    }

    public Continent(int continentId, String name, List<Country> countries) {
        this.continentId = continentId;
        this.name = name;
        this.countries = countries;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public int getContinentId() {
        return continentId;
    }

    public void setContinentId(int continentId) {
        this.continentId = continentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
