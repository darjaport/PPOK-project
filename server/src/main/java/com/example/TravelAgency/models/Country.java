package com.example.TravelAgency.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int countryId;
    private String name;

    @ManyToOne
    @JoinColumn(name = "continentId")
    private Continent continent;

    @OneToMany(mappedBy = "country")
    private List<City> cities;

    public Country(String name, Continent continent) {
        this.name = name;
        this.continent = continent;
    }

    public Country() {
    }

    public Country(String name, Continent continent, List<City> cities) {
        this.name = name;
        this.continent = continent;
        this.cities = cities;
    }

    public Country(int countryId, String name, Continent continent, List<City> cities) {
        this.countryId = countryId;
        this.name = name;
        this.continent = continent;
        this.cities = cities;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }
}
