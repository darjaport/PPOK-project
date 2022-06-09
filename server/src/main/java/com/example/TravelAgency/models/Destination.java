package com.example.TravelAgency.models;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int destinationId;
    private String name;
    private String description;
    private int price;
    private int groupSize;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    private LocalDate dateAdded;
    @Transient
    private int tripLength;

    @ManyToOne
    @JoinColumn(name = "guideId")
    private Guide guide;

    @ManyToOne
    @JoinColumn(name = "difficultyLevelId")
    private DifficultyLevel difficultyLevel;

    @ManyToOne
    @JoinColumn(name = "cityId")
    private City city;

    // @OneToMany(mappedBy = "destination")
    @OneToMany(orphanRemoval = true, mappedBy = "destination")
    private List<Image> images;

    public Destination() {
    }

    public Destination(String name, String description, int price, int groupSize, LocalDate startDate,
            LocalDate endDate, LocalDate dateAdded, Guide guide, DifficultyLevel difficultyLevel,
            City city, List<Image> images) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.groupSize = groupSize;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dateAdded = dateAdded;
        this.guide = guide;
        this.difficultyLevel = difficultyLevel;
        this.city = city;
        this.images = images;
    }

    public Destination(int destinationId, String name, String description, int price, int groupSize,
            LocalDate startDate, LocalDate endDate, LocalDate dateAdded, Guide guide,
            DifficultyLevel difficultyLevel, City city, List<Image> images) {
        this.destinationId = destinationId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.groupSize = groupSize;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dateAdded = dateAdded;
        this.guide = guide;
        this.difficultyLevel = difficultyLevel;
        this.city = city;
        this.images = images;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public DifficultyLevel getDifficultyLevels() {
        return difficultyLevel;
    }

    public void setDifficultyLevels(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
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
