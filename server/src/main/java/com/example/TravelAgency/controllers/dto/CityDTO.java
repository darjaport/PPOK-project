package com.example.TravelAgency.controllers.dto;

public class CityDTO {
    private int cityId;
    private String name;

    public CityDTO() {
    }

    public CityDTO(String name) {
        this.name = name;
    }

    public CityDTO(int cityId, String name) {
        this.cityId = cityId;
        this.name = name;
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
