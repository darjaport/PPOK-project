package com.example.TravelAgency.controllers.dto;

public class CountryDTO {
    private int countryId;
    private String name;

    public CountryDTO() {
    }

    public CountryDTO(String name) {
        this.name = name;
    }

    public CountryDTO(int countryId, String name) {
        this.countryId = countryId;
        this.name = name;
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
