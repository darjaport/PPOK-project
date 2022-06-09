package com.example.TravelAgency.controllers.dto;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Transient;

public class DestinationDTO {
    private int destinationId;
    private String name;
    private String description;
    private int price;
    private int groupSize;
    @Transient
    private int tripLength;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate dateAdded;

    public DestinationDTO() {
    }

    public DestinationDTO(String name, String description, int price, int groupSize, LocalDate startDate,
            LocalDate endDate, LocalDate dateAdded) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.groupSize = groupSize;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dateAdded = dateAdded;
    }

    public DestinationDTO(int destinationId, String name, String description, int price, int groupSize,
            LocalDate startDate,
            LocalDate endDate, LocalDate dateAdded) {
        this.destinationId = destinationId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.groupSize = groupSize;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dateAdded = dateAdded;
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
}
