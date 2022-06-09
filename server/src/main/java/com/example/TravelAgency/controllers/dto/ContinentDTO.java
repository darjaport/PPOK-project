package com.example.TravelAgency.controllers.dto;

public class ContinentDTO {
    private int continentId;
    private String name;

    public ContinentDTO() {
    }

    public ContinentDTO(String name) {
        this.name = name;
    }

    public ContinentDTO(int continentId, String name) {
        this.continentId = continentId;
        this.name = name;
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
