package com.example.TravelAgency.controllers.dto;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

public class DestinationCompleteDataDTO {
    private int destinationId;
    private String name;
    private String description;
    private int price;
    private int groupSize;
    @Transient
    private int tripLength;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    private LocalDate dateAdded;
    private String guideName;
    private String guideLastName;
    private String difficultyLevelName;
    private String cityName;
    private String countryName;
    private String continentName;
    private List<ImageDTO> imageList;
    private int guideId;
    private int difficultyLevelId;
    private int continentId;

    public List<ImageDTO> getImageList() {
        return imageList;
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

    public void setImageList(List<ImageDTO> imageList) {
        this.imageList = imageList;
    }

    public int getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
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

    public int getTripLength() {
        return Period.between(this.startDate, this.endDate).getDays() + 1;
    }

    public void setTripLength(int tripLength) {
        this.tripLength = tripLength;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDifficultyLevelName() {
        return difficultyLevelName;
    }

    public void setDifficultyLevelName(String difficultyLevelName) {
        this.difficultyLevelName = difficultyLevelName;
    }

    public String getGuideName() {
        return guideName;
    }

    public void setGuideName(String guideName) {
        this.guideName = guideName;
    }

    public String getGuideLastName() {
        return guideLastName;
    }

    public void setGuideLastName(String guideLastName) {
        this.guideLastName = guideLastName;
    }

}
