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
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cityId;
    private String name;

    @ManyToOne
    @JoinColumn(name = "countryId")
    private Country country;

    @OneToMany(mappedBy = "city")
    private List<Destination> destinations;

    public City(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public City() {
    }

    public City(String name, Country country, List<Destination> destinations) {
        this.name = name;
        this.country = country;
        this.destinations = destinations;
    }

    public City(int cityId, String name, Country country, List<Destination> destinations) {
        this.cityId = cityId;
        this.name = name;
        this.country = country;
        this.destinations = destinations;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
