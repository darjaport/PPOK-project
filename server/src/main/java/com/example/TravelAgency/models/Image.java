package com.example.TravelAgency.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imageId;
    private String name;
    private String src;

    @ManyToOne
    @JoinColumn(name = "destinationId")
    private Destination destination;

    public Image() {
    }

    public Image(String name, String src, Destination destination) {
        this.name = name;
        this.src = src;
        this.destination = destination;
    }

    public Image(int imageId, String name, String src, Destination destination) {
        this.imageId = imageId;
        this.name = name;
        this.src = src;
        this.destination = destination;
    }

    public Destination getDestinations() {
        return destination;
    }

    public void setDestinations(Destination destination) {
        this.destination = destination;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
