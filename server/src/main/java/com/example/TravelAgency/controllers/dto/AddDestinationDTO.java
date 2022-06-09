package com.example.TravelAgency.controllers.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class AddDestinationDTO {
    private String name;
    private String description;
    private int price;
    private int groupSize;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    private int guideId;
    private String cityName;
    private String countryName;
    private int difficultyLevelId;
    private int continentId;

    public AddDestinationDTO() {
    }

    public AddDestinationDTO(String name, String description, int price, int groupSize,
            LocalDate startDate, LocalDate endDate, int guideId, String cityName,
            String countryName, int difficultyLevelId, int continentId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.groupSize = groupSize;
        this.startDate = startDate;
        this.endDate = endDate;
        this.guideId = guideId;
        this.cityName = cityName;
        this.countryName = countryName;
        this.difficultyLevelId = difficultyLevelId;
        this.continentId = continentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getGroupSize() {
        return groupSize;
    }

    public void setGroupSize(int groupSize) {
        this.groupSize = groupSize;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getGuideId() {
        return guideId;
    }

    public void setGuideId(int guideId) {
        this.guideId = guideId;
    }

    public int getDifficultyLevelId() {
        return difficultyLevelId;
    }

    public void setDifficultyLevelId(int difficultyLevelId) {
        this.difficultyLevelId = difficultyLevelId;
    }

    public int getContinentId() {
        return continentId;
    }

    public void setContinentId(int continentId) {
        this.continentId = continentId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
